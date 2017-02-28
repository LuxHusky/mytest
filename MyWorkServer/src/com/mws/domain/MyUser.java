package com.mws.domain;

public class MyUser {
			
	private String account;
	private String password;
	private String name;
	private int id;
	private String loginType;
	private int user_sorce;

	public String toString() {
		return "MyUser [account=" + account + ", password=" + password
				+ ", name=" + name + ", id=" + id + ", loginType=" + loginType
				+ ", user_sorce=" + user_sorce + "]";
	}
	public MyUser(String account, String password, String name, int id,
			String loginType, int user_sorce) {
		super();
		this.account = account;
		this.password = password;
		this.name = name;
		this.id = id;
		this.loginType = loginType;
		this.user_sorce = user_sorce;
	}
	public MyUser(){
		super();
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public int getUser_sorce() {
		return user_sorce;
	}
	public void setUser_sorce(int user_sorce) {
		this.user_sorce = user_sorce;
	}
	
	
	
	
}
