package org.telecom.billingservice.accountmag.queryservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.accountmag.querydao.IAccountDayQueryDao;
import org.telecom.billingservice.accountmag.queryservice.IAccountDayQueryService;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.bean.AccountDayBean;
import org.telecom.billingservice.bean.PagerBean;

/**
 * 业务层日账务查询接口实现类
 * 
 * @author liuyangliang
 *
 */
@Service
public class AccountDayQueryServiceImpl implements IAccountDayQueryService {
	@Resource
	private IAccountDayQueryDao accountDayQueryDaoImpl;

	@DataSource(value = "read")
	@Override
	public PagerBean listAccountDayBeanBy2Params(PagerBean page, Map<String, Object> params) {
		// TODO Auto-generated method stub
		int count = accountDayQueryDaoImpl.countAccountDayBeanBy2Params(params);
		page.setCount(count);

		if (count > 0) {
			params.put("index", page.getIndex());
			params.put("limit", page.getLimit());
			List<AccountDayBean> data = accountDayQueryDaoImpl.listAccountDayBeanBy2Params(params);
			page.setData(data);
		}
		return page;
	}

}
