package org.telecom.billingservice.selfservicemag.querydao;

import java.util.List;
import java.util.Map;

import org.telecom.billingservice.bean.BillMonthBean;
import org.telecom.billingservice.bean.BusinessDayBean;
import org.telecom.billingservice.bean.BusinessMonthBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.UserInfoBean;
/**
 * 持久层用户自服务查询接口
 * @author 李博
 *
 */
public interface ISelfserviceQueryDao {
	/**
	 * 根据id查询个人信息
	 * @param userInfoId 用户Id
	 * @return 用户实体
	 */
UserInfoBean findUserInfoBeanById(Long userInfoId);
/**
 * 月账单分页统计方法
 * @param params 查询条件
 * @return 统计的条数
 */
int countBusinessDayByParams(Map params);
/**
 * 日账单分页统计方法
 * @param params 查询条件
 * @return 统计的条数
 */
int countBusinessMonthByParams(Map params);
/**
 * 个人月账单分页统计方法
 * @param params 查询条件
 * @return 统计的条数
 */
int countBillMonthByParams(Map params);

/**
 * 个人月账单分页
 * @param page   分页实体
 * @param params  动态条件参数
 * @return  分页
 */
List<BillMonthBean> listBillMonthBeanBy2Params(Map<String,Object> params);
/**
 * 账务账号下所有业务账号当月发生的费用明细信息分页
 * @param page   分页实体
 * @param params  动态条件参数
 * @return  分页
 */
List<BusinessMonthBean> listBusinessMonthBeanBy2Params(Map<String,Object> params);
/**
 * 账务账号下单个业务账号每日发生的费用明细信息分页
 * @param page   分页实体
 * @param params  动态条件参数
 * @return  分页
 */
List<BusinessDayBean> listBusinessDayBeanBy2Params(Map<String,Object> params);


}
