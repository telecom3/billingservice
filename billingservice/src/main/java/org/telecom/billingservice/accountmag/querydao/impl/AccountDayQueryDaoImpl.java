package org.telecom.billingservice.accountmag.querydao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.telecom.billingservice.accountmag.mapper.AccountDayQueryMapper;
import org.telecom.billingservice.accountmag.querydao.IAccountDayQueryDao;
import org.telecom.billingservice.bean.AccountDayBean;
/**
 * 持久层日账务查询接口实现类
 * @author liuyangliang
 *
 */
@Repository
public class AccountDayQueryDaoImpl implements IAccountDayQueryDao {
	@Resource
	private AccountDayQueryMapper accountDayQueryMapper;

	@Override
	public List<AccountDayBean> listAccountDayBeanBy2Params(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return accountDayQueryMapper.listAccountDayBeanBy2Params(params);
	}

	@Override
	public int countAccountDayBeanBy2Params(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return accountDayQueryMapper.countAccountDayBeanBy2Params(params);
	}
	
	

}
