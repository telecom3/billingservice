<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
      #title{
        	text-align: center;
        }
       
    </style>
</head>
<body>


<!--主要区域开始-->
<div id="waikuang">
   			<div id="title">
        		<h1>修改权限</h1>
        	</div>
        	<br>
        	<br>
    <form  class="layui-form" id="form1">
        		<input type="hidden"  name="id" id="id"/ >
       			<div class="layui-form-item">
						<label class="layui-form-label">权限名称:</label>
						<div class="layui-input-inline">
							 <input type="text" name="authorityName" lay-verify="required" id="authorityName" placeholder="请输入权限名" autocomplete="off" class="layui-input">
						</div>
					</div>
						
				<div class="layui-form-item">
						<label class="layui-form-label">权限编码:</label>
						<div class="layui-input-inline">
							<input type="text" name="authorityCode" lay-verify="required"
								autocomplete="off" class="layui-input" placeholder="请输入权限编码"
								id="authorityCode">
						</div>
					</div>	
      			<div class="layui-form-item">
						<label class="layui-form-label">父级ID:</label>
						<div class="layui-input-inline">
							<input type="text" name="pId"  lay-verify="required" 
								autocomplete="off" class="layui-input" 
								placeholder="请输入父级ID" id="pId">
						</div>
					</div>
					
					<div class="layui-form-item">
    					<div class="layui-input-inline" style="width: 400px;text-align: center;">
      						<button class="layui-btn" lay-submit lay-filter="demo1">修改</button>
    						
    					</div>
  					</div>
   		 </form>
</div>
<!--主要区域结束-->
<script>
layui.use('form', function(){
	  var form = layui.form;
	  //监听提交
	  form.on('submit(demo1)', function(data){
		  $.post("/billingservice/templates/authority/updateAuthority", $("#form1").serialize(),null);
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
