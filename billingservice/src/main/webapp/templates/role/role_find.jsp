<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<link type="text/css" rel="stylesheet" media="all"
	href="../styles/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="../styles/global_color.css" />
<link rel="stylesheet" href="../../static/layui/css/layui.css"
	media="all">
<link type="text/css" rel="stylesheet" href="../styles/index1.css">
<script src="../../static/js/index.js"></script>
<script src="../../static/layui/layui.js"></script>
</head>
<body>
<div class="layui-container">
		<div class="layui-row">
			<div class="layui-col-md4 layui-col-md-offset4">
			<br/>
					<div class="layui-form-item">
						<label class="layui-form-mid">角色名称</label>
						<div class="layui-input-block">
							<input type="text" name="roleName" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="roleName">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">角色描述</label>
						<div class="layui-input-block">
							<input type="text" name="roleDescribe" required lay-verify="required"
								autocomplete="off" class="layui-input" id="roleDescribe"
								disabled="disabled">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">角色类型</label>
						<div class="layui-input-block">
							<input type="text" name="roleType" required lay-verify="required"
								autocomplete="off" class="layui-input" id="roleType"
								disabled="disabled">
						</div>
					</div>


					<div class="layui-form-item">
						<label class="layui-form-mid">权限名称</label>
						<div class="layui-input-block">
							<input type="text" class="layui-input" 
								name="authorityName" id="authorityName" disabled="disabled">
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<input type="button" onclick="cancel()" class="layui-btn layui-btn-primary" value="返回"/>
						</div>
					</div>
			</div>
		</div>
</div>
<script type="text/javascript">
function cancel(){
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	parent.layer.close(index);
};
</script>
</body>
</html>