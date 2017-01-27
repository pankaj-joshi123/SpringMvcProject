angular.module('oltiv.flankOverview',[])
.controller('flankOverViewController', function($scope,$stateParams,$state,$http){
  $scope.user=$stateParams.userObject;

  $http({
            method: "GET",
            url:"http://localhost:8080/openspec-1/masti/oltiv/hostel/getFlankOverview/"+$stateParams.flankId
          }).then(function success(response) {
            console.log(response.data);
           $scope.flank = response.data;
          },
           function error(response) {
           console.log(response);
          });

  $http({
          method: "GET",
          url:"http://localhost:8080/openspec-1/masti/oltiv/hostel/getFlankRooms/"+$stateParams.flankId
        }).then(function success(response) {
          console.log(response.data);
         $scope.rooms = response.data;
        },
         function error(response) {
         console.log(response);

        });

  /*$scope.number =$stateParams.flankObject.noOfRooms;
       $scope.getNumber = function(num) {
           return new Array(num);
       }

       $scope.number2 = $stateParams.flankObject.columns;
            $scope.getNumber2 = function(num2) {
                return new Array(num2);
       }*/


  $scope.showRoomOverview=function(room) {
    $state.go('roomOverview',{'roomObject':room,'flankObject':$scope.flank,'userObject':$stateParams.userObject})
  }
})