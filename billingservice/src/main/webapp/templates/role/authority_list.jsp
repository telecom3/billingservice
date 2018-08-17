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
    #main {
		margin: auto;
	}
	.layui-input{
		width: 165px;
	
	}
    </style>
    
    
</head>
<body>
<!--Logo区域开始-->
<jsp:include page="../nav/nav.jsp" flush="true"></jsp:include>


<!--导航区域结束-->

	<!--主要区域开始-->
	<div id="main">
		<div class="demoTable">
			<button class="layui-btn" onclick="add()" >新增</button>
		</div>
		
		<table class="layui-hide" id="table1" lay-filter="demo"></table>
		
	</div>
	
	
<!--主要区域结束-->
<!--主要区域结束-->
<div id="footer">
    <span>[源自全宇宙最帅组的技术，最优秀的小哥哥，最真实的企业环境，最适用的实战项目]</span>
    <br />
    <span>版权所有(C)全宇宙最帅组集团公司 </span>
</div>
</body>


<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>




<script>
	layui.use(
					[ 'table', 'laypage', 'laydate' ],
					function() {
						var table = layui.table, laydate = layui.laydate, laypage = layui.laypage;

						var table = layui.table;
						table.render({
							elem : '#table1',
							width : 950,
							height : 300,
							url : '/billingservice/templates/authority/mainAuthority' //数据接口
							,
							page : true //开启分页
							,
							limit : 5,
							limits : [ 5 ,10],
							cols : [ [ {
								field : 'id',
								title : 'ID',
								sort : true,
								fixed : 'left'
							}, {
								field : 'authorityCode',
								title : '权限编码'
							}, {
								field : 'authorityName',
								title : '权限名称'
							}, {
								field : 'pId',
								title : '父级ID',
							} , {
								fixed : 'right',
								title : '操作',
								align : 'center',
								toolbar : '#barDemo'
							} ] ]

							
						});
					
//监听工具条
table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
var data = obj.data //获得当前行数据
        ,layEvent = obj.event; //获得 lay-event 对应的值
if(layEvent === 'del'){
    layer.confirm('真的删除行么', function(index){
    	$.ajax({
    		url:"/billingservice/templates/authority/deleteAuthority",
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
	$.post("/billingservice/templates/authority/findAuthority", "id="+data.id,function(info){
		var index = layui.layer.open({
	        title : "修改用户",
	        type : 2,
	        content : "/billingservice/templates/role/authority_modi.jsp",//弹出层页面
	        area: ['460px', '450px'],
	        success : function(layero, index){
	            var body = layui.layer.getChildFrame('body', index);
	            body.find("#authorityName").val(info.authorityName);
	            body.find("#authorityCode").val(info.authorityCode);
	            body.find("#pId").val(info.pId);
	            body.find("#id").val(info.id);
	            
	            
	        }
	    });
		
	},"json");	
    layer.msg('编辑操作');
   
}
});

});
	
	function add() {
		
		var index = layui.layer.open({
	        title : "添加权限",
	        type : 2,
	        content : "/billingservice/templates/role/authority_add.jsp",//弹出层页面
	        area: ['460px', '450px']
	    })
	};
	
	
</script>

</html>
