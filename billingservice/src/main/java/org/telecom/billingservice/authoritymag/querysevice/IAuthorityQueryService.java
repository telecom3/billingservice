package org.telecom.billingservice.authoritymag.querysevice;

import java.util.List;

import org.telecom.billingservice.bean.AuthorityInfoBean;

/**
 * 业务层权限查询接口
 * @author Deng
 *
 */
public interface IAuthorityQueryService {
	/**
	 * 查询所有权限
	 * @return 权限集合
	 */
List<AuthorityInfoBean> findAllAuthorityInfoBean();

/**
 * 根据权限id查询权限对象
 * @param id 权限id
 * @return 权限对象
 */
AuthorityInfoBean findAuthorityInfoBeanById(long id);
}
