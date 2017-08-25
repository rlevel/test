package cn.appsys.pojo;

import java.util.Date;

public class DataDictionary {
	private Long id;

	private String typeCode;

	private String typeName;

	private Long valueId;

	private String valueName;

	private Long createdBy;

	private Date creationDate;

	private Long modifyBy;

	private Date modifyDate;
	private String tcode;

	public String getTcode() {
		return tcode;
	}

	public void setTcode(String tcode) {
		this.tcode = tcode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String gettypeCode() {
		return typeCode;
	}

	public void settypeCode(String typeCode) {
		this.typeCode = typeCode == null ? null : typeCode.trim();
	}

	public String gettypeName() {
		return typeName;
	}

	public void settypeName(String typeName) {
		this.typeName = typeName == null ? null : typeName.trim();
	}

	public Long getvalueId() {
		return valueId;
	}

	public void setvalueId(Long valueId) {
		this.valueId = valueId;
	}

	public String getvalueName() {
		return valueName;
	}

	public void setvalueName(String valueName) {
		this.valueName = valueName == null ? null : valueName.trim();
	}

	public Long getcreatedBy() {
		return createdBy;
	}

	public void setcreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getcreationDate() {
		return creationDate;
	}

	public void setcreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getmodifyBy() {
		return modifyBy;
	}

	public void setmodifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getmodifyDate() {
		return modifyDate;
	}

	public void setmodifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "DataDictionary [id=" + id + ", typeCode=" + typeCode
				+ ", typeName=" + typeName + ", valueId=" + valueId
				+ ", valueName=" + valueName + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + "]";
	}

}