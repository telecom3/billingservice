package org.telecom.billingservice.accountmag.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telecom.billingservice.accountmag.queryservice.IAccountDayQueryService;
import org.telecom.billingservice.accountmag.queryservice.IAccountMonthQueryService;
import org.telecom.billingservice.accountmag.queryservice.IAccountYearQueryService;
import org.telecom.billingservice.bean.PagerBean;

/**
 * 日账务业务测试
 * @author liuyangliang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class AccountDayQueryServiceImplTest {
	@Resource
	private IAccountDayQueryService accountDayQueryServiceImpl;
	@Resource
	private IAccountMonthQueryService accountMonthQueryServiceImpl;
	@Resource
	private IAccountYearQueryService accountYearQueryServiceImpl;
	
	@Test
	public void listAccountDayBeanBy2Params() {
		PagerBean page = new PagerBean(1, 2);
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("userName", "");
		params.put("accountYear", 2017);
		params.put("accountMonth", 4);
		page = accountDayQueryServiceImpl.listAccountDayBeanBy2Params(page, params);
		System.out.println(page);
	}
	
	@Test
	public void listAccountMonthBeanBy2Params() {
		PagerBean page = new PagerBean(1, 2);
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("userName", "");
		params.put("accountYear", 2016);
		page = accountMonthQueryServiceImpl.listAccountMonthBeanBy2Params(page, params);
		System.out.println(page);
	}
	@Test
	public void listAccountYearBeanBy2Params() {
		PagerBean page = new PagerBean(1, 2);
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("userName", "");
		page = accountYearQueryServiceImpl.listAccountYearBeanBy2Params(page, params);
		System.out.println(page);
	}
}
