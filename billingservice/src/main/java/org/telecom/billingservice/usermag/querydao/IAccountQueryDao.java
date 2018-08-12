package org.telecom.billingservice.usermag.querydao;

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
}
