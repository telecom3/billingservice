package org.telecom.billingservice.logmag.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telecom.billingservice.logmag.querysevice.IDataQueryService;

/**
 * 操作数据业务测试
 * @author liuyangliang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class DataQueryServiceImplTest {
	@Resource
	private IDataQueryService dataQueryServiceImpl;
	
	@Test
	public void getDataInfoBeanById() {
		
		System.out.println(dataQueryServiceImpl.getDataInfoBeanById(1L));
	}
}
