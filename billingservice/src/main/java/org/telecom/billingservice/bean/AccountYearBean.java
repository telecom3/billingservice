package org.telecom.billingservice.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 账务年份实体类
 * @author wzc
 *
 */
@Entity
@Table(name="t_account_year")

public class AccountYearBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 91278889644908479L;
	/**账务年费用ID*/
	@Id
	@Column(name="id")
	@GenericGenerator(name = "g.id", strategy = "identity")
	@GeneratedValue(generator="g.id")
	private long id;
	/**业务帐号*/
	@Column(name="os_name",length=20)
	private String osName;
	/**服务器IP*/
	@Column(name="service_ip",length=15)
	private String serviceIp;
	/**年份*/
	@Column(name="account_year",length=4)
	private String accountYear;
	/**总时长*/
	@Column(name="count_time")
	private long countTime;
	/**用户对象*/
	@OneToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.REFRESH,CascadeType.SAVE_UPDATE})
	@JoinColumn(name="fk_user_id")
	private UserInfoBean userInfo;
	public AccountYearBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public String getServiceIp() {
		return serviceIp;
	}
	public void setServiceIp(String serviceIp) {
		this.serviceIp = serviceIp;
	}
	public String getAccountYear() {
		return accountYear;
	}
	public void setAccountYear(String accountYear) {
		this.accountYear = accountYear;
	}
	public long getCountTime() {
		return countTime;
	}
	public void setCountTime(long countTime) {
		this.countTime = countTime;
	}
	public UserInfoBean getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfoBean userInfo) {
		this.userInfo = userInfo;
	}
	@Override
	public String toString() {
		return "AccountYearBean [id=" + id + ", osName=" + osName + ", serviceIp=" + serviceIp + ", accountYear="
				+ accountYear + ", countTime=" + countTime + ", userInfo=" + userInfo + "]";
	}
	
}
