package org.telecom.billingservice.usermag.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.usermag.handleservice.IAccountHandleService;
import org.telecom.billingservice.usermag.querysevice.IAccountQueryService;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 表现层账务账号处理
 * @author wzc
 *
 */
@RequestMapping(path="/templates/user")
@Controller
public class UserController {
	
	@Resource
	private IAccountQueryService accountQueryServiceImpl;
	@Resource
	private IAccountHandleService accountHandleServiceImpl;
	@RequestMapping(value="/mainAccount",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public @ResponseBody PagerBean mainAccount(String userID,String userReallName, String userName,String userState,int page,int limit)throws Exception {
		
		Map<String,Object> params = new HashMap<String,Object>(30);
		params.put("userID", userID);
		params.put("userReallName", userReallName);
		params.put("userName", userName);
		if(userState!=null) {
			if (userState.equals("开通")) {
				userState="1";
			}else if(userState.equals("暂停")) {
				userState="0";
			}else{
				userState=null;
			}
		}
		params.put("userState", userState);
		PagerBean pageBean = new PagerBean(page, limit);
		pageBean = accountQueryServiceImpl.listUserInfoBeanBy2Params(pageBean, params);
		return pageBean;
	}
	
	@RequestMapping(value="/delete",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})	
	public @ResponseBody boolean deleteTariffInfoBeanFromForm(UserInfoBean bean) {
		if(bean==null) {
			return false;
		}
		try {
			accountHandleServiceImpl.deleteUserInfoBeanById(bean.getId());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@RequestMapping(value="/find",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public void findById(long id,ModelMap map,HttpServletResponse res) {
		UserInfoBean user=accountQueryServiceImpl.findUserInfoBeanById(id);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/saveUser",method= {RequestMethod.POST})
	public void saveUser(UserInfoBean user,HttpServletResponse res) {
		user.setCreateTime(new Date());
		accountHandleServiceImpl.saveUserInfoBean(user);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/updateUser",method= {RequestMethod.POST})
	public void updateUser(UserInfoBean user,HttpServletResponse res) {
		
		UserInfoBean user1 = accountQueryServiceImpl.findUserInfoBeanById(user.getId());
		
		user1.setUserQQ(user.getUserQQ());
		user1.setUserTelphone(user.getUserTelphone());
		user1.setUpdateTime(new Date());
		accountHandleServiceImpl.updateUserInfoBean(user1);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/suspend",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public void suspendUser(long id,ModelMap map,HttpServletResponse res) {
		UserInfoBean user=accountQueryServiceImpl.findUserInfoBeanById(id);
		user.setUserState(0);
		accountHandleServiceImpl.updateUserInfoBean(user);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/open",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public void openUser(long id,ModelMap map,HttpServletResponse res) {
		UserInfoBean user=accountQueryServiceImpl.findUserInfoBeanById(id);
		user.setUserState(1);
		accountHandleServiceImpl.updateUserInfoBean(user);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
