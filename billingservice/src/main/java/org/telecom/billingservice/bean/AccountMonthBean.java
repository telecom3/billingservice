package org.telecom.billingservice.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 账务月份实体类
 * @author wzc
 *
 */
@Entity
@Table(name="t_account_month")
public class AccountMonthBean implements Serializable{
	/**账务月费ID*/
	/**
	 * 
	 */
	private static final long serialVersionUID = 8372724791242005821L;
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
	/**服务器IP*/
	@Column(name="service_ip",length=15)
	private String serviceIp;
	/**年份*/
	@Column(name="account_year",length=4)
	private String accountYear;
	/**月份*/
	@Column(name="account_month",length=2)
	private String accountMonth;
	/**总时长*/
	@Column(name="count_time")
	private long countTime;
	public AccountMonthBean() {
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
	public String getAccountMonth() {
		return accountMonth;
	}
	public void setAccountMonth(String accountMonth) {
		this.accountMonth = accountMonth;
	}
	public long getCountTime() {
		return countTime;
	}
	public void setCountTime(long countTime) {
		this.countTime = countTime;
	}
	@Override
	public String toString() {
		return "AccountMonthBean [id=" + id + ", userName=" + userName + ", osName=" + osName + ", serviceIp="
				+ serviceIp + ", accountYear=" + accountYear + ", accountMonth=" + accountMonth + ", countTime="
				+ countTime + "]";
	}
	
}
