package org.telecom.billingservice.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 角色实体类
 * @author wzc
 *
 */
@Entity
@Table(name="t_role_info")
public class RoleInfoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2098455943207335397L;
	/**角色ID*/
	@Id
	@Column(name="id")
	@GenericGenerator(name = "g.id", strategy = "identity")
	@GeneratedValue(generator="g.id")
	private long id;
	/**角色名称*/
	@Column(name="role_name",length=20)
	private String roleName;
	/**角色描述*/
	@Column(name="role_describe",length=50)
	private String roleDescribe;
	/**角色类型(0-超级管理员,1-普通管理员,2-用户)*/
	@Column(name="role_type")
	private int roleType;
	
	/**权限集合*/
	@ManyToMany(fetch=FetchType.LAZY)
	@Cascade(value = { CascadeType.SAVE_UPDATE,CascadeType.REFRESH})
	@JoinTable(name="t_role_authority_info",
	joinColumns=@JoinColumn(name="fk_role_id"),
	inverseJoinColumns=@JoinColumn(name="fk_authority_id"))
	private Set<AuthorityInfoBean> authorityInfos;
	
	public RoleInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescribe() {
		return roleDescribe;
	}
	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
	}
	public int getRoleType() {
		return roleType;
	}
	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}
	
	
	public Set<AuthorityInfoBean> getAuthorityInfos() {
		return authorityInfos;
	}
	public void setAuthorityInfos(Set<AuthorityInfoBean> authorityInfos) {
		this.authorityInfos = authorityInfos;
	}
	@Override
	public String toString() {
		return "RoleInfoBean [id=" + id + ", roleName=" + roleName + ", roleDescribe=" + roleDescribe + ", roleType="
				+ roleType + ", authorityInfos=" + authorityInfos + "]";
	}
	
}
