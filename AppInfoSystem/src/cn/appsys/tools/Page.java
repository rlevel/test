package cn.appsys.tools;

public class Page {
	// 页码
	private Integer currentPageNo;
	// 每页显示记录数
	private Integer pageSize;
	// 总记录数
	private Integer totalCount;
	// 总页数
	private Integer totalPageCount;
	// limit开始
	private Integer start;

	// 计算总页数
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