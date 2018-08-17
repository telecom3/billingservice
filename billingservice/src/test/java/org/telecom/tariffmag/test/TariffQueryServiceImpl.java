package org.telecom.tariffmag.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.TariffInfoBean;
import org.telecom.billingservice.tariffmag.querysevice.ITariffQueryService;

/**
 * 资费分页查询
 * @author asus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class TariffQueryServiceImpl {
	 @Resource
	 private ITariffQueryService iTariffQueryServiceImpl;
	 
	 	@Test
	    public void listBillMonthBeanBy2Params(){
	    	PagerBean page = new PagerBean(1, 2);
			Map<String, Object> params = new HashMap<String,Object>();
			
			params.put("tariffName", "3");
			
			page = iTariffQueryServiceImpl.listTariffInfoBeanBy2Params(page, params);
			
	    } 

	 	@Test
	 	public void findTarIffQueryById() {
	 		TariffInfoBean tar=iTariffQueryServiceImpl.findTarInfoBeanById(1L);
	 		System.out.println(tar);
	 	}
}
