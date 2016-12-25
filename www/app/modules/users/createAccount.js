angular.module('oltiv.createAccount',[])
.controller('createAccountCtrl', function($scope,$http,$state){

 $scope.chutiya='bhai tera Account Create ho raha h';

 $scope.check =function()	{

   $scope.chutiya="post done from html";
   var employees = {'name': $scope.name,'lastname': $scope.lastname,'loginname': $scope.loginName,'email': $scope.email };

     $http.get("http://localhost:8080/openspec-1/masti/oltiv/greeting/all")
 			.success(function(data) {
 				  console.log(employees);
 			}
 		    );
 }

 $scope.add=function() {
   var employees = {'name': $scope.name,'lastname': $scope.lastname,'loginName': $scope.loginName,'email': $scope.email };

                $http.post("http://localhost:8080/openspec-1/masti/oltiv/greeting/create",employees)
			.success(function(data) {
				console.log(employees);
				$scope.chutiya="created from create Account.js";

				$state.go('userOverview',{'empObject':employees});
			});
 }
})