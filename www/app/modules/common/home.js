angular.module('oltiv.home',[])
.controller('homeCtrl', function($scope,$http,$state,$cookieStore){

    var isLoggedIn = $cookieStore.get('loggedIN');
    isLoggedIn=true;   //////////////////////////////////////////////////////to be commented
    if(isLoggedIn)
    {
        console.log("bhai tu logged in hai tujhe login ki jarurat nahi");
    }
    else
    {
        console.log("You are not Logged in Please Login to Continue");
        $state.go('login');
    }

    $scope.logout= function() {
        $cookieStore.put('loggedIN',false);
        console.log($cookieStore.get('loggedIN'))
                $state.go('login');
    }
})