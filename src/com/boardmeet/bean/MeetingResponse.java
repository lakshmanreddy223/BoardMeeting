package com.boardmeet.bean;

import java.util.List;

public class MeetingResponse {
       
     List<ConductedMeetingsBean> ConductedList;
	 List<UpcomingMeetingsBean>  UPcomingBean;
	 List<NotificationBean>      NotificaBean;
	  CommitteeBean               committes; 
	 public MeetingResponse() {}
	 
	public MeetingResponse(List<ConductedMeetingsBean> conductedList, List<UpcomingMeetingsBean> uPcomingBean,
			List<NotificationBean> notificaBean) {
		super();
		ConductedList = conductedList;
		UPcomingBean = uPcomingBean;
		NotificaBean = notificaBean;
	}

	public MeetingResponse(List<ConductedMeetingsBean> conductedList, List<UpcomingMeetingsBean> uPcomingBean,
			List<NotificationBean> notificaBean, CommitteeBean committes) {
		super();
		ConductedList = conductedList;
		UPcomingBean = uPcomingBean;
		NotificaBean = notificaBean;
		this.committes = committes;
	}

	public List<ConductedMeetingsBean> getConductedList() {
		return ConductedList;
	}
	public void setConductedList(List<ConductedMeetingsBean> conductedList) {
		ConductedList = conductedList;
	}
	public List<UpcomingMeetingsBean> getUPcomingBean() {
		return UPcomingBean;
	}
	public void setUPcomingBean(List<UpcomingMeetingsBean> uPcomingBean) {
		UPcomingBean = uPcomingBean;
	}
	public List<NotificationBean> getNotificaBean() {
		return NotificaBean;
	}
	public void setNotificaBean(List<NotificationBean> notificaBean) {
		NotificaBean = notificaBean;
	}

	public CommitteeBean getCommittes() {
		return committes;
	}

	public void setCommittes(CommitteeBean committes) {
		this.committes = committes;
	}

	@Override
	public String toString() {
		return "MeetingResponse [ConductedList=" + ConductedList + ", UPcomingBean=" + UPcomingBean + ", NotificaBean="
				+ NotificaBean + ", committes=" + committes + "]";
	}

	
}
