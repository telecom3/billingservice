package org.telecom.billingservice.bean;

import java.util.List;

/**
 * 分页类
 * @author wkc
 *
 */
public class PagerBean {
	/**当前页码*/
	private int page;
	/**每页行数*/
	private int limit;
	/**起始位置*/
	private int index;
	/**返回信息*/
	private String msg;
	/**获取的数据*/
	private List<?> data;
	/**laiui为0*/
	private  int code=0;
	/**满足条件的总条数*/
	private long count;
	/**满足条件的总页数*/
	private long totalPage;
	public PagerBean() {
		// TODO Auto-generated constructor stub
	}
	public PagerBean(int page, int limit) {
		super();
		this.page = page;
		this.limit = limit;
		index = (page-1)*limit;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
		totalPage = (count % limit) == 0 ? (count / limit) : (count / limit) + 1;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	@Override
	public String toString() {
		return "PagingBean [page=" + page + ", limit=" + limit + ", index=" + index + ", msg=" + msg + ", data=" + data
				+ ", code=" + code + ", count=" + count + ", totalPage=" + totalPage + "]";
	}
	
	
}
