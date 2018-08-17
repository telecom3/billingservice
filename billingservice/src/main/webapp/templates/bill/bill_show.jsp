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
        	var str="<tr><td>业务账号</td><td>"+jsonData.osName+"</td></tr>"+
        	"<tr><td>服务器地址</td><td>"+jsonData.ipAddress+"</td></tr>"+
        	"<tr><td>登出时间</td><td></td>"+jsonData.createTime+"</tr>"+
        	"<tr><td>登入时间</td><td></td>"+jsonData.updateTime+"</tr>"
        	+"<tr><td>支付状态</td><td></td>"+jsonData.businessState+"</tr>"
        	
        	$("#tbody").html(str);
        },
        error:function(){
        	alert("错误")
        }
    
    })
    
    </script>
    
</html>