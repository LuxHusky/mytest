package com.mws.domain;

public class WorkType {

	private long workTypeID;
	private String workTypeName;

	public WorkType() {
		super();
	}

	public WorkType(long workTypeID, String workTypeName) {
		super();
		this.workTypeID = workTypeID;
		this.workTypeName = workTypeName;
	}

	public long getWorkTypeID() {
		return workTypeID;
	}

	public void setWorkTypeID(long workTypeID) {
		this.workTypeID = workTypeID;
	}

	public String getWorkTypeName() {
		return workTypeName;
	}

	public void setWorkTypeName(String workTypeName) {
		this.workTypeName = workTypeName;
	}

}
