package org.telecom.billingservice.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 业务账号实体类
 * @author wzc
 *
 */
@Entity
@Table(name="t_business_info")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class BusinessInfoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2579332781337060320L;
	/**业务账号ID*/
	@Id
	@Column(name="id")
	@GenericGenerator(name = "g.id", strategy = "identity")
	@GeneratedValue(generator="g.id")
	private long id;
	/**业务帐号*/
	@Column(name="business_os",length=20)
	private String businessOs;
	/**业务帐号密码*/
	@Column(name="business_os_pwd",length=32)
	private String businessOsPwd;
	/**服务器IP*/
	@Column(name="IP_adress",length=20)
	private String ipAdress;
	/**业务帐号状态(业务状态、  0为停止使用状态    、1为使用状态)*/
	@Column(name="business_state")
	private int businessState;
	/**业务帐号创建时间*/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd ")
	@Column(name="create_time")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createTime;
	/**业务帐号修改时间*/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd ")
	@Column(name="update_time")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date updateTime;
	/**用户对象*/
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value = {CascadeType.REFRESH,CascadeType.SAVE_UPDATE  })
	@JoinColumn(name="fk_account_id")
	private UserInfoBean userInfo;
	/**资费对象*/
	@OneToOne(fetch=FetchType.LAZY)
	@Cascade(value = { CascadeType.REFRESH,CascadeType.SAVE_UPDATE  })
	@JoinColumn(name="fk_tariff_id")
	private TariffInfoBean tariffInfo;
	/**版本*/
	@Version
	private int version;
	public BusinessInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBusinessOs() {
		return businessOs;
	}
	public void setBusinessOs(String businessOs) {
		this.businessOs = businessOs;
	}
	public String getBusinessOsPwd() {
		return businessOsPwd;
	}
	public void setBusinessOsPwd(String businessOsPwd) {
		this.businessOsPwd = businessOsPwd;
	}
	public String getIpAdress() {
		return ipAdress;
	}
	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}
	public int getBusinessState() {
		return businessState;
	}
	public void setBusinessState(int businessState) {
		this.businessState = businessState;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public UserInfoBean getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfoBean userInfo) {
		this.userInfo = userInfo;
	}
	public TariffInfoBean getTariffInfo() {
		return tariffInfo;
	}
	public void setTariffInfo(TariffInfoBean tariffInfo) {
		this.tariffInfo = tariffInfo;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "BusinessInfoBean [id=" + id + ", businessOs=" + businessOs + ", businessOsPwd=" + businessOsPwd
				+ ", ipAdress=" + ipAdress + ", businessState=" + businessState + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", userInfo=" + userInfo + ", tariffInfo=" + tariffInfo + ", version="
				+ version + "]";
	}
	
}
