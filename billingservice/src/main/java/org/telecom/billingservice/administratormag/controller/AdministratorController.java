package org.telecom.billingservice.administratormag.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.telecom.billingservice.administratormag.handleservice.IAdministratorHandleService;
import org.telecom.billingservice.administratormag.queryservice.IAdministratorQueryService;
import org.telecom.billingservice.authoritymag.querysevice.IRoleQueryService;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.RoleInfoBean;
import org.telecom.billingservice.bean.UserInfoBean;

import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("/templates/administrator")
@Controller
public class AdministratorController {
	@Resource
	private IAdministratorQueryService administratorQueryServiceImpl;
	@Resource
	private IAdministratorHandleService administratorHandleServiceImpl;
	@Resource
	private IRoleQueryService roleQueryServiceImpl;

	@RequestMapping(value = "/page", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public @ResponseBody PagerBean showAll(int page, int limit, String userName) throws Exception {

		Map<String, Object> params = new HashMap<>(20);
		params.put("userName", userName);

		PagerBean pageBean = new PagerBean(page, limit);
		PagerBean pager = administratorQueryServiceImpl.listAdministratorBy2Params(pageBean, params);
		System.out.println(pager);
		return pager;
	}

	@RequestMapping(value = "/del", method = { RequestMethod.POST })
	public void delete(UserInfoBean user) throws IOException {
		System.out.println(user.getId() + "" + user);
		long id = user.getId();
		administratorHandleServiceImpl.deleteAdministrator(id);

	}

	
	
	@RequestMapping(value="/update1",method= {RequestMethod.POST})
	public void updateUser(UserInfoBean account,HttpServletResponse res) {
		UserInfoBean user = administratorQueryServiceImpl.findUserInfoBeanById(account.getId());
		user.setUserQQ(account.getUserQQ());
		administratorHandleServiceImpl.updateAdministrator(user);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/add", method = { RequestMethod.POST }, produces = { "application/json;charset=utf-8" })
	public void add(UserInfoBean account,@RequestParam("roleName")long roleId ) throws IOException {

		System.out.println("添加成功" + "" + account);
		RoleInfoBean roleInfo = new RoleInfoBean();
		roleInfo.setId(roleId);
		account.setRoleInfo(roleInfo);
		administratorHandleServiceImpl.saveAdministrator(account);

	}

	@RequestMapping(value = "/findById", method = { RequestMethod.POST }, produces = {
			"application/json;charset=utf-8" })
	public void findById(long id, ModelMap map, HttpServletResponse res) {

		UserInfoBean user = administratorQueryServiceImpl.findUserInfoBeanById(id);
		System.out.println(user);
		try {
			ObjectMapper mapper = new ObjectMapper();

			// filterOutAllExcept("userName","loginName") 序列化对象时，只包含userName和loginName
			// serializeAllExcept("houses","girls","role") 序列化对象时，除了houses，girls，role
			// 之外的属性，都参与到序列化

			mapper.writeValue(res.getWriter(), user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
