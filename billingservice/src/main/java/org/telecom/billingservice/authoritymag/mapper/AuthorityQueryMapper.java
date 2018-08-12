package org.telecom.billingservice.authoritymag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.telecom.billingservice.bean.AuthorityInfoBean;
/**
 * 权限映射类
 * @author wzc
 *
 */
public interface AuthorityQueryMapper {
	
	
	
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
}
