package org.telecom.billingservice.logmag.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.logmag.querysevice.ILoginLogQueryService;
import org.telecom.billingservice.logmag.querysevice.IOperateLogQueryService;

/**
 * 操作日志controller
 * @author Deng
 *
 */
@RequestMapping("/templates/login")
@Controller
public class LogController {
	@Resource
	private IOperateLogQueryService  operateLogQueryServiceImpl;
	@Resource
	private ILoginLogQueryService loginLogQueryServiceImpl;
	//记录日志
	private Logger log = Logger.getLogger(this.getClass());
	
@RequestMapping(value="/operateLog",produces= {"application/json;charset=utf-8"})
public @ResponseBody PagerBean operateLogPage(int page, int limit,String start,String end) {
	Map<String,Object> params=new HashMap<String,Object>(15);
	params.put("startTime", start);
	params.put("endTime", end);
	//记录参数信息
	log.info( page);
	log.info(limit);
	log.info( start);
	log.info(end);
	PagerBean pager=new PagerBean(page, limit);
	try {
		 pager=operateLogQueryServiceImpl.listOperateInfoBeanBy2Params(pager, params);
		 
	} catch (Exception e) {
		// TODO: handle exception
		log.error("LogController---------operateLogPage()",e);
	}
	return pager;
}

@RequestMapping(value="/loginLog",produces= {"application/json;charset=utf-8"})
public @ResponseBody PagerBean loginLogPage( int page,int limit,String start,String end) {
		
	Map<String,Object> params=new HashMap<String,Object>(15);
	params.put("startTime", start);
	params.put("endTime", end);
	//记录参数信息
	log.info( page);
	log.info(limit);
	log.info( start);
	log.info(end);
	PagerBean pager=new PagerBean(page, limit);
	try {
		 pager=loginLogQueryServiceImpl.listLoginInfoBeanBy2Params(pager, params);
		 
	} catch (Exception e) {
		// TODO: handle exception
		log.error("LogController---------loginLogPage()",e);
	}
	return pager;
}
}
