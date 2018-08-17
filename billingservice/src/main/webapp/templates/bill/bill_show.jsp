<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global_color.css" />
    <link type="text/css" rel="stylesheet" href="../../static/layui/css/layui.css" media="all" />
    <link type="text/css" rel="stylesheet"href="../../static/styles/index1.css">
    <script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../../static/layui/layui.js"></script>
    <script src="../../static/js/index.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<table class="layui-table">
	  <colgroup>
	    <col width="150">
	    <col width="200">
	    <col>
	  </colgroup>
	  <thead>
	    <tr>
	      <th>字段名</th>
	      <th>信息</th>
	
	    </tr> 
	  </thead>
	  <tbody id="tbody">
	    <tr>
	      <td>姓名</td>
	      <td>张三</td>
	    </tr>
	    <tr>
	      <td></td>
	      <td>2016-11-28</td>
	    </tr>
	    <tr>
	      <td>许闲心</td>
	      <td>2016-11-28</td>
	    </tr>
	  </tbody>
	</table>
      
</body>
<%String osName=request.getParameter("osName"); %>
    <script>
     var osName='<%=osName%>'
    $.ajax({
		url:"/billingservice/templates/bill/info?osName="+osName,
        dataType:"json",
        success:function(jsonData){
        	var jsonData = eval (jsonData);
        	console.info(jsonData.createTime)
        	console.info(jsonData)
        	var str="<tr><td>业务账号</td><td>"+jsonData.businessOs+"</td></tr>"+
        	"<tr><td>服务器地址</td><td>"+jsonData.ipAdress+"</td></tr>"+
        	"<tr><td>支付状态</td><td>"+jsonData.businessState+"</td></tr>"+
        	"<tr><td>登出时间</td><td>"+jsonData.createTime+"</td></tr>"+
        	"<tr><td>登入时间</td><td>"+jsonData.updateTime+"</td></tr>"
        
        	
        	$("#tbody").html(str);
        },
        error:function(){
        	alert("错误")
        }
    
    })
    function parseDateTime(dat)
	 {
	var date = new Date(dat.time);
	var Y = date.getFullYear() + '-';
	var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	var D = date.getDate() + '';
	
	return Y+M+D;
	 }
    
    </script>
    
   
    
</html>