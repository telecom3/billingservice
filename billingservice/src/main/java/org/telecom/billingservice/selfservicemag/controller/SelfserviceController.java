package org.telecom.billingservice.selfservicemag.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.selfservicemag.handleservice.ISelfserviceHandleService;
import org.telecom.billingservice.usermag.querysevice.IAccountQueryService;

@RequestMapping("/templates/user")
@Controller
public class SelfserviceController {
	@Resource
	private ISelfserviceHandleService selfserviceHandleServiceImpl;
	@Resource
	private IAccountQueryService accountQueryServiceImpl;
	
	@RequestMapping(value="/updateTel",method= {RequestMethod.POST})
	public String updateSelfInfo(UserInfoBean userInfo) {
		
		Session session = SecurityUtils.getSubject().getSession();
		UserInfoBean user = (UserInfoBean) session.getAttribute("userInfo");
		
		user.setUserTelphone(userInfo.getUserTelphone());
		selfserviceHandleServiceImpl.updateSelfInfo(user);
		
		
		session.setAttribute("userInfo", user);
		return "redirect:/templates/user/user_info.jsp";
	}
}
