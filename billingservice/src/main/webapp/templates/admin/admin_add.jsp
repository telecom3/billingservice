<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>中国电信</title>
    <link rel="stylesheet" href="../../static/layui/css/layui.css"
	media="all">
	<script src="../../static/layui/layui.js"></script>
<link type="text/css" rel="stylesheet" media="all"
	href="../styles/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="../styles/global_color.css" />
<script src="../../static/js/jquery-3.3.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="../styles/index1.css">




</head>
<body>

	<div class="layui-container">
		<div class="layui-row" id="tou">
			<div class="layui-col-md2  layui-col-md-offset5">
			<br>
			</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-md4 layui-col-md-offset4">
				<form class="layui-form" id="form1" method="post">

					<input type="hidden" name="id" value="111">


					<div class="layui-form-item">
						<label class="layui-form-mid">管理员名称</label>
						<div class="layui-input-block">
							<input type="text" id="userName" name="userName" required lay-verify="required"
								placeholder="请输入管理员名称" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">管理员账号</label>
						<div class="layui-input-block">
							<input type="text" id="userReallName" name="userReallName" required lay-verify="required"
								placeholder="请输入管理员账号" autocomplete="off" class="layui-input">
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-mid">密码</label>
						<div class="layui-input-block">
							<input id="userPwd" type="password" name="userPwd" required
								lay-verify="pwd1"  placeholder="请输入密码"
								autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">电话</label>
						<div class="layui-input-block">
							<input  id="userTelphone" name="userTelphone" class="layui-input" type="tel"
								autocomplete="off" placeholder="请输入手机" lay-verify="phone">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">邮箱</label>
						<div class="layui-input-block">
							<input id="userEmail" name="userEmail" class="layui-input" type="text"
								autocomplete="off" placeholder="请输入邮箱" lay-verify="email">
						</div>
					</div>
					<div class="layui-form-item">
      				 <div class="layui-block">
      					<label class="layui-form-mid">角色名称</label>
      				<div class="layui-input-block">
        				<select name=roleName id="laozi" lay-filter="aihao">
        				</select>
      						</div>
    					</div>
    				</div>
					
					

					<div class="layui-form-item">
						<div class="layui-input-block">
							&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
							<button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
							&nbsp;&nbsp;&nbsp; <input type="button" onclick="cancel()"
								class="layui-btn " value="取消" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script>
$(function(){
    var str="";
    $.post("/billingservice/templates/authoritymag/findAll",null,function(info){
    	console.log(info)
    	 str+="<option >"+"请选择角色名称"+"</option>"; 
    	for (var i = 0; i < info.length; i++) {
			str+="<option value='"+info[i].id+"'>"+info[i].roleName+"</option>";
		}
    	
    	$("#laozi").html(str);
    },"json");
    });


function cancel(){
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	parent.layer.close(index);
};


	layui.use('form', function() {
		var form = layui.form;
		
		
		//监听提交
		form.on('submit(formDemo)', function(data) {
			$.post("/billingservice/templates/administrator/add",
					$("#form1").serialize(), null);
			var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			//关闭主页面iframe窗口
			parent.layer.close(index);
			//刷新主页面
			parent.location.reload();
		});
		
		
		
		//自定义验证规则
        form.verify({
            pwd1: [/(.+){6,12}$/, '密码必须6到12位'],
        });
	});
	layui.use('form', function(){
	    var form = layui.form; 
	    form.render();
	});
	
</script>
</html>
