angular.module('oltiv.containerDim',[])
.controller('containerDimCtrl', function($scope,$http,$state,$cookieStore){

       $cookieStore.put('rows',$scope.rows);
        $cookieStore.put('cols',$scope.columns);

      $scope.add =function() {
        var rows=$scope.rows;
        var columns=$scope.columns;
        var table ='';
            var x=5;
            var y=5;
            for(var i=0;i<=x;i++) {
              table += '<tr>';

              for(var j=0;j<=y;j++) {
                table += '<input type="text">'+'</input>'
              }

              table+= '<br>'+'</tr>';
            }

            document.write('<table>'+table+'</table>');
      }

     $scope.number = 10;
     $scope.getNumber = function(num) {
         return new Array(num);
     }

     $scope.number2 = 10;
          $scope.getNumber2 = function(num2) {
              return new Array(num2);
     }
})