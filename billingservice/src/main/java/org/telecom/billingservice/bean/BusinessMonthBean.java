package org.telecom.billingservice.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 业务月份实体类
 * @author wzc
 *
 */
@Entity
@Table(name="t_business_month")
public class BusinessMonthBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4001853401367675866L;
	/**业务月份ID*/
	@Id
	@Column(name="id")
	@GenericGenerator(name = "g.id", strategy = "identity")
	@GeneratedValue(generator="g.id")
	private long id;
	/**业务账号*/
	@Column(name="business_name",length=20)
	private String businessName;
	/**用户账号*/
	@Column(name="user_name",length=20)
	private String userName;
	/**时长*/
	@Column(name="os_time")
	private long osTime;
	/**费用*/
	@Column(name="os_cost")
	private double osCost;
	/**月份*/
	@Column(name="business_monrth",length=2)
	private String businessMonrth;
	/**年份*/
	@Column(name="business_year",length=4)
	private String businessYear;
	/**套餐*/
	@Column(name="tariff_name",length=20)
	private String tariffName;
	public BusinessMonthBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getOsTime() {
		return osTime;
	}
	public void setOsTime(long osTime) {
		this.osTime = osTime;
	}
	public double getOsCost() {
		return osCost;
	}
	public void setOsCost(double osCost) {
		this.osCost = osCost;
	}
	public String getBusinessMonrth() {
		return businessMonrth;
	}
	public void setBusinessMonrth(String businessMonrth) {
		this.businessMonrth = businessMonrth;
	}
	public String getBusinessYear() {
		return businessYear;
	}
	public void setBusinessYear(String businessYear) {
		this.businessYear = businessYear;
	}
	public String getTariffName() {
		return tariffName;
	}
	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}
	@Override
	public String toString() {
		return "BusinessMonthBean [id=" + id + ", businessName=" + businessName + ", userName=" + userName + ", osTime="
				+ osTime + ", osCost=" + osCost + ", businessMonrth=" + businessMonrth + ", businessYear="
				+ businessYear + ", tariffName=" + tariffName + "]";
	}
	
}
