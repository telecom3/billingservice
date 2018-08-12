package org.telecom.billingservice.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 权限实体类
 * @author wzc
 *
 */
@Entity
@Table(name="t_authority_info")
public class AuthorityInfoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3709003272558578159L;
	/**权限表ID*/
	@Id
	@Column(name="id")
	@GenericGenerator(name = "g.id", strategy = "identity")
	@GeneratedValue(generator="g.id")
	private long id;
	/**权限编码*/
	@Column(name="authority_code",length=32)
	private String authorityCode;
	/**权限名称*/
	@Column(name="authority_name",length=20)
	private String authorityName;
	/**父级ID*/
	@Column(name="p_id")
	private long pId;
	/**角色集合*/
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="authorityInfos")
	private Set<RoleInfoBean> roleInfos;
	
	public AuthorityInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthorityCode() {
		return authorityCode;
	}
	public void setAuthorityCode(String authorityCode) {
		this.authorityCode = authorityCode;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public long getpId() {
		return pId;
	}
	public void setpId(long pId) {
		this.pId = pId;
	}
	
	public Set<RoleInfoBean> getRoleInfos() {
		return roleInfos;
	}
	public void setRoleInfos(Set<RoleInfoBean> roleInfos) {
		this.roleInfos = roleInfos;
	}
	@Override
	public String toString() {
		return "AuthorityInfoBean [id=" + id + ", authorityCode=" + authorityCode + ", authorityName=" + authorityName
				+ ", pId=" + pId + ", roleInfos=" + roleInfos + "]";
	}
	
}
