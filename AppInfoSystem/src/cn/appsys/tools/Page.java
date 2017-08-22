package cn.appsys.tools;

public class Page {
	// ҳ��
	private Integer currentPageNo;
	// ÿҳ��ʾ��¼��
	private Integer pageSize;
	// �ܼ�¼��
	private Integer totalCount;
	// ��ҳ��
	private Integer totalPageCount;
	// limit��ʼ
	private Integer start;

	// ������ҳ��
	public Integer getTotalPageCount() {
		if (totalCount % pageSize == 0) {
			totalPageCount = totalCount / pageSize;
		} else {
			totalPageCount = totalCount / pageSize + 1;
		}
		return totalPageCount;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(Integer currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "Page [currentPageNo=" + currentPageNo + ", pageSize="
				+ pageSize + ", totalCount=" + totalCount + ", totalPageCount="
				+ totalPageCount + "]";
	}

}