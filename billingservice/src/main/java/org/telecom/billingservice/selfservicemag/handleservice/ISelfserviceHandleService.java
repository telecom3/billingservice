package org.telecom.billingservice.selfservicemag.handleservice;

import org.telecom.billingservice.bean.UserInfoBean;

/**
 * 业务层用户自服务处理接口
 * @author Deng
 *
 */
public interface ISelfserviceHandleService {
	/**
	 * 修改个人信息
	 * 修改内容局限在：修改联系方式，不允许修改真实姓名，身份证，账务账号等敏感信息。
	 * @param userInfo
	 */
void updateSelfInfo(UserInfoBean userInfo);
}
