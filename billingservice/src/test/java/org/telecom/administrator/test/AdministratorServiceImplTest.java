package org.telecom.administrator.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telecom.billingservice.administratormag.handleservice.IAdministratorHandleService;
import org.telecom.billingservice.administratormag.queryservice.IAdministratorQueryService;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.UserInfoBean;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class AdministratorServiceImplTest {
	
	@Resource
	private IAdministratorHandleService administratorHandleServiceImpl;
	
	@Resource
	private IAdministratorQueryService administratorQueryServiceImpl;
	
	@Test
	public void listAdministratorBy2Params() {
		PagerBean page =new PagerBean(1,2);
		Map params =new HashMap();
		page=administratorQueryServiceImpl.listAdministratorBy2Params(page, params);
		System.out.println(page);
	}
	
	@Test
	public void saveAdministrator() {
		UserInfoBean user=administratorQueryServiceImpl.findUserInfoBeanById(1L);
		administratorHandleServiceImpl.saveAdministrator(user);
		
	}
}
