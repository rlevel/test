package cn.appsys.pojo;

import java.io.Serializable;
import java.util.Date;

public class DevUser implements Serializable {
	private static final long serialVersionUID = -2550259689783373675L;

	private Integer id;

	private String devcode;

	private String devname;

	private String devpassword;

	private String devemail;

	private String devinfo;

	private Integer createdby;

	private Date creationdate;

	private Integer modifyby;

	private Date modifydate;

	public String getDevcode() {
		return devcode;
	}

	public void setDevcode(String devcode) {
		this.devcode = devcode == null ? null : devcode.trim();
	}

	public String getDevname() {
		return devname;
	}

	public void setDevname(String devname) {
		this.devname = devname == null ? null : devname.trim();
	}

	public String getDevpassword() {
		return devpassword;
	}

	public void setDevpassword(String devpassword) {
		this.devpassword = devpassword == null ? null : devpassword.trim();
	}

	public String getDevemail() {
		return devemail;
	}

	public void setDevemail(String devemail) {
		this.devemail = devemail == null ? null : devemail.trim();
	}

	public String getDevinfo() {
		return devinfo;
	}

	public void setDevinfo(String devinfo) {
		this.devinfo = devinfo == null ? null : devinfo.trim();
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
		return "DevUser [id=" + id + ", devcode=" + devcode + ", devname="
				+ devname + ", devpassword=" + devpassword + ", devemail="
				+ devemail + ", devinfo=" + devinfo + ", createdby="
				+ createdby + ", creationdate=" + creationdate + ", modifyby="
				+ modifyby + ", modifydate=" + modifydate + "]";
	}

}