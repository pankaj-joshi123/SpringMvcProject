angular.module('oltiv.roomOverview',[])
.controller('roomOverViewController', function($scope,$stateParams,$state,$http){
  $scope.flank=$stateParams.flankObject;
  $scope.room=$stateParams.roomObject;
})