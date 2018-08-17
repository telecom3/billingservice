<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>电信</title>
    <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global_color.css" />
      <link rel="stylesheet" href="../../static/layui/css/layui.css" media="all">
    <link type="text/css" rel="stylesheet"href="../../static/styles/index1.css">
    <script src="../../static/layui/layui.js"></script>
    <script src="../../static/js/jquery-3.3.1.min.js"></script>
    
<style type="text/css">
  	#eName,#eTime,#eLx,#eZt{
  	color: red;
  	}

</style>
</head>
<body>

<!--导航区域结束-->
<!--主要区域开始-->
<div id="main" >
  <form class="layui-form" id="form1">
    <div class="layui-form-item">
        <label class="layui-form-label">资费名称</label>
        <div class="layui-input-block">
            <input type="text" id="tariffName1" name="tariffName" lay-verify="title" autocomplete="off" placeholder="请输入资费名称" class="layui-input">
            <span id="eName">只能输入汉字或字母1-10位</span>
        </div>
    </div>
     <div class="layui-form-item">
        <label class="layui-form-label">资费状态</label>
        <div class="layui-input-block">
            <input type="text" id="tariffState1" name="tariffState" lay-verify="title" autocomplete="off" placeholder="资费状态  ， 0代表未开通   ，1代表已经开通" class="layui-input">
      		 <span id="eZt">只能输入0或者1（0表示未开通，1表示开通）</span>
        </div>
    </div>
     <div class="layui-form-item">
        <label class="layui-form-label">资费类型</label>
        <div class="layui-input-block">
            <input type="text" id="tariffType1" name="tariffType" lay-verify="title" autocomplete="off" placeholder="资费类型：  1 代表包月  、  2 代表套餐   、 3  代表计时" class="layui-input">
       		 <span id="eLx">只能输入1或者2或者3（1代表包月，2代表套餐，3代表包时）</span>	
        </div>
    </div>
      <div class="layui-form-item">
        <label class="layui-form-label">基本时长</label>
        <div class="layui-input-block">
            <input type="text" name="baseTime" lay-verify="title" autocomplete="off" placeholder="请输入时长（使用时长）" class="layui-input">
        	<span id="eTime"></span>
        </div>
    </div>
      <div class="layui-form-item">
        <label class="layui-form-label">基本费用</label>
        <div class="layui-input-block">
            <input type="text" name="baseCost" lay-verify="title" autocomplete="off" placeholder="请输入基本费用" class="layui-input">
        </div>
    </div>
      <div class="layui-form-item">
        <label class="layui-form-label">单位费用</label>
        <div class="layui-input-block">
            <input type="text" name="unitCost" lay-verify="title" autocomplete="off" placeholder="请输入单位费用" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">资费描述</label>
        <div class="layui-input-block">
            <input type="text" name="costDescrible" lay-verify="title" autocomplete="off" placeholder="请描述资费详情" class="layui-input">
        </div>
    </div>
     <button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
    
	
</form>
<!--主要区域结束-->
<div id="footer">
    <span>[源自全宇宙最帅组的技术，最优秀的小哥哥，最真实的企业环境，最适用的实战项目]</span>
    <br />
    <span>版权所有(C)全宇宙最帅组集团公司 </span>
</div>
</body>
<script>
var bool=null;
var bool1=null;
var bool2=null;
var bool3=null;

$("#tariffName1").blur(function(){
	//姓名
	var eName = /^[a-zA-Z0-9-\u4e00-\u9fa5]{1,10}$/;
	var bool=eName.test(this.value);
	
	if(bool){
		$("#eName").css({display:"none"})
	}else{
		$("#eName").css({display:"inline"})
	}
})

$("#tariffState1").blur(function(){
	//姓名
	var eZt = /^[0,1]{1}$/;
	var bool1=eZt.test(this.value);
	
	if(bool1){
		$("#eZt").css({display:"none"})
	}else{
		$("#eZt").css({display:"inline"})
	}
})

$("#tariffType1").blur(function(){
	//姓名
	var eLx = /^[1,2,3]{1}$/;
	var bool2=eLx.test(this.value);
	
	if(bool2){
		$("#eLx").css({display:"none"})
	}else{
		$("#eLx").css({display:"inline"})
	}
})



/* ^[01]$ */



layui.use('form', function() {
	var form = layui.form;

	//监听提交
	form.on('submit(formDemo)', function(data) {
		$.post("/billingservice/tariffInfo/fee/save", $("#form1").serialize(),null);
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
