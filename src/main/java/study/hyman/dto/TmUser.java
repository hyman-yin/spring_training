package study.hyman.dto;

import java.util.Date;

public class TmUser {
	private String id;
	private String userId;
	private String userName;
	private Date createdDatetime;
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public Date getCreatedDatetime() {
		return createdDatetime;
	}
	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "TmUser [id=" + id + ", userId=" + userId + ", userName=" + userName + ", createdDatetime="
				+ createdDatetime + ", password=" + password + "]";
	}
	
}
