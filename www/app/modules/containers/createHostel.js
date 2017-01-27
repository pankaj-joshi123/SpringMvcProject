angular.module('oltiv.createHostel',[])
.controller('createHostelCtrl', function($scope,$http,$state){

 $scope.add=function() {
   var hostel = {'hostelName': $scope.name};

   $http.post("http://localhost:8080/openspec-1/masti/oltiv/hostel/create",hostel)
			.success(function(data) {
				$state.go('hostelOverview',{hostelId:data.id});
			});
 }
})