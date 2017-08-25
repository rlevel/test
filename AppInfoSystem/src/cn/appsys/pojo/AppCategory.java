package cn.appsys.pojo;

import java.util.Date;

public class AppCategory {
	private Integer id;

	private String categoryCode;

	private String categoryName;

	private Integer parentId;

	private Long createdBy;

	private Date creationTime;

	private Long modifyBy;

	private Date modifyDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "AppCategory [id=" + id + ", categoryCode=" + categoryCode
				+ ", categoryName=" + categoryName + ", parentId=" + parentId
				+ ", createdBy=" + createdBy + ", creationTime=" + creationTime
				+ ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + "]";
	}

}