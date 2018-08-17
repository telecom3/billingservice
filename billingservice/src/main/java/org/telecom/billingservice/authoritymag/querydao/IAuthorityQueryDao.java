package org.telecom.billingservice.authoritymag.querydao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.telecom.billingservice.bean.AuthorityInfoBean;
import org.telecom.billingservice.bean.PagerBean;

/**
 * 持久层权限查询接口
 * @author wzc
 *
 */
public interface IAuthorityQueryDao {

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
	
	/**
	 * 根据 角色id查询权限对象集合
	 * @param id 角色id
	 * @return 权限对象集合
	 */
	Set<AuthorityInfoBean> listAuthorityInfoBeanById(long id);
	
	/**
	 * 查询权限分页对象
	 * @param page 分页对象
	 * @return 权限分页对象
	 */
	List<AuthorityInfoBean> listAuthorityInfoBean(PagerBean page);
}
