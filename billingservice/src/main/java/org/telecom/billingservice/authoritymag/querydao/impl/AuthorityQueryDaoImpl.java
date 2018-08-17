package org.telecom.billingservice.authoritymag.querydao.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.telecom.billingservice.authoritymag.mapper.AuthorityQueryMapper;
import org.telecom.billingservice.authoritymag.querydao.IAuthorityQueryDao;
import org.telecom.billingservice.bean.AuthorityInfoBean;
import org.telecom.billingservice.bean.PagerBean;

/**
 * 实现持久层权限类
 * @author wzc
 *
 */
@Repository
public class AuthorityQueryDaoImpl implements IAuthorityQueryDao {
	@Resource
	private AuthorityQueryMapper authorityQueryMapper;
	
	

	@Override
	public AuthorityInfoBean findAuthorityInfoBeanById(long id) {
		// TODO Auto-generated method stub
		return authorityQueryMapper.findAuthorityInfoBeanById(id);
	}



	@Override
	public List<AuthorityInfoBean> findAllAuthorityInfoBean() {
		// TODO Auto-generated method stub
		return authorityQueryMapper.findAllAuthorityInfoBean();
	}



	@Override
	public Set<AuthorityInfoBean> listAuthorityInfoBeanById(long id) {
		// TODO Auto-generated method stub
		return authorityQueryMapper.listAuthorityInfoBeanById(id);
	}



	@Override
	public List<AuthorityInfoBean> listAuthorityInfoBean(PagerBean page) {
		// TODO Auto-generated method stub
		return authorityQueryMapper.listAuthorityInfoBean(page);
	}



	

}
