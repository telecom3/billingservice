<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

    <link rel="stylesheet" href="../../static/layui/css/layui.css" media="all">

    <script src="../../static/layui/layui.js"></script>
</head>
<body>
    
    <button type="button" class="layui-btn layui-btn-primary" id="test4"><i class="layui-icon"></i>只允许上传表格文件</button>
    
</body>
<script type="text/javascript">

layui.use(['form', 'upload'], function(){  //如果只加载一个模块，可以不填数组。如：layui.use('form')
	  var form = layui.form //获取form模块
	  ,upload = layui.upload; //获取upload模块
	  
	  upload.render({ //允许上传的文件后缀
		    elem: '#test4'
		    ,url: '/billingservice/templates/account/file'
		    ,accept: 'file' //普通文件
		    ,exts: 'xlsx' //只允许上传表格文件
		    ,done: function(res){
		      console.log(res)
		    }
		  });
});

</script>
</html>