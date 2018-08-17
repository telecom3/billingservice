package org.telecom.billingservice.authoritymag.querysevice.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.authoritymag.querydao.IAuthorityQueryDao;
import org.telecom.billingservice.authoritymag.querysevice.IAuthorityQueryService;
import org.telecom.billingservice.bean.AuthorityInfoBean;
import org.telecom.billingservice.bean.PagerBean;
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
	
	@DataSource(value = "read")
	@Override
	public Set<AuthorityInfoBean> listAuthorityInfoBeanById(long id) {
		return authorityQueryDaoImpl.listAuthorityInfoBeanById(id);
	}

	@Override
	public PagerBean listAuthorityInfoBean(PagerBean page) {
		// TODO Auto-generated method stub
		List<AuthorityInfoBean> data = authorityQueryDaoImpl.listAuthorityInfoBean(page);
		int count = authorityQueryDaoImpl.findAllAuthorityInfoBean().size();
		
		page.setCount(count);
		page.setData(data);
		
		return page;
	}
}
