package org.telecom.billingservice.usermag.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.telecom.billingservice.bean.BusinessInfoBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.TariffInfoBean;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.usermag.handleservice.IBusinessHandleService;
import org.telecom.billingservice.usermag.querysevice.IBusinessQueryService;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 表现层业务账号处理
 * @author wzc
 *
 */
@RequestMapping(path="/templates/business")
@Controller
public class BusinessController {
	
	@Resource
	private IBusinessHandleService businessHandleServiceImpl;
	@Resource
	private IBusinessQueryService businessQueryServiceImpl;
	
	@RequestMapping(value="/mainBusiness",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public @ResponseBody PagerBean mainAccount(String businessOs,String ipAdress, String userID,String businessState,int page,int limit)throws Exception {
		
		Map<String,Object> params = new HashMap<String,Object>(30);
		params.put("businessOs", businessOs);
		params.put("ipAdress", ipAdress);
		params.put("userID", userID);
		if(businessState!=null) {
			if (businessState.equals("开通")) {
				businessState="1";
			}else if(businessState.equals("暂停")) {
				businessState="0";
			}else{
				businessState=null;
			}
		}
		params.put("businessState", businessState);
		PagerBean pageBean = new PagerBean(page, limit);
		pageBean = businessQueryServiceImpl.listBusinessInfoBeanBy2Params(pageBean, params);
		
		return pageBean;
	}
	@RequestMapping(value="/delete",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})	
	public @ResponseBody boolean deleteTariffInfoBeanFromForm(UserInfoBean bean) {
		if(bean==null) {
			return false;
		}
		try {
			businessHandleServiceImpl.deleteBusinessInfoBeanById(bean.getId());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	@RequestMapping(value="/find",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public void findById(long id,ModelMap map,HttpServletResponse res) {
		BusinessInfoBean user=businessQueryServiceImpl.findBusinessInfoBeanById(id);
		System.out.println(user);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/save",method= {RequestMethod.POST})
	public void saveUser( BusinessInfoBean business,@RequestParam("tariffName")long tariffId,HttpServletResponse res) {
		Session session = SecurityUtils.getSubject().getSession();
		UserInfoBean user=(UserInfoBean) session.getAttribute("userInfo");
		
		TariffInfoBean tariff = new TariffInfoBean();
		tariff.setId(tariffId);
		business.setTariffInfo(tariff);
		business.setUserInfo(user);
		business.setCreateTime(new Date());
		
		businessHandleServiceImpl.saveBusinessInfoBean(business);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/update",method= {RequestMethod.POST})
	public void updateUser( BusinessInfoBean business,HttpServletResponse res) {
		
		BusinessInfoBean bean = businessQueryServiceImpl.findBusinessInfoBeanById(business.getId());
		
		bean.setBusinessOsPwd(business.getBusinessOsPwd());
		bean.setUpdateTime(new Date());
		businessHandleServiceImpl.updateBusinessInfoBean(bean);
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
		BusinessInfoBean Business=businessQueryServiceImpl.findBusinessInfoBeanById(id);
		Business.setBusinessState(0);
		businessHandleServiceImpl.updateBusinessInfoBean(Business);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), Business);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/open",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public void openUser(long id,ModelMap map,HttpServletResponse res) {
		BusinessInfoBean Business=businessQueryServiceImpl.findBusinessInfoBeanById(id);
		Business.setBusinessState(1);
		businessHandleServiceImpl.updateBusinessInfoBean(Business);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), Business);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
