package org.telecom.billingservice.administratormag.querydao;

import java.util.List;
import java.util.Map;

import org.telecom.billingservice.bean.UserInfoBean;


public interface IAdministratorQueryDao {
	/**
	 * 多条件分页查询总条数
	 * @param params 集合条件 
	 * @return 受影响的数据
	 */
	int countAdministratorByParams(@SuppressWarnings("rawtypes") Map params);
	/**
	 * 多条件分页查询管理员集合
	 * @param params  
	 * @return
	 */
	List<UserInfoBean> listAdministratorByParams(@SuppressWarnings("rawtypes") Map params);
	/**
	 * 通过id查询管理员对象
	 * @param id 管理员id
	 * @return 管理员对象
	 */
	UserInfoBean findUserInfoBeanById(Long id);
}
