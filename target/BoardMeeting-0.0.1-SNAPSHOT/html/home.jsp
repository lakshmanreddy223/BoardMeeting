<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ page errorPage="error.jsp" %>
    <html>

    <head>
        <%
        
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        if(session.getAttribute("Authorization")==null)
        {
            out.println("<script>parent.location.href='index.jsp'</script>");
        }
       
        
    String auth =(String)session.getAttribute("Authorization");
    String memid =(String)session.getAttribute("memberid");
    String name =(String)session.getAttribute("member_name");
    String emailuname =(String)session.getAttribute("email");
    String designation =(String)session.getAttribute("designation");
    String phone =(String)session.getAttribute("phone");
    String imgpath =(String)session.getAttribute("imagepath");
%>

            <head>
                <title>Board_Login</title>
                <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.8/angular-material.min.css">
                <link rel="stylesheet" href="../css/style.css" />
                <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
                <!-- <link rel="stylesheet" href="../css/app.css" /> -->
                <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
                <link rel="stylesheet" href="../css/app.css" />
				<link rel="stylesheet" href="../css/style.css" />
                <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
                <script rel="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
                <script rel="text/javascript" src='https://cdnjs.cloudflare.com/ajax/libs/angular-material-icons/0.7.1/angular-material-icons.min.js'></script>
                <script rel="text/javascript" src="../js/angular-animate.min.js"></script>
                <script rel="text/javascript" src="../js/angular-aria.min.js"></script>
                <script rel="text/javascript" src="../js/angular-messages.min.js"></script>
                <script rel="text/javascript" src="../js/angular-material.min.js"></script>
                <script rel="text/javascript" src="../controllers/home_controller.js"></script>
                <style>
                    .header_style {
                        box-shadow: 0px -1px 4px 4px rgba(0, 0, 0, 0.158);
                        padding: 56px;
                        background-color: white;
                    }
                    .icon_style{
                        min-height: 20px;
                    }  
                    .view_all{
                        font-size: 12px;
                        cursor: pointer;
                        color:#5074ad;
                    }                
                </style>
                <script>
                  $(document).on("click", function(event){
        var $trigger = $(".w3-dropdown-click");
        if($trigger !== event.target && !$trigger.has(event.target).length){
          $('#Demo').attr('class','w3-hide');
        }            
    });
    function myFunction() {
      var x = document.getElementById("Demo");
      if (x.className.indexOf("w3-show") == -1) {
          x.className += " w3-show w3-dropdown-content w3-bar-block w3-border";
      } else { 
          x.className = x.className.replace(" w3-show", "");
      }
  }
                  </script>
            </head>

            <body ng-app="BlankApp" ng-controller="myCtrl" ng-cloak>
             
              <header>
                  <span style="display: none">{{tokVar = '<%=auth%>'}}</span>
                  <span style="display: none">{{memid = '<%=memid%>'}}</span>
                    <md-toolbar md-scroll-shrink>
                        <div class="md-toolbar-tools header_style" style="padding-right:0px" >
                            <img src="../image/fis-logo.png" alt="image caption" style="width:204px">
                            <span flex></span>
                            <md-card class="w3-dropdown-click" onclick="myFunction()" style="max-height: 120px;background: #0e3965d1;margin:0px;border-radius: 0px" >
                                    <md-card-title>
                                      <md-card-title-media>
                                        <div class="md-media-sm card-media " >
                                        <!--  <img ng-if="<%= imgpath %>==null" src="../image/no_user.jpg" style="color:grey;border-radius: 44px;"></img>-->
                                          <img src="<%= imgpath %>" style="color:grey;border-radius: 44px;height:inherit;"></img>
                                        </div>
                                    </md-card-title-media>
                                      <md-card-title-text style="margin-left:10px">
                                        <span class="md-headline" style="color:rgba(255, 255, 255, 0.98)"><%=name%><span style="color:white;margin-left:12px" flex>&#9662;</span></span>
                                        <span class="md-subhead description" style="color:rgba(255, 255, 255, 0.98)" layout-wrap><%=designation%></span>
                                      </md-card-title-text>
                                    </md-card-title>
                                    <div>
                                    <div id="Demo" class="w3-dropdown-content w3-bar-block w3-card-4 w3-animate-zoom" style="position:inherit;margin-left:56px">
                                      <a href="Logout"  href="_blank" class="w3-bar-item w3-button">Logout</a>
                                    </div>
                            </md-card>         
                        </div>
                    </md-toolbar>       
                </header>
              
                <div style="margin-top:32px">
                <div id="upperNotfiandCommittee"  layout-gt-md="row" layout-sm="column"  layout-margin layout-padding>
                    <div></div>
                    <div flex >
                        <md-card >
                                <md-toolbar style="background:linear-gradient(to right, #0e7ecee3 , #0e3965d1);" class="md-primary" >
                                  <div class="md-toolbar-tools" layout-align="center center">
                                    <!-- <lable class="md-flex">Add New KPI</lable> -->
                                    <h2 style="color:rgb(250,250,250)" >Notifications</h2>   
                                  </div>
                                </md-toolbar>
                                <md-card ng-show="!isEmpty_notification" ng-repeat="noti in notification | limitTo:2 " style="margin: 0px;">
                                  <div layout="row" >
                                    <div layout="column" style="min-height:98px;max-height:144px;" flex>
                                      <div layout="row" layout-padding style="padding-top:2px;min-height:56px;max-height:64px;overflow-y:auto">
                                            <md-card-content layout-padding flex style="padding-bottom:3px;display: contents;">
                                                    <span class="md-subhead description" style="font-size:14px" >{{noti.title}}</span>
                                        </md-card-content>
                                      </div>
                                      <div layout="row"  style="padding-top:2px;padding-bottom: 2px" >
                                        <div layout="row" layout-padding>
                                          <div layout="column">
                                            <md-icon md-svg-src="../image/calendar.svg" class="icon_style" aria-label="calendar"></md-icon>
                                            </div>
                                        <div layout="column">          
                                          <span flex>
                                                <span class="md-primary">{{noti.day}}</span>
                                          </span>
                                           </div>
                                          </div>
                                      
                                          <div layout="row" layout-padding style="padding-left: 0px" >                                         
                                              <div layout="column" >          
                                                <span flex>
                                                      <span class="md-primary">{{noti.date}}</span>
                                                </span>
                                                 </div>
                                            </div>    

                                            <div layout="row" layout-padding style="margin-left: 32px">
                                                    <div layout="column">
                                                      <md-icon md-svg-src="../image/time.svg" class="icon_style" aria-label="time "></md-icon>
                                                      </div>
                                                  <div layout="column">          
                                                    <span flex>
                                                          <span class="md-primary">{{noti.time}}</span>
                                                    </span>
                                                     </div>
                                                    </div>                             
                                    </div>
                                    <div layout="row" layout-padding  style="padding-top: 1px;"> 
                                              <span style="font-size: 12px">{{noti.venue}}</span>
                                              <span flex></span>   
                                              <span >  
                                                    <a href="{{noti.agendalink}}" target="_blank" style="display:flex"> 
                                                    <md-icon md-svg-src="../image/download.svg"  class="icon_style" aria-label="agenda"></md-icon>            
                                                        <span  class="md-primary" style="color:#16c36f;font-size: 14px" layout-margin >Agenda</span>  </a>   
                                                                      
                                        </div>                         
                                      </div>          
                                    <!-- <md-divider></md-divider> -->          
                                  </div>
                                 <div ng-if="$index==1" layout="row"  layout-align="end center" style="background: #e0e0e0"><span layout-padding ng-click="showNotification($event)" class="view_all" >view all</span></div>
                                  <md-divider class="horizontal-divider" style="border-color:black"></md-divider>
                                 </md-card>
                                 <md-card ng-show="isEmpty_notification" style="margin:0px;" >
                                        <md-card-header>
                                                <md-card-header-text>
                                                   <span><br></span>
                                                   <span class = "md-subhead" style="color:#0e3965d1;align-self: center;font-size: large;">You have no nearby meetings.</span>
                                                  <span><br></span>
                                                </md-card-header-text>
                                             </md-card-header>
                                 </md-card>
                              </md-card>
                            </div>

                            <div></div> 
                           
                            <div id="committee_div" flex>
                              <md-card >
                                    <md-toolbar style="background:linear-gradient(to right, #0e7ecee3 , #0e3965d1);" class="md-primary">
                                      <div class="md-toolbar-tools" layout-align="center center">
                                        <!-- <lable class="md-flex">Add New KPI</lable> -->
                                        <h2 style="color:rgb(250,250,250)" >Member of Committee</h2>       
                                      </div>
                                    </md-toolbar>
                                    <div  ng-show="!isEmpty_committee" ng-repeat="comit in commitees | limitTo:3">
                                    <md-card style="margin:0px;"  layout-padding >                                
                                      <div layout="row" layout-align="space-around center" >{{comit}}</div>                               
                                    </md-card>
                                     <div  ng-if="$index==2" layout="row" layout-align="end center"  style="background: #e0e0e0"><span layout-padding class="view_all" ng-click="showCommitees($event)" >view all</span></div>
                                    <md-divider class="horizontal-divider" style="border-color:black"></md-divider>
                                  </div>  
                                  <div  ng-show="isEmpty_committee">
                                        <md-card style="margin:0px;"  layout-padding >
                                                <md-card-header>
                                                        <md-card-header-text>
                                                          <span><br></span>
                                                           <span class = "md-subhead" style="color:#0e3965d1;align-self: center;font-size: large;">You are not associated with any active committee.</span>
                                                           <span></span>
                                                        </md-card-header-text>
                                                     </md-card-header>
                                         </md-card>
                                  </div>     
                                  </md-card>
                                  </div>
                                  <div></div>
                               </div>
                
                    <div id="Upcoming_div" ng-init="myVar=2" layout-gt-md="row" layout-sm="column" layout-margin layout-padding>
                    <div></div>
                    <div flex >
                    <md-card style="margin: 0px;">
                        <md-toolbar style="background:linear-gradient(to right, #0e7ecee3 , #0e3965d1);" class="md-primary">
                          <div class="md-toolbar-tools" layout-align="space-around center">
                            <!-- <lable class="md-flex">Add New KPI</lable> -->
                            <h2 style="color:rgb(250,250,250)">Upcoming Meetings</h2>
                          </div>
                        </md-toolbar>
                        <md-card ng-show="!isEmpty_upcoming" style="margin:0px" ng-repeat="upcome in upcoming | limitTo:2">
                          <div layout="row" style="height:112px ">
                                <md-card style="margin: 0px;" flex="45">
                                        <div layout="row" style="height:112px ">
                                          <div layout="column " flex>
                                            <div layout="row" layout-padding style="min-height:58px;max-height:96px;overflow-y:auto">
                                                  <md-card-content layout-padding flex style="padding-bottom:3px;display: contents;">
                                                          <span class="md-subhead description" style="font-size: 14px" >{{upcome.title}}</span>
                                              </md-card-content>
                                            </div>
                                            <div layout="row" layout-padding style="padding-top: 1px;padding-left:0px;margin-bottom: 16px;">
                                              <div layout="row" layout-padding>
                                                <div layout="column">
                                                  <md-icon md-svg-src="../image/calendar.svg" class="icon_style" aria-label="android "></md-icon>
                                                  </div>
                                              <div layout="column">          
                                                      <span class="md-primary" flex>{{upcome.day}}</span>
                                                 </div>
                                                </div>
                                            
                                                <div layout="row" layout-padding style="padding-left: 0px">                                         
                                                    <div layout="column" >          
                                                            <span class="md-primary" flex>{{upcome.date}}</span>
                                                       </div>
                                                  </div>    
      
                                                  <div layout="row" layout-padding style="margin-left: 16px">
                                                          <div layout="column">
                                                            <md-icon md-svg-src="../image/time.svg" class="icon_style" aria-label="android "></md-icon>
                                                            </div>
                                                        <div layout="column">          
                                                                <span class="md-primary" flex>{{upcome.time}}</span>
                                                           </div>
                                                          </div>                             
                                            </div>
                                          </div>
                                          <!-- <md-divider></md-divider> -->          
                                        </div>
                                       </md-card>
                            <!-- <md-divider></md-divider> -->
                            <md-divider class="vertical-divider"></md-divider>
                            <md-card flex=25 style="margin:0px" layout-align="space-around center">
                            <div layout="column " >   
                              <a href="{{upcome.agendalink}}" target="_blank">
                                <span style="color:#16c36f; font-size: 16px;">Agenda</span>  
                                </a>     
                            </div>
                            </md-card>
                            <md-divider class="vertical-divider "></md-divider>
                            <md-card flex="30" style="margin:0px" layout-padding >
                            <div layout="column" layout-wrap style="layout:4px"> 
                              <span  style="font-size: 16px;" >{{upcome.venue}}</span>         
                            </div>
                          </md-card>
                          </div>
                          <div ng-if="$index==1" ng-click="showUpcomingMeetings($event)" layout="row" layout-align="end center"  style="background: #e0e0e0"><span layout-padding class="view_all" >view all</span></div>
                          <md-divider class="horizontal-divider" style="border-color:black"></md-divider>
                        </md-card>
                        <md-card ng-show="isEmpty_upcoming" style="margin:0px;"  layout-padding >
                                <md-card-header>
                                        <md-card-header-text>
                                            <span><br></span>
                                           <span class = "md-subhead" style="color:#0e3965d1;align-self: center;font-size: large;">There are no meetings scheduled succeeding 10 days.</span>
                                           <span><br></span>
                                          </md-card-header-text>
                                        </md-card-header-text>
                                     </md-card-header>
                         </md-card>
                      </md-card>
                      </div>
                      <div></div>
                     </div>


                     <div id="conductedmeetings_div" layout-gt-md="row" layout-sm="column" layout-margin layout-padding>
                            <div></div>
                            <div flex >
                            <md-card style="margin: 0px;">
                                <md-toolbar style="background:linear-gradient(to right, #0e7ecee3 , #0e3965d1);" class="md-primary">
                                  <div class="md-toolbar-tools" layout-align="space-around center">
                                    <!-- <lable class="md-flex">Add New KPI</lable> -->
                                    <h2 style="color:rgb(250,250,250)">Conducted Meetings</h2>
                                  </div>
                                </md-toolbar>
                                <md-card ng-if="!isEmpty_conducted" style="margin:0px" ng-repeat="condlist in conductedlist | limitTo:2">
                                        <div layout="row" style="height:112px ">
                                              <md-card style="margin: 0px;" flex="45">
                                                      <div layout="row" style="height:112px ">
                                                        <div layout="column " flex>
                                                          <div layout="row" layout-padding  style="min-height:58px;max-height:94px;overflow-y:auto">
                                                                <md-card-content layout-padding flex style="padding-bottom:3px;display: contents;">
                                                                        <span class="md-subhead description"  style="font-size: 14px">{{condlist.title}}</span>
                                                            </md-card-content>
                                                          </div>
                                                          <div layout="row" layout-padding style="padding-top:0px;padding-left:0px;margin-bottom:24px">
                                                            <div layout="row" layout-padding flex="65" style="padding-right:0px">
                                                              <div layout="column">
                                                                <md-icon md-svg-src="../image/calendar.svg" class="icon_style" aria-label="android "></md-icon>
                                                                </div>
                                                            <div layout="column">          
                                                              <span flex>
                                                                    <span class="md-primary">{{condlist.day}}</span>
                                                              </span>
                                                               </div>
															                                             
                                                                  <div layout="column" style="margin-left: 16px;">          
                                                                    <span >
                                                                          <span class="md-primary">{{condlist.date}}</span>
                                                                    </span>
                                                                   
                                                                </div> 
                                                              </div>
                                                          
                                                              
                                                                <div layout="row" layout-padding  flex="35" style="padding-left: 0px; padding-right: 0px;">
                                                                        <div layout="column">
                                                                          <md-icon md-svg-src="../image/time.svg" class="icon_style" aria-label="time"></md-icon>
                                                                          </div>
                                                                      <div layout="column">          
                                                                        <span flex>
                                                                              <span class="md-primary">{{condlist.time}}</span>
                                                                        </span>
                                                                         </div>
                                                                        </div>                             
                                                          </div>
                                                        </div>
                                                        <!-- <md-divider></md-divider> -->          
                                                      </div>
                                                     </md-card>
                                          <!-- <md-divider></md-divider> -->
                                          <md-divider class="vertical-divider"></md-divider>
                                          <md-card flex=10 style="margin:0px" layout-align="space-around center">
                                          <div layout="column " >   
                                            <a target="_blank" href="{{condlist.agendalink}}">
                                              <span style="color:#16c36f; font-size: 16px;">Agenda</span>  
                                              </a>           
                                          </div>
                                          </md-card>
                                          <md-divider class="vertical-divider "></md-divider>
                                          <md-card flex=15 style="margin:0px" layout-align="space-around center">
                                          <div layout="column" > 
                                                <a href="{{condlist.minutes_of_meet}}" target="_blank">
                                                        <span ng-if="condlist.minutes_of_meet !='NA'" style="color:#16c36f;font-size: 16px;" >Minutes Of Meetings</span>
                                                        </a>
                                                        <span ng-if="condlist.minutes_of_meet =='NA'" style="padding:12px;color:#16c36f;font-size: 16px;">Minutes of Meeting yet to be uploaded</span> 
                                            </div>
                                         </md-card>
                                          <md-divider class="vertical-divider "></md-divider>
                                          <md-card flex=30 style="margin:0px" layout-padding >
                                          <div layout="column" layout-wrap style="padding:4px">  
                                            <span style="font-size: 16px;" >{{condlist.venue}}</span>
                                          </div>
                                       </md-card>
                                    </div>
                                    <div ng-if="$index==1" layout="row" layout-align="end center"  style="background: #e0e0e0"><span layout-padding class="view_all" ng-click="showConductedMeeting($event)">view all</span></div>
                                    <md-divider class="horizontal-divider" style="border-color:black"></md-divider>
                                 </md-card>
                                 <md-card ng-show="isEmpty_conducted" style="margin:0px;"  layout-padding >
                                        <md-card-header>
                                                <md-card-header-text>
                                                   <span ><br></span>
                                                   <span class = "md-subhead" style="color:#0e3965d1;align-self: center;font-size: large;">There are no conducted meetings.</span>
                                                   <span></span>
                                                </md-card-header-text>
                                             </md-card-header>
                                 </md-card>
                              </md-card>
                              </div>
                              <div></div>
                             </div>
        

                    <!--45,10,15,30 <div layout="column " flex="15" layout-align="space-around center">
                                      <span style="color:#16c36f;font-size: 13px;">Minutes Of Meetings</u>
                                      </span>
                                    </div>-->

            </div>

            </body>

    </html>