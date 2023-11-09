const app = angular.module("admin-app", ["ngRoute"]);

app.config(function ($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix("");
    $routeProvider
        .when("/admin", {
            templateUrl: "/fe/admin/index.html",
        })
        .when("/product", {
            templateUrl: "/fe/admin/product/table-product.html",
            controller: "product-controller"
        })
        // .when("/authorize", {
        //     templateUrl: "/admin/authority/home.html",
        //     controller: "authority-controller"
        // })
        // .when("/unauthorized", {
        //     templateUrl: "/admin/authority/unauthorized.html",
        //     controller: "authority-controller"
        // })
        .otherwise({
            redirectTo: "/admin"
        });
})