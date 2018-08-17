package org.telecom.billingservice.shiro;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> buildFilterChainDefinitionMap() {

		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
//		map.put("/**", "anon");
		// 默认能匿名访问的页面
		map.put("/static/**", "anon");
		map.put("/templates/login.jsp", "anon");
		map.put("/templates/error.jsp", "anon");
		map.put("/templates/public/login", "anon");
		map.put("/templates/public/logout", "logout");

		// 超级管理员
		map.put("/**", "roles[adminAll]");
		// 账单管理
		map.put("/templates/bill/**", "roles[bill]");
		// 权限管理
		map.put("/templates/role/**", "roles[role]");
		// 资费管理
		map.put("/templates/fee/**", "roles[fee]");
		// 账务账号管理
		map.put("/templates/account/**", "roles[account]");
		// 管理员管理
		map.put("/templates/admin/**", "roles[admin]");
		// 账务管理
		 map.put("/templates/credit/**", "roles[credit]");
		// 报表管理
		map.put("/templates/report/**", "roles[report]");
		// 日志管理
		map.put("/templates/login/**", "roles[login]");
		// 用户
		map.put("/templates/service/**", "roles[user]");
		map.put("/templates/user/**", "roles[user]");
		
		map.put("/**", "authc");
		return map;
	}

}
