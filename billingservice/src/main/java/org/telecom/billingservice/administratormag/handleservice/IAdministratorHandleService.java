package org.telecom.billingservice.administratormag.handleservice;

import org.telecom.billingservice.bean.UserInfoBean;

/**
 * 业务层管理员处理接口
 * @author Deng
 *
 */
public interface IAdministratorHandleService {
	/**
	 * 添加管理员
	 * @param user 用户实体
	 */
void saveAdministrator(UserInfoBean user);

/**
 * 修改管理员
 * @param user  账务账号实体
 */
void updateAdministrator(UserInfoBean user);
/**
 * 删除管理员
 * @param user  账务账号实体
 */
void deleteAdministrator(Long userId);

}
