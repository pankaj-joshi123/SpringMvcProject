var app = angular.module('oltiv', [
'ui.router',
'ngCookies',
'oltiv.login',
'oltiv.forgotPwd',
'oltiv.createAccount',
'oltiv.userOverview',
'oltiv.home',
'oltiv.register',
'oltiv.viewAllUsers'
]);

app.config(['$urlRouterProvider', '$stateProvider', function ($urlRouterProvider,$stateProvider,$cookieStore)
 {
   $stateProvider
 .state('login',{
   url:'/login',
   templateUrl:'app/modules/users/loginPage.html',
   controller: "loginCtrl"
   })

 .state('forgotPwd',{
    url:'/forgotPwd',
    templateUrl: 'app/modules/users/forgotPwd.html',
    controller: "forgotPwdCtrl"
    })

 .state('createAccount',{
    url:'/createAccount',
    templateUrl: 'app/modules/users/createAccount.html',
    controller: 'createAccountCtrl'
    })

 .state('userOverview',{
    url:'/overview',
    templateUrl: 'app/modules/users/userOverview.html',
    controller: "overViewController",
    params: {'empObject':null}
    })

 .state('home',{
     url:'/home',
     templateUrl: 'app/modules/common/home.html',
     controller: 'homeCtrl'
    })

 .state('register',{
      url:'/register',
      templateUrl: 'app/modules/registrations/register.html',
      controller: 'registrationCtrl'
     })

 .state('allUsers',{
       url:'/allUsers',
       templateUrl: 'app/modules/registrations/viewAllUsers.html',
       controller: 'usersListCtrl'
      })

  $urlRouterProvider.otherwise('/home');
}]);
