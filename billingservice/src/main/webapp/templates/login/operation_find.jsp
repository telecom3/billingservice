<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" media="all"
	href="../../static/styles/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="../../static/styles/global_color.css" />
<link rel="stylesheet" href="../../static/layui/css/layui.css"
	media="all">
<script src="../../static/layui/layui.js"></script>
<link rel="stylesheet" type="text/css" href="../../static/styles/index1.css" />
<script src="../../static/layui/layui.js"></script>
<script src="../../static/js/jquery-3.3.1.min.js"></script>

<style>
.layui-input {
	font-size: 15px;
	color: #009688;
}
</style>

</head>
<body>

	<div class="layui-row ">
	    <br><br><br><br>
		  <div class="layui-col-md4 layui-col-md-offset4">  
			<div class="layui-form-item">
				<label class="layui-form-label">用户名:</label>
				<div class="layui-input-block">
					<input type="text" name="title" lay-verify="title"
						autocomplete="off" readonly="readonly" id="name1" class="layui-input">
				</div>
			</div>
			</div>
		
			
			 <div class="layui-col-md4 layui-col-md-offset4">  
			<div class="layui-form-item">
				<label class="layui-form-label">操作类型:</label>
				<div class="layui-input-block">
					<input type="text" name="title" lay-verify="title"
						autocomplete="off" readonly="readonly" id="type" class="layui-input">
				</div>
			</div>
			</div>
			
              <div class="layui-col-md4 layui-col-md-offset4">  
             	<div class="layui-form-item">
				<label class="layui-form-label">操作时间:</label>
				<div class="layui-input-block">
					<input type="text" name="title" lay-verify="title"
						autocomplete="off" readonly="readonly" id="login_time" class="layui-input">
				</div>
		     	</div>
		     	</div>
		     	
			 <div class="layui-col-md4 layui-col-md-offset4">  
			<div class="layui-form-item">
				<label class="layui-form-label">操作模块：</label>
				<div class="layui-input-block">
					<input type="text" name="title" lay-verify="title"
						autocomplete="off" readonly="readonly" id="moduleName" class="layui-input">
				</div>
		     	</div>
		     	</div>
		
		 <div class="layui-col-md4 layui-col-md-offset4">  
			  <div class="layui-input-inline">
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">操作数据:</label>
					<div class="layui-input-block">
						<textarea class="layui-textarea" id="content" readonly="readonly"></textarea>
					</div>
				</div>
				
			</div>
	</div>	
	</div>	
	
</body>
</html>