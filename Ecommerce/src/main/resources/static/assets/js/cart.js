const app = angular.module("cart-app", []);

app.controller("cart-controller", function cart($scope, $http) {

    $scope.cart = {
        items: [],

        add(id) {
            alert("Thêm sản phẩm thành công");
            const item = this.items.find(item => item.id === id);
            if(item) {
                item.quantity++;
                this.saveToLocalStorage();
            }else {
                $http.get(`/rest/products/${id}`).then(resp => {
                    resp.data.quantity = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                });
            }
        },

        remove(id) {
            const index = this.items.findIndex(item => item.id === id);
            this.items.splice(index, 1);
            this.saveToLocalStorage();
        },

        clear() {
            this.items = [];
            this.saveToLocalStorage();
        },

        saveToLocalStorage() {
            const json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },

        get count() {
            return this.items
                .map(item => item.quantity)
                .reduce((total, quantity) => total += quantity, 0)
        },

        get amount() {
            return this.items
                .map(item => item.quantity * item.price)
                .reduce((total, quantity) => total += quantity, 0)
        },

        loadFromLocalStorage() {
            const json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        }
    }

    $scope.cart.loadFromLocalStorage();

    $scope.order = {
        createDate: new Date(),
        address: "",
        account: {
            username: $("#username").text()
        },

        get orderDetails() {
            return $scope.cart.items.map(item => {
                return {
                    product: {
                        id: item.id
                    },
                    price: item.price,
                    quantity: item.quantity
                }
            });
        },

        purchase() {
            const order = angular.copy(this);
            $http.post("/rest/orders", order).then(resp => {
                alert("Đặt hàng thành công");
                $scope.cart.clear();
                location.href= "/order/detail/" + resp.data.id;
            }).catch(error => {
                alert("Đặt hàng không thành công");
                console.log(error);
            })
        }
    }
})
