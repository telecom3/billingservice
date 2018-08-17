package org.telecom.billingservice.authoritymag.querydao;

import java.util.List;
import java.util.Map;

import org.telecom.billingservice.bean.RoleInfoBean;

/**
 * 持久层角色查询接口
 * @author wzc
 *
 */
public interface IRoleQueryDao {
	
	
	
	/**
	 * 按多条件统计条数
	 * @param params 查询条件
	 * @return 数据条数
	 */
	int countRoleInfoByParams(Map params);
	/**
	 * 多条件查询角色集合
	 * @param params 查询条件
	 * @return 角色集合
	 */
	List<RoleInfoBean> listRoleInfoByParams(Map params);
	/**
	 * 根据ID查询角色对象
	 * @param id 角色ID
	 * @return 角色对象
	 */
	RoleInfoBean findRoleInfoBeanById(long id);
	/**
	 * 查询所有角色
	 * @return 角色集合
	 */
	List<RoleInfoBean> listRoleInfoAll();
}
