<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>中国电信</title>
    <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global_color.css" />
    <link rel="stylesheet" href="../../static/layui/css/layui.css" media="all">
    <script src="../../static/layui/layui.js"></script>
    <script src="../../static/js/jquery-3.3.1.min.js"></script>
    

    <style type="text/css">
       #waikuang{
        margin: auto;
      	width: 500px;
        }
        #title{
        	margin-left: 100px;
        }
       
    </style>
</head>
<body>

<!--导航区域结束-->
<!--主要区域开始-->
<div id="waikuang">
   			<div id="title">
        		<h1>添加账务账号</h1>
        	</div>
        	<br>
        	<br>
    <form  class="layui-form" id="form1">
        	
       			<div class="layui-form-item">
						<label class="layui-form-label">用户名:</label>
						<div class="layui-input-inline">
							 <input type="text" name="userName" lay-verify="required" id="userName" placeholder="请输入用户名" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">密码:</label>
						<div class="layui-input-inline">
							<input type="password" name="userPwd"  lay-verify="required"
								autocomplete="off" class="layui-input" placeholder="请输入密码"
								 id="userPwd">
						</div>
						<div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
					</div>	
				<div class="layui-form-item">
						<label class="layui-form-label">真实姓名:</label>
						<div class="layui-input-inline">
							<input type="text" name="userReallName" lay-verify="required"
								autocomplete="off" class="layui-input" placeholder="请输入真实姓名"
								id="userReallName">
						</div>
					</div>	
      			<div class="layui-form-item">
						<label class="layui-form-label">身份证:</label>
						<div class="layui-input-inline">
							<input type="text" name="userID"  lay-verify="identity" 
								autocomplete="off" class="layui-input" 
								placeholder="请输入身份证" id="userID">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">性别:</label>
						<div class="layui-input-inline">
							 <input type="radio" name="userGender" value="0" title="男" checked> 
     						 <input type="radio" name="userGender" value="1" title="女"> 
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">邮箱:</label>
						<div class="layui-input-inline">
							<input type="text" name="userEmail"  lay-verify="email"
								autocomplete="off" class="layui-input" 
								placeholder="请输入邮箱" id="userEmail">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">QQ:</label>
						<div class="layui-input-inline">
							<input type="text" name="userQQ"  lay-verify="required"
								autocomplete="off" class="layui-input" 
								placeholder="请输入QQ" id="userQQ">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">电话:</label>
						<div class="layui-input-inline">
							<input type="text" name="userTelphone" lay-verify="required|phone"
								autocomplete="off" class="layui-input" 
								placeholder="请输入联系电话" id="userTelphone">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">地址:</label>
						<div class="layui-input-inline">
							<input type="text" name="userAdress"  lay-verify="required"
								autocomplete="off" class="layui-input" 
								placeholder="请输入地址" id="userAdress">
						</div>
					</div>
					<div class="layui-form-item">
    					<div class="layui-input-inline">
      						<button class="layui-btn" lay-submit lay-filter="demo1" style="margin-left: 160px">添加</button>
    						
    					</div>
  					</div>
   		 </form>

    			
</div>
</body>
<script type="text/javascript">
layui.use('form', function(){
	  var form = layui.form;
	  //监听提交
	  form.on('submit(demo1)', function(data){
		  $.post("/billingservice/templates/user/saveUser", $("#form1").serialize(),null);
		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			//关闭主页面iframe窗口
			parent.layer.close(index);
			//刷新主页面
			parent.location.reload();
	    
	   		 return false;
	  });
	});

	

</script>
</html>
