package org.telecom.billingservice.accountmag.querydao;

import java.util.List;
import java.util.Map;

import org.telecom.billingservice.bean.AccountYearBean;
/**
 * 持久层年账务查询接口
 * @author liuyangliang
 *
 */
public interface IAccountYearQueryDao {
	/**
	 * 月账务分页数据
	 * @param page 分页bean
	 * @param params 分页条件
	 * @return 月账务分页数据集合
	 */
	List<AccountYearBean> listAccountYearBeanBy2Params(Map<String, Object> params);

	/**
	 * 月账务分页数据总条数
	 * @param params 分页条件
	 * @return 月账务分页数据总条数
	 */
	int countAccountYearBeanBy2Params(Map<String, Object> params);
}
