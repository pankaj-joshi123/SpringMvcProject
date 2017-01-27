angular.module('oltiv.hostelOverview',[])
.controller('hostelOverViewController', function($scope,$stateParams,$state,$http){
  $scope.user=$stateParams.userObject;

  $http({
          method: "GET",
          url:"http://localhost:8080/openspec-1/masti/oltiv/hostel/getHostelOverview/"+$stateParams.hostelId
        }).then(function success(response) {
          console.log(response.data);
         $scope.hostel = response.data;
        },
         function error(response) {
         console.log(response);
        });

  $http({
        method: "GET",
        url:"http://localhost:8080/openspec-1/masti/oltiv/hostel/getHostelFlanks/"+$stateParams.hostelId
      }).then(function success(response) {
        console.log(response.data);
       $scope.flanks = response.data;
      },
       function error(response) {
       console.log(response);

      });

  $scope.createFlank=function(hostel) {
  		$state.go('createFlank',{'hostelId':$stateParams.hostelId});
      }

  $scope.showFlankOverview=function(flank) {
        $state.go('flankOverview',{flankId:flank.id,'userObject':$stateParams.userObject})
  }
})