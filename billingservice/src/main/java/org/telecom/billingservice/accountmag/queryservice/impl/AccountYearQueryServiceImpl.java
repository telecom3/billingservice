package org.telecom.billingservice.accountmag.queryservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.accountmag.querydao.IAccountYearQueryDao;
import org.telecom.billingservice.accountmag.queryservice.IAccountYearQueryService;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.bean.AccountYearBean;
import org.telecom.billingservice.bean.PagerBean;
/**
 * 业务层年账务查询接口实现类
 * @author liuyangliang
 *
 */
@Service
public class AccountYearQueryServiceImpl implements IAccountYearQueryService {
	@Resource
	private IAccountYearQueryDao accountYearQueryDaoImpl;
	
	@DataSource(value = "read")
	@Override
	public PagerBean listAccountYearBeanBy2Params(PagerBean page, Map<String, Object> params) {
		int count = accountYearQueryDaoImpl.countAccountYearBeanBy2Params(params);
		page.setCount(count);
		
		if (count > 0) {
			params.put("index", page.getIndex());
			params.put("limit", page.getLimit());
			List<AccountYearBean> data = accountYearQueryDaoImpl.listAccountYearBeanBy2Params(params);
			page.setData(data);
		}
		return page;
	}

}
