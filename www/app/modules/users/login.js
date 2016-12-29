angular.module('oltiv.login',[])
.controller('loginCtrl', function($scope,$http,$state,$cookieStore){

 $scope.login = function() {
         $http.get("http://localhost:8080/openspec-1/masti/oltiv/greeting/getUserByLoginName/"+$scope.userName)
          			.success(function(data) {
          				  console.log(data);
          				  $scope.masti=data;

          				  if(data.password==$scope.password)
          				  {
          				    $cookieStore.put('loggedIN',true);
          				    console.log($cookieStore.get('loggedIN'))
			            	$state.go('home');
          				  }
          				  else
          				  $scope.message="Invalid UserName or Password";
          			}
         );
 }
})