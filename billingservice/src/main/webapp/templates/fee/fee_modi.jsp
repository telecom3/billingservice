<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>电信</title>
    <link type="text/css" rel="stylesheet" media="all"
	href="../../static/styles/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="../../static/styles/global_color.css" />
<link rel="stylesheet" href="../../static/layui/css/layui.css"
	media="all">

<script src="../../static/js/jquery-3.3.1.min.js"></script>
<script src="../../static/layui/layui.js"></script>
<style type="text/css">
#waikuang {
	margin: auto;
	height: 700px;
	width: 500px;
}

#title {
	text-align: center;
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
		<h1>资费个人信息修改</h1>
	</div>
	<form class="layui-form" id="form1">
		<div class="layui-form-item">
			<label class="layui-form-mid">资费状态:</label>
			<div class="layui-input-block">
				<input type="text" name="tariffState" required lay-verify="required"
					autocomplete="off" class="layui-input" id="updatetariffState"  disabled="disabled">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-mid">名称(可修改)</label>
			<div class="layui-input-block">
				<input type="text" name="tariffName" required lay-verify="required"
					autocomplete="off" class="layui-input" id="updatetariffName">
			</div>
		</div>
		<!-- <div class="layui-form-item">
			<label class="layui-form-label">资费状态</label>
			<div class="layui-input-block">
				<input type="checkbox" name="close" lay-skin="switch"
					autocomplete="off" lay-text="暂停|开通" id="updatetariffState">
			</div>
		</div> -->
		<div class="layui-form-item">
			<label class="layui-form-mid">资费类型</label>
			<div class="layui-input-block">
				<input type="text" name="tariffType" required lay-verify="required"
					autocomplete="off" class="layui-input" disabled="disabled"
					id="updatetariffType">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-mid">基本时长</label>
			<div class="layui-input-block">
				<input type="text" name="baseTime" required lay-verify="required"
					autocomplete="off" class="layui-input" disabled="disabled"
					id="updatebaseTime">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-mid">基本费用</label>
			<div class="layui-input-block">
				<input type="text" name="baseCost" required lay-verify="required"
					autocomplete="off" class="layui-input" disabled="disabled"
					id="updatebaseCost">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-mid">单位费用</label>
			<div class="layui-input-block">
				<input type="text" name="unitCost" required lay-verify="required"
					autocomplete="off" class="layui-input" disabled="disabled"
					id="updateunitCost">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-mid">描述(可修改)</label>
			<div class="layui-input-block">
				<input type="text" name="costDescrible"
					requiredlay-verify="required" autocomplete="off"
					class="layui-input" id="updatecostDescrible">
			</div>
		</div>






		<div class="layui-form-item">
			<div class="layui-input-block">
				<input type="hidden" name="id" lay-verify="title" autocomplete="off"
					class="layui-input" id="updateid">
			</div>
		</div>

		<div class="layui-form-item">
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
			console.log($("#form1").serialize())
			$
					.post("/billingservice/tariffInfo/fee/update", $("#form1")
							.serialize(),
							function(info) {

								if (info == 1) {
									//获取窗口索引
									var index = parent.layer
											.getFrameIndex(window.name);
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
