package com.mws.domain;

public class User {

	private long userID;
	private int userSysID;
	private String userName;
	private String userPassWord;

	public User() {
		super();
	}

	public User(long userID, int userSysID, String userName, String userPassWord) {
		super();
		this.userID = userID;
		this.userSysID = userSysID;
		this.userName = userName;
		this.userPassWord = userPassWord;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public int getUserSysID() {
		return userSysID;
	}

	public void setUserSysID(int userSysID) {
		this.userSysID = userSysID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassWord() {
		return userPassWord;
	}

	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}

}
