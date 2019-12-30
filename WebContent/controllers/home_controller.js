

var myapp = angular.module('BlankApp', ['ngMaterial', 'ngAnimate', 'ngAria', 'ngMessages']);

//myapp.config(PanelProviderConfig);
// myapp.controller('head_control',function($scope,$rootScope){
//   $scope.tokVar='';
//   $rootScope.token=$scope.tokVar;
//   alert($rootScope.token);
// });
myapp.controller('myCtrl', function ($timeout, $scope, $rootScope, $mdDialog, $mdPanel, $http) {
  $scope.tokVar = '';
  $scope.memid='';
  $scope.data = {};
  $scope.conductedlist;
  $scope.commitees;
  $scope.upcoming;
  $scope.notification;

  $scope.isEmpty_notification=false;
  $scope.isEmpty_upcoming=false;
  $scope.isEmpty_committee=false;
  $scope.isEmpty_conducted=false;

  $timeout(function () {
    $scope.data.member_id=$scope.memid;
    $http({
      method: 'POST',
      url: "https://icmuat.niyogin.in/BoardMeeting/boardMeet/Dashboard/service/afterLogin",
      headers: {
        'Authorization':  $scope.tokVar,
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
        'Accept': 'application/json'
      },
      data: $scope.data,
    }).success(function (response) {
      console.log(response);
      $scope.commitees=response.committes.committe;
      $scope.conductedlist=response.ConductedList;
      $scope.upcoming=response.UPcomingBean;
      $scope.notification=response.NotificaBean;

      if($scope.notification[0]==undefined){
        //console.log("isEmpty_notification");
        $scope.isEmpty_notification=true;
       }
       if($scope.commitees[0]==undefined){
        //console.log("isEmpty_committee");
        $scope.isEmpty_committee=true;
       }
       if($scope.upcoming[0]==undefined){
        //console.log("isEmpty_upcoming");
        $scope.isEmpty_upcoming=true;
       }
       if($scope.conductedlist[0]==undefined){
        //console.log("isEmpty_conducted");
        $scope.isEmpty_conducted=true;
       }

      $rootScope.rootcommittess=$scope.commitees;
      $rootScope.rootupcoming=$scope.upcoming;
      $rootScope.rootnotification=$scope.notification;
      $rootScope.rootconducted=$scope.conductedlist;
    }).error(function (error) {
      alert("fail");
    });
  }, 500);
 
  $scope.change = function () {
    alert($scope.tokVar);
  }
  $scope.showNotification = function (ev) {
    $scope.dialog_notification='';
    $mdDialog.show({
      controller: NotificationDialogController,
      templateUrl: '../html/notification_dialog.html',
      parent: angular.element(document.body),
      targetEvent: ev,
      clickOutsideToClose: true,
      fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
    })
      .then(function (answer) {
        $scope.status = 'You said the information was "' + answer + '".';
      }, function () {
        $scope.status = 'You cancelled the dialog.';
      });
  };

  function NotificationDialogController($scope, $rootScope, $mdDialog) {
    $scope.notification_dialog=$rootScope.rootnotification;
    $scope.hide = function () {
      $mdDialog.hide();
    };

    $scope.cancel = function () {
      $mdDialog.cancel();
    };

    $scope.login = function () {
      alert($scope.dialog.boarduname);
    };

    $scope.answer = function (answer) {
      $mdDialog.hide(answer);
    };
  }

  $scope.showUpcomingMeetings = function (ev) {
    $mdDialog.show({
      controller: upcomingDialogController,
      templateUrl: '../html/upcomingMeeting_dialog.html',
      parent: angular.element(document.body),
      targetEvent: ev,
      clickOutsideToClose: true,
      fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
    })
      .then(function (answer) {
        $scope.status = 'You said the information was "' + answer + '".';
      }, function () {
        $scope.status = 'You cancelled the dialog.';
      });
  };

  function upcomingDialogController($scope, $rootScope, $mdDialog) {
    $scope.upcoming_dialog=$rootScope.rootupcoming;
    $scope.hide = function () {
      $mdDialog.hide();
    };

    $scope.cancel = function () {
      $mdDialog.cancel();
    };

    $scope.answer = function (answer) {
      $mdDialog.hide(answer);
    };
  }

  $scope.showConductedMeeting = function (ev) {
    $mdDialog.show({
      controller: conductedDialogController,
      templateUrl: '../html/ConductedMeeting_dialog.html',
      parent: angular.element(document.body),
      targetEvent: ev,
      clickOutsideToClose: true,
      fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
    })
      .then(function (answer) {
        $scope.status = 'You said the information was "' + answer + '".';
      }, function () {
        $scope.status = 'You cancelled the dialog.';
      });
  };
  function conductedDialogController($scope, $rootScope, $mdDialog) {
    $scope.conducted_dialog=$rootScope.rootconducted;
    $scope.hide = function () {
      $mdDialog.hide();
    };

    $scope.cancel = function () {
      $mdDialog.cancel();
    };

    $scope.answer = function (answer) {
      $mdDialog.hide(answer);
    };
  }


  $scope.showCommitees = function (ev) {
    $mdDialog.show({
      controller: Commitees_dialog_Controller,
      templateUrl: '../html/Committee.html',
      parent: angular.element(document.body),
      targetEvent: ev,
      clickOutsideToClose: true,
      fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
    })
      .then(function (answer) {
        $scope.status = 'You said the information was "' + answer + '".';
      }, function () {
        $scope.status = 'You cancelled the dialog.';
      });
  };
  function Commitees_dialog_Controller($scope, $rootScope, $mdDialog) {
    $scope.dialog_Committees=$rootScope.rootcommittess;
    $scope.hide = function () {
      $mdDialog.hide();
    };

    $scope.cancel = function () {
      $mdDialog.cancel();
    };

    $scope.answer = function (answer) {
      $mdDialog.hide(answer);
    };
  }

  // $mdPanelProvider.definePreset('demoPreset', {
  //   attachTo: angular.element(document.body),
  //   controller: PanelMenuCtrl,
  //   controllerAs: 'ctrl',
  //   template: '' +
  //       '<div class="menu-panel" md-whiteframe="4">' +
  //       '  <div class="menu-content">' +
  //       '    <div class="menu-item" ng-repeat="item in ctrl.items">' +
  //       '      <button class="md-button">' +
  //       '        <span>{{item}}</span>' +
  //       '      </button>' +
  //       '    </div>' +
  //       '    <md-divider></md-divider>' +
  //       '    <div class="menu-item">' +
  //       '      <button class="md-button" ng-click="ctrl.closeMenu()">' +
  //       '        <span>Close Menu</span>' +
  //       '      </button>' +
  //       '    </div>' +
  //       '  </div>' +
  //       '</div>',
  //   panelClass: 'menu-panel-container',
  //   focusOnOpen: false,
  //   zIndex: 100,
  //   propagateContainerEvents: true,
  //   groupName: 'menus'
  // });



  // this.navigation = {
  //   name: 'navigation',
  //   items: [
  //     'Home',
  //     'About',
  //     'Contact'
  //   ]
  // };
  // this.favorites = {
  //   name: 'favorites',
  //   items: [
  //     'Add to Favorites'
  //   ]
  // };
  // this.more = {
  //   name: 'more',
  //   items: [
  //     'Account',
  //     'Sign Out'
  //   ]
  // };

  // $mdPanel.newPanelGroup('menus', {
  //   maxOpen: 2
  // });

  // this.showMenu = function($event, menu) {
  //   /**
  //    * The request to open the panel has two arguments passed into it. The
  //    * first is a preset name passed in as a string. This will request a
  //    * cached preset and apply its configuration parameters. The second is an
  //    * object containing parameters that can only be filled through a
  //    * controller. These parameters represent configuration needs associated
  //    * with user interaction, panel position, panel animation, and other
  //    * miscellaneous needs.
  //    */
  //   $mdPanel.open('demoPreset', {
  //     id: 'menu_' + menu.name,
  //     position: $mdPanel.newPanelPosition()
  //         .relativeTo($event.target)
  //         .addPanelPosition(
  //           $mdPanel.xPosition.ALIGN_START,
  //           $mdPanel.yPosition.BELOW
  //         ),
  //     locals: {
  //       items: menu.items
  //     },
  //     openFrom: $event
  //   });
  // };

  // this.closeMenu = function() {
  //   mdPanelRef && mdPanelRef.close();
  // };


})

