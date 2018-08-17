<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        #main{
            margin: auto;
        }
       
    </style>
</head>
<body>

  <div class="layui-tab layui-tab-brief" lay-filter="demo">
            <br/><br/>
            <div style="margin-left:60px">
            <table class="layui-hide" id="test" lay-filter="demo"></table>
            </div>
            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
            </script>
</div>
   




</body>
<script>
	var IP ='';
	var accountYear='';
	var accountMonth='';
function child(d){
	IP = d.serviceIp;
	accountYear=d.accountYear;
	accountMonth=d.accountMonth;
    layui.use(['table','laypage'], function(){
    	
        var table = layui.table
        , laypage = layui.laypage;
        //执行一个 table 实例
        
        table.render({
            elem: '#test'
            	   ,height: 300
                   ,width: 630
            ,url: '/billingservice/templates/account/day'
            ,page: true //开启分页
            ,where: {serviceIp:IP,year:accountYear,month:accountMonth}
            ,cols: [[ //表头
                {field: 'userName', title: '账务账号', width:120, sort: true}
                   ,{field: 'osName', title: '业务账号', width:120}
                   ,{field: 'serviceIp', title: '服务器', width:150}
                   ,{field: 'accountMonth', title: '月份', width:120}  
                   ,{field: 'countTime', title: '总时长', width:120}  
                   
            ]]
        });
    });
}
</script>
</body>
</html>
