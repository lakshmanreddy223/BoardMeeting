<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<html>
<head>
        <title>Board Logout</title>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.8/angular-material.min.css">
        <link rel="stylesheet" href="css/style.css" />
        <!-- <link rel="stylesheet" href="../css/app.css" /> -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="css/app.css" />
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <script rel="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
        <script rel="text/javascript" src='https://cdnjs.cloudflare.com/ajax/libs/angular-material-icons/0.7.1/angular-material-icons.min.js'></script>
        <script rel="text/javascript" src="js/angular-animate.min.js"></script>
        <script rel="text/javascript" src="js/angular-aria.min.js"></script>
        <script rel="text/javascript" src="js/angular-messages.min.js"></script>
        <script rel="text/javascript" src="js/angular-material.min.js"></script>
        <script rel="text/javascript" src="controllers/index_controller.js"></script>
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
    padding: 4px 0;
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
    margin-left: -4px;
    border-width: 4px;
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
                             <img src="image/fis-logo.png" alt="image caption"  style="width:204px">
                             <label  style="color:rgb(169, 158, 144);font-size: medium;padding-left:32px;"> Welcome Board Members</label>
                            </div>
                            <span flex></span>
                            <span style="padding-left:48px;font-size:20px;color:green;background-color: rgb(247, 248, 255);"> You have successfully logged out</span>
                   </md-toolbar>
            </header>
         <div ng-app="profiles" ng-controller="profile_control" style='margin-top: 66px;'>
              <div ng-hide="isVisible" layout="row" layout-padding layout-wrap layout-fill style="padding-bottom: 32px;" layout-align="center">
                        <md-whiteframe class="md-whiteframe-{{$index+1}}dp user-div" style="margin:32px" flex-sm="45" flex-gt-sm="35" flex-gt-md="25"  layout-align="center center" ng-repeat="x in users">
                           <div ng-click="showAdvanced($event,$index)">
                               <md-card style="padding-top: 16px;box-shadow: unset;line-height: 24px; ">         
                                  <img ng-src = "{{x.imagepath}}" class = "md-card-image" style="height:178px;width:180px;align-self: center;margin: 2px;" >
                               <!--   <img ng-if="x.imagepath==null" src = "image/no_user.jpg" class = "md-card-image" style="height:178px;width:180px;align-self: center;margin: 2px;" >-->  
                                  <md-content layout-margin>
                                          <span ><b>{{x.membername}}<b></span><br>
                                          <span>{{x.memberdesignation}}</span>
                                  </md-content>
                                  </md-card>
                        </div>
                       </md-whiteframe>
                      </div>
     
         </div>
     </body>
</head>
</html>
  