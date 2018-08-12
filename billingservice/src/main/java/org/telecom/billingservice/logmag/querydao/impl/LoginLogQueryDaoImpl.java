package org.telecom.billingservice.logmag.querydao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.telecom.billingservice.bean.LoginInfoBean;
import org.telecom.billingservice.logmag.mapper.LoginLogQueryMapper;
import org.telecom.billingservice.logmag.querydao.ILoginLogQueryDao;

/**
 * 持久层登录日志查询接口实现类
 * @author liuyangliang
 *
 */
@Repository
public class LoginLogQueryDaoImpl implements ILoginLogQueryDao {
	@Resource
	private LoginLogQueryMapper loginLogQueryMapper;
	
	@Override
	public List<LoginInfoBean> listLoginInfoBeanBy2Params(Map<String, Object> params) {
		return loginLogQueryMapper.listLoginInfoBeanBy2Params(params);
	}

	@Override
	public int countLoginInfoBeanBy2Params(Map<String, Object> params) {
		return loginLogQueryMapper.countLoginInfoBeanBy2Params(params);
	}

}
