package org.telecom.usermag.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telecom.billingservice.bean.BusinessInfoBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.usermag.handleservice.IBusinessHandleService;
import org.telecom.billingservice.usermag.querysevice.IBusinessQueryService;

/**
 * 业务层业务账测试
 * @author wzc
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class BusinessServiceImplTest {
	@Resource
	private IBusinessHandleService businessHandleServiceImpl;
	@Resource
	private IBusinessQueryService businessQueryServiceImpl;
	
	
	@Test
	public void listBusinessInfoBeanBy2Params() {
		PagerBean page = new PagerBean(1, 2);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("businessOs", "1");
		params.put("businessState", "");
		params.put("ipAdress", "");
		params.put("userID", "");
		page= businessQueryServiceImpl.listBusinessInfoBeanBy2Params(page, params);
		System.out.println(page);
	}
	
	
	@Test
	public void saveBusinessInfoBean() {
		BusinessInfoBean bean=new BusinessInfoBean();
		bean.setBusinessOsPwd("123");
		bean.setBusinessOs("456移动");
		businessHandleServiceImpl.saveBusinessInfoBean(bean);
	}
	@Test
	public void updateBusinessInfoBean() {
		BusinessInfoBean bean=businessQueryServiceImpl.findBusinessInfoBeanById(7L);
		bean.setBusinessOs("中国移动");
		businessHandleServiceImpl.updateBusinessInfoBean(bean);
	}
	@Test
	public void deleteBusinessInfoBeanById() {
		BusinessInfoBean bean=businessQueryServiceImpl.findBusinessInfoBeanById(7L);
		businessHandleServiceImpl.deleteBusinessInfoBeanById(bean.getId());
	}
	
}
