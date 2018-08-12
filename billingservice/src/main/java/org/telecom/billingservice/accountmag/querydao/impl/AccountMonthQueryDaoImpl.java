package org.telecom.billingservice.accountmag.querydao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.telecom.billingservice.accountmag.mapper.AccountMonthQueryMapper;
import org.telecom.billingservice.accountmag.querydao.IAccountMonthQueryDao;
import org.telecom.billingservice.bean.AccountMonthBean;
/**
 * 持久层月账务查询接口实现类
 * @author liuyangliang
 *
 */
@Repository
public class AccountMonthQueryDaoImpl implements IAccountMonthQueryDao {
	@Resource
	private AccountMonthQueryMapper accountMonthQueryMapper;

	@Override
	public List<AccountMonthBean> listAccountMonthBeanBy2Params(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return accountMonthQueryMapper.listAccountMonthBeanBy2Params(params);
	}

	@Override
	public int countAccountMonthBeanBy2Params(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return accountMonthQueryMapper.countAccountMonthBeanBy2Params(params);
	}
	
	

}
