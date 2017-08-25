package cn.appsys.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class AppVersion {
	private Long id;

	private Long appId;

	private String versionNo;

	private String versionInfo;

	private Long publishStatus;

	private String downloadLink;

	private BigDecimal versionSize;

	private Long createdBy;

	private Date creationDate;

	private Long modifyBy;

	private Date modifyDate;

	private String apkLocPath;

	private String apkFileName;

	private String apkName;

	private String appName;

	private String publishStatusName;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getappId() {
		return appId;
	}

	public void setappId(Long appId) {
		this.appId = appId;
	}

	public String getversionNo() {
		return versionNo;
	}

	public void setversionNo(String versionNo) {
		this.versionNo = versionNo == null ? null : versionNo.trim();
	}

	public String getversionInfo() {
		return versionInfo;
	}

	public void setversionInfo(String versionInfo) {
		this.versionInfo = versionInfo == null ? null : versionInfo.trim();
	}

	public Long getpublishStatus() {
		return publishStatus;
	}

	public void setpublishStatus(Long publishStatus) {
		this.publishStatus = publishStatus;
	}

	public String getdownloadLink() {
		return downloadLink;
	}

	public void setdownloadLink(String downloadLink) {
		this.downloadLink = downloadLink == null ? null : downloadLink.trim();
	}

	public BigDecimal getversionSize() {
		return versionSize;
	}

	public void setversionSize(BigDecimal versionSize) {
		this.versionSize = versionSize;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
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

	public String getApkLocPath() {
		return apkLocPath;
	}

	public void setApkLocPath(String apkLocPath) {
		this.apkLocPath = apkLocPath;
	}

	public String getApkFileName() {
		return apkFileName;
	}

	public void setApkFileName(String apkFileName) {
		this.apkFileName = apkFileName;
	}

	public String getapkName() {
		return apkName;
	}

	public void setapkName(String apkName) {
		this.apkName = apkName;
	}

	public String getpublishStatusName() {
		return publishStatusName;
	}

	public void setpublishStatusName(String publishStatusName) {
		this.publishStatusName = publishStatusName;
	}

	@Override
	public String toString() {
		return "AppVersion [id=" + id + ", appId=" + appId + ", versionNo="
				+ versionNo + ", versionInfo=" + versionInfo
				+ ", publishStatus=" + publishStatus + ", downloadLink="
				+ downloadLink + ", versionSize=" + versionSize
				+ ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate
				+ ", apkLocPath=" + apkLocPath + ", apkFileName=" + apkFileName
				+ ", apkName=" + apkName + ", appName=" + appName
				+ ", publishStatusName=" + publishStatusName + "]";
	}

}