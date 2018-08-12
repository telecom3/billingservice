package org.telecom.billingservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 账单月费实体类
 * @author wzc
 *
 */
@Entity
@Table(name="t_business_monrh")
public class BillMonthBean {
	/**账单月费ID*/
	@Id
	@Column(name="id")
	@GenericGenerator(name = "g.id", strategy = "identity")
	@GeneratedValue(generator="g.id")
	private long id;
	/**支付类型(0-现金支付，1-支付宝支付，2-微信支付)*/
	@Column(name="pay_type")
	private int payType;
	/**支付状态(0-未支付，1-已支付)*/
	@Column(name="pay_state")
	private int payState;
	/**时长*/
	@Column(name="os_time")
	private long osTime;
	/**费用*/
	@Column(name="os_cost")
	private double osCost;
	/**年份*/
	@Column(name="business_year",length=4)
	private String businessYear;
	/**月份*/
	@Column(name="business_month",length=2)
	private String businessMonth;

	/**用户对象*/
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value = { CascadeType.REFRESH,CascadeType.SAVE_UPDATE })
	private UserInfoBean userInfo;
	public BillMonthBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPayType() {
		return payType;
	}
	public void setPayType(int payType) {
		this.payType = payType;
	}
	public int getPayState() {
		return payState;
	}
	public void setPayState(int payState) {
		this.payState = payState;
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
	public String getBusinessYear() {
		return businessYear;
	}
	public void setBusinessYear(String businessYear) {
		this.businessYear = businessYear;
	}
	
	public UserInfoBean getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfoBean userInfo) {
		this.userInfo = userInfo;
	}
	@Override
	public String toString() {
		return "BillMonthBean [id=" + id + ", payType=" + payType + ", payState=" + payState + ", osTime=" + osTime
				+ ", osCost=" + osCost + ", businessYear=" + businessYear + ", businessMonth=" + businessMonth
				+ ", userInfo=" + userInfo + "]";
	}
	
}
