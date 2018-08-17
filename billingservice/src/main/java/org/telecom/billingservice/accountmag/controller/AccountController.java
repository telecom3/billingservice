package org.telecom.billingservice.accountmag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.telecom.billingservice.accountmag.queryservice.IAccountDayQueryService;
import org.telecom.billingservice.accountmag.queryservice.IAccountMonthQueryService;
import org.telecom.billingservice.accountmag.queryservice.IAccountYearQueryService;
import org.telecom.billingservice.bean.PagerBean;

/**
 * 表现层账务处理类
 * 
 * @author liuyangliang
 *
 */
@RequestMapping("/templates/account")
@Controller
public class AccountController {
	@Resource
	private IAccountDayQueryService accountDayQueryServiceImpl;
	@Resource
	private IAccountMonthQueryService accountMonthQueryServiceImpl;
	@Resource
	private IAccountYearQueryService accountYearQueryServiceImpl;
	// 记录日志
	private Logger log = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/year", produces = { "application/json;charset=utf-8" })
	public @ResponseBody PagerBean accountYear(int page, int limit, String accountYear) {
		// 记录参数信息
		
		log.info(page);
		log.info(limit);
		log.info(accountYear);
		Map<String, Object> params = new HashMap<String, Object>(15);
		
        params.put("accountYear", accountYear);
		PagerBean pager = new PagerBean(page, limit);
		try {
			pager =  accountYearQueryServiceImpl.listAccountYearBeanBy2Params(pager, params);

		} catch (Exception e) {
			// TODO: handle exception
			log.error("AccountController ---------accountYear()", e);
		}
		return pager;
	}

	@RequestMapping(value = "/month", produces = { "application/json;charset=utf-8" })
	public @ResponseBody PagerBean accountMonth(int page, int limit,String year, String month,String serviceIp) {
		Map<String, Object> params = new HashMap<String, Object>(15);
		System.out.println(serviceIp);
		System.out.println(year);
        if(serviceIp!=null) {
        	log.info(serviceIp);
        	
        	params.put("serviceIp", serviceIp);
        }
        if(year!=null) {
        	log.info(year);
        	params.put("accountYear", year);
        }
		// 记录参数信息
		log.info(page);
		log.info(limit);
		log.info(month);
		params.put("accountMonth", month);
		PagerBean pager = new PagerBean(page, limit);
		try {
			pager =accountMonthQueryServiceImpl.listAccountMonthBeanBy2Params(pager, params);

		} catch (Exception e) {
			// TODO: handle exception
			log.error("AccountController ---------accountYear()", e);
		}
		
		return pager;
	}

	@RequestMapping(value = "/day", produces = { "application/json;charset=utf-8" })
	public @ResponseBody PagerBean accountDay(int page, int limit, String year, String month,String serviceIp) {
		Map<String, Object> params = new HashMap<String, Object>(15);
		 if(serviceIp!=null) {
	        	log.info(serviceIp);
	        	params.put("serviceIp", serviceIp);
	        }
		 
		 if(year!=null) {
	        	log.info(year);
	        	params.put("accountYear", year);
	        }
		 if(month!=null) {
	        	log.info(month);
	        	params.put("accountMonth", month);
	        }
		// 记录参数信息
		log.info(page);
		log.info(limit);
		log.info(year);
		
		PagerBean pager = new PagerBean(page, limit);
		try {
			pager = accountDayQueryServiceImpl.listAccountDayBeanBy2Params(pager, params);

		} catch (Exception e) {
			// TODO: handle exception
			log.error("AccountController ---------accountYear()", e);
		}
		return pager;
	}
}
