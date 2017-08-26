package cn.appsys.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppInfo implements Serializable {
	private static final long serialVersionUID = 621945397109638653L;

	private Integer id;

	private String softwareName;

	private String APKName;

	private String supportROM;

	private String interfaceLanguage;

	private BigDecimal softwareSize;

	private Date updateDate;

	private Integer devId;

	private String appInfo;

	private Integer status;

	private Date onSaleDate;

	private Date offSaleDate;

	private Long flatformId;

	private Integer categoryLevel1;

	private Integer categoryLevel2;

	private Integer categoryLevel3;

	private Integer downloads;

	private Integer createdBy;

	private Date creationDate;

	private Integer modifyBy;

	private Date modifyDate;

	private String logoPicPath;

	private String logoLocPath;

	private Integer versionId;

	private String statusName;

	private String flatformName;

	private String categorylevel1Name;

	private String categorylevel2Name;

	private String categorylevel3Name;

	private String versionNo;

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getFlatformName() {
		return flatformName;
	}

	public void setFlatformName(String flatformName) {
		this.flatformName = flatformName;
	}

	public String getCategorylevel1Name() {
		return categorylevel1Name;
	}

	public void setCategorylevel1Name(String categorylevel1Name) {
		this.categorylevel1Name = categorylevel1Name;
	}

	public String getCategorylevel2Name() {
		return categorylevel2Name;
	}

	public void setCategorylevel2Name(String categorylevel2Name) {
		this.categorylevel2Name = categorylevel2Name;
	}

	public String getCategorylevel3Name() {
		return categorylevel3Name;
	}

	public void setCategorylevel3Name(String categorylevel3Name) {
		this.categorylevel3Name = categorylevel3Name;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getAPKName() {
		return APKName;
	}

	public void setAPKName(String aPKName) {
		APKName = aPKName;
	}

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public String getSupportROM() {
		return supportROM;
	}

	public void setSupportROM(String supportROM) {
		this.supportROM = supportROM;
	}

	public String getInterfaceLanguage() {
		return interfaceLanguage;
	}

	public void setInterfaceLanguage(String interfaceLanguage) {
		this.interfaceLanguage = interfaceLanguage;
	}

	public BigDecimal getSoftwareSize() {
		return softwareSize;
	}

	public void setSoftwareSize(BigDecimal softwareSize) {
		this.softwareSize = softwareSize;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getAppInfo() {
		return appInfo;
	}

	public void setAppInfo(String appInfo) {
		this.appInfo = appInfo;
	}

	public Date getOnSaleDate() {
		return onSaleDate;
	}

	public void setOnSaleDate(Date onSaleDate) {
		this.onSaleDate = onSaleDate;
	}

	public Date getOffSaleDate() {
		return offSaleDate;
	}

	public void setOffSaleDate(Date offSaleDate) {
		this.offSaleDate = offSaleDate;
	}

	public Long getFlatformId() {
		return flatformId;
	}

	public void setFlatformId(Long flatformId) {
		this.flatformId = flatformId;
	}

	public Integer getCategoryLevel1() {
		return categoryLevel1;
	}

	public void setCategoryLevel1(Integer categoryLevel1) {
		this.categoryLevel1 = categoryLevel1;
	}

	public Integer getCategoryLevel2() {
		return categoryLevel2;
	}

	public void setCategoryLevel2(Integer categoryLevel2) {
		this.categoryLevel2 = categoryLevel2;
	}

	public Integer getCategoryLevel3() {
		return categoryLevel3;
	}

	public void setCategoryLevel3(Integer categoryLevel3) {
		this.categoryLevel3 = categoryLevel3;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getLogoPicPath() {
		return logoPicPath;
	}

	public void setLogoPicPath(String logoPicPath) {
		this.logoPicPath = logoPicPath;
	}

	public String getLogoLocPath() {
		return logoLocPath;
	}

	public void setLogoLocPath(String logoLocPath) {
		this.logoLocPath = logoLocPath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDevId() {
		return devId;
	}

	public void setDevId(Integer devId) {
		this.devId = devId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDownloads() {
		return downloads;
	}

	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Integer getVersionId() {
		return versionId;
	}

	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}

	@Override
	public String toString() {
		return "AppInfo [id=" + id + ", softwareName=" + softwareName
				+ ", APKName=" + APKName + ", supportROM=" + supportROM
				+ ", interfaceLanguage=" + interfaceLanguage
				+ ", softwareSize=" + softwareSize + ", updateDate="
				+ updateDate + ", devId=" + devId + ", appInfo=" + appInfo
				+ ", status=" + status + ", onSaleDate=" + onSaleDate
				+ ", offSaleDate=" + offSaleDate + ", flatformId=" + flatformId
				+ ", categoryLevel1=" + categoryLevel1 + ", categoryLevel2="
				+ categoryLevel2 + ", categoryLevel3=" + categoryLevel3
				+ ", downloads=" + downloads + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + ", logoPicPath=" + logoPicPath
				+ ", logoLocPath=" + logoLocPath + ", versionId=" + versionId
				+ ", statusName=" + statusName + ", flatformName="
				+ flatformName + ", categorylevel1Name=" + categorylevel1Name
				+ ", categorylevel2Name=" + categorylevel2Name
				+ ", categorylevel3Name=" + categorylevel3Name + ", versionNo="
				+ versionNo + "]";
	}

}
