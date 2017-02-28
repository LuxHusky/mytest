package com.mws.domain;

public class UserType {

	private long userID;
	private long workTypeID;

	public UserType() {
		super();
	}

	public UserType(long userID, long workTypeID) {
		super();
		this.userID = userID;
		this.workTypeID = workTypeID;
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

}
