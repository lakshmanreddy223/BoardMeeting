<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<html>
<head>
<% 
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.

%>
    <title>Board_Login</title>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.8/angular-material.min.css">
    <link rel="stylesheet" href="../css/style.css" />
    <!-- <link rel="stylesheet" href="../css/app.css" /> -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="../css/app.css" />
    <script rel="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
    <script rel="text/javascript" src='https://cdnjs.cloudflare.com/ajax/libs/angular-material-icons/0.7.1/angular-material-icons.min.js'></script>
    <script rel="text/javascript" src="../js/angular-animate.min.js"></script>
    <script rel="text/javascript" src="../js/angular-aria.min.js"></script>
    <script rel="text/javascript" src="../js/angular-messages.min.js"></script>
    <script rel="text/javascript" src="../js/angular-material.min.js"></script>
    <script rel="text/javascript" src="../controllers/index_controller.js"></script>
    <style>
        /* form {
            border: 3px solid #f1f1f1;
        }

        input[type=text],
        input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            opacity: 0.8;
        }

        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: #f44336;
        }

        .imgcontainer {
            text-align: center;
            margin: 24px 0 12px 0;
        }

        img.avatar {
            width: 40%;
            border-radius: 50%;
        }

        .container {
            padding: 16px;
        }

        span.psw {
            float: right;
            padding-top: 16px;
        }

        .img {
            width: auto;
        }

        .bg {
            background: #eeeeee;
            padding: 30px;
        }

        .ng_grid-container {
            box-shadow: 0px -1px 4px 2px rgba(0, 0, 0, 0.158);
            display: grid;
            grid-template-columns: auto auto;
            /* grid-gap: 10px;
    background-color: #f7f4f4;
    padding: 6%; 
        }*/
        .header_style{
            box-shadow: 0px -1px 4px 4px rgba(0, 0, 0, 0.158);
            padding: 56px;
            background-color: white;
        }
    </style>
</head>

<body>
   <header>
        <md-toolbar md-scroll-shrink >
                <div class="md-toolbar-tools header_style">
                        <img src="../image/fis-logo.png" alt="image caption"  style="width:204px">
                        <label  style="color:rgb(169, 158, 144);font-size: medium;padding-left:32px;"> Welcome Board Members</label>
                </div>
                
              </md-toolbar>
       </header>
    <div ng-app="profiles" ng-controller="profile_control" style='padding: 66px;'>
        <div ng-hide="isVisible" layout="row" layout-xs="column" layout-md="column" layout-align="space-around center" layout-wrap >
            <div class="user-div" style="position:relative" ng-mouseover="" ng-mouseleave="" ng-repeat="x in users">
                <!-- <div ng-click="showAdvanced($event,$index)">
                    <div class="md-user-avatar" layout="row" layout-align="center center" >  
                        <img src="../image/img1.jpg"  flex><!--url({{ x.imgpath || 
                     </div>
                    <p class="user-name">{{x.membername}}</p>
                    <p class="user-department">{{x.memberdesignation}}</p> 
                     <div layout="horizontal" layout-wrap layout-align="center start">
                        <div class="user-roles">{{x.memberdesignation}}</div>
                    </div> 
                 </div> --> 
                 <div ng-click="showAdvanced($event,$index)">
                 <md-card>
                        <img ng-src = "../image/img1.jpg" class = "md-card-image" style="padding: 8px;padding-bottom: 1px;" alt = "Learn HTML5">
                         
                        
                        <md-content layout-margin>
                                <span >{{x.membername}}</span><br>
                                <span>{{x.memberdesignation}}</span>
                        </md-content>
                        </md-card>
            </div>
        </div>
    </div>
        <!-- <div ng-hide="!isVisible">
            <md-dialog  layout="row" layout-align="space-around" layout-padding="layout-padding" ng-cloak="ng-cloak" class="login-form">
              <md-card flex="flex" flex-gt-sm="50" flex-gt-md="33">
                <md-toolbar>
                  <div class="md-toolbar-tools">
                    <h2><span>Login Form</span></h2>
                  </div>
                </md-toolbar>
                <md-card-content>
                  <form name="Form">
                    <md-input-container class="md-block">
                      <label>Login</label>
                      <input type="text" name="email" ng-model="vm.formData.email" placeholder="login" required=""/>
                      <div ng-messages="Form.email.$error" role="alert" multiple="">
                        <div ng-message="required" class="my-message">Please enter your email.</div>
                      </div>
                    </md-input-container>
                    <md-input-container class="md-block">
                      <label>Password</label>
                      <input type="password" name="password" ng-model="vm.formData.password" placeholder="password" required="" md-maxlength="16"/>
                      <div ng-messages="Form.password.$error" role="alert" multiple="">
                        <div ng-message="required" class="my-message">Please enter your password.</div>
                        <div ng-message="md-maxlength" class="my-message">Too long.</div>
                      </div>
                    </md-input-container>
                    <md-button ng-disabled="!Form.$valid" ng-click="vm.submit()" class="md-raised md-primary">&nbsp Login &nbsp</md-button>
                  </form>
                </md-card-content>
              </md-card>
            </md-dialog >   
        </div> -->
        <!-- <div ng-show="users.length<1" layout="column" class="nothing-to-show" layout-align="center center">
                <div class="empty-view-text">Seems no users created so far.</div>
                <div style="font-size:20px; color:#9E9E9E">Let's add one here</div>
                <md-button class="md-raised normal-button" ng-click="showUserAddDialog()">Add New User</md-button>
            </div> -->

    </div>
</body>
</head>
</html>
  <!-- <md-card-avatar>
                              <img class = "md-user-avatar" src = "/html5/images/html5-mini-logo.jpg">
                           </md-card-avatar> 
                           
                           <md-card-header-text>
                              <span class = "md-title">HTML5</span>
                              <span class = "md-subhead">Learn HTML5 @TutorialsPoint.com</span>
                           </md-card-header-text>
                        </md-card-header>-->
                        
                        <!-- <md-card-title>
                           <md-card-title-text>
                              <span class = "md-headline">{{x.membername}}</span>
                           </md-card-title-text>
                           <md-card-title-text>
                                <span class = "md-headline">{{x.memberdesignation}}</span>
                             </md-card-title-text>
                        </md-card-title> -->
                        
                        <!-- <md-card-actions layout = "row" layout-align = "start center">
                           <md-button>Download</md-button>
                           <md-button>Start</md-button>
                           <md-card-icon-actions>
                              <md-button class = "md-icon-button" aria-label = "icon">
                                 <md-icon class = "material-icons">add</md-icon>
                              </md-button>
                           </md-card-icon-actions>
                        </md-card-actions> -->