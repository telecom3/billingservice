package org.telecom.usermag.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telecom.billingservice.bean.UserInfoBean;
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
	private IAccountQueryService accountQueryServiceImpl; 
	
	@Test
	public void findUserInfoBeanById() {
		UserInfoBean bean=accountQueryServiceImpl.findUserInfoBeanById(1L);
		System.out.println(bean);
	}
}	
