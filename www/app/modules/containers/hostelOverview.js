angular.module('oltiv.hostelOverview',[])
.controller('hostelOverViewController', function($scope,$stateParams){
  $scope.hostel=$stateParams.hostelObject;
})