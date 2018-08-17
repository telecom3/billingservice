package org.telecom.billingservice.publicservicemag.querydao;

import org.telecom.billingservice.bean.UserInfoBean;
/**
 * 持久层公共服务查询接口
 * @author 李博
 *
 */
public interface IPublicQueryDao {

	/**
	 * 显示个人信息
	 * 用户个人信息主要展示：身份信息，账务账号，联系信息等非敏感信息。
	 * 管理员个人信息主要展示，身份信息，联系信息等非敏感信息。
	 * @param userInfoId
	 * @return
	 */
UserInfoBean findUserInfoBeanById(Long userInfoId);
/**
 * 用户登录业务
 * @param userName  用户名
 * @return  用户实体
 */
UserInfoBean  login(String userName);
}
