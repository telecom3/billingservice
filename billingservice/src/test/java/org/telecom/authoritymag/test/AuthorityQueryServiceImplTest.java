package org.telecom.authoritymag.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telecom.billingservice.authoritymag.handleservice.IAuthorityHandleService;
import org.telecom.billingservice.authoritymag.querysevice.IAuthorityQueryService;
import org.telecom.billingservice.bean.AuthorityInfoBean;

/**
 * 权限测试
 * @author wzc
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class AuthorityQueryServiceImplTest {
	@Resource
	private IAuthorityHandleService authorityHandleServiceImpl;
	@Resource
	private IAuthorityQueryService authorityQueryServiceImpl;
	
	@Test
	public void saveAuthorityInfoBean() {
		AuthorityInfoBean bean=new AuthorityInfoBean();
		bean.setAuthorityCode("154");
		bean.setAuthorityName("项目经理");
		bean.setpId(7111);
		authorityHandleServiceImpl.saveAuthorityInfoBean(bean);
		
	}
	@Test
	public void updateAuthorityInfoBean() {
		//AuthorityInfoBean bean=authorityHandleServiceImpl.getAuthorityInfoBeanById(7L);
		AuthorityInfoBean bean=authorityQueryServiceImpl.findAuthorityInfoBeanById(7L);
		System.out.println(bean);
		bean.setAuthorityCode("1017");
		authorityHandleServiceImpl.updateAuthorityInfoBean(bean);
		
	}
	@Test
	public void deleteAuthorityInfoBeanById() {
		AuthorityInfoBean bean=authorityHandleServiceImpl.getAuthorityInfoBeanById(7L);
		authorityHandleServiceImpl.deleteAuthorityInfoBeanById(bean.getId());
	}
	@Test
	public void findAllAuthorityInfoBean() {
		List<AuthorityInfoBean> list =authorityQueryServiceImpl.findAllAuthorityInfoBean();
		System.out.println(list);
	}

}
