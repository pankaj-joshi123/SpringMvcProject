angular.module('oltiv.createAccount',[])
.controller('createAccountCtrl', function($scope,$http,$state){

 $scope.add=function() {
   var employees = {'name': $scope.name,'lastname': $scope.lastname,'loginName': $scope.loginName,'password':$scope.password,'email': $scope.email };

                $http.post("http://localhost:8080/openspec-1/masti/oltiv/greeting/create",employees)
			.success(function(data) {
				console.log(employees);
				$scope.chutiya="created from create Account.js";

				$state.go('userOverview',{'empObject':employees});
			});
 }
})