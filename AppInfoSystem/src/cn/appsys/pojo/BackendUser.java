package cn.appsys.pojo;

import java.util.Date;

public class BackendUser {
	private Integer id;

	private String usercode;

	private String username;

	private String userpassword;

	private Integer usertype;

	private Integer createdby;

	private Date creationdate;

	private Integer modifyby;

	private Date modifydate;

	private String uservaluename;

	public String getUservaluename() {
		return uservaluename;
	}

	public void setUservaluename(String uservaluename) {
		this.uservaluename = uservaluename;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode == null ? null : usercode.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword == null ? null : userpassword.trim();
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}

	public Integer getModifyby() {
		return modifyby;
	}

	public void setModifyby(Integer modifyby) {
		this.modifyby = modifyby;
	}

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	@Override
	public String toString() {
		return "BackendUser [id=" + id + ", usercode=" + usercode
				+ ", username=" + username + ", userpassword=" + userpassword
				+ ", usertype=" + usertype + ", createdby=" + createdby
				+ ", creationdate=" + creationdate + ", modifyby=" + modifyby
				+ ", modifydate=" + modifydate + ", uservaluename="
				+ uservaluename + "]";
	}

}