package com.boardmeetdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.boardmeet.bean.CommitteeBean;
import com.boardmeet.bean.ConductedMeetingsBean;
import com.boardmeet.bean.MeetingInfoReqBean;
import com.boardmeet.bean.MeetingResponse;
import com.boardmeet.bean.NotificationBean;
import com.boardmeet.bean.UpcomingMeetingsBean;
import com.boardmeetutil.BoardMeetingSql;
import com.boardmeetutil.CommonUtils;
import com.serverinit.ConfigListener;

public class MeetingDao {
	
	private static final String[] WeekDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday",
	        "Friday", "Saturday" };
	private static SimpleDateFormat dateformate=new SimpleDateFormat(ConfigListener.getProperty("E_DataBaseMeetingDate"));
	private static String Day="";
	private static String DateMonth="";
	
	ConductedMeetingsBean conducted=null;
	UpcomingMeetingsBean  upcoming=null;
	NotificationBean      TendayNotification=null;
	
	public Response boardMemberDashboard(MeetingInfoReqBean bean) {
		Response resp=null;
		List<ConductedMeetingsBean> conductedlist=null;
		List<UpcomingMeetingsBean> upcominglist=null;
		List<NotificationBean> notificationlist=null;
		CommitteeBean committee=null;
		PreparedStatement pst;
		MeetingResponse datalist=null;
		try {
			committee=boardMemberCommitees(bean);
			Connection con=CommonUtils.testConnection();
			pst = con.prepareStatement(BoardMeetingSql.UserMeetings);
		pst.setInt(1, Integer.parseInt(bean.getMember_id()));
		System.out.println("Query Execution with member_id");
		ResultSet rset=pst.executeQuery();
		conductedlist=new ArrayList<ConductedMeetingsBean>();
		upcominglist=new ArrayList<UpcomingMeetingsBean>();
		notificationlist=new ArrayList<NotificationBean>();
		datalist=new MeetingResponse();
		while(rset.next()) {		
			JSONObject upComFlag=upComNotification(rset);
			Set<String> set =upComFlag.keySet();
			for(String key:set) {
			if(key.equals("upcoming")) {
				upcominglist.add((UpcomingMeetingsBean)upComFlag.get("upcoming"));
				
			   }
			if(key.equals("TendayNotification")) {
				notificationlist.add((NotificationBean)upComFlag.get("TendayNotification"));
			   }
			if(key.equals("conducted")) {
				conductedlist.add((ConductedMeetingsBean)upComFlag.get("conducted"));
			   }
			}
		  }
		 }
		 catch (SQLException e) {
			e.printStackTrace();
		}
		 datalist.setUPcomingBean(upcominglist);
		 datalist.setNotificaBean(notificationlist);
		 datalist.setConductedList(conductedlist);
		 datalist.setCommittes(committee);
		 
		if(conductedlist==null && notificationlist==null && upcominglist==null) {
			System.out.println("all three null");
			resp=Response.status(202).entity("There is no data in both list").build();
		}
		else {	
			System.out.println("===========INto the else "+datalist);
				resp=Response.ok().entity(datalist).build();
		  }
		
		return resp;
	} 
	
	 /*public void run() {
		System.out.println("run=UpperName===="+Thread.currentThread().getName());
		System.out.println(upComNotification(datetime));
		System.out.println("run=DownName===="+Thread.currentThread().getName()+"\n");
	}*/
	
	public JSONObject upComNotification(ResultSet rset) throws SQLException {		
		JSONObject obj=null;
		boolean flag=false;
		String date=rset.getString("date");
		String time=rset.getString("time");
		String meeting_id=String.valueOf(rset.getInt("meeting_id"));
		String title=rset.getString("title");
		String venue=rset.getString("venue");
		String agendalink=rset.getString("agenda_link");
		String minutes_of_meeting=rset.getString("minute_of_meeting_link");  // download link  for  for conduted meetings 
		String date_time=date+" "+time;
		
		GregorianCalendar cal= new GregorianCalendar();
		try {
			obj=new JSONObject();
			//System.out.println("UpperName===="+Thread.currentThread().getName());
			 Date parseDatime=dateformate.parse(date_time);
			 Date currentdate=dateformate.parse(dateformate.format(new Date()));
			 long timediff=parseDatime.getTime()-currentdate.getTime();
			 cal.setTime(parseDatime);
				Day=WeekDays[cal.get(Calendar.DAY_OF_WEEK)-1];
			    DateMonth=new SimpleDateFormat(ConfigListener.getProperty("F_ForDateWithMonthName")).format(parseDatime);//ConfigListener.getProperty("F_ForDateWithMonthName")
			 System.out.println(timediff);
				flag=timediff>=0?true:false; 
				if(flag) {
				    if(timediff>=864000000) {
				    	System.out.println("upcoming");
				    		upcoming= new UpcomingMeetingsBean(meeting_id, title, Day, DateMonth, MeetingDao.getDozenTime(time), agendalink, venue);
				    		obj.put("upcoming", upcoming);
						}
						else {
							System.out.println("TendayNotification");
							TendayNotification=new NotificationBean(meeting_id, title, Day, DateMonth, MeetingDao.getDozenTime(time), agendalink, venue);;	
							obj.put("TendayNotification", TendayNotification);
						}
				    
				    }
				else {
					System.out.println("Notification Meetings" );	
					conducted= new ConductedMeetingsBean(meeting_id, title, Day, DateMonth, MeetingDao.getDozenTime(time), agendalink, venue, minutes_of_meeting);
					obj.put("conducted", conducted);
				}
				
		   } catch (ParseException e) {
			  e.printStackTrace();
		  }
		return obj;
	}
	
	public static void main(String args[]) throws ParseException {
		//MeetingDao hh=new MeetingDao();
		//hh.upComNotification("05/18/2018 11:25");
		SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		long ss=df1.parse("05/18/2018 00:25").getTime()-df1.parse("05/08/2018 00:25").getTime();
		System.out.println(ss);
	}
	
	public static void tenDayNotification() {
		
	}
	
	
	 public static String getDozenTime(String Time) {
		SimpleDateFormat df = new SimpleDateFormat(ConfigListener.getProperty("G_ForStringToTimeParse"));
		Date date=null;
		try {
			date = df.parse(Time);
		} catch (ParseException e) {
			e.printStackTrace();
		 }
		df.applyPattern(ConfigListener.getProperty("H_ConvertToAmPm"));
		return df.format(date);
	}
	 
	 public CommitteeBean boardMemberCommitees(MeetingInfoReqBean bean) {
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
			
			return commitees;
		}
}
