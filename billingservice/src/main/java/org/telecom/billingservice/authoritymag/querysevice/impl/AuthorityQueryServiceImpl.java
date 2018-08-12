package org.telecom.billingservice.authoritymag.querysevice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.authoritymag.querydao.IAuthorityQueryDao;
import org.telecom.billingservice.authoritymag.querysevice.IAuthorityQueryService;
import org.telecom.billingservice.bean.AuthorityInfoBean;
@Service
public class AuthorityQueryServiceImpl implements IAuthorityQueryService{
	@Resource
	private IAuthorityQueryDao authorityQueryDaoImpl;
	
	@DataSource(value = "read")
	@Override
	public List<AuthorityInfoBean> findAllAuthorityInfoBean() {
		// TODO Auto-generated method stub
		return authorityQueryDaoImpl.findAllAuthorityInfoBean();
	}
	
	@DataSource(value = "read")
	@Override
	public AuthorityInfoBean findAuthorityInfoBeanById(long id) {
		// TODO Auto-generated method stub
		return authorityQueryDaoImpl.findAuthorityInfoBeanById(id);
	}

}
