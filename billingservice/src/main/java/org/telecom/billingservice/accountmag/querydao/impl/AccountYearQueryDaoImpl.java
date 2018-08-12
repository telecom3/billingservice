package org.telecom.billingservice.accountmag.querydao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.telecom.billingservice.accountmag.mapper.AccountYearQueryMapper;
import org.telecom.billingservice.accountmag.querydao.IAccountYearQueryDao;
import org.telecom.billingservice.bean.AccountYearBean;
/**
 * 持久层年账务查询接口实现类
 * @author liuyangliang
 *
 */
@Repository
public class AccountYearQueryDaoImpl implements IAccountYearQueryDao {
	@Resource
	private AccountYearQueryMapper accountYearQueryMapper;

	@Override
	public List<AccountYearBean> listAccountYearBeanBy2Params(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return accountYearQueryMapper.listAccountYearBeanBy2Params(params);
	}

	@Override
	public int countAccountYearBeanBy2Params(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return accountYearQueryMapper.countAccountYearBeanBy2Params(params);
	}
	

}
