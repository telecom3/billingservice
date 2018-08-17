package org.telecom.billingservice.authoritymag.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.telecom.billingservice.bean.RoleInfoBean;
/**
 * 角色映射类
 * @author wzc
 *
 */
public interface RoleMapper {
	
	

	/**
	 * 按多条件统计条数
	 * @param params 查询条件
	 * @return 数据条数
	 */
	@SelectProvider(method = "countRoleByParams", type = RoleMapperSqlProvider.class)
	int countRoleInfoByParams(@Param("params")Map params);
	/**
	 * 多条件查询角色集合
	 * @param params 查询条件
	 * @return 角色集合
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="roleName", column="role_name",javaType=String.class),
		@Result(property="roleType", column="role_type",javaType=int.class),
		@Result(property="roleDescribe", column="role_describe",javaType=String.class),
		@Result(property="authorityInfos",javaType=Set.class,column="id",many=@Many
		(select="org.telecom.billingservice.authoritymag.mapper.AuthorityQueryMapper.listAuthorityInfoBeanById"))
	})
	@SelectProvider(method = "listRoleByParams", type = RoleMapperSqlProvider.class)
	List<RoleInfoBean> listRoleInfoByParams(@Param("params")Map params);
	/**
	 * 根据ID查询角色对象
	 * @param id 角色ID
	 * @return 角色对象
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="roleName", column="role_name",javaType=String.class),
		@Result(property="roleType", column="role_type",javaType=int.class),
		@Result(property="roleDescribe", column="role_describe",javaType=String.class),
		@Result(property="authorityInfos",javaType=Set.class,column="id",many=@Many
		(select="org.telecom.billingservice.authoritymag.mapper.AuthorityQueryMapper.listAuthorityInfoBeanById"))
		
	})
	@Select("select id,role_name,role_type,role_describe from t_role_info where id=#{id}")
	RoleInfoBean findRoleInfoBeanById(long id);
	/**
	 * 查询所有角色
	 * @return 角色集合
	 */
	@Results({
		@Result(id=true,property="id",column="id",javaType=long.class),
		@Result(property="roleName", column="role_name",javaType=String.class),
		@Result(property="roleType", column="role_type",javaType=int.class),
		@Result(property="roleDescribe", column="role_describe",javaType=String.class),
		@Result(property="authorityInfos",javaType=Set.class,column="id",many=@Many
		(select="org.telecom.billingservice.authoritymag.mapper.AuthorityQueryMapper.listAuthorityInfoBeanById"))
		
	})
	@Select("select id,role_name,role_type,role_describe from t_role_info ")
	List<RoleInfoBean> listRoleInfoAll();
}
