package org.telecom.billingservice.authoritymag.mapper;

import java.util.List;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.telecom.billingservice.bean.AuthorityInfoBean;
import org.telecom.billingservice.bean.PagerBean;
/**
 * 权限映射类
 * @author wzc
 *
 */
public interface AuthorityQueryMapper {
	
	
	
	List<AuthorityInfoBean> listAuthorityById(long id);
	/**
	 * 查询所有权限
	 * @return 权限集合
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="authorityCode", column="authority_code",javaType=String.class),
		@Result(property="authorityName", column="authority_name",javaType=String.class),
		@Result(property="pId", column="p_id",javaType=long.class)
	})
	@Select(value = { "select id,authority_code,authority_name,p_id from t_authority_info" })
	List<AuthorityInfoBean> findAllAuthorityInfoBean();
	
	/**
	 * 根据权限id查询权限对象
	 * @param id 权限id
	 * @return 权限对象
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="authorityCode", column="authority_code",javaType=String.class),
		@Result(property="authorityName", column="authority_name",javaType=String.class),
		@Result(property="pId", column="p_id",javaType=long.class)
	})
	@Select("select id,authority_code,authority_name,p_id from t_authority_info where id=#{id}")
	AuthorityInfoBean findAuthorityInfoBeanById(long id);
	
	/**
	 * 根据 角色id查询权限对象集合
	 * @param id 角色id
	 * @return 权限对象集合
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="authorityCode", column="authority_code",javaType=String.class),
		@Result(property="authorityName", column="authority_name",javaType=String.class),
		@Result(property="pId", column="p_id",javaType=long.class)
	})
	@Select("select a.id,a.authority_code,a.authority_name,a.p_id from t_authority_info a ,t_role_authority_info r where r.fk_role_id=#{id} and r.fk_authority_id=a.id")
	Set<AuthorityInfoBean> listAuthorityInfoBeanById(@Param("id")long id);
	
	
	/**
	 * 查询权限分页对象
	 * @param page 分页对象
	 * @return 权限分页对象
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="authorityCode", column="authority_code",javaType=String.class),
		@Result(property="authorityName", column="authority_name",javaType=String.class),
		@Result(property="pId", column="p_id",javaType=long.class)
	})
	@Select("select id,authority_code,authority_name,p_id from t_authority_info limit #{page.index},#{page.limit}")
	List<AuthorityInfoBean> listAuthorityInfoBean(@Param("page")PagerBean page);
	
}
