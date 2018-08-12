package org.telecom.billingservice.accountmag.querydao;

import java.util.List;
import java.util.Map;

import org.telecom.billingservice.bean.AccountDayBean;
/**
 * 持久层日账务查询接口
 * @author liuyangliang
 *
 */
public interface IAccountDayQueryDao {
	/**
	 * 日账务分页数据
	 * @param page 分页bean
	 * @param params 分页条件
	 * @return 日账务分页数据集合
	 */
	List<AccountDayBean> listAccountDayBeanBy2Params(Map<String,Object> params);
	
	/**
	 * 日账务分页数据总条数
	 * @param params 分页条件
	 * @return 日账务分页数据总条数
	 */
	int countAccountDayBeanBy2Params(Map<String,Object> params);
}
