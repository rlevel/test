package cn.appsys.tools;

public class Page {
	//ҳ��
	private Integer n;
	//ÿҳ��ʾ��¼��
	private Integer size;
	//�ܼ�¼��
	private Integer total;
	//��ҳ��
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
