angular.module('oltiv.viewAllUsers',[])
.controller('usersListCtrl', function($scope,$http,$state){

$http({
      method: "GET",
      url:"http://localhost:8080/openspec-1/masti/oltiv/greeting/getAllUsers"
    }).then(function success(response) {
      console.log(response.data);
     $scope.users = response.data;
    },
    function error(response) {
   $scope.getno="not done";
   console.log(response);

    });

})