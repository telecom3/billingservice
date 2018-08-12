package org.telecom.billingservice.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 业务单日实体类
 * @author wzc
 *
 */
@Entity
@Table(name="t_business_monrh")
public class BusinessDayBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5403881883294755179L;
	/**业务单日ID*/
	@Id
	@Column(name="id")
	@GenericGenerator(name = "g.id", strategy = "identity")
	@GeneratedValue(generator="g.id")
	private long id;
	/**用户账号*/
	@Column(name="user_name",length=20)
	private String userName;
	/**业务账号*/
	@Column(name="os_name",length=20)
	private String osName;
	/**费用*/
	@Column(name="os_cost")
	private double osCost;
	/**每日*/
	@Column(name="business_day",length=2)
	private String businessDay;
	/**月份*/
	@Column(name="business_month",length=2)
	private String businessMonth;
	/**年份*/
	@Column(name="business_year",length=4)
	private String businessYear;
	/**套餐*/
	@Column(name="tariff_name",length=20)
	private String tariffName;
	public BusinessDayBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public double getOsCost() {
		return osCost;
	}
	public void setOsCost(double osCost) {
		this.osCost = osCost;
	}
	public String getBusinessDay() {
		return businessDay;
	}
	public void setBusinessDay(String businessDay) {
		this.businessDay = businessDay;
	}
	public String getBusinessMonth() {
		return businessMonth;
	}
	public void setBusinessMonth(String businessMonth) {
		this.businessMonth = businessMonth;
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
		return "BusinessDayBean [id=" + id + ", userName=" + userName + ", osName=" + osName + ", osCost=" + osCost
				+ ", businessDay=" + businessDay + ", businessMonth=" + businessMonth + ", businessYear=" + businessYear
				+ ", tariffName=" + tariffName + "]";
	}
	
}
