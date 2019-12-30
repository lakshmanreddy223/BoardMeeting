package com.loadservice;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.boardmeetdao.IndexLoadDao;


@Path("indexload")
public class OnloadService {

		@GET
	    @Path("/before")  
	    @Produces(MediaType.APPLICATION_JSON)
		public Response getData(){
			System.out.println("Enter into csv method");
			Response resp=null;
			IndexLoadDao  load=new IndexLoadDao();
			resp=load.boardMemberDashboard();
			return resp;
		}
		
	}
	
