var app = angular.module('oltiv', [
'ui.router',
'oltiv.login',
'oltiv.forgotPwd',
'oltiv.createAccount',
'oltiv.userOverview'
]);

app.config(['$urlRouterProvider', '$stateProvider', function ($urlRouterProvider,$stateProvider)
 {
   $stateProvider
 .state('login',{
   url:'/login',
   templateUrl:'app/modules/users/loginPage.html',
   controller: "loginCtrl" })

 .state('forgotPwd',{
    url:'/forgotPwd',
    templateUrl: 'app/modules/users/forgotPwd.html',
    controller: "forgotPwdCtrl" })

 .state('createAccount',{
    url:'/createAccount',
    templateUrl: 'app/modules/users/createAccount.html',
    controller: 'createAccountCtrl'})

 .state('userOverview',{
    url:'/overview',
    templateUrl: 'app/modules/users/userOverview.html',
    controller: "overViewController",
    params: {'empObject':null}
    })
    
  $urlRouterProvider.otherwise('/login');
}]);

app.controller("MainCtrl", ['$scope', '$http', '$window', function ($scope,$http,$window) {


         $scope.addd =function()
		{
        $scope.mess2="post done from html";

        var employees = { 'name': $scope.namme , 'addr': $scope.addr, 'age': $scope.age, 'mob': $scope.mob, 'dob': $scope.dob };

                $http.post("http://localhost:8080/rest/ng/greeting/mastibaap/",employees)
			.success(function(data) {
				console.log(employees);
				$scope.post="done";
			});
		}
 }]); 

app.controller("dispController", ['$scope', '$http', function ($scope,$http	) { 
             $scope.mess3="in display"; 
    
    $http({
      method: "GET",
      url: "http://localhost:8080/mastijar-1/rest/ng/greeting/all"
    }).then(function success(response) {
      $scope.mess3="in display222"; 
      console.log(response.data);
     $scope.students = response.data;
    }, 
    function error(response) {
   $scope.getno="not done";   
   console.log(response);
      
    });


    }]); 

app.controller("searchController",['$scope', '$http', function($scope,$http){

   $scope.searching =function()
  {
    var item=$scope.searchitem;
    $http({
      method: "GET",
      url: "http://localhost:8080/mastijar-1/rest/ng/greeting/"+$scope.searchitem
    }).then(function success(response) {
      console.log(response.data);
          $scope.students = response.data;
                       $scope.mess3=undefined;
    }, 
    function error(response) {
   console.log(response);
   $scope.mess3="not found in database"
    $scope.student=undefined;  
    });   

  }

}]);



app.controller("updateController",['$scope', '$http', function($scope,$http){


   $scope.searching =function()
  {
    var item=$scope.searchitem;
    $http({
      method: "GET",
      url: "http://localhost:8080/mastijar-1/rest/ng/greeting/"+$scope.searchitem
    }).then(function success(response) {
      console.log(response.data);
          $scope.students = response.data;
                       $scope.mess3=undefined;
    }, 
    function error(response) {
   console.log(response);
   $scope.mess3="not found in database"
    $scope.student=undefined;  
    });   

  }

  $scope.updating =function()
		{
                $http.put("http://localhost:8080/mastijar-1/rest/ng/greeting/",$scope.students[0])
			.success(function(data) {
				console.log(students[0]);
				$scope.post="done";
			});
		}
}]);
