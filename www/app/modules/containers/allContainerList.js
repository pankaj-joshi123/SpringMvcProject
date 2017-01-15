angular.module('oltiv.containerList',[])
.controller('containerListCtrl', function($scope,$http,$state){

$http({
      method: "GET",
      url:"http://localhost:8080/openspec-1/masti/oltiv/container/getAllContainers"
    }).then(function success(response) {
      console.log(response.data);
     $scope.hostels = response.data;
    },
     function error(response) {
     console.log(response);

    });

    $scope.showUserOverview=function(user) {
		$state.go('userOverview',{'empObject':user});
    }
})