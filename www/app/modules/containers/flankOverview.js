angular.module('oltiv.flankOverview',[])
.controller('flankOverViewController', function($scope,$stateParams,$state,$http){
  $scope.flank=$stateParams.flankObject;

  $scope.number =$stateParams.flankObject.noOfRooms;
       $scope.getNumber = function(num) {
           return new Array(num);
       }

       $scope.number2 = $stateParams.flankObject.columns;
            $scope.getNumber2 = function(num2) {
                return new Array(num2);
       }
})