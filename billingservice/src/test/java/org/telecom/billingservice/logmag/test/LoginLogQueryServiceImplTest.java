package org.telecom.billingservice.logmag.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.logmag.querysevice.ILoginLogQueryService;

/**
 * 操作数据业务测试
 * @author liuyangliang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class LoginLogQueryServiceImplTest {
	@Resource
	private ILoginLogQueryService loginLogQueryServiceImpl;

	@Test
	public void listLoginInfoBeanBy2Params() {
		PagerBean page = new PagerBean(1, 2);
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("loginName", "");
		params.put("startTime","2018-08-01");
		params.put("endTime", "2018-08-10");
		page = loginLogQueryServiceImpl.listLoginInfoBeanBy2Params(page, params);
		System.out.println(page);
	}

	
}
