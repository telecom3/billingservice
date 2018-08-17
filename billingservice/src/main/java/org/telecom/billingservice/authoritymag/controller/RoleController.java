package org.telecom.billingservice.authoritymag.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.telecom.billingservice.authoritymag.handleservice.IRoleHandleService;
import org.telecom.billingservice.authoritymag.querysevice.IRoleQueryService;
import org.telecom.billingservice.bean.AuthorityInfoBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.RoleInfoBean;
import org.telecom.billingservice.bean.UserInfoBean;

import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("/templates/authoritymag")
@Controller
public class RoleController {
	@Resource
	private IRoleQueryService roleQueryServiceImpl;

	@Resource
	private IRoleHandleService roleHandleServiceImpl;

	@RequestMapping(value = "/page", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public @ResponseBody PagerBean showAll(int page, int limit, String roleName) throws Exception {

		Map<String, Object> params = new HashMap<>(20);
		params.put("roleName", roleName);

		PagerBean pageBean = new PagerBean(page, limit);
		PagerBean pager = roleQueryServiceImpl.listRolePageBeanByParams(params, pageBean);
		System.out.println(pager);
		return pager;
	}

	@RequestMapping(value = "/add", method = { RequestMethod.POST }, produces = { "application/json;charset=utf-8" })
	public void add(RoleInfoBean roleInfo,@RequestParam("authorityName")long authorityId ,HttpServletResponse res) throws IOException {
		System.out.println(roleInfo.getRoleType());
		System.out.println("添加成功" + "" + roleInfo);
		Set<AuthorityInfoBean> set = new HashSet<AuthorityInfoBean>();
		AuthorityInfoBean authority=new AuthorityInfoBean();
		authority.setId(authorityId);
		set.add(authority);
		roleInfo.setAuthorityInfos(set);
		
		roleHandleServiceImpl.saveRoleInfoBean(roleInfo);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/update1", method = { RequestMethod.POST })
	public void updateUser(RoleInfoBean roleInfo, HttpServletResponse res) {
		RoleInfoBean roleInfo1 = roleQueryServiceImpl.findRoleInfoBeanById(roleInfo.getId());
		System.out.println("修改"+roleInfo);
		roleInfo1.setRoleType(roleInfo.getRoleType());
		roleHandleServiceImpl.updateRoleInfoBean(roleInfo1);
	}

	@RequestMapping(value = "/findById", method = { RequestMethod.POST }, produces = {
			"application/json;charset=utf-8" })
	public void findById(long id, ModelMap map, HttpServletResponse res) {

		RoleInfoBean roleInfo = roleQueryServiceImpl.findRoleInfoBeanById(id);
		System.out.println(roleInfo);
		try {
			ObjectMapper mapper = new ObjectMapper();

			// filterOutAllExcept("userName","loginName") 序列化对象时，只包含userName和loginName
			// serializeAllExcept("houses","girls","role") 序列化对象时，除了houses，girls，role
			// 之外的属性，都参与到序列化

			mapper.writeValue(res.getWriter(), roleInfo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/del", method = { RequestMethod.POST })
	public void delete(UserInfoBean user) throws IOException {
		System.out.println(user.getId() + "" + user);
		long id = user.getId();
		roleHandleServiceImpl.deleteRoleInfoBeanById(user.getId());

	}
	
	@RequestMapping(value="/findAll",method= {RequestMethod.POST})
	public void findAllRoleInfo(HttpServletResponse res) {
		
		List<RoleInfoBean> roleInfoAll = roleQueryServiceImpl.listRoleInfoAll();
		System.out.println(roleInfoAll);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), roleInfoAll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
