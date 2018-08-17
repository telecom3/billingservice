package org.telecom.billingservice.usermag.querysevice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.RoleInfoBean;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.usermag.querydao.IAccountQueryDao;
import org.telecom.billingservice.usermag.querysevice.IAccountQueryService;

/**
 * 业务层账务账号查询接口实现类
 * @author wzc
 *
 */
@Service
public class AccountQueryServiceImpl implements IAccountQueryService{
	@Resource
	private IAccountQueryDao accountQueryDaoImpl;
	@DataSource(value = "read")
	@Override
	public UserInfoBean findUserInfoBeanById(Long userId) {
		// TODO Auto-generated method stub
		return accountQueryDaoImpl.findUserInfoBeanById(userId);
	}
	@DataSource(value = "read")
	@Override
	public PagerBean listUserInfoBeanBy2Params(PagerBean page, Map<String, Object> params) {
		// TODO Auto-generated method stub
		int totalRows=accountQueryDaoImpl.countUserInfoByParams(params);
		if(totalRows > 0) {
			params.put("index", page.getIndex());
			params.put("rows", page.getLimit());
			//分页数据查询
			List<UserInfoBean> datas = accountQueryDaoImpl.listUserInfoByParams(params);
			page.setCount(totalRows);
			page.setData(datas);
		}
		return page;
	}

}
