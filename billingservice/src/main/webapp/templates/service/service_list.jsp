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
		 #main {
	margin: auto;
		}
	.layui-input{
			width: 160px;
		}
    .laytable-cell-1-d.userInfo.userReallName{
    	width: 200px;
    }
    
    </style>
</head>
<body>

<!--导航区域开始-->
<jsp:include page="../nav/nav.jsp" flush="true"></jsp:include>

<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
 <div class="demoTable">
			<!--查询-->
			OS账号：
			<div class="layui-inline">
				<input class="layui-input" name="businessOs" id="businessOs"
					/>
			</div>
			服务器IP：
			<div class="layui-inline">
				<input class="layui-input" name="ipAdress" id="ipAdress"
					 />
			</div>
			身份证：
			<div  class="layui-inline">
				<input class="layui-input" name="userID" id="userID"
					/>
			</div>
			状态：
			<div class="layui-inline">
				<select name="businessState" lay-verify="businessState" lay-search="" id="businessState" class="select_search ">
					<option  value="全部">全部</option>
					<option  value="开通">开通</option>
					<option  value="暂停">暂停</option>
					
				</select>
			</div>
			<button class="layui-btn" data-type="reload"  id="find">搜索</button>
			<button class="layui-btn" onclick="add()" >新增</button>
		</div>
		
		<table class="layui-hide" id="table1" lay-filter="demo"></table>
		
		
	</div>

		
	<!--主要区域结束-->
	<div id="footer">
		<span>[源自全宇宙最帅组的技术，最优秀的小哥哥，最真实的企业环境，最适用的实战项目]</span> <br /> <span>版权所有(C)全宇宙最帅组集团公司
		</span>
	</div>
</body>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	<a class="layui-btn layui-btn-xs" lay-event="kai">开通/暂停</a>
</script>
<script>
	layui.use([ 'table', 'laypage', 'laydate' ],
					function() {
						var table = layui.table, laydate = layui.laydate, laypage = layui.laypage;
						var table = layui.table;
						table.render({
							elem : '#table1',
							width : 950,
							height : 300,
							url : '/billingservice/templates/business/mainBusiness' //数据接口
							,
							page : true //开启分页
							,
							limit : 5,
							limits : [ 5 ],
							cols : [ [ {
								field : 'id',
								width : 65,
								title : 'ID',
								sort : true,
								fixed : 'left'
							},{
								field : 'businessOs',
								width : 110,
								title : '业务账号',
							}, {
								field : 'ipAdress',
								width : 100,
								title : '服务器IP'
							}, {
								field : 'businessState',
								width : 80,
								title : '状态'
							},{
								field : 'userID',
								templet:'<div >{{d.userInfo?d.userInfo.userID:""}}</div>',
								title : '身份证 ',
								width : 148
							}, {
								field : 'userReallName',
								width : 100,
								title : '姓名',
								templet:'<div>{{d.userInfo?d.userInfo.userReallName:""}}</div>'
							},  {
								field : 'tariffName',
								width : 110,
								title : '资费',
								templet:'<div>{{d.tariffInfo?d.tariffInfo.tariffName:""}}</div>'
							}, {
								fixed : 'right',
								title : '操作',
								width : 225,
								align : 'center',
								toolbar : '#barDemo'
							} ] ]
							,
							done : function(res, page, count) {
								$("[data-field='businessState']").children().each(
										function() {
											if ($(this).text() == '1') {
												$(this).text("开通")
											} else if ($(this).text() == '0') {
												$(this).text("暂停")
											}
										})
							}
						});
					
	//监听工具条
table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
var data = obj.data //获得当前行数据
        ,layEvent = obj.event; //获得 lay-event 对应的值
if(layEvent === 'detail'){
	$.post("/billingservice/templates/business/find", "id="+data.id,function(info){
		var index = layui.layer.open({
	        title : "查看业务账号",
	        type : 2,
	        content : "/billingservice/templates/service/service_detail.jsp",//弹出层页面
	        area: ['620px', '750px'],
	        success : function(layero, index){
	            var body = layui.layer.getChildFrame('body', index);
	            body.find("#updateUserName").val(info.userInfo.userName);
	            body.find("#updatebusinessOs").val(info.businessOs);
	            body.find("#updateuserReallName").val(info.userInfo.userReallName);
	            body.find("#updateuserID").val(info.userInfo.userID);
	            body.find("#updateuserGender").val(info.userInfo.userGender);
	            body.find("#updatebusinessOsPwd").val(info.businessOsPwd);
	            body.find("#updatebusinessState").val(info.businessState);
	            body.find("#updatetariffName").val(info.tariffInfo.tariffName);
	            body.find("#updatecostDescrible").val(info.tariffInfo.costDescrible);
	            body.find("#updatecreateTime").val(info.createTime);
	            body.find("#updateupdateTime").val(info.updateTime);
	           
	            if(info.userInfo.userGender==0){
	            	body.find("#updateuserGender").val("男");
	    		}else{
	    			body.find("#updateuserGender").val("女");
	    		}
	            if(info.businessState==0){
	            	body.find("#updatebusinessState").val("暂停");
	    		}else{
	    			body.find("#updatebusinessState").val("开通");
	    		}
	            
	        }
	    });
		
	},"json");
} else if(layEvent === 'del'){
    layer.confirm('确定删除该账号吗', function(index){
    	$.ajax({
    		url:"/billingservice/templates/business/delete",
    		type:"post",
    		data:{"id":data.id},
    		dataType:'json',
    		success:function(data){
    			$(".layui-laypage-btn").click() 
    			layer.msg('删除成功');
    		}
    		
    	})
    });
} else if(layEvent === 'edit'){
	$.post("/billingservice/templates/business/find", "id="+data.id,function(info){
		var index = layui.layer.open({
	        title : "修改用户",
	        type : 2,
	        content : "/billingservice/templates/service/service_modi.jsp",//弹出层页面
	        area: ['550px', '680px'],
	        success : function(layero, index){
	            var body = layui.layer.getChildFrame('body', index);
	            body.find("#updateUserName").val(info.userInfo.userName);
	            body.find("#updatebusinessOs").val(info.businessOs);
	            body.find("#updateuserReallName").val(info.userInfo.userReallName);
	            body.find("#updateuserID").val(info.userInfo.userID);
	            body.find("#updateuserGender").val(info.userInfo.userGender);
	            body.find("#updatebusinessOsPwd").val(info.businessOsPwd);
	            body.find("#updatebusinessState").val(info.businessState);
	            body.find("#updatetariffName").val(info.tariffInfo.tariffName);
	            body.find("#updatecostDescrible").val(info.tariffInfo.costDescrible);
	            body.find("#updatecreateTime").val(info.createTime);
	            body.find("#updateupdateTime").val(info.updateTime);
	            body.find("#updateid").val(info.id);
	            if(info.userInfo.userGender==0){
	            	body.find("#updateuserGender").val("男");
	    		}else{
	    			body.find("#updateuserGender").val("女");
	    		}
	            if(info.businessState==0){
	            	body.find("#updatebusinessState").val("暂停");
	    		}else{
	    			body.find("#updatebusinessState").val("开通");
	    		}
	            
	        }
	    });
		
	},"json");	
    layer.msg('编辑操作');
   
}else if(layEvent === 'kai'){
	if(data.businessState==1){
		layer.confirm('确定暂停该账号吗', function(index){
	    	$.ajax({
	    		url:"/billingservice/templates/business/suspend",
	    		type:"post",
	    		data:{"id":data.id},
	    		dataType:'json',
	    		success:function(data){
	    			$(".layui-laypage-btn").click() 
	    			layer.msg('暂停成功');
	    		}
	    		
	    	})
	    });
	}else{
	    	$.ajax({
	    		url:"/billingservice/templates/business/open",
	    		type:"post",
	    		data:{"id":data.id},
	    		dataType:'json',
	    		success:function(data){
	    			$(".layui-laypage-btn").click() 
	    			layer.msg('开通成功');
	    		}
	    		
	    	})
	}
	
}
});
var $ = layui.$, active = {
		reload : function() {
			var userID1 = $('#userID');
			var businessOs1 = $('#businessOs');
			var ipAdress1 = $('#ipAdress');
			var businessState1 = $('#businessState');
			console.log( userID1);
			table.reload('table1',
							{page : {curr : 1},
								where : {
										userID : userID1.val(),
										businessOs : businessOs1.val(),
										ipAdress : ipAdress1.val(),
										businessState : businessState1.val()
								}
							});
		}
	};
	$('#find').on('click', function() {
		var type = $(this).data('type');
		active[type] ? active[type].call(this) : '';
	});
});
	
	function add() {
		
		var index = layui.layer.open({
	        title : "添加业务帐号",
	        type : 2,
	        content : "/billingservice/templates/service/service_add.jsp",//弹出层页面
	        area: ['480px', '580px']
	    })
	}
	
	
	
</script>
<script>
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
</script>
</html>
