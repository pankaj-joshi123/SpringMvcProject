angular.module('oltiv.forgotPwd',[])
.controller('forgotPwdCtrl', function($scope,$http){

 $scope.sendNewPasswordToMail = function() {
          $http.get("http://localhost:8080/openspec-1/masti/oltiv/greeting/forgotPassword/"+$scope.gmailId)
           			.success(function(data) {
           				  console.log(data);
           				   $scope.chutiya='Successfully Send Mail to Gmail Id';
           			}
          );
  }

})