app.controller("product-controller", function ($scope, $http) {
    $scope.items = [];
    $scope.categories = [];
    $scope.form = {};

    $scope.initialize = function () {
        $http.get("/rest/products").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
        });

        $http.get("/rest/categories").then(resp => {
            $scope.categories = resp.data;
        });
    }

    // Khởi đầu
    $scope.initialize();

    // Xóa form
    $scope.reset = function () {
        $scope.form = {
            createDate: new Date(),
            image: '',
            available: true
        };
    }

    // Hiển thị lên form
    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(1)").tab('show');
    }

    // Thêm sản phẩm mới
    $scope.create = function () {
        var item = angular.copy($scope.form);
        $http.post(`/rest/products`, item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Thêm sản phẩm thành công");
        }).catch(error => {
            alert("Thêm sản phẩm thất bại");
            console.log("Error", error);
        })
    }

    // Cập nhật sản phẩm
    $scope.update = function () {
        var item = angular.copy($scope.form);
        $http.put(`/rest/product/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id === item.id);
            $scope.items[index] = item;
            alert("Cập nhật sản phẩm thành công");
        }).catch(error => {
            alert("Cập nhật sản phẩm thất bại");
            console.log("Error", error);
        })
    }
    // Xóa sản phẩm
    $scope.delete = function (item) {

    }

    // Upload hình ảnh
    $scope.imageChanged = function (files) {
        const data = new FormData();
        data.append('files', files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.image = resp.data.name;
        }).catch(error => {
            alert("Lỗi Upload hình ảnh");
            console.log("Error", error);
        })
    }
})