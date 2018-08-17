<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

    </style>
    <script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
   
</head>
<body>
<!--Logo区域开始-->
<jsp:include page="../nav/nav.jsp" flush="true"></jsp:include>


<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
     <div class="demoTable">
	 角色名称：
			<div class="layui-inline">
				<input class="layui-input" id="roleName" name="roleName">
			</div>
			<button class="layui-btn" data-type="reload" id="find">搜索</button>
			
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
,url: '/billingservice/templates/authoritymag/page' //数据接口
,page: true //开启分页
,limit:5
,limits:[5,10]
,cols: [[ //表头
     {field: 'id', title: 'ID', sort: true, fixed: 'left',  align:'center'}
    ,{field: 'roleName', title: '角色名称',  align:'center'}
    ,{field: 'roleDescribe', title: '角色描述',  align:'center'}
    ,{field: 'roleType', title: '角色类型',  align:'center'}
     ,{field: 'authorityName', templet: function(d){    		 
    		 for (var i=0;i<d.authorityInfos.length;i++)
			 {
				 return d.authorityInfos[i].authorityName
				 console.log(d.authorityInfos[i].authorityName) 
			 }
    	}, title: '权限名称',  align:'center'
     }
     ,{fixed: 'right',title: '操作',width:160,  align:'center', toolbar: '#barDemo'}
]]
//数据转换
,done: function(res, page, count){
	 
	
	   $("[data-field='roleType']").children().each(function(){
		  if($(this).text()=='0'){
			   $(this).text("超级管理员")
		  }
	  })
	   $("[data-field='roleType']").children().each(function(){
		  if($(this).text()=='1'){
			   $(this).text("普通管理员")
		  }
	  })
	   $("[data-field='roleType']").children().each(function(){
		  if($(this).text()=='2'){
			   $(this).text("用户")
		  }
	  })
}
});
//监听工具条
table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
var data = obj.data //获得当前行数据
        ,layEvent = obj.event; //获得 lay-event 对应的值
if(layEvent === 'detail'){
	$.post("/billingservice/templates/authoritymag/findById", "id="+data.id,function(info){
		var index = layui.layer.open({
	        title : "查看用户",
	        type : 2,
	        content : "/billingservice/templates/role/role_find.jsp",//弹出层页面
	        area: ['620px', '550px'],
	        
	        success : function(layero, index){
	            var body = layui.layer.getChildFrame('body', index);
	            body.find("#roleName").val(info.roleName);
	            body.find("#roleDescribe").val(info.roleDescribe);
	            body.find("#roleType").val(info.roleType);
	            for (var i=0;i<info.authorityInfos.length;i++)
				 {
	            	 body.find("#authorityName").val(info.authorityInfos[i].authorityName);
				 }
	            if(info.roleType==0){
	            	console.log(info.roleType)
	            	 body.find("#roleType").val("超级管理员")
	            }else if(info.roleType==1){
	            	 body.find("#roleType").val("普通管理员")
	            }else if(info.roleType==2){
	            	 body.find("#roleType").val("用户")
	            }
	        }
	    });
		
	},"json");
} else if(layEvent === 'del'){
	layer.confirm('真的删除行么', function(index){
		$.ajax({
			url:"/billingservice/templates/authoritymag/del",
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
    	$.post("/billingservice/templates/authoritymag/findById", "id="+data.id,function(info){
    		console.log(data.id);
    	var index = layui.layer.open({
            title : "修改用户",
            type : 2,
            content: "/billingservice/templates/role/role_modi.jsp",//弹出层页面
            area: ['800px', '550px'],
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
               // 取到弹出层里的元素，并把编辑的内容放进去
                body.find("#roleName").val(info.roleName);
	            body.find("#roleDescribe").val(info.roleDescribe);
	            body.find("#roleType").val(info.roleType);
	            body.find("#updateId").val(info.id);
	            for (var i=0;i<info.authorityInfos.length;i++)
				 {
	            	 body.find("#authorityName").val(info.authorityInfos[i].authorityName);
				 }
	            if(info.roleType==0){
	            	console.log(info.roleType)
	            	 body.find("#roleType").val("超级管理员")
	            }else if(info.roleType==1){
	            	 body.find("#roleType").val("普通管理员")
	            }else if(info.roleType==2){
	            	 body.find("#roleType").val("用户")
	            }
            }
        });
    	},"json");
    } 

  });
$('#add').on('click', function(){
	var index = layui.layer.open({
        title : "添加用户",
        type : 2,
        content : "role_add.jsp",//弹出层页面
        area: ['450px', '550px']
    })
	
});

	var $ = layui.$, active = {
							reload : function() {
								var roleName1 = $('#roleName');
								console.log(roleName1.val());
								table.reload('test', {
									page : {
										curr : 1
									},
									where : {
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
