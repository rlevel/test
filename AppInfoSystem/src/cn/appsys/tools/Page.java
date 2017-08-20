package cn.appsys.tools;

public class Page {
	//页码
	private Integer n;
	//每页显示记录数
	private Integer size;
	//总记录数
	private Integer total;
	//总页数
	private Integer pageSize;
	public Integer getN() {
		return n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
