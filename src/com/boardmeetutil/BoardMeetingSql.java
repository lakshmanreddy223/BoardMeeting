package com.boardmeetutil;

public class BoardMeetingSql {
	
	public static final String GetAllMembers="SELECT * FROM boardmember";
	public static final String GetCommitties="select distinct committee_name from committee where committee_id in ( select committee_id from mapping where member_id=?)";
	public static final String UserMeetings="select * from schedulemeeting where meeting_id in (select distinct meeting_id from mappingschedule where member_id=?)";
}
