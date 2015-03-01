var cricInfo = angular.module(
                        'cricInfo', 
                        [
                         'ngRoute',
                        ]);

cricInfo.config(
    ['$routeProvider', 
     function(
        $routeProvider
        ){

    $routeProvider
        .when('/', {
            controller: 'MainController'
        });
}]);


cricInfo.controller(
        'MainController', [
            '$scope',
            '$http',
            '$timeout',
            function
            (
                $scope, 
                $http, 
                $timeout
            ){
            $http.get('http://angular-with-django.herokuapp.com/current_score/').success(
                    function(data) {
                        $scope.data = data;   
                    }).error(
                    function(data) {
                        alert(data);
                    });


            $scope.fetchData = function fetchData(){

                $http.get('http://angular-with-django.herokuapp.com/current_score/').success(
                    function(data) {
                        $scope.data = data;   
                    }).error(
                    function(data) {
                        alert(data);
                    });

                console.log("am refreshed");
                $timeout($scope.fetchData,6000);

            }   

            $timeout($scope.fetchData,6000);
                
            }        
        ]);
