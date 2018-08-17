<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

		<!-- <meta charset="UTF-8" /> -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<script src="js/jquery.min.js"></script>
		<script src="js/Helper.js"></script>
		<script src="js/keyboard.js"></script>
		<script src="js/const.js"></script>
		<script src="js/level.js"></script>
		<script src="js/crackAnimation.js"></script>
		<script src="js/prop.js"></script>
		<script src="js/bullet.js"></script>
		<script src="js/tank.js"></script>
		<script src="js/num.js"></script>
		<script src="js/menu.js"></script>
		<script src="js/map.js"></script>
		<script src="js/Collision.js"></script>
		<script src="js/stage.js"></script>
		<script src="js/main.js"></script>
		<link rel="stylesheet" type="text/css" href="css/default.css" />
		<link rel="stylesheet" href="../../layui/css/layui.css" media="all">
		<link rel="stylesheet" href="../../layui/css/layui.mobile.css" media="all">
		<link type="text/css" rel="stylesheet" href="../../styles/index1.css">
		<link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
		<style type="text/css">
			#canvasDiv canvas{
				position:absolute;
			}
		</style>
		
</head>
<body>

			<h3 style="text-align: center;">操作说明：玩家1：wasd上左下右，space射击；玩家2：方向键，enter射击。n下一关，p上一关。</h3>

<div class="container">


			
			<div class="main clearfix">
			<a href="../../../templates/index.jsp" class="layui-btn">返回主页</a>
			<a href="../snake/snake.jsp" class="layui-btn">贪吃蛇</a>
				<div id="canvasDiv" >
					<canvas id="wallCanvas" ></canvas> 
					<canvas id="tankCanvas" ></canvas>
					<canvas id="grassCanvas" ></canvas>
					<canvas id="overCanvas" ></canvas> 
					<canvas id="stageCanvas" ></canvas>
				</div>
			</div>
			
		</div><!-- /container -->

</body>
</html>