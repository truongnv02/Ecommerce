const app = angular.module("admin-app", ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider
        .when("/admin", {
            templateUrl: "/fe/admin/index.html",
        })
        .when("/product", {
            templateUrl: "/fe/admin/product/product.html",
            controller: "product-controller"
        })
        .when("/authorize", {
            templateUrl: "/fe/admin/authority/home.html",
            controller: "authority-controller"
        })
        .when("/unauthorized", {
            templateUrl: "/fe/admin/authority/unauthorized.html",
            controller: "authority-controller"
        })
        .otherwise({
            template: "<h1 class='text-center'>ADMIN</h1>"
        });
})