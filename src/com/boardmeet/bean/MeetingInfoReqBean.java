package com.boardmeet.bean;

public class MeetingInfoReqBean {

	public String member_id;
	
	public MeetingInfoReqBean() {}

	public MeetingInfoReqBean(String member_id) {
		super();
		this.member_id = member_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	
	
}
