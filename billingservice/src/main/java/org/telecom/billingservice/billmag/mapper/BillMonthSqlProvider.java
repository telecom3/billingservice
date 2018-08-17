package org.telecom.billingservice.billmag.mapper;

import java.util.Map;

import org.telecom.billingservice.bean.BusinessMonthBean;
import org.telecom.billingservice.bean.PagerBean;
import org.telecom.billingservice.util.StringUtils;



public class BillMonthSqlProvider {
	   
	  public String listByMonthBill(Map params) {
		   
		   
		  StringBuilder str=new StringBuilder();
	      if(params!=null) {
	    	  str.append(""
    				+ " select b.*,u.* from t_bill_month as b left join t_user_info as u on b.fk_user_id=u.id where 1=1"
    				+ "");
	    
//	    	  String idcard=(String) params1.get("idcard");
//	    	 if( StringUtils.isEmpty(idcard)) {
//	    		 str.append(" AND u.user_ID="+idcard);
//	    	 };
	    	  Map maprams=(Map) params.get("params");
	    	  String userName=maprams==null?"":(String) maprams.get("userName");
		    	 if(!StringUtils.isEmpty(userName)) {
		    		 str.append(" AND user_realName like concat("+userName+",'%') ");
		    	 }
		    	 String monthname=maprams==null?"":(String) maprams.get("businessMonth"); 
		    	 if(!StringUtils.isEmpty(monthname)){
		    	     str.append(" and business_month ="+monthname);
		    	 }
		    	 String year= maprams==null?"":(String) maprams.get("businessYear");
		    	 if(!StringUtils.isEmpty(year)) {
		    		 str.append(" and business_year ="+year);  		    		 
		    	 }
	    
	    	 PagerBean pager=(PagerBean) params.get("pager");
	    	  str.append(" limit "+pager.getIndex()+","+pager.getLimit()+"");

	      }
	         return str.toString();
	   }

	  public String countMonthBill(Map params) {
		   
		   
		  StringBuilder str=new StringBuilder();
	      if(params!=null) {
	    	  str.append(""
    				+ " select count(b.id) from t_bill_month as b left join t_user_info as u on b.fk_user_id=u.id where 1=1"
    				+ "");
	    	  Map params1=(Map) params.get("params");
//	    	  String idcard=(String) params1.get("idcard");
//	    	 if( StringUtils.isEmpty(idcard)) {
//	    		 str.append(" AND u.user_ID="+idcard);
//	    	 };
	    	   Map maprams=(Map) params.get("params");
	    	
	    	  String userName=(maprams==null?"":(String) maprams.get("userName"));
		    	 if(!StringUtils.isEmpty(userName)) {
		    		 str.append(" AND user_realName like concat("+userName+",'%') ");
		    	 }
		    	 String monthname=maprams==null?"":(String) maprams.get("businessMonth"); 
		    	 if(!StringUtils.isEmpty(monthname)){
		    	     str.append(" and business_month ="+monthname);
		    	 }
		    	 String year= maprams==null?"":(String) maprams.get("businessYear");
		    	 if(!StringUtils.isEmpty(year)) {
		    		 str.append(" and business_year ="+year);  		    		 
		    	 }
	    

	      }
	         return str.toString();
	   }
}
