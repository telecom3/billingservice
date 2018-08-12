package org.telecom.billingservice.selfservicemag.querysevice;

import java.util.Map;

import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.UserInfoBean;

/**
 * 业务层用户自服务查询接口
 * @author Deng
 *
 */
public interface ISelfserviceQueryService {
	/**
	 * 根据id查询个人信息
	 * @param userInfoId 用户Id
	 * @return 用户实体
	 */
UserInfoBean findUserInfoBeanById(Long userInfoId);

/**
 * 个人月账单分页
 * @param page   分页实体
 * @param params  动态条件参数
 * @return  分页
 */
PagerBean listBillMonthBeanBy2Params(PagerBean page,Map<String,Object> params);
/**
 * 账务账号下所有业务账号当月发生的费用明细信息分页
 * @param page   分页实体
 * @param params  动态条件参数
 * @return  分页
 */
PagerBean listBusinessMonthBeanBy2Params(PagerBean page,Map<String,Object> params);
/**
 * 账务账号下单个业务账号每日发生的费用明细信息分页
 * @param page   分页实体
 * @param params  动态条件参数
 * @return  分页
 */
PagerBean listBusinessDayBeanBy2Params(PagerBean page,Map<String,Object> params);




}
