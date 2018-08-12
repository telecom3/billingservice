package org.telecom.billingservice.logmag.querysevice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.bean.OperateInfoBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.logmag.querydao.IOperateLogQueryDao;
import org.telecom.billingservice.logmag.querysevice.IOperateLogQueryService;
/**
 * 业务层操作日志查询接口实现类
 * @author liuyangliang
 *
 */
@Service
public class OperateLogQueryServiceImpl implements IOperateLogQueryService {
	@Resource
	private IOperateLogQueryDao operateLogQueryDaoImpl;
	
	@DataSource(value = "read")
	@Override
	public PagerBean listOperateInfoBeanBy2Params(PagerBean page, Map<String, Object> params) {
		int count = operateLogQueryDaoImpl.countOperateInfoBeanBy2Params(params);
		page.setCount(count);
		
		if(count>0) {
			params.put("index", page.getIndex());
			params.put("limit", page.getLimit());
			List<OperateInfoBean> data = operateLogQueryDaoImpl.listOperateInfoBeanBy2Params(params);
			page.setData(data);
		}
		
		return page;
	}

}
