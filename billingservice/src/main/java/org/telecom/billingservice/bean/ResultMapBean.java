package org.telecom.billingservice.bean;

import java.util.List;

/**
 * layui数据表格返回数据处理类
 * @author 
 *
 */
public class ResultMapBean {
	
	private int code=0;
	private int count;
	private String msg;
	private List<?> data;
	
	public ResultMapBean() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	@Override
	public String toString() {
		return "ResultMap [code=" + code + ", count=" + count + ", msg=" + msg + ", data=" + data + "]";
	}


	
	
    
    
    
    
    
    
}
