<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<head>
    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->
    <script src="../../static/js/echarts.js"></script>
    <script src="../../static/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="../../static/layui/css/layui.css">

    <style>
        #h3{
            text-align: left;
            font-size: 30px;
        }
        #main{
            text-align: left;
        }
        #button1{
            margin-left:300px;
            display: inline-block;
        }

    </style>
</head>
        <body>
        <div class="layui-container">
        <div class="layui-col-md12 layui-row"><h3 id="h3">业务图形报表</h3></div>
         <div class="layui-row">

        <div  class="layui-col-md7">
        <div id="main" style="width: 800px;height:500px;" ></div>
        </div>
         </div>
            <div class="layui-row">

                <div class="layui-col-md12 lay">
                    <button class="layui-btn layui-btn-normal" id="button1">返回</button>&nbsp; &nbsp; &nbsp;
                    <button class="layui-btn layui-btn-normal" id="button2">切换业务图形报表</button>
                </div>

            </div>
        </div>
        </body>
<script>
 
    function callbackFn(myChart,jsonURL){
		$.ajax({
    		 url:jsonURL,
	         dataType:"json",
	         success:function(jsonData){
	        	var data=[200, 300, 400, 300, 800,500, 300,400,300,700,600,250]
		         myChart.setOption({
		        	 xAxis: {
		                 type: 'category',
		                 data: ['1', '2', '3', '4', '5', '6', '7','8','9','10','11','12']
		             },
		             yAxis: {
		                 type: 'value'
		             },
		             series:[{
		                 data: data,
		                 type: 'line'
		             },{
		                 data: [221, 300, 200, 300, 600,300, 200,100,300,400,600,650],
		                 type: 'line'
		             },{
		                 data: [400, 500, 600, 300, 600,300, 500,400,700,400,600,850],
		                 type: 'line'
		             }]
			    });
			    // 设置加载等待隐藏
			    myChart.hideLoading();
	         }
         });
	}
    
    function initReport(myChart){
 
		// 显示标题，图例和空的坐标轴
		myChart.setOption({
			tooltip: {
	            trigger: 'item',
	            formatter: "{a} <br/>{b}: {c} ({d}%)"
	        }
	       
		});
      myChart.title = '折線圖';
    }
    
     function createTestReport(showDivId,jsonURL){
 		var myChart = echarts.init(document.getElementById(showDivId));
 		// 初始化report对象
			initReport(myChart);
			myChart.showLoading({text: '正在努力的读取数据中...'  });
 		// 调用后台获取json数据
 		 callbackFn(myChart,jsonURL);
 	}

</script>
	<script type="text/javascript">
   	 $(document).ready(function(){
   	 	var showDivId = 'main';
   	 	var jsonURL = "/billingservice/templates/report/business";
   		createTestReport(showDivId,jsonURL);
       });
   </script>
   </html>
 