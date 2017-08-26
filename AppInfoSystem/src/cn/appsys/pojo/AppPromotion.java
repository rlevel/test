package cn.appsys.pojo;

import java.util.Date;

public class AppPromotion {
	private Integer id;

	private Integer appid;

	private String adpicpath;

	private Integer adpv;

	private Integer carouselposition;

	private Date starttime;

	private Date endtime;

	private Integer createdby;

	private Date creationdate;

	private Integer modifyby;

	private Date modifydate;

	public String getAdpicpath() {
		return adpicpath;
	}

	public void setAdpicpath(String adpicpath) {
		this.adpicpath = adpicpath == null ? null : adpicpath.trim();
	}

	public Integer getCarouselposition() {
		return carouselposition;
	}

	public void setCarouselposition(Integer carouselposition) {
		this.carouselposition = carouselposition;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
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

	public Integer getAppid() {
		return appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	public Integer getAdpv() {
		return adpv;
	}

	public void setAdpv(Integer adpv) {
		this.adpv = adpv;
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
		return "AppPromotion [id=" + id + ", appid=" + appid + ", adpicpath="
				+ adpicpath + ", adpv=" + adpv + ", carouselposition="
				+ carouselposition + ", starttime=" + starttime + ", endtime="
				+ endtime + ", createdby=" + createdby + ", creationdate="
				+ creationdate + ", modifyby=" + modifyby + ", modifydate="
				+ modifydate + "]";
	}

}