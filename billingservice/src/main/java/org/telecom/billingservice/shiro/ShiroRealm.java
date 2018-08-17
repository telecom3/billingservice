package org.telecom.billingservice.shiro;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.telecom.billingservice.authoritymag.querysevice.IAuthorityQueryService;
import org.telecom.billingservice.bean.AuthorityInfoBean;
import org.telecom.billingservice.bean.UserInfoBean;
import org.telecom.billingservice.publicservicemag.querysevice.IPublicQueryService;

public class ShiroRealm extends AuthorizingRealm {
	@Resource
	private IPublicQueryService publicQueryServiceImpl;
	@Resource
	private IAuthorityQueryService authorityQueryServiceImpl;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		// 1. 把 AuthenticationToken 转换为 UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		// 2. 从 UsernamePasswordToken 中来获取 username
		String userName = upToken.getUsername();

		// 3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
		UserInfoBean user = publicQueryServiceImpl.login(userName);

		// 6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
		// 以下信息是从数据库中获取的.

		// 4). 盐值加密.
		ByteSource salt = ByteSource.Util.bytes(userName);

		SimpleAuthenticationInfo info = null;
		info = new SimpleAuthenticationInfo(user, user.getUserPwd(), salt, getName());

		
		//将登陆用户信息对象存到shiro的session中
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("userInfo", user);
		
		return info;
	}

	// 授权会被 shiro 回调的方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		// 1. 从 PrincipalCollection 中来获取登录用户的信息
		UserInfoBean user = (UserInfoBean) principals.getPrimaryPrincipal();
		
		// 获取登陆用户的权限集合
		Set<AuthorityInfoBean> authority = authorityQueryServiceImpl.listAuthorityInfoBeanById(user.getRoleInfo().getId());

		// 2. 利用登录的用户的信息来用户当前用户的角色或权限(可能需要查询数据库)
		Set<String> roles = new HashSet<>();

		for (AuthorityInfoBean authorityInfoBean : authority) {
			// 超级管理员
			if ("1011".equals(authorityInfoBean.getAuthorityCode())) {
				roles.add("adminAll");
			}
			// 账单管理
			else if ("1012".equals(authorityInfoBean.getAuthorityCode())) {
				roles.add("bill");
			}
			// 权限管理
			else if ("1013".equals(authorityInfoBean.getAuthorityCode())) {
				roles.add("role");
			}
			// 资费管理
			else if ("1014".equals(authorityInfoBean.getAuthorityCode())) {
				roles.add("fee");
			}
			// 账务账号管理
			else if ("1015".equals(authorityInfoBean.getAuthorityCode())) {
				roles.add("account");
			}
			// 管理员管理
			else if ("1016".equals(authorityInfoBean.getAuthorityCode())) {
				roles.add("admin");
			}
			// 账务管理
			 else if("1017".equals(authorityInfoBean.getAuthorityCode())) {
				 roles.add("credit");
			 }
			// 报表管理
			else if ("1018".equals(authorityInfoBean.getAuthorityCode())) {
				roles.add("report");
			}
			// 日志管理
			else if ("1019".equals(authorityInfoBean.getAuthorityCode())) {
				roles.add("login");
			}
			// 用户
			else if ("1021".equals(authorityInfoBean.getAuthorityCode())) {
				roles.add("user");
			}
		}
		
		// 3. 创建 SimpleAuthorizationInfo, 并设置其 reles 属性.
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		
		// 4. 返回 SimpleAuthorizationInfo 对象.
		return info;
	}

}
