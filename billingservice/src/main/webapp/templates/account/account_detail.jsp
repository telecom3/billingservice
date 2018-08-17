<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>中国电信</title>
   <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
    <link rel="stylesheet" href="../../static/layui/css/layui.css" media="all">
    <script src="../../static/js/jquery-3.3.1.min.js"></script>
    <script src="../../static/js/index.js"></script>
    <script src="../../static/layui/layui.js"></script>
    <style type="text/css">
        #waikuang{
        margin: auto;
      	height: 700px;
      	width: 500px;
        }
        #title{
        	text-align:center;
        	margin-top: 20px;
        	margin-bottom: 20px;
        	
        }
    </style>
</head>
<body>

<!--主要区域开始-->
<div id="waikuang">
        <!--必填项-->
        	<div id="title">
        		<h1>账务账号资料</h1>
        	</div>
       			<div class="layui-form-item">
						<label class="layui-form-mid">用户名:</label>
						<div class="layui-input-block">
							<input type="text" name="userName" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateUserName">
						</div>
					</div>
				<div class="layui-form-item">
						<label class="layui-form-mid">真实姓名:</label>
						<div class="layui-input-block">
							<input type="text" name="userReallName" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateuserReallName">
						</div>
					</div>	
      			<div class="layui-form-item">
						<label class="layui-form-mid">身份证:</label>
						<div class="layui-input-block">
							<input type="text" name="userID" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateuserID">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">性别:</label>
						<div class="layui-input-block">
							<input type="text" name="userGender" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateuserGender">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">邮箱:</label>
						<div class="layui-input-block">
							<input type="text" name="userEmail" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateuserEmail">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">状态:</label>
						<div class="layui-input-block">
							<input type="text" name="userState" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateuserState">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">QQ:</label>
						<div class="layui-input-block">
							<input type="text" name="userQQ" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateuserQQ">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">电话:</label>
						<div class="layui-input-block">
							<input type="text" name="userTelphone" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateuserTelphone">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">地址:</label>
						<div class="layui-input-block">
							<input type="text" name="userAdress" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateuserAdress">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">创建时间:</label>
						<div class="layui-input-block">
							<input type="text" name="createTime" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updatecreateTime">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">修改时间:</label>
						<div class="layui-input-block">
							<input type="text" name="updateTime" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateupdateTime">
						</div>
					</div>
       
</div>
</body>
</html>
