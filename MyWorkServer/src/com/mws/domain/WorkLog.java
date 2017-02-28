package com.mws.domain;

public class WorkLog {

	private long workLogID;
	private long userID;
	private long workTypeID;
	private long longTime;
	private String workContent;

	public WorkLog() {
		super();
	}

	public WorkLog(long workLogID, long userID, long workTypeID, long longTime,
			String workContent) {
		super();
		this.workLogID = workLogID;
		this.userID = userID;
		this.workTypeID = workTypeID;
		this.longTime = longTime;
		this.workContent = workContent;
	}

	public long getWorkLogID() {
		return workLogID;
	}

	public void setWorkLogID(long workLogID) {
		this.workLogID = workLogID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public long getWorkTypeID() {
		return workTypeID;
	}

	public void setWorkTypeID(long workTypeID) {
		this.workTypeID = workTypeID;
	}

	public long getLongTime() {
		return longTime;
	}

	public void setLongTime(long longTime) {
		this.longTime = longTime;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

}
