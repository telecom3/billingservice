package org.telecom.billingservice.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

/**
 * 数据实体类
 * @author wzc
 *
 */
@XmlRootElement 
@Entity
@Table(name="t_data_info")
public class DataInfoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1058646290187982417L;
	/**数据ID*/
	@Id
	@Column(name="id")
	@GenericGenerator(name = "g.id", strategy = "identity")
	@GeneratedValue(generator="g.id")
	private long id;
	/**操作数据*/
	@Column(name="data_info")
	private String dataInfo;
	public DataInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDataInfo() {
		return dataInfo;
	}
	public void setDataInfo(String dataInfo) {
		this.dataInfo = dataInfo;
	}
	@Override
	public String toString() {
		return "DataInfoBean [id=" + id + ", dataInfo=" + dataInfo + "]";
	}
	
}
