package org.telecom.billingservice.authoritymag.handleservice;


import org.telecom.billingservice.bean.AuthorityInfoBean;

/**
 * 业务层权限处理接口
 * @author Deng
 *
 */
public interface IAuthorityHandleService {
	/**
	 * 添加权限实体
	 * @param user 权限实体实体
	 */
void saveAuthorityInfoBean(AuthorityInfoBean authorityInfo);

/**
 * 修改权限
 * @param authorityInfo  权限实体
 */
void updateAuthorityInfoBean(AuthorityInfoBean authorityInfo);
/**
 * 删除权限
 * @param user  账务账号实体
 */
void deleteAuthorityInfoBeanById(Long authorityInfoId);
/**
 * 查看权限
 * @param authorityInfoId 权限ID
 * @return 权限对象
 */
AuthorityInfoBean getAuthorityInfoBeanById(Long authorityInfoId);
}
