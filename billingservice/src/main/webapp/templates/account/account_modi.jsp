<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>中国电信</title>
    <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global_color.css" />
    <link rel="stylesheet" href="../../static/layui/css/layui.css" media="all">
    <link type="text/css" rel="stylesheet"href="../../static/styles/index1.css">
    <script src="../../static/js/index.js"></script>
    <script src="../../static/layui/layui.js"></script>
   <script src="../../static/js/jquery-3.3.1.min.js"></script>
    
    <style type="text/css">
         #waikuang{
        margin: auto;
      
        }
        #title{
        	text-align:center;
        }
        .layui-input{
    		width: 300px;
    	}
    	#update{
    		margin-left: 200px;
    	}
    </style>
   
</head>
<body>


<jsp:include page="../nav/nav.jsp" flush="true"></jsp:include>

<div id="waikuang">
        <!--必填项-->
        	<div id="title">
        		<h1>修改账务账号</h1>
        	</div>
        	<form class="layui-form" id="form1">
       			<div class="layui-form-item">
						<label class="layui-form-label">用户名:</label>
						<div class="layui-input-inline">
							<input type="text" name="userName" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateUserName">
						</div>
					</div>
				<div class="layui-form-item">
						<label class="layui-form-label">真实姓名:</label>
						<div class="layui-input-inline">
							<input type="text" name="userReallName" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateuserReallName">
						</div>
					</div>	
      			<div class="layui-form-item">
						<label class="layui-form-label">身份证:</label>
						<div class="layui-input-inline">
							<input type="text" name="userID" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateuserID">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">性别:</label>
						<div class="layui-input-inline">
							<input type="text" name="userGender" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateuserGender">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">邮箱:</label>
						<div class="layui-input-inline">
							<input type="text" name="userEmail" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateuserEmail">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">状态:</label>
						<div class="layui-input-inline">
							<input type="text" name="userState" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateuserState">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">QQ:</label>
						<div class="layui-input-inline">
							<input type="text" name="userQQ"  lay-verify="required"
								autocomplete="off" class="layui-input" 
								 id="updateuserQQ">
						</div>
						<div class="layui-form-mid layui-word-aux">可修改</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">电话:</label>
						<div class="layui-input-inline">
							<input type="text" name="userTelphone"  lay-verify="required"
								autocomplete="off" class="layui-input" 
								 id="updateuserTelphone">
						</div>
						<div class="layui-form-mid layui-word-aux">可修改</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">地址:</label>
						<div class="layui-input-inline">
							<input type="text" name="userAdress" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateuserAdress">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">创建时间:</label>
						<div class="layui-input-inline">
							<input type="text" name="createTime" required lay-verify="title"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updatecreateTime">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">修改时间:</label>
						<div class="layui-input-inline">
							<input type="text" name="updateTime" required lay-verify="title"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateupdateTime">
						</div>
					</div>	
						<div class="layui-form-item">
								<div class="layui-input-block">
									<input type="hidden" name="id"  lay-verify="title"
										autocomplete="off" class="layui-input" 
										 id="updateid">
								</div>
						</div>
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<button id="update" class="layui-btn" lay-submit lay-filter="formDemo">修改</button>
						</div>
					</div>
       </form>
</div>
</body>
<script type="text/javascript">
layui.use('form', function() {
	var form = layui.form;
	//监听提交
	form.on('submit(formDemo)', function(data) {
		console.log( $("#form1").serialize())
		$.post("/billingservice/templates/user/updateUser", $("#form1").serialize(),function(info){
			
			
			if(info==1){
				//获取窗口索引
				var index = parent.layer.getFrameIndex(window.name); 
				//关闭主页面iframe窗口
				parent.layer.close(index);
				//刷新主页面
				parent.location.reload();
			}
		});
		return false;
	});
});
</script>
</html>
