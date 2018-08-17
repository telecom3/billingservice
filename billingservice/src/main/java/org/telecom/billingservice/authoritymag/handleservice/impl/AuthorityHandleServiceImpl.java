package org.telecom.billingservice.authoritymag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.annotation.MyLog;
import org.telecom.billingservice.authoritymag.handledao.IAuthorityHandleDao;
import org.telecom.billingservice.authoritymag.handleservice.IAuthorityHandleService;
import org.telecom.billingservice.bean.AuthorityInfoBean;
import org.telecom.billingservice.enmu.OperateLogEnum;
/**
 * 实现业务层权限处理接口
 * @author wzc
 *
 */
@Service
public class AuthorityHandleServiceImpl implements IAuthorityHandleService{
	@Resource
	private IAuthorityHandleDao authorityHandleDaoImpl; 
	
	@DataSource(value = "write")
	@Override
	@MyLog(menuName=7,operateType=OperateLogEnum.SAVE)
	public void saveAuthorityInfoBean(AuthorityInfoBean authorityInfo) {
		// TODO Auto-generated method stub
		authorityHandleDaoImpl.save(authorityInfo);
	}
	@DataSource(value = "write")
	@Override
	@MyLog(menuName=7,operateType=OperateLogEnum.UPDATE)
	public void updateAuthorityInfoBean(AuthorityInfoBean authorityInfo) {
		// TODO Auto-generated method stub
		authorityHandleDaoImpl.saveAndFlush(authorityInfo);
	}
	@DataSource(value = "write")
	@Override
	@MyLog(menuName=7,operateType=OperateLogEnum.DELETE)
	public void deleteAuthorityInfoBeanById(Long authorityInfoId) {
		// TODO Auto-generated method stub
		authorityHandleDaoImpl.delete(authorityInfoId);
	}
	
	
	@Override
	public AuthorityInfoBean getAuthorityInfoBeanById(Long authorityInfoId) {
		// TODO Auto-generated method stub
		return authorityHandleDaoImpl.getOne(authorityInfoId);
	}

}
