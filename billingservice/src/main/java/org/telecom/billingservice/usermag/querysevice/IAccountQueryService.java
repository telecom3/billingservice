package org.telecom.billingservice.usermag.querysevice;

import java.util.Map;

import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.UserInfoBean;

/**
 * 业务层账务账号查询接口
 * @author Deng
 *
 */
public interface IAccountQueryService {
	/**
	 * 根据用户得id查找用户
	 * @param userId  账务账号id
	 * @return  账务账号实体
	 */
UserInfoBean findUserInfoBeanById(Long  userId);
/**
 * 账务账号分页
 * @param page  分页实体
 * @param params  动态条件查询参数
 * @return  分页实体
 */
PagerBean listUserInfoBeanBy2Params(PagerBean page,Map<String,Object> params);
}
