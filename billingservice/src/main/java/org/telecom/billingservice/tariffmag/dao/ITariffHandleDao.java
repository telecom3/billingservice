package org.telecom.billingservice.tariffmag.dao;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.bean.TariffInfoBean;

/**
 * 资费持久层接口
 * @author asus
 *
 */
public interface ITariffHandleDao extends JpaRepository<TariffInfoBean, Long>,JpaSpecificationExecutor<TariffInfoBean>{
	
	/**
	 * 分页
	 * @param tariffName
	 * @param pageable
	 * @return
	 */
	/*@Query(value="from TariffInfoBean as u where u.tariffName like concat(?1,'%')")
	Page<TariffInfoBean>listTariffInfoBean(String tariffName,Pageable pageable);*/
	
	
}
