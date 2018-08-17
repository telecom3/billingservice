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
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

/**
 * 登录日志实体类
 * @author wzc
 *
 */
@XmlRootElement 
@Entity
@Table(name="t_login_info")
public class LoginInfoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4718180452535163127L;
	/**登陆日志实体类*/
	@Id
	@Column(name="id")
	@GenericGenerator(name = "g.id", strategy = "identity")
	@GeneratedValue(generator="g.id")
	private long id;
	/**登陆人员*/
	@Column(name="login_name",length=20)
	private String loginName;
	/**登陆、退出时间*/
	@Column(name="login_exit_time")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date loginExitTime;
	/**登陆方式(0代表浏览器登陆、1手机登陆)*/
	@Column(name="login_type")
	private int loginType;
	/**登陆IP*/
	@Column(name="login_ip")
	private String loginIp;
	/**登陆/退出(0登陆、1退出)*/
	@Column(name="login_exit")
	private int loginExit;
	public LoginInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Date getLoginExitTime() {
		return loginExitTime;
	}
	public void setLoginExitTime(Date loginExitTime) {
		this.loginExitTime = loginExitTime;
	}
	public int getLoginType() {
		return loginType;
	}
	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public int getLoginExit() {
		return loginExit;
	}
	public void setLoginExit(int loginExit) {
		this.loginExit = loginExit;
	}
	@Override
	public String toString() {
		return "LoginInfoBean [id=" + id + ", loginName=" + loginName + ", loginExitTime=" + loginExitTime
				+ ", loginType=" + loginType + ", loginIp=" + loginIp + ", loginExit=" + loginExit + "]";
	}
	
}
