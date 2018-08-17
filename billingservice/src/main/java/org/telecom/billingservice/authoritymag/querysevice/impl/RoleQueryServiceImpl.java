package org.telecom.billingservice.authoritymag.querysevice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.authoritymag.querydao.IRoleQueryDao;
import org.telecom.billingservice.authoritymag.querysevice.IRoleQueryService;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.RoleInfoBean;


/**
 * 角色业务实现类
 * @author wzc
 *
 */
@Service
public class RoleQueryServiceImpl implements IRoleQueryService{
	@Resource
	private IRoleQueryDao roleQueryDaoImpl;
	@DataSource(value = "read")
	@Override
	public PagerBean listRolePageBeanByParams(Map<String, Object> params, PagerBean page) {
		int totalRows=roleQueryDaoImpl.countRoleInfoByParams(params);
		if(totalRows > 0) {
			params.put("index", page.getIndex());
			params.put("rows", page.getLimit());
			//分页数据查询
			List<RoleInfoBean> datas = roleQueryDaoImpl.listRoleInfoByParams(params);
			page.setCount(totalRows);
			page.setData(datas);
		}
		return page;
	}
	@DataSource(value = "read")
	@Override
	public RoleInfoBean findRoleInfoBeanById(long id) {
		// TODO Auto-generated method stub
		return roleQueryDaoImpl.findRoleInfoBeanById(id);
	}
	@DataSource(value = "read")
	@Override
	public List<RoleInfoBean> listRoleInfoAll() {
		// TODO Auto-generated method stub
		return roleQueryDaoImpl.listRoleInfoAll();
	}

}
