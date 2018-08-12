package publicservicetest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.publicservicemag.handledao.IPublicHandleDao;
import org.telecom.billingservice.publicservicemag.handleservice.IPublicHandleService;
import org.telecom.billingservice.publicservicemag.querysevice.IPublicQueryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class PublicServiceTest {
   @Resource
	private IPublicHandleService publicHandleServiceImpl;
   @Resource
   private IPublicQueryService publicQueryServiceImpl;
   
   @Test
   public void findUserInfoBeanById() {
	   UserInfoBean user= publicQueryServiceImpl.findUserInfoBeanById(1L);
	   System.out.println(user);
   }
   
   
   @Test
   public void login() {
	   UserInfoBean userInfo = new UserInfoBean();
	   userInfo.setUserName("zhangsan");
	   userInfo.setUserPwd(Integer.toString(123));
	   UserInfoBean user= publicQueryServiceImpl.login(userInfo);
	   System.out.println(user);
	   
   }
   @Test
   public void updateUserPassword() {
	   UserInfoBean userInfo =publicQueryServiceImpl.findUserInfoBeanById(2L);
	   userInfo.setUserPwd(Integer.toString(1234));
	  publicHandleServiceImpl.updateUserPassword(userInfo);
	  System.out.println(userInfo);
   }
}
