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
})
