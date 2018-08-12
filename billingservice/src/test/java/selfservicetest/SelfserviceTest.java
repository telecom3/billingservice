package selfservicetest;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.selfservicemag.handleservice.ISelfserviceHandleService;
import org.telecom.billingservice.selfservicemag.querysevice.ISelfserviceQueryService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class SelfserviceTest {
    @Resource
	private ISelfserviceHandleService selfserviceHandleServiceImpl;
    @Resource
    private ISelfserviceQueryService selfserviceQueryServiceImpl;
    @Test
    public void updateSelfInfo() {
    	UserInfoBean userInfo=selfserviceQueryServiceImpl.findUserInfoBeanById(2L);
    	userInfo.setUserTelphone("13555555555");
    	System.out.println(userInfo);
    }
    @Test
    public void listBillMonthBeanBy2Params(){
    	PagerBean page = new PagerBean(1, 2);
		Map<String, Object> params = new HashMap<String,Object>();
		
		params.put("businessMonth", "3");
		
		page = selfserviceQueryServiceImpl.listBillMonthBeanBy2Params(page, params);
		
    } 
    @Test
    public void listBusinessMonthBeanBy2Params() {
    	PagerBean page = new PagerBean(1, 2);
		Map<String, Object> params = new HashMap<String,Object>();
		
		params.put("businessMonth", "4");
		
		page = selfserviceQueryServiceImpl.listBusinessMonthBeanBy2Params(page, params);
        System.out.println(page);
    }
    @Test
    public void listBusinessDayBeanBy2Params() {
    	PagerBean page = new PagerBean(1, 3);
		Map<String, Object> params = new HashMap<String,Object>();
		
		params.put("businessDay", "4");
		
		page = selfserviceQueryServiceImpl.listBusinessDayBeanBy2Params(page, params);
		
		System.out.println(page);
    }
}
