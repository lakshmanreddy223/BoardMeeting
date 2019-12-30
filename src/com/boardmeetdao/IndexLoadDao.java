package com.boardmeetdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.boardmeet.bean.MembersBean;
import com.boardmeetutil.BoardMeetingSql;
import com.boardmeetutil.CommonUtils;

public class IndexLoadDao {

	public Response boardMemberDashboard() {
		Response resp=null;
		List<MembersBean> memberlist=null;
		PreparedStatement pst;
		try {
			Connection con=CommonUtils.testConnection();
			pst = con.prepareStatement(BoardMeetingSql.GetAllMembers);
		  ResultSet rset=pst.executeQuery();
		  memberlist=new ArrayList<MembersBean>();
		 while(rset.next()) {
			MembersBean membean=new MembersBean();
			membean.setMemberid(String.valueOf(rset.getInt("member_id")));
			membean.setUname(rset.getString("email"));
			membean.setMembername(rset.getString("member_name"));
			membean.setMemberdesignation(rset.getString("designation"));	
			membean.setImagepath(rset.getString("image_path"));
			memberlist.add(membean);
		  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(memberlist.isEmpty()) {
			resp=Response.status(202).entity(new JSONObject().put("msg", "There is no user")).build();
		}
		else {
			resp=Response.ok().entity(memberlist).build();
		}
		return resp;
		
	} 
	
}
