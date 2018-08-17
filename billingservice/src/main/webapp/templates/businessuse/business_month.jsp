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

</head>

<body onload="initialYearAndMonth();">

<!--Logo区域结束-->
<jsp:include page="../nav/nav.jsp" flush="true"></jsp:include>





<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="" method="">
        <!--查询-->
        <div class="layui-col-md12">

            <div class="active">
                用户名: &nbsp;&nbsp;
                <div class="layui-inline">
                    <input class="layui-input" name="username" id="nameReload" autocomplete="off">
                </div>

                账务账号:
                <div class="layui-inline">
                    <input class="layui-input" name="account" id="accountReload" autocomplete="off">
                </div>

                身份证:&nbsp;&nbsp;
                <div class="layui-inline">
                    <input class="layui-input" name="idcard" id="idcardReload" autocomplete="off">
                </div>

                <button class="layui-btn so" data-type="reload" id="so">搜索</button>
                <div><input type="button" value="返回" class="layui-btn" onclick="location.href='bill_list.jsp'" /></div>
            </div>
        </div>
        
        
            
      
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">

            </table>
        </div>
        <!--分页-->
        <div id="pages">
            <a href="#">上一页</a>
            <a href="#" class="current_page">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">下一页</a>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[源自全宇宙最帅组的技术，最优秀的小哥哥，最真实的企业环境，最适用的实战项目]</span>
    <br />
    <span>版权所有(C)全宇宙最帅组集团公司 </span>
</div>
</body>
<script>
    layui.use('table', function() {
        var table = layui.table;


        table.render({
            elem: '#datalist'
            , width: 900
            , height: 400
            , url: '/billingservice/business/month'
            , page: true //开启分页
            , limit: 5
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'businessName', title: 'os账号', width: 160, sort: true,templet: '#bunsinessName'}
                , {field: 'username', title: '账务账号', width: 160, sort: true, templet: '#username'}
                , {field: 'osTime', title: '时长', width: 80, sort: true, templet: '#osTime'}
                , {field: 'osCost', title: '费用', width: 160, sort: true, templet: '#osCost'}
                , {field: 'businessMonrth', title: '月', width: 120, sort: true,templet:"#businessMonrth"}
                , {field: 'businesssYear', title: '年', width: 120, sort: true,templet:"#businessYear"}
                , {field: 'triffName', title: '资费', width: 120, sort: true,templet:"#triffName"}
               // , {fixed: 'triffName', width: 150, align: 'center', toolbar: '#barDemo'}

            ]]
        })


        //监听工具条
        table.on('tool(demo)', function(obj) {
            var data = obj.data;
            if (obj.event === 'show1') {
                // /accountmag/delete?id="+JSON.stringify(data.id);
                var index1 = layui.layer.open({
                    title : "账单报表",
                    type : 2,
                    content : "echart.jsp?id=" + data.id,//弹出层页面
                    area: ['600px', '600px'],
                    success : function(layero, index){
                        var body = layui.layer.getChildFrame('body', index);
                        setTimeout(function(){
                            layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                                tips: 3
                            });
                        },500)
                    }
                })
            } else if (obj.event === 'show2') {
                var index2 = layui.layer.open({
                    title : "业务报表",
                    type : 2,
                    content : "echart2.jsp?id=" + data.id,//弹出层页面
                    area: ['600px', '600px'],
                    success : function(layero, index){
                        var body = layui.layer.getChildFrame('body', index);
                        setTimeout(function(){
                            layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                                tips: 3
                            });
                        },500)
                    }
                })

            }
        });



        //查询按钮获取查询框的值
        var $ = layui.$, active = {
            reload: function(){
                var reload1 = $('#accountReload');
                var reload2=$('#idcardReload');
                var reload3=$('#nameReload');
                table.reload('idTest', {
                    where: {
                        account:reload1.val(),
                        idcard:reload2.val(),
                        username:reload3.val()
                    }
                });
            }
        };

        $('.layui-btn so').on('click', function() {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });

</script>
</html>
