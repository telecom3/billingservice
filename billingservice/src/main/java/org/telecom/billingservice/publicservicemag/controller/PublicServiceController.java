package org.telecom.billingservice.publicservicemag.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.publicservicemag.handleservice.IPublicHandleService;
import org.telecom.billingservice.publicservicemag.handleservice.IWeatherService;
import org.telecom.billingservice.publicservicemag.querysevice.IPublicQueryService;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 公共服务表现层业务处理
 * 
 * @author 李博
 *
 */
@RequestMapping("/templates/public")
@Controller
public class PublicServiceController {
	@Resource
	private IPublicQueryService publicQueryServiceImpl;
	@Resource
	private IPublicHandleService publicHandleServiceImpl;
	@Resource
    private IWeatherService weatherServiceImpl;

	@RequestMapping(value = "updatePwd", method = { RequestMethod.POST }, produces = { "application/json;charset=utf-8" })
	public void findUserInfoBeanById(@RequestParam("id")long id,@RequestParam("oldPwd")String oldPwd,@RequestParam("newPwd")String newPwd,HttpServletResponse res) {
		
		
		UserInfoBean user = publicQueryServiceImpl.findUserInfoBeanById(id);
		
		
		Object result = new SimpleHash("MD5", oldPwd, ByteSource.Util.bytes(user.getUserName()), 1024);
		 
		int num = 0;
		
		if(result.toString().equals(user.getUserPwd())) {
			user.setUserPwd(newPwd);
			publicHandleServiceImpl.updateUserPassword(user);
			
			SecurityUtils.getSubject().logout();
			num = 1;
			
		}else {
			num = 0;
		}
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), num);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("userName") String userName, @RequestParam("pwd") String pwd) {
		String resultPageURL = "redirect:/templates/index.jsp";

		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		
		if (!currentUser.isAuthenticated()) {
        	// 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(userName, pwd);
            
            token.setRememberMe(true);
           
            try {
            	// 执行登录. 
                currentUser.login(token);
            } 
            // 所有认证时异常的父类. 
            catch (AuthenticationException ae) {
            	resultPageURL = "redirect:/templates/error.jsp";
            	System.out.println("登录失败: " + ae.getMessage());
            }
        }
		
		return resultPageURL;
	}

	/**
	 * 用户登出
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityUtils.getSubject().logout();
		return "redirect:/billingservice/templates/login.jsp";
	}
	/**
	 * 天气服务查询
	 * @return
	 */
	@RequestMapping(value="/weather",produces = { "application/json;charset=utf-8" })
	public @ResponseBody String weatherMessage() {

		String  weather=weatherServiceImpl.getWeather("成都");
		return  weather ;
	}
}
