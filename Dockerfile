FROM tomee
MAINTAINER Lakshman
RUN yum update -y
COPY BoardMeeting-0.0.1-SNAPSHOT.war /usr/local/tomee/webapps/

