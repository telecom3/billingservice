package org.telecom.billingservice.publicservicemag.querysevice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.publicservicemag.querydao.IPublicQueryDao;
import org.telecom.billingservice.publicservicemag.querysevice.IPublicQueryService;
/**
 * 业务层公共服务查询实现
 * @author 李博
 *
 */
@Service
public class PublicQueryServiceImpl implements IPublicQueryService{
    @Resource
	private IPublicQueryDao publicQueryDaoImpl;
	@Override
	public UserInfoBean findUserInfoBeanById(Long userInfoId) {
		// TODO Auto-generated method stub
		return publicQueryDaoImpl.findUserInfoBeanById(userInfoId);
	}
	@Override
	public UserInfoBean login(String userName) {
		// TODO Auto-generated method stub
		return publicQueryDaoImpl.login(userName);
	}


}
