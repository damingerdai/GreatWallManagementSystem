var GwmsApp = angular.module('GwmsApp',['ngRoute'])
    .config(['$routeProvider',function($routeProvider){
        $routeProvider
            .when('/personnel department/personInfo_Add',{
                templateUrl:'personnel department/personInfo_Add.html',
                controller:'personInfoAdd'
            })
    }]);
