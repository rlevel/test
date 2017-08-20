package cn.appsys.tools;

public class BillPage {
	private Integer productName;
	private Integer start;
	private Integer end;

	public Integer getProductName() {
		return productName;
	}

	public void setProductName(Integer productName) {
		this.productName = productName;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "BillPage [productName=" + productName + ", start=" + start
				+ ", end=" + end + "]";
	}

}
