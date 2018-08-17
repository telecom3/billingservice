<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
      <title>操作</title>
  <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global_color.css" />
    <link rel="stylesheet" href="../../static/layui/css/layui.css" media="all">
    <script src="../../static/layui/layui.js"></script>
    <link rel="stylesheet" type="text/css"href="../styles/index1.css"/>
    <script src="../../static/layui/layui.js"></script>
    <script src="../../static/js/jquery-3.3.1.min.js"></script>
    <style type="text/css">
        #main{
            margin: auto;
        }
    </style>
</head>
<body>


<jsp:include page="../nav/nav.jsp" flush="true"></jsp:include>

<!--主要区域开始-->
<div id="main">
  
   <div class="layui-tab layui-tab-brief" lay-filter="demo"
		style="margin-left: 0px">
		
		<div style="margin-left: 80px">

		<div class="layui-inline">
			<label class="layui-form-label">起始日期</label>
			<div class="layui-input-inline">
				<input type="text" name="start1" id="login_log_startDate"
					lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">结束日期</label>
			<div class="layui-input-inline">
				<input type="text" name="end1" id="login_log_endDate"
					lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<button class="layui-btn layui-btn-normal" id="search"
			data-type="reload">查询</button>
</div>

		<table class="layui-hide" id="test" lay-filter="demo"></table>
		<script type="text/html" id="barDemo">
              <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
        </script>
	</div>
   
</div>

   <div id="footer">
    <span>[源自全宇宙最帅组的技术，最优秀的小哥哥，最真实的企业环境，最适用的实战项目]</span>
    <br />
    <span>版权所有(C)全宇宙最帅组集团公司 </span>
</div>

</body>
<script>
		layui.use(
						[ 'laydate', 'table', 'laypage' ],
						function() {
							var laydate = layui.laydate, table = layui.table, laypage = layui.laypage;

							//执行一个laydate实例
							laydate.render({
								elem : '#login_log_startDate' //指定元素
							});
							laydate.render({
								elem : '#login_log_endDate' //指定元素
							});

					        //执行一个 table 实例
					        table.render({
					            elem: '#test'
					            ,height: 332
					            ,width:910
					            ,url: '/billingservice/templates/login/loginLog' //数据接口
					            ,page: true //开启分页
					            ,cols: [[ //表头
					                {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
					                ,{field: 'loginName', title: '登录人员', width:90}
					                ,{field: 'loginExitTime', title: '登退时间', width:120, sort: true}
					                ,{field: 'loginType', title: '登录方式', width:170, sort: true}
					                ,{field: 'loginExit', title: '登退状态', width:120}
					                ,{field: 'loginIp', title: '登录IP', width: 220}
					                ,{fixed: 'right', width: 100, align:'center', toolbar: '#barDemo'}
					            ]]
					        ,done: function(res, page, count){
						  		  $("[data-field='loginType']").children().each(function(){
						  			  if($(this).text()=='0'){
						  				   $(this).text("浏览器登录")
						  			  }
						  			if($(this).text()=='1'){
						  				   $(this).text("手机登录")
						  			  } 	
						  			  
						  		  });
						  		  
						  		  
						  		 $("[data-field='loginExit']").children().each(function(){
						  			  if($(this).text()=='0'){
						  				   $(this).text("登录")
						  			  }
						  			if($(this).text()=='1'){
						  				   $(this).text("退出")
						  			  } 
						  			
						  		  
						  		  });
						  	    }

						        });
					        //监听工具条
					        table.on('tool(demo)', function(obj) {
								var data = obj.data;
								if (obj.event === 'detail') {
									var index = layui.layer.open({
								        title : "查看日志详情",
								        type : 2,
								        content : "loginLog_find.jsp",//弹出层页面
								        area: ['500px', '500px'],
								        end: function () {     //弹出层结束后,父层执行页面刷新
									        location.reload();
									      },
								        success : function(layero, index){
								            var body = layui.layer.getChildFrame('body', index);
								            if(data){
								                // 取到弹出层里的元素，并把编辑的内容放进去
								               
								                body.find("#name1").val(data.loginName); 
								                body.find("#login_time").val(data.loginExitTime);
								                body.find("#type").val(loginType(data.loginType));	
								                body.find("#moduleName").val(loginStatus(data.loginExit));
								                body.find("#IP").val(data.loginIp);	
								            }
								            setTimeout(function(){
								                layui.layer.tips('返回主页面', '.layui-layer-setwin .layui-layer-close', {
								                    tips: 3
								                });
								            },500);
								        }
								    }) ;       }
						    }) ;


							//登录日志——按条件查询
							var $ = layui.$, active = {
								reload : function() {
									var startDate = $('#login_log_startDate');
									var endDate = $('#login_log_endDate');
									table.reload('test', {
										where : {
											start : startDate.val(),
											end : endDate.val()
										}
									});
								}
							};

							$('#search').on('click', function() {
								var type = $(this).data('type');
								active[type] ? active[type].call(this) : '';
							});

						});
	</script>

	<script>
		function loginType(obj){
			if(obj==0){
				return "浏览器登录"
			}
			if(obj==1){
				return "手机登录"
			}
		
		}
		
		function loginStatus(obj){
			if(obj==0){
				return "登录"
			}
			if(obj==1){
				return "退出"
			}
			
		}
	</script>
</body>
</html>