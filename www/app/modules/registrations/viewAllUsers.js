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
     console.log(response);

    });

 $scope.uploadFile = function() {

    $http({
      method: "GET",
      url:"http://localhost:8080/openspec-1/masti/oltiv/greeting/bulkImport"
    }).then(function success(response) {
      console.log(response.data);
    },
    function error(response) {
      console.log(response);
    });
 }

 $scope.showUserOverview=function(user) {
		$state.go('userOverview',{'empObject':user});
 }

 $scope.writeRecordsToFile = function() {
     $http({
       method: "GET",
       url:"http://localhost:8080/openspec-1/masti/oltiv/greeting/writeToCSV"
     }).then(function success(response) {
       console.log(response.data);
     },
     function error(response) {
       console.log(response);
     });
  }

})