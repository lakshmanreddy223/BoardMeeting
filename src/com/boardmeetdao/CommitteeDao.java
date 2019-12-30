package com.boardmeetdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.boardmeet.bean.CommitteeBean;
import com.boardmeet.bean.MeetingInfoReqBean;
import com.boardmeetutil.BoardMeetingSql;
import com.boardmeetutil.CommonUtils;

public class CommitteeDao {
	
	
	public Response boardMemberCommitees(MeetingInfoReqBean bean) {
		Response resp=null;
		CommitteeBean commitees=null;
		Connection con=null;
		PreparedStatement pst;
		try {
			con=CommonUtils.testConnection();
			pst = con.prepareStatement(BoardMeetingSql.GetCommitties);
		pst.setInt(1, Integer.parseInt(bean.getMember_id()));
		ResultSet rset=pst.executeQuery();
		
		commitees=new CommitteeBean();
		List<String> li=new ArrayList<String>();
		while(rset.next()) {		
			li.add(rset.getString("committee_name"));
		}
		commitees.setCommitte(li);
		if(li.isEmpty()) {
			resp=Response.status(202).entity("Value is null").build();
		}
		else {
			resp=Response.ok().entity(commitees).build();
		}
	  } 
		catch(SQLException ex) {
	      		ex.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resp;
	}

}
