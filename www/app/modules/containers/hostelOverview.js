angular.module('oltiv.hostelOverview',[])
.controller('hostelOverViewController', function($scope,$stateParams,$state,$http){
  $scope.hostel=$stateParams.hostelObject;

  $http({
        method: "GET",
        url:"http://localhost:8080/openspec-1/masti/oltiv/hostel/getHostelFlanks/"+$scope.hostel.id
      }).then(function success(response) {
        console.log(response.data);
       $scope.flanks = response.data;
      },
       function error(response) {
       console.log(response);

      });

  $scope.createFlank=function(hostel) {
  		$state.go('createFlank',{'hostelObject':$scope.hostel});
      }

  $scope.showFlankOverview=function(flank) {
        $state.go('flankOverview',{'flankObject':flank})
  }
})