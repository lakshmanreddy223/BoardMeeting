package com.boardmeet.bean;

public class MembersBean {

	public String memberid;
	public String uname;
	public String membername;
	public String memberdesignation;
	public String imagepath;
	
	public MembersBean() {
		
	}

	public MembersBean(String memberid, String uname, String membername, String memberdesignation, String imagepath) {
		super();
		this.memberid = memberid;
		this.uname = uname;
		this.membername = membername;
		this.memberdesignation = memberdesignation;
		this.imagepath = imagepath;
	}



	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getMemberdesignation() {
		return memberdesignation;
	}


	public void setMemberdesignation(String memberdesignation) {
		this.memberdesignation = memberdesignation;
	}


	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	@Override
	public String toString() {
		return "MembersBean [memberid=" + memberid + ", uname=" + uname + ", membername=" + membername
				+ ", memberdegnation=" + memberdesignation + ", imagepath=" + imagepath + "]";
	}
	
}
