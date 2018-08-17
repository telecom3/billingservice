package org.telecom.billingservice.administratormag.queryservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.administratormag.querydao.IAdministratorQueryDao;
import org.telecom.billingservice.administratormag.queryservice.IAdministratorQueryService;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.UserInfoBean;
@Service
public class AdministratorQueryServiceImpl implements IAdministratorQueryService {
	@Resource
	private IAdministratorQueryDao administratorQueryDaoImpl; 
	@Override
	public PagerBean listAdministratorBy2Params(PagerBean page, Map<String, Object> params) {
		//总数据条数
		int totalRows=administratorQueryDaoImpl.countAdministratorByParams(params);
		if(totalRows > 0) {
			params.put("index", page.getIndex());
			params.put("limit", page.getLimit());
			//分页数据查询
			List<UserInfoBean> datas = administratorQueryDaoImpl.listAdministratorByParams(params);
			page.setCount(totalRows);
			page.setData(datas);
		}
		return page;
	}

	@Override
	public UserInfoBean findUserInfoBeanById(Long id) {
		return administratorQueryDaoImpl.findUserInfoBeanById(id);
	}

}
