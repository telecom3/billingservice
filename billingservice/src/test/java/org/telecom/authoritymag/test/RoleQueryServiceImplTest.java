package org.telecom.authoritymag.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telecom.billingservice.authoritymag.handleservice.IRoleHandleService;
import org.telecom.billingservice.authoritymag.querysevice.IRoleQueryService;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.RoleInfoBean;

/**
 * 角色测试类
 * @author wzc
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class RoleQueryServiceImplTest {
	@Resource
	private IRoleHandleService roleHandleServiceImpl;
	@Resource
	private IRoleQueryService roleQueryServiceImpl;
	
	@Test
	public void saveRoleInfoBean() {
		RoleInfoBean bean=new RoleInfoBean();
		bean.setRoleDescribe("管理员");
		bean.setRoleName("fghjkl");
		bean.setRoleType(2);
		roleHandleServiceImpl.saveRoleInfoBean(bean);
	}
	@Test
	public void updateRoleInfoBean() {
		RoleInfoBean bean=roleQueryServiceImpl.findRoleInfoBeanById(7L);
		bean.setRoleType(2);
		roleHandleServiceImpl.updateRoleInfoBean(bean);
	}
	@Test
	public void deleteRoleInfoBeanById() {
		RoleInfoBean bean=roleQueryServiceImpl.findRoleInfoBeanById(7L);
		roleHandleServiceImpl.deleteRoleInfoBeanById(bean.getId());
	}
	
	@Test
	public void listRolePageBeanByParams() {
		PagerBean page = new PagerBean(1, 2);
		Map params = new HashMap();
		params.put("roleName", "");
		page=roleQueryServiceImpl.listRolePageBeanByParams(params, page);
		System.out.println(page);
	}
	
	
}
