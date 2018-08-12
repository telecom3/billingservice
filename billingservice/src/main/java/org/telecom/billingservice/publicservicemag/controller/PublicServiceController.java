package org.telecom.billingservice.publicservicemag.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.publicservicemag.handleservice.impl.PublicHandleServiceImpl;
import org.telecom.billingservice.publicservicemag.querysevice.IPublicQueryService;

/**
 * 公共服务表现层业务处理
 * @author 李博
 *
 */
@RequestMapping("")
@Controller
public class PublicServiceController {
	@Resource
	private IPublicQueryService publicQueryServiceImpl;
	@RequestMapping(value="",method={RequestMethod.POST},produces= {"application/json;charset=utf-8"})
public void findUserInfoBeanById(long id,ModelMap map,HttpServletResponse res) {
	UserInfoBean userInfo=publicQueryServiceImpl.findUserInfoBeanById(id);
}
	public String userInfoLogin(UserInfoBean userInfo,Model model) {
		userInfo=publicQueryServiceImpl.login(userInfo);
		
		return null;
	}
}
