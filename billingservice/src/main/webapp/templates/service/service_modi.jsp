<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>电信</title>
    <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global_color.css" />
    <link type="text/css" rel="stylesheet" href="../../static/layui/css/layui.css" media="all" />
    <link type="text/css" rel="stylesheet"href="../../static/styles/index1.css">
    <script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../../static/layui/layui.js"></script>
    <script src="../../static/js/index.js"></script>
   <style type="text/css">
    	.layui-input{
    		width: 300px;
    	}
    	.layui-textarea{
			width: 300px;    	
    	}
    
    
    </style>
</head>
<body>

<!--主要区域开始-->
<div id="waikuang">
        <!--必填项-->
        	
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
						<label class="layui-form-label">OS账号:</label>
						<div class="layui-input-inline">
							<input type="text" name="businessOs" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updatebusinessOs">
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
						<label class="layui-form-label">OS密码:</label>
						<div class="layui-input-inline">
							<input type="text" name="businessOsPwd"  lay-verify="required"
								autocomplete="off" class="layui-input" 
								 id="updatebusinessOsPwd">
						</div>
						<div class="layui-form-mid layui-word-aux">可修改</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">业务账号状态:</label>
						<div class="layui-input-inline">
							<input type="text" name="businessState" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updatebusinessState">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">资费名称:</label>
						<div class="layui-input-inline">
							<input type="text" name="tariffName" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updatetariffName">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">资费描述:</label>
						<div class="layui-input-inline">
						<textarea name="costDescrible" class="layui-textarea" required lay-verify="required"
								autocomplete="off" disabled="disabled" id="updatecostDescrible" ></textarea>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">创建时间:</label>
						<div class="layui-input-inline">
							<input type="text" name="createTime" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updatecreateTime">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">修改时间:</label>
						<div class="layui-input-inline">
							<input type="text" name="updateTime" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateupdateTime">
						</div>
						<div class="layui-form-label">
								<div class="layui-input-inline">
									<input type="hidden" name="id"  lay-verify="title"
										autocomplete="off" class="layui-input" 
										 id="updateid">
								</div>
						</div>
					</div><div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit lay-filter="formDemo">修改</button>
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
		$.post("/billingservice/templates/business/update", $("#form1").serialize(),function(info){
			
			
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
