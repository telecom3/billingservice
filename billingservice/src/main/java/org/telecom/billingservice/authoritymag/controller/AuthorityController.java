package org.telecom.billingservice.authoritymag.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.telecom.billingservice.authoritymag.handleservice.IAuthorityHandleService;
import org.telecom.billingservice.authoritymag.querysevice.IAuthorityQueryService;
import org.telecom.billingservice.bean.AuthorityInfoBean;
import org.telecom.billingservice.bean.PagerBean;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 表现层权限处理
 * @author liuyangliang
 *
 */
@RequestMapping(path="/templates/authority")
@Controller
public class AuthorityController {
	@Resource
	private IAuthorityQueryService authorityQueryServiceImpl;
	@Resource
	private IAuthorityHandleService authorityHandleServiceImpl;
	
	@RequestMapping(value="/mainAuthority",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public @ResponseBody PagerBean mainAuthority(int page,int limit)throws Exception {
		
		PagerBean pageBean = new PagerBean(page, limit);
		pageBean = authorityQueryServiceImpl.listAuthorityInfoBean(pageBean);
		return pageBean;
	}
	
	@RequestMapping(value="/deleteAuthority",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})	
	public @ResponseBody boolean deleteAuthority(@RequestParam("id")long id) {
		try {
			authorityHandleServiceImpl.deleteAuthorityInfoBeanById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@RequestMapping(value="/saveAuthority",method= {RequestMethod.POST})
	public void saveAuthority(AuthorityInfoBean authority,HttpServletResponse res) {
		authorityHandleServiceImpl.saveAuthorityInfoBean(authority);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/updateAuthority",method= {RequestMethod.POST})
	public void updateAuthority(AuthorityInfoBean authority,HttpServletResponse res) {
		
		AuthorityInfoBean authority1 = authorityQueryServiceImpl.findAuthorityInfoBeanById(authority.getId());
		
		authority1.setAuthorityName(authority.getAuthorityName());
		authority1.setAuthorityCode(authority.getAuthorityCode());
		authority1.setpId(authority.getpId());
		authorityHandleServiceImpl.updateAuthorityInfoBean(authority1);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/findAuthority",method= {RequestMethod.POST})
	public void findAuthority(@RequestParam("id")long id,HttpServletResponse res) {
		
		AuthorityInfoBean authority = authorityQueryServiceImpl.findAuthorityInfoBeanById(id);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), authority);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/findAllAuthority",method= {RequestMethod.POST})
	public void findAllAuthority(HttpServletResponse res) {
		
		List<AuthorityInfoBean> authorityAll = authorityQueryServiceImpl.findAllAuthorityInfoBean();
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), authorityAll);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
