package org.telecom.billingservice.accountmag.queryservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.accountmag.querydao.IAccountMonthQueryDao;
import org.telecom.billingservice.accountmag.queryservice.IAccountMonthQueryService;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.bean.AccountMonthBean;
import org.telecom.billingservice.bean.PagerBean;
/**
 * 业务层月账务查询接口实现类
 * @author liuyangliang
 *
 */
@Service
public class AccountMonthQueryServiceImpl implements IAccountMonthQueryService {
	@Resource
	private IAccountMonthQueryDao accountMonthQueryDaoImpl;
	
	@DataSource(value = "read")
	@Override
	public PagerBean listAccountMonthBeanBy2Params(PagerBean page, Map<String, Object> params) {
		int count = accountMonthQueryDaoImpl.countAccountMonthBeanBy2Params(params);
		page.setCount(count);
		
		if (count > 0) {
			params.put("index", page.getIndex());
			params.put("limit", page.getLimit());
			List<AccountMonthBean> data = accountMonthQueryDaoImpl.listAccountMonthBeanBy2Params(params);
			page.setData(data);
		}
		return page;
	}

}
