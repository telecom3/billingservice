package org.telecom.billingservice.usermag.querysevice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.bean.BusinessInfoBean;
import org.telecom.billingservice.bean.PagerBean;

import org.telecom.billingservice.usermag.querydao.IBusinessQueryDao;
import org.telecom.billingservice.usermag.querysevice.IBusinessQueryService;

/**
 * 业务层业务账号 查询接口实现
 * @author wzc
 *
 */
@Service
public class BusinessQueryServiceImpl implements IBusinessQueryService{
	@Resource
	private IBusinessQueryDao businessQueryDaoImpl;
	@DataSource(value = "read")
	@Override
	public BusinessInfoBean findBusinessInfoBeanById(Long businessInfoId) {
		// TODO Auto-generated method stub
		return businessQueryDaoImpl.findBusinessInfoBeanById(businessInfoId);
	}
	@DataSource(value = "read")
	@Override
	public PagerBean listBusinessInfoBeanBy2Params(PagerBean page, Map<String, Object> params) {
		int totalRows=businessQueryDaoImpl.countBusinessInfoBeanByParams(params);
		if(totalRows > 0) {
			params.put("index", page.getIndex());
			params.put("rows", page.getLimit());
			//分页数据查询
			List<BusinessInfoBean> datas = businessQueryDaoImpl.listBusinessInfoBeanByParams(params);
			page.setCount(totalRows);
			page.setData(datas);
		}
		return page;
	}

}
