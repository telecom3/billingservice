<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电信</title>
<link type="text/css" rel="stylesheet" media="all"
	href="../../static/styles/global.css" />

<link rel="stylesheet" type="text/css"
	href="../../static/styles/index1.css" />
<script src="../../static/js/index.js"></script>
<link rel="stylesheet" href="../../static/layui/css/layui.css"
	media="all">
<link rel="stylesheet" href="../../static/layui/css/layui.mobile.css"
	media="all">
	<style type="text/css">
	ul{
	background-color: #526e86;
	}
	</style>
</head>
<body>
<ul class="layui-nav">
  <li class="layui-nav-item">
    <span>欢迎您：${userInfo.userReallName}</span>
  </li>
  <li class="layui-nav-item">
    <a style="color: yellow;" href="/billingservice/templates/public/logout">退出</a>
  </li>
  
  <li class="layui-nav-item">
    <span id="city"></span>  
    &nbsp;&nbsp;&nbsp;&nbsp;
  </li>
  <li class="layui-nav-item">
    <span id="weath"></span> 
     &nbsp;&nbsp;&nbsp;&nbsp;
  </li>
  <li class="layui-nav-item">
    <span id="temp"></span> 
  </li>

</ul>




	<nav>
	<menu>
		<menuitem id="demo1"> <a>菜单</a>
		<menu>
			<menuitem>
			<a href="../index.jsp">主页</a></menuitem>


			<shiro:hasAnyRoles name="adminAll,user">
				<menuitem> <a href="../role/role_list.jsp">用户管理</a>
				<menu>
					<menuitem>
					<a href="../account/account_list.jsp">账务账号管理</a></menuitem>
					<menuitem>
					<a href="../service/service_list.jsp">业务账号管理</a></menuitem>
				</menu>
				</menuitem>
			</shiro:hasAnyRoles>

			<shiro:hasAnyRoles name="adminAll,report">
				<menuitem>
				<a href="../report/report_list.jsp">报表查询</a></menuitem>
			</shiro:hasAnyRoles>

			<shiro:hasAnyRoles name="adminAll,login">
				<menuitem id="demo2"> <a>前台日志</a>
				<menu>
					<menuitem id="demo3"> <a href="../login/login_rizi.jsp">登录日志</a>
					</menuitem>
					<menuitem>
					<a href="../login/login_caozuo.jsp">操作日志</a></menuitem>
				</menu>
				</menuitem>
			</shiro:hasAnyRoles>

			<shiro:hasAnyRoles name="adminAll,role">
				<menuitem> <a>权限管理</a>
				<menu>
					<menuitem>
					<a href="../role/role_list.jsp">角色管理</a></menuitem>
					<menuitem>
					<a href="../role/authority_list.jsp">权限管理</a></menuitem>
				</menu>
				</menuitem>
			</shiro:hasAnyRoles>

			<shiro:hasAnyRoles name="adminAll,credit">
				<menuitem>
				<a href="../credit/credit_account.jsp">账务查询</a></menuitem>
			</shiro:hasAnyRoles>

			<shiro:hasAnyRoles name="adminAll,bill,user">
				<menuitem>
				<a href="../bill/bill_list.jsp">账单查询</a></menuitem>
			</shiro:hasAnyRoles>

			<shiro:hasAnyRoles name="adminAll,fee">
				<menuitem>
				<a href="../fee/fee_list.jsp">资费查询</a></menuitem>
			</shiro:hasAnyRoles>

			<shiro:hasAnyRoles name="adminAll,admin">
				<menuitem>
				<a href="../admin/admin_list.jsp">管理员管理</a></menuitem>
			</shiro:hasAnyRoles>

			<shiro:hasAnyRoles name="adminAll,user">
				<menuitem>
				<a href="../user/user_info.jsp">个人信息</a></menuitem>
			</shiro:hasAnyRoles>


			<menuitem>
			<a href="../user/user_modi_pwd.jsp">修改密码</a></menuitem>

			<menuitem> <a>休闲娱乐</a>
				<menu>
					<menuitem><a href="../../static/game/Tanks/tanke.jsp">坦克大战</a></menuitem>
					<menuitem><a href="../../static/game/snake/snake.jsp">贪吃蛇</a></menuitem>
					<menuitem><a href="#">待开发中。。。</a></menuitem>
				</menu>
				</menuitem>


		</menu>
		</menuitem>


		<!--   <menuitem><a>no drop</a></menuitem>-->
	</menu>
	</nav>


</body>
<script type="text/javascript">
var city=""
var weather=""
var temp=""
$(function() {
	 weath();
});
//自启动函数
setInterval("weath()",3600000);
function  weath(){
	$.ajax({
		   type: "POST",
		   url: "/billingservice/templates/public/weather",
		   data: "city=成都",
		   success: function(msg){
			    city=msg.result.result.city;
			    weather=msg.result.result.weather;
			    temp=msg.result.result.temp;
			    showValue();
		   }
		});
}

function showValue(){
	$("#city").html("城市："+city);
	$("#weath").html("天气："+weather);
	$("#temp").html("温度："+ temp+"℃");
	
}
</script>
</html>
