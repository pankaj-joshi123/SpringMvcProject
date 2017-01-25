var app = angular.module('oltiv', [
'ui.router',
'ngCookies',
'oltiv.login',
'oltiv.forgotPwd',
'oltiv.createAccount',
'oltiv.userOverview',
'oltiv.home',
'oltiv.register',
'oltiv.viewAllUsers',
'oltiv.containerDim',
'oltiv.hostelList',
'oltiv.createHostel',
'oltiv.hostelOverview',
'oltiv.createFlank',
'oltiv.flankOverview',
'oltiv.roomOverview'
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

 .state('containerDimension',{
        url:'/containerDimension',
        templateUrl: 'app/modules/containers/containerDimension.html',
        controller: 'containerDimCtrl'
       })


 .state('hostelList',{
        url:'/hostelList',
        templateUrl: 'app/modules/containers/hostelList.html',
        controller: 'hostelListCtrl'
       })

 .state('createHostel',{
         url:'/createHostel',
         templateUrl: 'app/modules/containers/createHostel.html',
         controller: 'createHostelCtrl'
       })

 .state('hostelOverview',{
     url:'/hostelOverview',
     templateUrl: 'app/modules/containers/hostelOverview.html',
     controller: "hostelOverViewController",
     params: {'hostelObject':null}
     })

 .state('createFlank',{
      url:'/createFlank',
      templateUrl: 'app/modules/containers/createHostelFlank.html',
      controller: "createFlankCtrl",
      params: {'hostelObject':null}

      })

 .state('flankOverview',{
      url:'/flankOverview',
      templateUrl: 'app/modules/containers/flankOverview.html',
      controller: "flankOverViewController",
      params: {'flankObject':null}
      })

 .state('roomOverview',{
       url:'/roomOverview',
       templateUrl: 'app/modules/containers/roomOverView.html',
       controller: "roomOverViewController",
       params: {'roomObject':null,
                'flankObject':null
               }
       })

  $urlRouterProvider.otherwise('/home');
}]);
