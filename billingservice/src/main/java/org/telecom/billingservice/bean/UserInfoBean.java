package org.telecom.billingservice.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

/**
 * 用户实体类
 * @author wzc
 *
 */
@Entity
@Table(name="t_user_info")
@OptimisticLocking(type=OptimisticLockType.VERSION)
public class UserInfoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7728420004484655959L;
	/**用户ID*/
	@Id
	@Column(name="id")
	@GenericGenerator(name = "g.id", strategy = "identity")
	@GeneratedValue(generator="g.id")
	private long id;
	/**用户名*/
	@Column(name="user_name",length=20)
	private String userName;
	/**用户密码*/
	@Column(name="user_pwd",length=32)
	private String userPwd;
	/**用户性别(0-男，1-女)*/
	@Column(name="user_gender")
	private int userGender;
	/**用户真实姓名*/
	@Column(name="user_reallName",length=20)
	private String userReallName;
	/**用户邮箱*/
	@Column(name="user_email",length=20)
	private String userEmail;
	/**用户身份证*/
	@Column(name="user_ID",length=20)
	private String userID;
	/**用户地址*/
	@Column(name="user_adress",length=50)
	private String userAdress;
	/**用户QQ*/
	@Column(name="user_qq",length=20)
	private String userQQ;
	/**用户电话*/
	@Column(name="user_telphone",length=20)
	private String userTelphone;
	/**状态(0-暂停使用,1-开通)*/
	@Column(name="user_state")
	private int userState; 
	/**用户创建时间*/
	@Column(name="create_time")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createTime;
	/**用户修改时间*/
	@Column(name="update_time")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updateTime;
	/**版本*/
	@Version
	private int version;
	/**角色对象*/
	@OneToOne(fetch=FetchType.LAZY)
	@Cascade(value = { CascadeType.REFRESH,CascadeType.SAVE_UPDATE })
	@JoinColumn(name="fk_role_id")
	private RoleInfoBean roleInfo;
	/**业务账号集合*/
	@OneToMany(fetch=FetchType.LAZY,mappedBy="userInfo")
	@Cascade(value = { CascadeType.REFRESH })
	private Set<BusinessInfoBean> businessInfos;
	/**账单月份集合*/
	@OneToMany(fetch=FetchType.LAZY,mappedBy="userInfo")
	@Cascade(value = { CascadeType.REFRESH })
	private Set<BillMonthBean> billMonths;
	/**账务年份对象*/
	@OneToOne(fetch=FetchType.LAZY,mappedBy="userInfo")
	@Cascade(value = { CascadeType.REFRESH })
	private AccountYearBean accountYearBean;
	public UserInfoBean() {
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
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public int getUserGender() {
		return userGender;
	}
	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}
	public String getUserReallName() {
		return userReallName;
	}
	public void setUserReallName(String userReallName) {
		this.userReallName = userReallName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserAdress() {
		return userAdress;
	}
	public void setUserAdress(String userAdress) {
		this.userAdress = userAdress;
	}
	public String getUserQQ() {
		return userQQ;
	}
	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}
	public String getUserTelphone() {
		return userTelphone;
	}
	public void setUserTelphone(String userTelphone) {
		this.userTelphone = userTelphone;
	}
	public int getUserState() {
		return userState;
	}
	public void setUserState(int userState) {
		this.userState = userState;
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
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public RoleInfoBean getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(RoleInfoBean roleInfo) {
		this.roleInfo = roleInfo;
	}
	public Set<BusinessInfoBean> getBusinessInfos() {
		return businessInfos;
	}
	public void setBusinessInfos(Set<BusinessInfoBean> businessInfos) {
		this.businessInfos = businessInfos;
	}
	public Set<BillMonthBean> getBillMonths() {
		return billMonths;
	}
	public void setBillMonths(Set<BillMonthBean> billMonths) {
		this.billMonths = billMonths;
	}
	public AccountYearBean getAccountYearBean() {
		return accountYearBean;
	}
	public void setAccountYearBean(AccountYearBean accountYearBean) {
		this.accountYearBean = accountYearBean;
	}
	@Override
	public String toString() {
		return "UserInfoBean [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + ", userGender="
				+ userGender + ", userReallName=" + userReallName + ", userEmail=" + userEmail + ", userID=" + userID
				+ ", userAdress=" + userAdress + ", userQQ=" + userQQ + ", userTelphone=" + userTelphone
				+ ", userState=" + userState + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", version=" + version + ", roleInfo=" + roleInfo + ", businessInfos=" + businessInfos
				+ ", billMonths=" + billMonths + ", accountYearBean=" + accountYearBean + "]";
	}
	
	
}
