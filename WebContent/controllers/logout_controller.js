

var user=[{name:"Piyush", imgpath:"../image/img1.jpg", designation:"CEO", uname:"20lucky7"},{name:"John",imgpath:"../image/img2.jpg", designation:"CTO", uname:"20piyush7"},{name:"John",imgpath:"../image/img2.jpg", designation:"CTO", uname:"20piyush7"},{name:"John",imgpath:"../image/img2.jpg", designation:"CTO", uname:"20sudhanshu7"},{name:"John",imgpath:"../image/img2.jpg", designation:"CTO", uname:"20me7"},{name:"John",imgpath:"../image/img2.jpg", designation:"CTO", uname:"20myself7"},{name:"John",imgpath:"../image/img2.jpg", designation:"CTO", uname:"20bannesir7"},{name:"John",imgpath:"../image/img2.jpg", designation:"CTO", uname:"20hemant7"},{name:"John",imgpath:"../image/img2.jpg", designation:"CTO", uname:"20sorabh7"},{name:"John",imgpath:"../image/img2.jpg", designation:"CTO"},{name:"John",imgpath:"../image/img2.jpg", designation:"CTO", uname:"20kamal7"},{name:"John",imgpath:"../image/img2.jpg", designation:"CTO", uname:"20sudhanshu7"},{name:"John",imgpath:"../image/img2.jpg", designation:"CTO", uname:"20sudhanshu7"}];


//http://localhost:8080/BoardMeeting/boardMeet/Login?boarduname=Nick@gmail.com&boardpass=18051948  For login
//http://localhost:8080/BoardMeeting/boardMeet/load/indexload/before to get all members

var app = angular.module('profiles', ['ngMaterial','ngAnimate','ngAria','ngMessages']);
app.controller('profile_control',function($scope,$rootScope,$mdDialog,$http) { 
  $scope.isVisible=false;
  $scope.status = '  ';
    $http({
    method: 'GET',
     url: "http://localhost:8080/Board_Meeting/boardMeet/load/indexload/before",
      headers: {
       'Accept': 'application/json'
       },
    }).success(function (response) {
        console.log(response);
        $scope.users=response;
        $rootScope.username=$scope.users;
    }).error(function (error) {
       alert('Failure')
   });
    
    
    $scope.showAdvanced = function(ev,index) {
        $rootScope.index=index;
        $mdDialog.show({
          controller: DialogController,
          templateUrl: '../html/login-dialog.html',
          parent: angular.element(document.body),
          targetEvent: ev,
          clickOutsideToClose:true,
          fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
        })
        .then(function(answer) {
          $scope.status = 'You said the information was "' + answer + '".';
        }, function() {
          $scope.status = 'You cancelled the dialog.';
        });
      };


      function DialogController($scope,$rootScope, $mdDialog, $http) {
        $scope.dialog = {};
        $scope.dialog.boarduname=$rootScope.username[$rootScope.index].uname;       
        $scope.hide = function() {
          $mdDialog.hide();
        };
    
        $scope.cancel = function() {
          $mdDialog.cancel();
        };

        $scope.login = function(){
          alert($scope.dialog.boarduname );
          alert($scope.dialog.boardpass)
          $http({
           method : 'GET',
           url : 'http://localhost:8080/Board_Meeting/boardMeet/Login?boarduname='+$scope.dialog.boarduname+'&boardpass='+$scope.dialog.boardpass,
            data : $scope.dialog
        })//.success(function (response) {
//          console.log(response);
//         }).error(function (error) {
//         alert('Failure')
//        });
      };

        $scope.answer = function(answer) {
          $mdDialog.hide(answer);
        };
      }

     
 });

