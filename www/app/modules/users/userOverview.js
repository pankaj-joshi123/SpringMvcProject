angular.module('oltiv.userOverview',[])
.controller('overViewController', function($scope,$stateParams,$state){

  $scope.employee=$stateParams.empObject;

  $scope.addToHostel=function(employee) {
   		$state.go('hostelList',{'userObject':employee});
  }
})