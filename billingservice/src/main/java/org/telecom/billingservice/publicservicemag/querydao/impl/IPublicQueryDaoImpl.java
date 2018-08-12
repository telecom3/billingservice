package org.telecom.billingservice.publicservicemag.querydao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.publicservicemag.mapper.PublicUserInfoMapper;
import org.telecom.billingservice.publicservicemag.querydao.IPublicQueryDao;
/**
 * 持久层公共服务查询接口实现
 * @author 李博
 *
 */
@Repository
public class IPublicQueryDaoImpl implements IPublicQueryDao{ 
    @Resource
	private PublicUserInfoMapper publicUserInfoMapper;
	@Override
	public UserInfoBean findUserInfoBeanById(Long userInfoId) {
		// TODO Auto-generated method stub
		return publicUserInfoMapper.findUserInfoBeanById(userInfoId);
	}
	@Override
	public UserInfoBean login(UserInfoBean userInfo) {
		// TODO Auto-generated method stub
		return publicUserInfoMapper.login(userInfo);
	}


}
