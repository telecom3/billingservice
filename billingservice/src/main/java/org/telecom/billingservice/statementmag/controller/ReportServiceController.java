package org.telecom.billingservice.statementmag.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telecom.billingservice.bean.BusinessMonthBean;
import org.telecom.billingservice.bean.ReportDataBean;
import org.telecom.billingservice.bean.ReportDataBean2;
import org.telecom.billingservice.statementmag.querysevice.IDataReportService;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("/templates/report")
@RestController
public class ReportServiceController{
  
	private final Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IDataReportService dataReportServiceImpl;
	 @RequestMapping(value="/business",produces= {"application/json;charset=utf-8"})
	  public void getEchartReport(String userRealName,HttpServletResponse resp) throws JsonGenerationException, JsonMappingException, IOException{
		  
		    ObjectMapper om=new ObjectMapper();
		    
		    om.setSerializationInclusion(Include.NON_NULL);
		    log.info(userRealName);
		    if(userRealName==null) {
		    	userRealName="";
		    }
		    List<ReportDataBean2> report= new ArrayList<>();
		    System.out.println("参数1"+userRealName);
		    
		    List<BusinessMonthBean> list = dataReportServiceImpl.findBusinessMonths(userRealName,"2012");
		    
		    System.out.println(dataReportServiceImpl.findBusinessMonths(userRealName,"2012"));
		    
		    for (BusinessMonthBean businessMonthBean : list) {
		    	ReportDataBean2 data=new ReportDataBean2();
				data.setName(businessMonthBean.getBusinessMonrth());
				data.setValue((int)businessMonthBean.getOsCost());
				report.add(data);
			}
		   
		    
		  
		    
		    om.writeValue(resp.getWriter(), report);
	  }
}
