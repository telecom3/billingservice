package org.telecom.billingservice.logmag.querydao;

import java.util.List;
import java.util.Map;

import org.telecom.billingservice.bean.LoginInfoBean;

/**
 * 持久层登录日志查询接口
 * @author liuyangliang
 *
 */
public interface ILoginLogQueryDao {
	/**
	 * 查询登录日志集合
	 * @param params 查询条件
	 * @return 登陆日志集合
	 */
	List<LoginInfoBean> listLoginInfoBeanBy2Params(Map<String,Object> params);
	
	/**
	 * 查询登录日志条数
	 * @param params 查询条件
	 * @return 条数
	 */
	int countLoginInfoBeanBy2Params(Map<String,Object> params);
}
