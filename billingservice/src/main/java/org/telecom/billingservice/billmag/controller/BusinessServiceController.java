package org.telecom.billingservice.billmag.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.telecom.billingservice.bean.BillMonthBean;
import org.telecom.billingservice.bean.BusinessDayBean;
import org.telecom.billingservice.bean.BusinessInfoBean;
import org.telecom.billingservice.bean.BusinessMonthBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.ResultMapBean;
import org.telecom.billingservice.billmag.mapper.BillMonthSqlProvider;
import org.telecom.billingservice.billmag.querysevice.IBusinessDayQueryService;
import org.telecom.billingservice.billmag.querysevice.IBusinessInfoService;
import org.telecom.billingservice.billmag.querysevice.IBusinessMonthQueryService;
import org.telecom.billingservice.billmag.querysevice.impl.BillMonthServiceImpl;
import org.telecom.billingservice.billmag.querysevice.impl.BusinessMonthServiceImpl;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javassist.expr.NewArray;

@RequestMapping("/templates/bill")
@RestController
public class BusinessServiceController extends WebMvcConfigurerAdapter  {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private BusinessMonthServiceImpl businessMonthServiceImpl;
	
	@Resource
	private BillMonthServiceImpl billMonthServiceImpl;
	
	@Resource
	private IBusinessDayQueryService businessDayServiceImpl;
	
	@Resource
	private IBusinessInfoService businessInfoServiceImpl;
	
	@RequestMapping(value="/month",produces= {"application/json;charset=utf-8"})
	public void businessPageBy2Param(int page,int limit,BusinessMonthBean month,HttpServletResponse resp) throws JsonGenerationException, JsonMappingException, IOException {
	    resp.setCharacterEncoding("utf-8");
		PagerBean pager=new PagerBean(page,limit);
		Map<String,Object> params =new HashMap<String, Object>();
		System.out.println("page=" + page + "   limit=" + limit + "  参数1=" + month);
		log.info(page);
		log.info(limit);
		log.info(month);
		if(month!=null) {
			
			params.put("month", month);
		}
		pager=businessMonthServiceImpl.listBusinessMonthBeanBy2Params(pager, params);
//		System.out.println(pager);
		ResultMapBean result=new ResultMapBean();
	    Long i=pager.getCount();
		Integer count=i.intValue();
		result.setCount(count);
		result.setData(pager.getData());
		ObjectMapper om=new ObjectMapper();
		om.writeValue(resp.getWriter(), result);
		
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/bills",produces= {"application/json;charset=utf-8"})
	public void billPageBy2Param(int page,int limit,String userRealName,String year,String month,HttpServletResponse resp) throws JsonGenerationException, JsonMappingException, IOException {
		
		resp.setCharacterEncoding("utf-8");		
		System.out.println("page=" + page + "   limit=" + limit + "  参数1=" + month);
		PagerBean pager=new PagerBean(page,limit);
		Map<String,Object> params =new HashMap<String, Object>();
		log.info(page);
		log.info(limit);
		log.info(userRealName);
		log.info(month);
		log.info(year);
		if(userRealName==null) {
			userRealName="";
			
		}
		 
	     
		 pager=billMonthServiceImpl.listBillMonthBeanBy2Params(pager, params);
		 System.out.println(pager);
		 
		 ObjectMapper om=new ObjectMapper();
		 
		
	    
		 ResultMapBean result=new ResultMapBean();
		 Long i=pager.getCount();
		 Integer count=i.intValue();
		 result.setCount(count);
		 List<BillMonthBean>list=(List<BillMonthBean>) pager.getData();
		 result.setData(list);
		 om.writeValue(resp.getOutputStream(),result);
		
		
	}
	@RequestMapping(value="/day",produces= {"application/json;charset=utf-8"})
	public void businessDayPageBy2Param(int page,int limit,String userName,HttpServletResponse resp) throws JsonGenerationException, JsonMappingException, IOException {
		
		resp.setCharacterEncoding("utf-8");		
		System.out.println("page=" + page + "   limit=" + limit + "  参数1="+userName);
		PagerBean pager=new PagerBean(page,limit);
		Map<String,Object> params =new HashMap<String, Object>();
		log.info(page);
		log.info(limit);
		log.info(userName);
		
		if(userName==null) {
			userName="";
			
		}
		BusinessDayBean businessDayBean=new BusinessDayBean();
		businessDayBean.setUserName(userName);
		params.put("day", businessDayBean);
		
		 pager=businessDayServiceImpl.listBusinessDayBeanBy2Params(pager, params);
		 System.out.println(pager);
		 
		 ObjectMapper om=new ObjectMapper();
		 ResultMapBean result=new ResultMapBean();
		 Long i=pager.getCount();
		 Integer count=i.intValue();
		 result.setCount(count);
		 List<BusinessDayBean>list=(List<BusinessDayBean>) pager.getData();
		 result.setData(list);
		
		 om.writeValue(resp.getWriter(),result);
		
	}
	@RequestMapping(value="/info",produces= {"application/json;charset=utf-8"})
	public void businessInfo(String osName,HttpServletResponse resp) throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper om=new ObjectMapper();
		resp.setCharacterEncoding("utf-8");		
		System.out.println("参数1="+osName);
		
		Map<String,Object> params =new HashMap<String, Object>();
		
		log.info(osName);
		
		BusinessInfoBean bean=businessInfoServiceImpl.getBusinessInfoBean(osName);
		
		om.writeValue(resp.getWriter(), bean);
		 
		
		
	}

}
