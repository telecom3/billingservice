<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电信</title>
<link type="text/css" rel="stylesheet" media="all"
	href="../styles/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="../styles/global_color.css" />
<link type="text/css" rel="stylesheet"
	href="../../static/layui/css/layui.css" media="all" />
<link type="text/css" rel="stylesheet" href="../styles/index1.css">
<script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../../static/layui/layui.js"></script>
<script src="../../static/js/index.js"></script>
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
						<label class="layui-form-mid">角色名称</label>
						<div class="layui-input-block">
							<input type="text" name="roleName" required lay-verify="required"
								placeholder="请输入角色名称" autocomplete="off" class="layui-input">
						</div>
					</div>
					<br> <br>
					<div class="layui-form-item">
						<label class="layui-form-mid">角色描述</label>
						<div class="layui-input-block">
							<input type="text" name="roleDescribe" required lay-verify="required"
								placeholder="请输入角色描述" autocomplete="off" class="layui-input">
						</div>
					</div>
					<br> <br>

					<div class="layui-form-item">
						<label class="layui-form-mid">角色类型</label>
						<div class="layui-input-inline">
							<select id="edit_exam_school" name="roleType">
								<option value="2">请选择角色类型</option>
								<option value="0">超级管理员</option>
								<option value="1">普通管理员</option>
								<option value="2">用户</option>
							</select>
						</div>
					</div>
					<br> <br>
					<div class="layui-form-item">
      				 <div class="layui-inline ">
      					<label class="layui-form-mid">权限名称</label>
      				<div class="layui-input-inline">
        				<select name=authorityName id="tariff" lay-filter="aihao">
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
    $.post("/billingservice/templates/authority/findAllAuthority",null,function(info){
    	 str+="<option >"+"请选择权限名称"+"</option>"; 
    	for (var i = 0; i < info.length; i++) {
			str+="<option value='"+info[i].id+"'>"+info[i].authorityName+"</option>";
		}
    	
    	$("#tariff").html(str);
    },"json");
    });




	layui.use('form', function() {
		var form = layui.form;
		form.render();
	});
	
	
	function cancel(){
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		parent.layer.close(index);
	};
	layui.use('form', function() {
		var form = layui.form;
		
		
		//监听提交
		form.on('submit(formDemo)', function(data) {
			$.post("/billingservice/templates/authoritymag/add",
					$("#form1").serialize(), null);
			var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			//关闭主页面iframe窗口
			parent.layer.close(index);
			//刷新主页面
			parent.location.reload();
		});
	});
</script>
</html>
