angular.module('oltiv.createFlank',[])
.controller('createFlankCtrl', function($scope,$http,$state,$stateParams){
      $scope.hostel=$stateParams.hostelObject;
 $scope.add=function() {
   var flank = {'flankName': $scope.name,'hostelId':$stateParams.hostelObject.id,'noOfRooms':$scope.room,'columns':$scope.cols,'studenPerRoom':$scope.student,'staringRoomNo':$scope.startingRoomNo};

                $http.post("http://localhost:8080/openspec-1/masti/oltiv/hostel/createFlank",flank)
			.success(function(data) {
		$state.go('flankOverview',{'flankObject':flank});
			});
 }
})