package com.adb.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	int id;
	String logonId;
	String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogonId() {
		return logonId;
	}
	public void setLogonId(String logonId) {
		this.logonId = logonId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", logonId=" + logonId + ", password=" + password + "]";
	}
	
	
}
