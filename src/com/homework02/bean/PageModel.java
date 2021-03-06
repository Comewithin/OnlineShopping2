package com.homework02.bean;

public class PageModel {
	static int DEFAULT_PAGE_SIZE = 8;
	// 页码
	private int pageIndex;
	// 总记录数
	private int totalRecordSum;
	// 每页的大小
	private int pageSize;
	// 总页数
	private int totalPageSum;

	public int getPageIndex() {

		this.pageIndex = this.pageIndex <= 1 ? 1 : this.pageIndex;

		this.pageIndex = this.pageIndex >= getTotalPageSum() ? getTotalPageSum() : this.pageIndex;

		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalRecordSum() {
		return totalRecordSum;
	}

	public void setTotalRecordSum(int totalRecordSum) {
		this.totalRecordSum = totalRecordSum;
	}

	public int getPageSize() {
		this.pageSize = DEFAULT_PAGE_SIZE;
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPageSum() {
		this.totalPageSum = (getTotalRecordSum() + getPageSize() - 1) / getPageSize();
		return totalPageSum;
	}

	public void setTotalPageSum(int totalPageSum) {
		this.totalPageSum = totalPageSum;
	}

	public int getStartRowNum() {
		return (getPageIndex() - 1) * getPageSize();
	}

}
