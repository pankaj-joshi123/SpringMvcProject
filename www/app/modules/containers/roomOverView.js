angular.module('oltiv.roomOverview',[])
.controller('roomOverViewController', function($scope,$stateParams,$state,$http){
  $scope.flank=$stateParams.flankObject;
  $scope.room=$stateParams.roomObject;
  $scope.user=$stateParams.userObject;

  $http({                                                                                             ////loading all users present in the room by id
        method: "GET",
        url:"http://localhost:8080/openspec-1/masti/oltiv/greeting/getAllUsersOfRoom/"+$stateParams.roomObject.id
      }).then(function success(response) {
        console.log(response.data);
       $scope.employees = response.data;
      },
       function error(response) {
       console.log(response);
      });

  $scope.addUserToRoom=function() {     ///need to make changes in state object and need to add the id of room to that user

   $stateParams.userObject.roomId=$stateParams.roomObject.id;

    $http.post("http://localhost:8080/openspec-1/masti/oltiv/greeting/create",$stateParams.userObject)
    			.success(function(data) {
    				console.log(employees);
    				$state.go('flankOverview',{flankId:$stateParams.flankObject.id});
    			});
  }

})