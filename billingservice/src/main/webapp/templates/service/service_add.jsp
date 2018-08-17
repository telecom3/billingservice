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
       #waikuang{
        margin: auto;
      	
        }
        #title{
        	margin-left: 130px;
        }
        #add{
        	margin-left: 130px;
        	margin-bottom: 20px;
        }
       
    </style>
   
</head>
<body>

<!--主要区域开始-->
<div id="waikuang">
   			<div id="title">
        		<h1>添加业务账号</h1>
        	</div>
        	<br>
        	<br>
    <form  class="layui-form" id="form1">
        	
       			<div class="layui-form-item">
						<label class="layui-form-label">OS账号:</label>
						<div class="layui-input-inline">
							 <input type="text" name="businessOs" lay-verify="required" id="businessOs" placeholder="请输入OS账号" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">密码:</label>
						<div class="layui-input-inline">
							<input type="password" name="businessOsPwd"  lay-verify="required"
								autocomplete="off" class="layui-input" placeholder="请输入密码"
								 id="businessOsPwd">
						</div>
						<div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
					</div>	
				<div class="layui-form-item">
						<label class="layui-form-label">服务器IP:</label>
						<div class="layui-input-inline">
							<input type="text" name="ipAdress" lay-verify="required"
								autocomplete="off" class="layui-input" placeholder="请输入服务器IP"
								id="ipAdress">
						</div>
					</div>	
					<div class="layui-form-item">
      				 <div class="layui-inline ">
      					<label class="layui-form-label">资费套餐</label>
      				<div class="layui-input-inline">
        				<select name="tariffName" id="tariff" lay-filter="aihao">
        				</select>
      						</div>
    					</div>
    				</div>
 
					<div class="layui-form-item">
    					<div class="layui-input-inline">
      							
      						<button id="add" class="layui-btn" lay-submit lay-filter="demo1">添加</button>
    						<input type="button" onclick="cancel()" class="layui-btn "  style="margin-left: 115px" value="批量添加"/>
    					</div>
  					</div>
   		 </form>
    			
</div>
</body>
<script type="text/javascript">


$(function(){
    var str="";
    $.post("/billingservice/tariffInfo/fee/all",null,function(info){

    	console.log(info)
        
    	 str+="<option >"+"请选择套餐"+"</option>"; 
    	for (var i = 0; i < info.length; i++) {
			str+="<option value='"+info[i].id+"'>"+info[i].tariffName+"</option>";
		}
    	
    	$("#tariff").html(str);
    },"json");
    });


layui.use('form', function(){
	  var form = layui.form;
	  //监听提交
	  form.on('submit(demo1)', function(data){
		  $.post("/billingservice/templates/business/save", $("#form1").serialize(),null);
		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			//关闭主页面iframe窗口
			parent.layer.close(index);
			//刷新主页面
			parent.location.reload();
	   		 return false;
	  });
	});

layui.use('form', function(){
    var form = layui.form; 
    form.render();
}); 

function cancel() {
	var index = layui.layer.open({
        title : "批量添加",
        type : 2,
        content : "file_upload.jsp",//弹出层页面
        area: ['320px', '300px']
    });
	//获取窗口索引
	//var index = parent.layer.getFrameIndex(window.name); 
	//关闭主页面iframe窗口
	//parent.layer.close(index);
}
</script>
</html>
