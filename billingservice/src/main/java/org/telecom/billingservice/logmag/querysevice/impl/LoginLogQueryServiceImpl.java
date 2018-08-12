package org.telecom.billingservice.logmag.querysevice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.bean.LoginInfoBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.logmag.querydao.ILoginLogQueryDao;
import org.telecom.billingservice.logmag.querysevice.ILoginLogQueryService;
/**
 * 业务层登录日志查询接口实现类
 * @author liuyangliang
 *
 */
@Service
public class LoginLogQueryServiceImpl implements ILoginLogQueryService {
	@Resource
	private  ILoginLogQueryDao loginLogQueryDaoImpl;
	
	@DataSource(value = "read")
	@Override
	public PagerBean listLoginInfoBeanBy2Params(PagerBean page, Map<String, Object> params) {
		int count = loginLogQueryDaoImpl.countLoginInfoBeanBy2Params(params);
		page.setCount(count);
		
		if(count>0) {
			params.put("index", page.getIndex());
			params.put("limit", page.getLimit());
			List<LoginInfoBean> data = loginLogQueryDaoImpl.listLoginInfoBeanBy2Params(params);
			page.setData(data);
		}
		
		return page;
	}

}
