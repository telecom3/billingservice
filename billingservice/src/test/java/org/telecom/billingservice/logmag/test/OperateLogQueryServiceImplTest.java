package org.telecom.billingservice.logmag.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.logmag.querysevice.IOperateLogQueryService;
/**
 * 操作数据业务测试
 * @author liuyangliang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class OperateLogQueryServiceImplTest {
	@Resource
	private IOperateLogQueryService operateLogQueryServiceImpl;

	@Test
	public void listOperateInfoBeanBy2Params() {
		PagerBean page = new PagerBean(1, 2);
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("operator", "");
		params.put("startTime","2018-08-01");
		params.put("endTime", "2018-08-10");
		page = operateLogQueryServiceImpl.listOperateInfoBeanBy2Params(page, params);
		System.out.println(page);
	}
}
