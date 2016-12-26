angular.module('oltiv.login',[])
.controller('loginCtrl', function($scope,$http){

 $scope.login = function() {
         $http.get("http://localhost:8080/openspec-1/masti/oltiv/greeting/getUserByLoginName/"+$scope.userName)
          			.success(function(data) {
          				  console.log(data);
          				  $scope.masti=data;
          			}
         );
 }
})