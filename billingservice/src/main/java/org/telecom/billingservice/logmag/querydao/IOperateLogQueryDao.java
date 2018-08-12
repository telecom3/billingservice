package org.telecom.billingservice.logmag.querydao;

import java.util.List;
import java.util.Map;

import org.telecom.billingservice.bean.OperateInfoBean;

/**
 * 持久层操作日志查询接口
 * @author liuyangliang
 *
 */
public interface IOperateLogQueryDao {
	/**
	 * 查询操作日志集合
	 * @param params 查询条件
	 * @return 操作日志集合
	 */
	List<OperateInfoBean> listOperateInfoBeanBy2Params(Map<String,Object> params);
	
	/**
	 * 查询操作日志条数
	 * @param params 查询条件
	 * @return 条数
	 */
	int countOperateInfoBeanBy2Params(Map<String,Object> params);
}
