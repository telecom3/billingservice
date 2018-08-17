package org.telecom.billingservice.tariffmag.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.TariffInfoBean;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.tariffmag.handleservice.ITariffHandleService;
import org.telecom.billingservice.tariffmag.querysevice.ITariffQueryService;

import com.fasterxml.jackson.databind.ObjectMapper;




/**
 * 资费控制器
 * @author asus
 *
 */
@RequestMapping(value="/tariffInfo/fee")
@Controller
public class Tariffmag {
	@Resource
	private ITariffQueryService tariffQueryServiceImpl;
	@Resource
	private ITariffHandleService tariffHandleServiceImpl;
	@RequestMapping(value="/page",method= {RequestMethod.GET},produces= {"application/json;charset=utf-8"})
	public @ResponseBody PagerBean showAll(int page,int limit,String tariffName) throws Exception {
		
		
		Map<String,Object>params=new HashMap<>(20);
		params.put("tariffName",tariffName);
		PagerBean pageBean=new PagerBean(page,limit);
		PagerBean pager=tariffQueryServiceImpl.listTariffInfoBeanBy2Params(pageBean, params);
		System.out.println(pager);
		return pager;
	}
	
	
	@RequestMapping(value="/save",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public @ResponseBody boolean addTariffInfoBean(TariffInfoBean tariffInfoBean) {
		try {
			tariffHandleServiceImpl.saveTariffInfoBean(tariffInfoBean);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	

	@RequestMapping(value="/update",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})	
	public @ResponseBody void updateUser(TariffInfoBean tariffInfoBean,HttpServletResponse res) {
		TariffInfoBean itar1=tariffQueryServiceImpl.findTarInfoBeanById(tariffInfoBean.getId());
		itar1.setTariffName(tariffInfoBean.getTariffName());
		itar1.setTariffType(tariffInfoBean.getTariffType());
		itar1.setBaseTime(tariffInfoBean.getBaseTime());
		itar1.setBaseCost(tariffInfoBean.getBaseCost());
		itar1.setUnitCost(tariffInfoBean.getUnitCost());
		itar1.setCostDescrible(tariffInfoBean.getCostDescrible());
		tariffHandleServiceImpl.updateTariffInfoBean(itar1);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping(value="/delete",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})	
	public @ResponseBody boolean deleteTariffInfoBeanFromForm(String id) {

		try {
			
			tariffHandleServiceImpl.deleteTariffInfoBeanById(Long.parseLong(id));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	/**id查找*/
	@RequestMapping(value="/find",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public void findById(long id,ModelMap map,HttpServletResponse res) {
		TariffInfoBean user=tariffHandleServiceImpl.getTariffInfoBeanById(id);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**查找全部*/
	@RequestMapping(value="/all",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public void findAll(ModelMap map,HttpServletResponse res) {
		List<TariffInfoBean> user=tariffQueryServiceImpl.listTarInfoBeanfindAll();
		System.out.println(user);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**暂停服务*/
	@RequestMapping(value="/suspend",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public void suspendUser(long id,ModelMap map,HttpServletResponse res) {
		TariffInfoBean user=tariffHandleServiceImpl.getTariffInfoBeanById(id);
		
		user.setTariffState(0);
		tariffHandleServiceImpl.updateTariffInfoBean(user);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**开启服务*/
	@RequestMapping(value="/open",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public void openUser(long id,ModelMap map,HttpServletResponse res) {
		TariffInfoBean user=tariffHandleServiceImpl.getTariffInfoBeanById(id);
		System.out.println(user);
		user.setTariffState(1);
		tariffHandleServiceImpl.updateTariffInfoBean(user);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(res.getWriter(), user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	
}
