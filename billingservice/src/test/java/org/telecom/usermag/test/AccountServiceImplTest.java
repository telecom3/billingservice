package org.telecom.usermag.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.usermag.handleservice.IAccountHandleService;
import org.telecom.billingservice.usermag.querysevice.IAccountQueryService;

/**
 * 账务账号测试类
 * @author wzc
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class AccountServiceImplTest {
	@Resource
	private IAccountHandleService accountHandleServiceImpl;
	@Resource
	private IAccountQueryService accountQueryServiceImpl; 
	
	
	@Test
	public void saveUserInfoBean() {
		UserInfoBean bean =new UserInfoBean();
		bean.setUserEmail("qqq.qq.com");
		accountHandleServiceImpl.saveUserInfoBean(bean);
	}
	@Test
	public void updateUserInfoBean() {
		UserInfoBean bean=accountQueryServiceImpl.findUserInfoBeanById(8L);
		bean.setUserName("debfss");
		accountHandleServiceImpl.updateUserInfoBean(bean);
	}
	@Test
	public void deleteUserInfoBeanById() {
		accountHandleServiceImpl.deleteUserInfoBeanById(7L);
	}
	@Test
	public void findUserInfoBeanById() {
		UserInfoBean bean=accountQueryServiceImpl.findUserInfoBeanById(2L);
		System.out.println(bean);
	}
	@Test
	public void listUserInfoBeanBy2Params() {
		PagerBean page = new PagerBean(1, 2);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", "d");
		params.put("userReallName", "");
		params.put("userID", "");
		params.put("userState", "");
		page= accountQueryServiceImpl.listUserInfoBeanBy2Params(page, params);
		System.out.println(page);
	}
	
}	
