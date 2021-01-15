package com.platform.entity;

/*
 * 2021/1/5
 * Mikael
 * 
 *用户实体类
 */
public class Users {
	
	//用户Id
	public String userId;
	//用户姓名
	public String userName;
	//用户生日
	public String birthDay;
	//用户性别
	public String gender;
	//用户电话号码
	public String phoneNumber;
	//用户账号
	public String account;
	//用户密码
	public String password;
	//用户等级(1管理员 2vip用户 3普通用户 0超级管理员)
	public String userStatus;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

}
