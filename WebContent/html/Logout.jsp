<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ page errorPage="html/error.jsp" %>
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
    <script rel="text/javascript" src="../controllers/logout_controller.js"></script>
    <style>
        
        .header_style{
            box-shadow: 0px -1px 4px 4px rgba(0, 0, 0, 0.158);
            padding: 56px;
            background-color: white;
        }

        .tooltip {
            position: relative;
    }
        
        .tooltip .tooltiptext {
    visibility: hidden;
    width: 120px;
    background-color: #555;
    color: #fff;
    text-align: center;
    border-radius: 6px;
    padding: 5px 0;
    position: absolute;
    z-index: 1;
    bottom: 125%;
    left: 50%;
    margin-left: -60px;
    opacity: 0;
    transition: opacity 0.3s;
}

.tooltip .tooltiptext::after {
    content: "";
    position: absolute;
    top: 100%;
    left: 50%;
    margin-left: -5px;
    border-width: 5px;
    border-style: solid;
    border-color: #555 transparent transparent transparent;
}

.tooltip:hover .tooltiptext {
    visibility: visible;
    opacity: 1;
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
         <div ng-app="profiles" ng-controller="profile_control" style='margin-top: 66px;'>
             <div ng-hide="isVisible" layout="row" layout-xs="column" layout-md="column" layout-align="space-around center" >
                 <div class="user-div" style="position:relative" ng-mouseover="" ng-mouseleave="" ng-repeat="x in users">
                     
                      <div ng-click="showAdvanced($event,$index)">
                      <md-card>
                             <img ng-src = "../image/img1.jpg" class = "md-card-image" style="padding: 8px;padding-bottom: 1px;" >      
                             <md-content layout-margin>
                                     <span >{{x.membername}}</span><br>
                                     <span>{{x.memberdesignation}}</span>
                             </md-content>
                             </md-card>
                 </div>
             </div>
         </div>
     
         </div>
     </body>
</head>
</html>
  