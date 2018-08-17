package org.telecom.billingservice.tariffmag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.telecom.billingservice.annotation.DataSource;
import org.telecom.billingservice.annotation.MyLog;
import org.telecom.billingservice.bean.TariffInfoBean;
import org.telecom.billingservice.enmu.OperateLogEnum;
import org.telecom.billingservice.tariffmag.dao.ITariffHandleDao;
import org.telecom.billingservice.tariffmag.handleservice.ITariffHandleService;

/**
 * 业务层资费实现类
 * 
 * @author asus
 *
 */
@Service
public class TariffHandleServiceImpl implements ITariffHandleService {
	@Resource
	private ITariffHandleDao tariffHandleDao;
	
	
	@DataSource(value = "write")
	/**添加*/
	@Override
	@MyLog(menuName=1,operateType=OperateLogEnum.SAVE)
	public void saveTariffInfoBean(TariffInfoBean tariffInfo) {
		tariffHandleDao.save(tariffInfo);

	}
	
	
	@DataSource(value = "write")
	/**修改*/
	@Override
	@MyLog(menuName=1,operateType=OperateLogEnum.UPDATE)
	public void updateTariffInfoBean(TariffInfoBean tariffInfo) {
		tariffHandleDao.saveAndFlush(tariffInfo);

	}
	
	@DataSource(value = "write")
	/**删除*/
	@Override
	@MyLog(menuName=1,operateType=OperateLogEnum.DELETE)
	public void deleteTariffInfoBeanById(TariffInfoBean tariffInfoId) {
		tariffHandleDao.delete(tariffInfoId);

	}
	
	
	@DataSource(value = "read")
	@Override
	public TariffInfoBean getTariffInfoBeanById(Long tariffInfoId) {
		// TODO Auto-generated method stub
		return tariffHandleDao.getOne(tariffInfoId);
	}

	
	@Override
	@MyLog(menuName=0,operateType=OperateLogEnum.DELETE)
	public void deleteTariffInfoBeanById(long id) {
		tariffHandleDao.delete(id);
		
	}

}
