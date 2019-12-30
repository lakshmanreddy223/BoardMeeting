package com.boardmeet.bean;

public class ConductedMeetingsBean {
	
	private String meetingid;
	private String title;
	private String day;
	private String date;
	private String time;
	private String agendalink;
	private String venue;
	private String Minutes_of_meet;
	
	public ConductedMeetingsBean() {
		
	}
	
	public ConductedMeetingsBean(String title, String day, String date, String time, String agendalink, String venue,
			String minutes_of_meet) {
		super();
		this.title = title;
		this.day = day;
		this.date = date;
		this.time = time;
		this.agendalink = agendalink;
		this.venue = venue;
		Minutes_of_meet = minutes_of_meet;
	}

	
	
	public ConductedMeetingsBean(String meetingid, String title, String day, String date, String time,
			String agendalink, String venue, String minutes_of_meet) {
		super();
		this.meetingid = meetingid;
		this.title = title;
		this.day = day;
		this.date = date;
		this.time = time;
		this.agendalink = agendalink;
		this.venue = venue;
		Minutes_of_meet = minutes_of_meet;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAgendalink() {
		return agendalink;
	}
	public void setAgendalink(String agendalink) {
		this.agendalink = agendalink;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getMinutes_of_meet() {
		return Minutes_of_meet;
	}
	public void setMinutes_of_meet(String minutes_of_meet) {
		Minutes_of_meet = minutes_of_meet;
	}

	public String getMeetingid() {
		return meetingid;
	}

	public void setMeetingid(String meetingid) {
		this.meetingid = meetingid;
	}

	@Override
	public String toString() {
		return "ConductedMeetingsBean [meetingid=" + meetingid + ", title=" + title + ", day=" + day + ", date=" + date
				+ ", time=" + time + ", agendalink=" + agendalink + ", venue=" + venue + ", Minutes_of_meet="
				+ Minutes_of_meet + "]";
	}
    
	
}
