package cn.appsys.pojo;

import java.util.Date;

public class AppCategory {
	private Integer id;

	private String categorycode;

	private String categoryname;

	private Integer parentid;

	private Long createdby;

	private Date creationtime;

	private Long modifyby;

	private Date modifydate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategorycode() {
		return categorycode;
	}

	public void setCategorycode(String categorycode) {
		this.categorycode = categorycode == null ? null : categorycode.trim();
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname == null ? null : categoryname.trim();
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Long getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}

	public Date getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(Date creationtime) {
		this.creationtime = creationtime;
	}

	public Long getModifyby() {
		return modifyby;
	}

	public void setModifyby(Long modifyby) {
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
		return "AppCategory [id=" + id + ", categorycode=" + categorycode
				+ ", categoryname=" + categoryname + ", parentid=" + parentid
				+ ", createdby=" + createdby + ", creationtime=" + creationtime
				+ ", modifyby=" + modifyby + ", modifydate=" + modifydate + "]";
	}

}