<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>电信</title>
  
    <link type="text/css" rel="stylesheet" href="../../static/layui/css/layui.css" media="all" />
    <link type="text/css" rel="stylesheet"href="../../static/styles/index1.css">

    <script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../../static/layui/layui.js"></script>
    <script src="../../static/js/index.js"></script>
    <script language="javascript" type="text/javascript">
        //写入下拉框中的年份和月份
        function initialYearAndMonth()
        //写入最近3年
        {
            var yearObj = document.getElementById("selYears");
            var year = (new Date()).getFullYear();
            for (var i = 0; i <= 2; i++) {
                var opObj = new Option(year - i, year - i);
                yearObj.options[i] = opObj;
            }
            //写入 12 月
            var monthObj = document.getElementById("selMonths");
            var opObj = new Option("全部", "全部");
            monthObj.options[0] = opObj;
            for (var i = 1; i <= 12; i++) {
                var opObj = new Option(i, i);
                monthObj.options[i] = opObj;
            }
        }
    </script>
    <style type="">
        #main{
            margin: auto;
        }
        #a{
           margin-left:40%;
           
        }
    </style>
</head>
<body onload="initialYearAndMonth();">
<!--Logo区域开始-->


<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="" method="">
     <img src="../../static/images/77428716BF5966CE7274576C9CE612DA.jpg" alt=""/>
    </form>
    <a href="" id="a"><button class="layui-btn layui-btn-primary .layui-layer-close">确认支付</button></a>
</div>
<!--主要区域结束-->

</body>

</html>
