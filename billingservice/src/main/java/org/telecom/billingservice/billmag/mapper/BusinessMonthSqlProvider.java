package org.telecom.billingservice.billmag.mapper;

import java.util.Map;

import org.telecom.billingservice.bean.BusinessDayBean;
import org.telecom.billingservice.bean.BusinessMonthBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.util.StringUtils;

public  class BusinessMonthSqlProvider {

	 public String countBusiness(Map params) {
	     StringBuilder str=new StringBuilder();
	      if(params!=null) {
	    	  str.append("select count(b.id)"
		    	  		+ "from t_business_month as b LEFT JOIN t_user_info as u on u.user_name=b.user_name where 1=1");
	    	  Map params1=(Map) params.get("params");

	    	  BusinessMonthBean month=(BusinessMonthBean) params1.get("month");
	    	  String userName=(month==null?"":month.getUserName());
		    	 if(!StringUtils.isEmpty(userName)) {
		    		 str.append(" AND user_name like concat("+month.getUserName()+",'%') ");
		    	 }
		    	 String monthname=month==null?"":month.getBusinessMonrth(); 
		    	 if(!StringUtils.isEmpty(monthname)){
		    	     str.append(" and business_monrth ="+monthname);
		    	 }
		    	 String year= month==null?"":month.getBusinessYear();
		    	 if(!StringUtils.isEmpty(year)) {
		    		 str.append(" and business_year ="+year);  		    		 
		    	 }
	      }
	        System.out.println(str.toString());
	         return str.toString();
//	   	  str.append("select b.business_monrth,b.business_year,b.os_cost,b.user_name"
//	 		+ "from t_business_month as b LEFT JOIN t_user_info as u on u.user_name=b.user_name where 1=1"
//	 		+ "");
  }

       public String listByBusiness(Map params) {
	     StringBuilder str=new StringBuilder();
	      if(params!=null) {
	    	  str.append("select *"
    				+ "  from t_business_month  where 1=1"
    				+ "");
	    	  Map params1=(Map) params.get("params");
//	    	  String idcard=(String) params1.get("idcard");
//	    	 if( StringUtils.isEmpty(idcard)) {
//	    		 str.append(" AND u.user_ID="+idcard);
//	    	 };
	    	  BusinessMonthBean month=(BusinessMonthBean) params1.get("month");
	    	  String userName=(month==null?"":month.getUserName());
		    	 if(!StringUtils.isEmpty(userName)) {
		    		 str.append(" AND user_name like concat("+month.getUserName()+",'%') ");
		    	 }
		    	 String monthname=month==null?"":month.getBusinessMonrth(); 
		    	 if(!StringUtils.isEmpty(monthname)){
		    	     str.append(" and business_monrth ="+monthname);
		    	 }
		    	 String year= month==null?"":month.getBusinessYear();
		    	 if(!StringUtils.isEmpty(year)) {
		    		 str.append(" and business_year ="+year);  		    		 
		    	 }
	    
	    	 PagerBean pager=(PagerBean) params.get("pager");
	    	  str.append(" limit "+pager.getIndex()+","+pager.getLimit()+"");

	      }
	         return str.toString();
  }
  
  public String countBusinessDay(Map params) {
	     StringBuilder str=new StringBuilder();
	      if(params!=null) {
	    	  str.append("select count(b.id)"
		    	  		+ "from t_business_day as b LEFT JOIN t_user_info as u on u.user_name=b.user_name where 1=1");
	    	  Map params1=(Map) params.get("params");

	    	  BusinessDayBean month=(BusinessDayBean) params1.get("day");
	    	  String userName=(month==null?"":month.getUserName());
		    	 if(!StringUtils.isEmpty(userName)) {
		    		 str.append(" AND user_name like concat("+month.getUserName()+",'%') ");
		    	 }
		    	 String monthname=month==null?"":month.getBusinessMonth(); 
		    	 if(!StringUtils.isEmpty(monthname)){
		    	     str.append(" and business_month ="+monthname);
		    	 }
		    	 String year= month==null?"":month.getBusinessYear();
		    	 if(!StringUtils.isEmpty(year)) {
		    		 str.append(" and business_year ="+year);  		    		 
		    	 }
	      }
	        System.out.println(str.toString());
	         return str.toString();
}
  public String listByBusinessDay(Map params) {
	     StringBuilder str=new StringBuilder();
	      if(params!=null) {
	    	  str.append("select *"
 				+ "  from t_business_day  where 1=1"
 				+ "");
	    	  Map params1=(Map) params.get("params");
//	    	  String idcard=(String) params1.get("idcard");
//	    	 if( StringUtils.isEmpty(idcard)) {
//	    		 str.append(" AND u.user_ID="+idcard);
//	    	 };
	    	  BusinessDayBean month=(BusinessDayBean) params1.get("day");
	    	  String userName=(month==null?"":month.getUserName());
		    	 if(!StringUtils.isEmpty(userName)) {
		    		 str.append(" AND user_name like concat("+month.getUserName()+",'%') ");
		    	 }
		    	 String monthname=month==null?"":month.getBusinessMonth(); 
		    	 if(!StringUtils.isEmpty(monthname)){
		    	     str.append(" and business_monrth ="+monthname);
		    	 }
		    	 String year= month==null?"":month.getBusinessYear();
		    	 if(!StringUtils.isEmpty(year)) {
		    		 str.append(" and business_year ="+year);  		    		 
		    	 }
	    	 PagerBean pager=(PagerBean) params.get("pager");
	    	  str.append(" limit "+pager.getIndex()+","+pager.getLimit()+"");

	      }
	         return str.toString();
}
}
