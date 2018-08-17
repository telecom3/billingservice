<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>电信</title>
     <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global_color.css" />
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

<!--导航区域结束-->
<!--主要区域开始-->
<div id="waikuang">
        <!--必填项-->
        	<div id="title">
        		<h1>资费个人信息查看</h1>
        	</div>
        	<div class="layui-form-item">
						<label class="layui-form-mid">资费状态:</label>
						<div class="layui-input-block">
							<input type="text" name="tariffState" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updatetariffState">
						</div>
					</div>
       			<div class="layui-form-item">
						<label class="layui-form-mid">资费名称:</label>
						<div class="layui-input-block">
							<input type="text" name="tariffName" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updatetariffName">
						</div>
					</div>
				<div class="layui-form-item">
						<label class="layui-form-mid">资费类型</label>
						<div class="layui-input-block">
							<input type="text" name="tariffType" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updatetariffType">
						</div>
					</div>	
      			<div class="layui-form-item">
						<label class="layui-form-mid">基本时长</label>
						<div class="layui-input-block">
							<input type="text" name="baseTime" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updatebaseTime">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">基本费用</label>
						<div class="layui-input-block">
							<input type="text" name="baseCost" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updatebaseCost">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">单位费用</label>
						<div class="layui-input-block">
							<input type="text" name="unitCost" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updateunitCost">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-mid">资费描述</label>
						<div class="layui-input-block">
							<input type="text" name="costDescrible" required lay-verify="required"
								autocomplete="off" class="layui-input" 
								disabled="disabled" id="updatecostDescrible">
						</div>
					</div>
					
					
					
       
</div>
</body>
</html>
