package com.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.boardmeet.bean.MeetingInfoReqBean;
import com.boardmeetdao.MeetingDao;

@Path("service")
public class BoardMeetServices {

	@POST 
    @Path("/afterLogin")  
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response getData(MeetingInfoReqBean bean){
		System.out.println("Enter into csv method");
		Response resp=null;
		MeetingDao meet=new MeetingDao();
		resp=meet.boardMemberDashboard(bean);
		return resp;
	}
	
}
