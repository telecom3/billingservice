package org.telecom.tariffmag.test;



import java.sql.Date;

import javax.annotation.Resource;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telecom.billingservice.bean.TariffInfoBean;
import org.telecom.billingservice.tariffmag.handleservice.ITariffHandleService;
import org.telecom.billingservice.tariffmag.querysevice.ITariffQueryService;

/**
 * 资费测试
 * @author asus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TariffHandleServiceImplTest {
	@Resource
	private ITariffHandleService iTariffHandleService;
	
	 @Resource
	 private ITariffQueryService iTariffQueryServiceImpl;
	
	@Test
	public void saveTariffHandle() {
		TariffInfoBean tariffInfoBean =new TariffInfoBean();
		tariffInfoBean.setId(7L);
		tariffInfoBean.setTariffName("9+9套餐");
		tariffInfoBean.setTariffType(1);
		iTariffHandleService.saveTariffInfoBean(tariffInfoBean);
		System.out.println(tariffInfoBean);
	}
	@Test
	public void delTariffHandle() {
		TariffInfoBean tariffInfoBean =iTariffHandleService.getTariffInfoBeanById(10L);
		/*System.out.println(tariffInfoBean);*/
		iTariffHandleService.deleteTariffInfoBeanById(tariffInfoBean);
		
		
	}


	@Test
	public void updateTariffHandle() {
		TariffInfoBean tariffInfoBean =iTariffQueryServiceImpl.findTarInfoBeanById(14L);
		tariffInfoBean.setTariffName("无限流量套餐");
		iTariffHandleService.updateTariffInfoBean(tariffInfoBean);
		
	}
	
	@Test
	public void findTariffHandle() {
		TariffInfoBean tariffInfoBean =iTariffHandleService.getTariffInfoBeanById(1L);
		System.out.println(tariffInfoBean);
		
	}


}
