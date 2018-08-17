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
<link rel="stylesheet" href="../../static/layui/css/layui.css"
	media="all">
	<script src="../../static/js/jquery-3.3.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="../styles/index1.css">
<script src="../../static/layui/layui.js"></script>

<body>
<div class="layui-container">
		<div class="layui-row">
			<div class="layui-col-md4 layui-col-md-offset4">
			<br/>
			<form class="layui-form" id="form1" method="post">
			
					<div class="layui-form-item">
					<div class="layui-input-block">
							<input name="id" id="updateId" type="hidden">
						</div>
						<label class="layui-form-mid">管理员名称</label>
						<div class="layui-input-block">
							<input type="text" name="userName" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="userName">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">管理员账号</label>
						<div class="layui-input-block">
							<input type="text" name="userReallName" required lay-verify="required"
								autocomplete="off" class="layui-input" id="userReallName"
								disabled="disabled">
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-mid">联系电话</label>
						<div class="layui-input-block">
							<input type="text" class="layui-input" 
								name="userTelphone" id="userTelphone" disabled="disabled">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-mid">邮箱</label>
						<div class="layui-input-block">
							<input type="text" class="layui-input" 
								name="userEmail" id="userEmail" disabled="disabled">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-mid">角色名称</label>
						<div class="layui-input-block">
							<input type="text" class="layui-input" 
								name="roleName" id="roleName" disabled="disabled">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-mid">角色qq</label>
						<div class="layui-input-block">
							<input type="text" class="layui-input" 
								 placeholder="请输入角色qq" name="userQQ" id="userQQ" >
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-mid">资费状态</label>
						<div class="layui-input-block">
							<input type="text" class="layui-input" 
								name="userState" id="userState" disabled="disabled">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-mid">创建时间</label>
						<div class="layui-input-block">
							<input type="text" class="layui-input" 
								name="createTime" id="createTime" disabled="disabled">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-mid">修改时间</label>
						<div class="layui-input-block">
							<input type="text" class="layui-input" 
								name="updateTime" id="updateTime" disabled="disabled">
						</div>
					</div>
					
					

					<div class="layui-form-item">
						<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formDemo">修改</button>
							<input type="button" onclick="cancel()" class="layui-btn layui-btn-primary" value="返回"/>
						</div>
					</div>
					</form>
			</div>
		</div>
</div>

</body>
<script>


	layui.use('form', function() {
		var form = layui.form;

		//监听提交
		form.on('submit(formDemo)', function(data) {
			console.log($("#form1").serialize())
			$.post("/billingservice/templates/administrator/update1", $("#form1").serialize(),function(){
				
				
					//获取窗口索引
					var index = parent.layer.getFrameIndex(window.name); 
					//关闭主页面iframe窗口
					parent.layer.close(index);
					//刷新主页面
					parent.location.reload();
				
			});
			
			return false;
		});
	});
	
	
	function cancel(){
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		parent.layer.close(index);
	};
</script>
</html>
