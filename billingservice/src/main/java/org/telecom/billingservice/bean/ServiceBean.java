package org.telecom.billingservice.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * 服务计费实体类
 * @author wzc
 *
 */
@Entity
@Table(name="t_service")
public class ServiceBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6356851400844530816L;
	/**服务计费ID*/
	@Id
	@Column(name="id")
	@GenericGenerator(name = "g.id", strategy = "identity")
	@GeneratedValue(generator="g.id")
	private long id;
	/**业务账号*/
	@Column(name="os_account",length=20)
	private String osAccount;
	/**服务器IP*/
	@Column(name="service_ip",length=15)
	private String serviceIp;
	/**登陆时间*/
	@Column(name="login_time")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date loginTime;
	/**退出时间*/
	@Column(name="exit_time")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date exitTime;
	/**有效时间*/
	@Column(name="effective_time")
	private long effectiveTime;
	public ServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOsAccount() {
		return osAccount;
	}
	public void setOsAccount(String osAccount) {
		this.osAccount = osAccount;
	}
	public String getServiceIp() {
		return serviceIp;
	}
	public void setServiceIp(String serviceIp) {
		this.serviceIp = serviceIp;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getExitTime() {
		return exitTime;
	}
	public void setExitTime(Date exitTime) {
		this.exitTime = exitTime;
	}
	public long getEffectiveTime() {
		return effectiveTime;
	}
	public void setEffectiveTime(long effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	@Override
	public String toString() {
		return "ServiceBean [id=" + id + ", osAccount=" + osAccount + ", serviceIp=" + serviceIp + ", loginTime="
				+ loginTime + ", exitTime=" + exitTime + ", effectiveTime=" + effectiveTime + "]";
	}
	
	
}
