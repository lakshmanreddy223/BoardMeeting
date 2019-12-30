package com.boardmeet.bean;

import java.util.List;

public class CommitteeBean {
	
	private List<String> committe;

	public CommitteeBean() {}
	
	public CommitteeBean(List<String> committe) {
		super();
		this.committe = committe;
	}

	public List<String> getCommitte() {
		return committe;
	}

	public void setCommitte(List<String> committe) {
		this.committe = committe;
	}

	@Override
	public String toString() {
		return "CommitteeBean [committe=" + committe + "]";
	}
	
}
