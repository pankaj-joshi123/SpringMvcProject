angular.module('oltiv.userOverview',[])
.controller('overViewController', function($scope,$stateParams){

  $scope.employee=$stateParams.empObject;

})