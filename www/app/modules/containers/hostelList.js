angular.module('oltiv.hostelList',[])
.controller('hostelListCtrl', function($scope,$http,$state,$stateParams){

$scope.user=$stateParams.userObject;

$http({
      method: "GET",
      url:"http://localhost:8080/openspec-1/masti/oltiv/hostel/getAllHostels"
    }).then(function success(response) {
      console.log(response.data);
     $scope.hostels = response.data;
    },
     function error(response) {
     console.log(response);
    });

    $scope.showHostelOverview=function(hostel) {
		$state.go('hostelOverview',{hostelId:hostel.id,'userObject':$stateParams.userObject});
    }
})