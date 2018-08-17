package org.telecom.billingservice.authoritymag.querysevice;

import java.util.List;
import java.util.Map;

import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.RoleInfoBean;



/**
 * 业务层角色查询接口
 * @author Deng
 *
 */
public interface IRoleQueryService {
	/**
	 * 多条件分页查询角色数据
	 * @param params 查询条件
	 * @param page 分页对象
	 * @return 分页数据对象
	 */
	PagerBean listRolePageBeanByParams(Map<String, Object> params,PagerBean page);
	
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
