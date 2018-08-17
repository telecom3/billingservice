package org.telecom.billingservice.usermag.querydao;

import java.util.List;
import java.util.Map;

import org.telecom.billingservice.bean.RoleInfoBean;
import org.telecom.billingservice.bean.UserInfoBean;

/**
 * 持久层账务账号查询接口
 * @author wzc
 *
 */
public interface IAccountQueryDao {
	/**
	 * 根据用户得id查找用户
	 * @param userId  账务账号id
	 * @return  账务账号实体
	 */
	UserInfoBean findUserInfoBeanById(Long  userId);
	
	
	
	/**
	 * 按多条件统计条数
	 * @param params 查询条件
	 * @return 数据条数
	 */
	int countUserInfoByParams(Map<String,Object> params);
	/**
	 * 多条件查询用户集合
	 * @param params 查询条件
	 * @return 用户集合
	 */
	List<UserInfoBean> listUserInfoByParams(Map<String,Object> params);
}
