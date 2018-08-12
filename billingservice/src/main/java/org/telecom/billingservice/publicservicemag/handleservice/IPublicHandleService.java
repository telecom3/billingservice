package org.telecom.billingservice.publicservicemag.handleservice;

import org.telecom.billingservice.bean.UserInfoBean;

/**
 * 业务层公共服务处理接口
 * @author Deng
 *
 */
public interface IPublicHandleService {

/**
 * 修改用户密码
 * @param userInfo  用户信息
 */
void updateUserPassword(UserInfoBean userInfo);

}
