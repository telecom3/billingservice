package org.telecom.billingservice.accountmag.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.telecom.billingservice.accountmag.queryservice.IAccountDayQueryService;
import org.telecom.billingservice.accountmag.queryservice.IAccountMonthQueryService;
import org.telecom.billingservice.accountmag.queryservice.IAccountYearQueryService;

/**
 * 表现层账务处理类
 * @author liuyangliang
 *
 */
@RequestMapping("/account")
@Controller
public class AccountController {
	@Resource
	private IAccountDayQueryService accountDayQueryServiceImpl;
	@Resource
	private IAccountMonthQueryService accountMonthQueryServiceImpl;
	@Resource
	private IAccountYearQueryService accountYearQueryServiceImpl;
	
	
}
