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
</head>
<body onload="initialYearAndMonth();">
<!--Logo区域开始-->

<!--导航区域开始-->



<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="" method="">
        <!--查询-->
      
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist" lay-filter="demo">

            </table>
        </div>
        <!--分页-->
        
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[源自全宇宙最帅组的技术，最优秀的小哥哥，最真实的企业环境，最适用的实战项目]</span>
    <br />
    <span>版权所有(C)全宇宙最帅组集团公司 </span>
</div>

</body>
<%String userName=request.getParameter("userRealName");%>
<script type="text/html" id="barDemo">
		
      <a  class="layui-btn" lay-event="show">查看业务信息</a>

	</script>
<script>

   var userName='<%=userName%>'
    layui.use('table', function() {
        var table = layui.table;
 
        table.render({
            elem: '#datalist'
            , width: 1300
            , height: 400
            , url: '/billingservice/templates/bill/day?userRealName='+JSON.stringify(userName)
            , page: true //开启分页
            , limit: 10
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'userName', title: '账务账号', width: 120, templet: '#userName'}
                , {field: 'osName', title: '服务器id', width: 120, sort: true, templet: '#osName'}
                , {field: 'osCost', title: '使用时长', width: 120, sort: true, templet: '#osCost'}
                , {field: 'businessDay', title: '日', width: 80, sort: true, templet: '#businessDay'}
                , {field: 'businessMonth', title: '月', width: 60, sort: true,tmplet:'#businessMonth'}
                , {field: 'businessYear', title: '年', width: 100, sort: true,tmplet:'#businessYear'}
                , {field: 'tariffName', title: '资费名字', width: 80, sort: true,tmplet:'#tariffName'}
                , {fixed: 'right', width: 130, align: 'center', toolbar: '#barDemo'}
            ]]
        })

        table.on('tool(demo)', function(obj) {
            var data = obj.data;
            if (obj.event === 'show') {
            	location.href="bill_show.jsp?osName="+data.osName
            }


        var $ = layui.$, active = {
            reload: function(){
                var reload1 = $('#billReload');
                var reload2=$('#idReload');
                var reload3=$('#nameReload');
                var reload4=$('#selYears').text;
                var reload5=$('#selMonths').text;
                table.reload('datalist', {
                    where: {
                        billName:reload1.val(),
                        idcard:reload2.val(),
                        username:reload3.val(),
                        year:reload4.val(),
                        month:reload5.val()
                    }
                });
            }
        };
            
         
    });
        })
</script>
</html>
