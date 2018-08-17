<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8">
<title>操作</title>
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
<style type="text/css">
#tableDiv {
	margin-left: 50px;
}
 #main{
            margin: auto;
        }
        


</style>
</head>
<body>
	<jsp:include page="../nav/nav.jsp" flush="true"></jsp:include>

	<!--主要区域开始-->
	<div id="main" >
		<div class="layui-tab layui-tab-brief" lay-filter="demo" >
			<ul class="layui-tab-title">
				<li class="layui-this" id="li1">年度账务查询</li>
				<li id="li2">月度账务查询</li>
			</ul>
			<div class="layui-tab-content" id="tableDiv" >

				<div class="layui-tab-item" >

					<div class="layui-inline">
						<label class="layui-form-label">请输入年份</label>
						<div class="layui-input-inline">
							<input type="text" name="date" id="month_Date" lay-verify="date"
								placeholder="yyyy" autocomplete="off" class="layui-input">
						</div>
					</div>

					<button class="layui-btn layui-btn-normal" id="search"
						data-type="reload">查询</button>

					<br />
			
					<table class="layui-hide" id="test" lay-filter="demo"  ></table>
					<script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
            </script>
				</div>


				<div class="layui-tab-item">
					<div class="layui-inline">
						<label class="layui-form-label">请输入月份</label>
						<div class="layui-input-inline">
							<input type="text" name="date" id="year_Date" lay-verify="date"
								placeholder="mm" autocomplete="off" class="layui-input">
						</div>
					</div>

					<button class="layui-btn layui-btn-normal" id="search2"
						data-type="reload">查询</button>

				
					<table class="layui-hide" id="test1" lay-filter="demo1"></table>
					<script type="text/html" id="barDemo1">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
            </script>
				</div>
			</div>
		</div>
	</div>

	<!--主要区域结束-->



	<div id="footer">
		<span>[源自全宇宙最帅组的技术，最优秀的小哥哥，最真实的企业环境，最适用的实战项目]</span> <br /> <span>版权所有(C)全宇宙最帅组集团公司
		</span>
	</div>

</body>
<script>
	layui
			.use(
					[ 'element', 'laydate', 'table' ],
					function() {
						var laydate = layui.laydate, table = layui.table, element = layui.element;

						//执行一个 table 实例
						table.render({
							elem : '#test',
							height : 332,
							width : 750,
							limit : 5,
                             
							
							limits : [ 5, 10 ],
							url : '/billingservice/templates/account/year' //数据接口
							,
							page : true //开启分页
							,
							cols : [ [ //表头
							{
								field : 'userInfo',
								title : '账务账号',
								width : 120,
								templet : '<div>{{d.userInfo.userName}}</div>'
							}, {
								field : 'osName',
								title : '业务账号',
								width : 120
							}, {
								field : 'serviceIp',
								title : '服务器',
								width : 150
							}, {
								field : 'accountYear',
								title : '年份',
								width : 120,
								sort : true
							}, {
								field : 'countTime',
								title : '总时长',
								width : 120
							}, {
								fixed : 'right',
								width : 120,
								align : 'center',
								toolbar : '#barDemo'
							} ] ]
						});

						//执行一个 table 实例
						table.render({
							elem : '#test1',
							height : 332,
							width : 830,
							limit : 5,
							limits : [ 5, 10 ],
							url : '/billingservice/templates/account/month' //数据接口
							,
							page : true,
							cols : [ [ //表头
							{
								field : 'userName',
								title : '账务账号',
								width : 100
							}, {
								field : 'osName',
								title : '业务账号',
								width : 120
							}, {
								field : 'serviceIp',
								title : '服务器',
								width : 150
							}, {
								field : 'accountYear',
								title : '年份',
								width : 120,
								sort : true
							}, {
								field : 'accountMonth',
								title : '月份',
								width : 120,
								sort : true
							}, {
								field : 'countTime',
								title : '总时长',
								width : 100
							}, {
								fixed : 'right',
								width : 120,
								align : 'center',
								toolbar : '#barDemo'
							} ] ]
						});

						//监听工具条---日详情
						table
								.on(
										'tool(demo1)',
										function(obj) {
											var data = obj.data;
											if (obj.event === 'detail') {
												layer
														.open({
															type : 2,
															area : [ '800px',
																	'500px' ],
															fixed : false, //不固定
															title : '日详情',
															maxmin : true,
															content : 'credit_account_day.jsp',
															success : function(
																	layero,
																	index) {
																var iframe = window['layui-layer-iframe'
																		+ index];
																//调用子页面的全局函数
																iframe
																		.child(data)
															}
														});
											}
										});

						//监听工具条---月详情
						table
								.on(
										'tool(demo)',
										function(obj) {
											var data = obj.data;
											if (obj.event === 'detail') {
												layer
														.open({
															type : 2,
															area : [ '800px',
																	'500px' ],
															fixed : false, //不固定
															title : '月详情', //不固定
															maxmin : true,
															content : 'credit_account_month.jsp',
															success : function(
																	layero,
																	index) {
																var iframe = window['layui-layer-iframe'
																		+ index];
																//调用子页面的全局函数
																iframe
																		.child(data)
															}
														});
											}
										});

						//按条件查询
						var $ = layui.$, active = {
							reload : function() {
								//第一个选项卡的搜索
								var month_Date = $('#month_Date');
								table.reload('test', {
									where : {
										accountYear : month_Date.val()
									}
								});
								//第二个选项卡的搜索
								var year_Date = $('#year_Date');

								table.reload('test1', {
									where : {
										month : year_Date.val()

									}
								});

							}
						};

						$('#search').on('click', function() {
							var type = $(this).data('type');
							active[type] ? active[type].call(this) : '';
						});

						$('#search2').on('click', function() {
							var type = $(this).data('type');
							active[type] ? active[type].call(this) : '';
						});
					});
</script>
</body>
</html>
