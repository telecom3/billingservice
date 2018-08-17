<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>电信</title>
    <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global_color.css" />
    <link rel="stylesheet" href="../../static/layui/css/layui.css" media="all">
    <link type="text/css" rel="stylesheet"href="../../static/styles/index1.css">
    <script src="../../static/layui/layui.js"></script>
    <script src="../../static/js/index.js"></script>
    <script src="../../static/js/jquery-3.3.1.min.js"></script>
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
    <style type="text/css">
        #main{margin: auto}
    </style>
   
    <style type="text/css">
        #main{margin: auto}
    </style>
</head>
<body>

<!--导航区域开始-->
<jsp:include page="../nav/nav.jsp" flush="true"></jsp:include>


<!--导航区域结束-->
<!--主要区域开始-->
<!--主要区域开始-->
<div id="main">
        <!--查询-->
   <div class="demoTable">
  管理员名称：
  <div class="layui-inline">
    <input class="layui-input" id="userName" name="userName"  autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload"  id="find">搜索</button>
  <button id="add" data-method="offset" data-type="auto" class="layui-btn layui-btn-normal" style="float: right;">添加</button>
</div>
	            
            
        <div id="data" style="text-align: center;">
			 <table class="layui-hide" id="test" lay-filter="demo"></table>
                        <script type="text/html" id="barDemo">
                            <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                        </script>               
        </div>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[源自全宇宙最帅组的技术，最优秀的小哥哥，最真实的企业环境，最适用的实战项目]</span>
    <br />
    <span>版权所有(C)全宇宙最帅组集团公司 </span>
</div>
</body>
<script>
layui.use(['table','laypage','laydate','layer'], function(){
	var $ = layui.jquery, layer = layui.layer; 
	var table = layui.table,
    laydate=layui.laydate,
    laypage = layui.laypage;
	
//执行一个 table 实例
table.render({
type: "post"	
,elem: '#test'
,width:950
,height: 332
,url: '/billingservice/templates/administrator/page' //数据接口
,page: true //开启分页
,limit:5
,limits:[5,10]
,cols: [[ //表头
     {field: 'id', title: 'ID', sort: true, fixed: 'left',  align:'center'}
    ,{field: 'userName', title: '管理员名称',  align:'center'}
    ,{field: 'userReallName', title: '管理员账号',  align:'center'}
    ,{field: 'userTelphone', title: '联系电话',  align:'center'}
    ,{field: 'userEmail', title: '邮箱',  align:'center'}
    ,{field: 'roleName',templet:'<div>{{d.roleInfo.roleName}}</div>', title: '角色名称',  align:'center'}
    ,{fixed: 'right',title: '操作',width:160,  align:'center', toolbar: '#barDemo'}
]]

});
//监听工具条
table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
var data = obj.data //获得当前行数据
        ,layEvent = obj.event; //获得 lay-event 对应的值
if(layEvent === 'detail'){
	$.post("/billingservice/templates/administrator/findById", "id="+data.id,function(info){
		var index = layui.layer.open({
	        title : "查看用户",
	        type : 2,
	        content : "/billingservice/templates/admin/admin_find.jsp",//弹出层页面
	        area: ['620px', '550px'],
	        success : function(layero, index){
	            var body = layui.layer.getChildFrame('body', index);
	            body.find("#userName").val(info.userName);
	            body.find("#userReallName").val(info.userReallName);
	            body.find("#userTelphone").val(info.userTelphone);
	            body.find("#userEmail").val(info.userEmail);
	            body.find("#userQQ").val(info.userQQ);
	            body.find("#userState").val(info.userState);
	            body.find("#createTime").val(info.createTime);
	            body.find("#updateTime").val(info.updateTime);
	            body.find("#version").val(info.version);
	            body.find("#roleName").val(info.roleInfo.roleName);
	            console.log(info.roleInfo.roleName)
	            
	        }
	    });
		
	},"json");
} else if(layEvent === 'del'){
	layer.confirm('真的删除行么', function(index){
		$.ajax({
			url:"/billingservice/templates/administrator/del",
    		type:"post",
    		data:{"id":data.id},
    		dataType:'json',
    		success:function(data){
    		}
		})
        obj.del(); //删除对应行（tr）的DOM结构
        layer.close(index);
        //向服务端发送删除指令
      });
    } else if(layEvent === 'edit'){
    	$.post("/billingservice/templates/administrator/findById", "id="+data.id,function(info){
    		console.log(data.id);
    	var index = layui.layer.open({
            title : "修改用户",
            type : 2,
            content: "/billingservice/templates/admin/admin_modi.jsp",//弹出层页面
            area: ['800px', '550px'],
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
               // 取到弹出层里的元素，并把编辑的内容放进去
                body.find("#userName").val(info.userName);
	            body.find("#userReallName").val(info.userReallName);
	            body.find("#userTelphone").val(info.userTelphone);
	            body.find("#userEmail").val(info.userEmail);
	            body.find("#userState").val(info.userState);
	            body.find("#createTime").val(info.createTime);
	            body.find("#updateTime").val(info.updateTime);
	            body.find("#version").val(info.version);
	            body.find("#roleName").val(info.roleInfo.roleName);
	            body.find("#updateId").val(info.id);
            }
        });
    	},"json");
    } 

  });
$('#add').on('click', function(){
	var index = layui.layer.open({
        title : "添加用户",
        type : 2,
        content : "admin_add.jsp",//弹出层页面
        area: ['800px', '500px']
    })
	
});

var $ = layui.$, active = {
		reload : function() {
			var userName1 = $('#userName');
			var roleName1 = $('#roleName');
			console.log( userName1);
			console.log( roleName1);
			table.reload('test',
							{page : {curr : 1},
								where : {
										userName : userName1.val(),
										roleName : roleName1.val()
								}
							});
		}
	};
	$('#find').on('click', function() {
		var type = $(this).data('type');
		active[type] ? active[type].call(this) : '';
	});
});



</script>
</html>
