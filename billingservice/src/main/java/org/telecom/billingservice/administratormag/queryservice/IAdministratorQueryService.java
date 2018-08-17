package org.telecom.billingservice.administratormag.queryservice;

import java.util.Map;

import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.UserInfoBean;

/**
 * 业务层管理员查询接口
 * @author Deng
 *
 */
public interface IAdministratorQueryService {
	/**
	 * 管理员分页
	 * @param page  分页实体
	 * @param params  动态条件查询参数
	 * @return  分页实体
	 */
	PagerBean listAdministratorBy2Params(PagerBean page,Map<String,Object> params);
	/**
	 * 通过id 查询管理员对象
	 * @param id  管理员id
	 * @return 管理员对象
	 */
	UserInfoBean findUserInfoBeanById(Long id);
}
