<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="shiro"
	uri="http://shiro.apache.org/tags"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<link type="text/css" rel="stylesheet" href="../../static/styles/index1.css">
<script src="../../static/layui/layui.js"></script>
<script src="../../static/js/jquery-3.3.1.min.js"></script>
<script>
	layui.use('element', function() {
		var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

		//监听导航点击
		element.on('nav(demo)', function(elem) {
			//console.log(elem)
			layer.msg(elem.text());
		});
	});
</script>

<style type="text/css">
#main {
	margin: auto
}
</style>
</head>
<body>
	<!--Logo区域开始-->
	<jsp:include page="../nav/nav.jsp" flush="true"></jsp:include>


	<!--导航区域结束-->
	<!--主要区域开始-->

	<div id="main">
		<!--查询-->
		<div class="search_add">


			<div class="layui-inline">
				<input class="layui-input" name="tariffName" id="tariffName"
					placeholder="请输入资费名称" />
			</div>
			<button class="layui-btn" data-type="reload" id="find">搜索</button>

			<!--   <div><input type="button" value="搜索" class="btn_search" data-type="reload" id="find"/></div> -->
			<!-- <input type="button" value="增加" class="btn_add" onclick="location.href='fee_add.jsp';" /> -->
			<!-- <input type="button" value="增加" class="btn_add" onclick="add()" /> -->
			<button class="layui-btn" id="add1">新增</button>

		</div>

		<!--数据区域：用表格展示数据-->
		<div id="data">
			<table class="layui-hide" id="test" lay-filter="demo"></table>
			<script type="text/html" id="barDemo">
                           <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  						   <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
  						   <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
						   <a class="layui-btn layui-btn-xs" lay-event="kai">开/关</a>
                        </script>

		</div>
	</div>
	<!--主要区域结束-->
	<div id="footer">
		<p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
		<p>版权所有(C)加拿大达内IT培训集团公司</p>
	</div>
</body>
<script>
	layui.use(
					[ 'table', 'laypage', 'laydate' ],
					function() {
						var table = layui.table, laydate = layui.laydate, laypage = layui.laypage;

						//执行一个 table 实例
						table.render({
							type : "post",
							elem : '#test',
							height : 332,
							url : '/billingservice/tariffInfo/fee/page' //数据接口
							,
							page : true //开启分页
							,
							limit : 5,
							cols : [ [ //表头
							{
								field : 'id',
								title : 'ID',
								width : 80,
								sort : true,
								fixed : 'left'
							}, {
								field : 'tariffState',
								title : '资费状态',
								width : 100
							}, {
								field : 'tariffName',
								title : '资费名称',
								width : 110
							}, {
								field : 'tariffType',
								title : '类型',
								width : 60
							}, {
								field : 'baseTime',
								title : '时长',
								width : 86,
								sort : true
							}, {
								field : 'baseCost',
								title : '费用',
								width : 80,
								sort : true
							}, {
								field : 'unitCost',
								title : '单位费用',
								width : 100,
								sort : true
							}, {
								field : 'costDescrible',
								title : '资费描述',
								width : 100
							}, {
								field : 'stratTime',
								title : '开通时间',
								width : 100,
								sort : true
							}

							/*   ,{field: 'businessInfo', title: '业务账号', width: 80, sort: true} */
							, {
								fixed : 'right',
								title : '操作',
								width : 200,
								align : 'center',
								toolbar : '#barDemo'
							} ] ]
							//数据转换
							,
							done : function(res, page, count) {
								$("[data-field='tariffState']").children()
										.each(function() {
											if ($(this).text() == '1') {
												$(this).text("开通")
											} else {
												$(this).text("暂停")
											}
										})
								$("[data-field='tariffType']").children().each(
										function() {
											if ($(this).text() == '0') {
												$(this).text("包月")
											}
										})
								$("[data-field='tariffType']").children().each(
										function() {
											if ($(this).text() == '1') {
												$(this).text("包月")
											}
										})
								$("[data-field='tariffType']").children().each(
										function() {
											if ($(this).text() == '2') {
												$(this).text("套餐")
											}
										})
								$("[data-field='tariffType']").children().each(
										function() {
											if ($(this).text() == '3') {
												$(this).text("计时")
											}
										})
							}

						});
						//监听工具条
						table
								.on(
										'tool(demo)',
										function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
											var data = obj.data //获得当前行数据
											, layEvent = obj.event; //获得 lay-event 对应的值
											if (layEvent === 'detail') {
												$
														.post(
																"/billingservice/tariffInfo/fee/find",
																"id=" + data.id,
																function(info) {
																	var index = layui.layer
																			.open({
																				title : "查看资费信息",
																				type : 2,
																				content : "/billingservice/templates/fee/fee_detail.jsp",//弹出层页面
																				area : [
																						'620px',
																						'600px' ],
																				success : function(
																						layero,
																						index) {
																					var body = layui.layer
																							.getChildFrame(
																									'body',
																									index);
																					body
																							.find(
																									"#updatetariffState")
																							.val(
																									info.tariffState);
																					body
																							.find(
																									"#updatetariffName")
																							.val(
																									info.tariffName);
																					body
																							.find(
																									"#updatetariffType")
																							.val(
																									info.tariffType);
																					body
																							.find(
																									"#updatebaseTime")
																							.val(
																									info.baseTime);
																					body
																							.find(
																									"#updatebaseCost")
																							.val(
																									info.baseCost);
																					body
																							.find(
																									"#updateunitCost")
																							.val(
																									info.unitCost);
																					body
																							.find(
																									"#updatecostDescrible")
																							.val(
																									info.costDescrible);
																					body
																							.find(
																									"#updateid")
																							.val(
																									info.id);
																					if (info.tariffState == 0) {
																						body
																								.find(
																										"#updatetariffState")
																								.val(
																										"暂停");
																					} else {
																						body
																								.find(
																										"#updatetariffState")
																								.val(
																										"开通");
																					}
																					if (info.tariffType == 0) {
																						body
																								.find(
																										"#updatetariffType")
																								.val(
																										"包月");
																					}
																					if (info.tariffType == 1) {
																						body
																								.find(
																										"#updatetariffType")
																								.val(
																										"包月");
																					}
																					if (info.tariffType == 2) {
																						body
																								.find(
																										"#updatetariffType")
																								.val(
																										"套餐");
																					}
																					if (info.tariffType == 3) {
																						body
																								.find(
																										"#updatetariffType")
																								.val(
																										"计时");
																					}
																				}
																			});

																}, "json");

											} else if (layEvent === 'del') {
												console.log(data.id)
												layer
														.confirm(
																'真的删除行么',
																function(index) {
																	$
																			.ajax({
																				url : "/billingservice/tariffInfo/fee/delete?id="
																						+ data.id,
																				type : "post",
																				data : {
																					"id" : data.id
																				},
																				contentType : 'application/json',
																				dataType : 'json',
																				success : function(
																						data) {
																					$(
																							".layui-laypage-btn")
																							.click()
																					layer
																							.msg('删除成功');
																				}

																			})
																});
											} else if (layEvent === 'edit') {
												$
														.post(
																"/billingservice/tariffInfo/fee/find",
																"id=" + data.id,
																function(info) {
																	var index = layui.layer
																			.open({
																				title : "修改用户",
																				type : 2,
																				contentType : 'application/json',
																				content : "/billingservice/templates/fee/fee_modi.jsp",//弹出层页面
																				area : [
																						'620px',
																						'600px' ],
																				success : function(
																						layero,
																						index) {
																					var body = layui.layer
																							.getChildFrame(
																									'body',
																									index);
																					body
																							.find(
																									"#updatetariffState")
																							.val(
																									info.tariffState);
																					body
																							.find(
																									"#updatetariffName")
																							.val(
																									info.tariffName);
																					body
																							.find(
																									"#updatetariffType")
																							.val(
																									info.tariffType);
																					body
																							.find(
																									"#updatebaseTime")
																							.val(
																									info.baseTime);
																					/*  body.find("updatebaseTime").val(new Date(info.baseTime).Format('yyyy年MM月dd日')); */
																					body
																							.find(
																									"#updatebaseCost")
																							.val(
																									info.baseCost);
																					body
																							.find(
																									"#updateunitCost")
																							.val(
																									info.unitCost);
																					body
																							.find(
																									"#updatecostDescrible")
																							.val(
																									info.costDescrible);
																					body
																							.find(
																									"#updateid")
																							.val(
																									info.id);

																					if (info.tariffState == 0) {
																						body
																								.find(
																										"#updatetariffState")
																								.val(
																										"暂停");
																					} else {
																						body
																								.find(
																										"#updatetariffState")
																								.val(
																										"开通");
																					}
																					if (info.tariffType == 0) {
																						body
																								.find(
																										"#updatetariffType")
																								.val(
																										"包月");
																					}
																					if (info.tariffType == 1) {
																						body
																								.find(
																										"#updatetariffType")
																								.val(
																										"包月");
																					}
																					if (info.tariffType == 2) {
																						body
																								.find(
																										"#updatetariffType")
																								.val(
																										"套餐");
																					}
																					if (info.tariffType == 3) {
																						body
																								.find(
																										"#updatetariffType")
																								.val(
																										"计时");
																					}
																				}
																			});

																}, "json");
												layer.msg('编辑操作');
											} else if (layEvent === 'kai') {
												console.log(data.userState)
												if (data.tariffState == 1) {

													layer
															.confirm(
																	'确定暂停该账号吗',
																	function(
																			index) {
																		$
																				.ajax({
																					url : "/billingservice/tariffInfo/fee/suspend",
																					type : "post",
																					data : {
																						"id" : data.id
																					},
																					dataType : 'json',
																					success : function(
																							data) {
																						$(
																								".layui-laypage-btn")
																								.click()
																						layer
																								.msg('暂停成功');
																					}

																				})
																	});
												} else {
													$
															.ajax({
																url : "/billingservice/tariffInfo/fee/open",
																type : "post",
																data : {
																	"id" : data.id
																},
																dataType : 'json',
																success : function(
																		data) {
																	$(
																			".layui-laypage-btn")
																			.click()
																	layer
																			.msg('开通成功');
																}

															})
												}

											}

										});
						var $ = layui.$, active = {
							reload : function() {
								var tariffName1 = $('#tariffName');
								/* var userName1 = $('#userName');
								var userState1 = $('#userState'); */
								console.log(tariffName1);
								table.reload('test', {
									page : {
										curr : 1
									},
									where : {
										tariffName : tariffName1.val(),
									/* userName : userName1.val(),
									userState : userState1.val() */
									}
								});
							}
						};
						$('#find').on('click', function() {
							var type = $(this).data('type');
							active[type] ? active[type].call(this) : '';
						});

						$("#add1")
								.click(
										function() {
											var index = layui.layer
													.open({
														title : "添加用户",
														type : 2,
														content : "/billingservice/templates/fee/fee_add.jsp",//弹出层页面
														area : [ '620px',
																'600px' ]
													})
										})

					});
</script>
</html>
