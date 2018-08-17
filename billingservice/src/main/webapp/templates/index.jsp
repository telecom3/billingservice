<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>电信</title>
        <link type="text/css" rel="stylesheet" media="all" href="../static/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../static/styles/global_color.css" />

        <link rel="stylesheet" type="text/css"href="../static/styles/index1.css"/>
        <!--  <script src="../static/js/index.js"></script> -->
         <style>
      		#a{
      		font-family:FangSong,"Times New Roman",Serif; 
      		}
			body {
			 font-family:	KaiTi,"Times New Roman",Serif; 
			}
			h1, h2, h3, h4, h5, h6 {
				font-family: Georgia, serif;
			}
			h1{
				font-size:330%;
				text-shadow:2px 2px 1px white;
			}
			p {
				line-height: 140%;
				font-size: 90%;
			}
			#accordion {
				margin: 100px;
			}
			#accordion article {
				-webkit-transform: perspective(900px) rotateY(60deg);
				-webkit-transition: all 0.7s ease-in-out;
				background: #fff;
				border: 1px solid #f3f3f3;
				box-shadow: 0px 5px 15px gray;
				float: left;
				height: 420px;
				margin-left: -180px;
				padding: 20px;
				width: 220px;
			}
			#accordion article:first-child {
				margin-left: 0px;
			}
			#accordion article img {
				float: left;
				padding: 0 10px 5px 0;
			}
			#accordion article:hover {
				-webkit-transform: perspective(0) rotateY(-10deg);
				margin: 0 140px 0 -60px;
			}
		</style>
    </head>
    <body>
    <!--<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">-->
    <jsp:include page="nav.jsp" flush="true"></jsp:include>
    
    <div id="accordion">
			<article id="a">
				<h2>今日优惠套餐</h2>
				<img src="../static/images/抖音.jpg" width="240" height="110">
				<p>
					抖音无限流量卡
				</p>
				<p>
					流量不用不花钱，套餐费5/元每月
				</p>
				<p>
					全国流量按天计算1元1G，2元不限量，全月30G达量就会降速成3G网络
					当月每天登录抖音，次月每天1元不限流量；当月如果未能每天登录（当月N天登录），则次月N天1元不限流量，剩余天数 1元1G/天、2元不限流量/天。
					当月成功邀请至少一位朋友办理并激活抖音卡，次月全月流量免费不限量（2018年12月31日前）。
					激活后首次充值50元送50元（前往微信公众号“抖卡助手”办理）。
				</p>
			</article>
			<article id="a">
				<h2>世界上另外一个我</h2>
				<img src="../static/images/孪生.jpg" width="230" height="110">
				<p>
					四川号码子孪生号功能上线
				</p>
				<p>
					快来找你的孪生兄弟吧
				</p>
			</article>
			<article id="a">
				<h2>天翼99元套餐</h2>
				<img src="../static/images/天翼.jpg" width="230" height="150">
				<p>
					默认开通4G功能，全国接听免费（国内通话和接听免费范围，不包括港澳台），赠送来电显示
				</p>
				<p>
					国内流量：当月国内手机上网流量达到该档位对应的套餐降速阈值后，上网速率降至1Mbps，次月恢复
				</p>
			</article>
			<article id="a">
				<h2>9元随心卡套餐</h2>
				<img src="../static/images/9元卡.jpg" width="230" height="150">
				<p>
					月基本费9元，300M国内流量，全国接听免费，赠送来电显示、189邮箱
				</p>
				<p>
					手机上网流量仅限制中国大陆境内使用，不分4G,3G,2G,不含WLAN（WI-FI）上网
					套餐外流量按照25元/GB（不足250MB实际用量0.1元/MB收费，达到25元）
				</p>
			</article>
			<article id="a">
				<h2>全新大牛卡</h2>
				<img src="../static/images/大牛卡.jpg" width="230" height="230">
				<p>
					新用户办理立即生效，开通后可享受3个月免费体验，第4个月开始收费。如：7月15日开通，则7月、8月、9月免套餐费，10月开始支付49元/月的套餐费。在体验期内（激活当月+次月+次次月），可享受全国流量不限量（5G限速），20条短信，100分钟国内语音；体验期过后，可享受全国流量不限量（10G限速），100分钟国内语音。
				</p>
				<!-- <p>
					手机上网流量仅限制中国大陆境内使用，不分4G,3G,2G,不含WLAN（WI-FI）上网
					套餐外流量按照25元/GB（不足250MB实际用量0.1元/MB收费，达到25元）
				</p> -->
			</article>
			<article id="a">
				<h2>e99全国不限量</h2>
				<img src="../static/images/E99.jpg" width="230" height="230">
				<p>
					①下单过程中若未新办号卡，下单成功后，不限量特权将在次月生效；(部分套餐因规则限制存在立即生效，若您在升级过程中未加卡，建议升级成功后咨询当地营业厅或10000号不限量是否当月生效。）

					②下单过程中若有新办号卡，下单成功后，不限量特权将在新办号卡激活次月生效，请在收到号卡后10天内激活号卡，号卡激活后才能使用并计费，逾期未激活将自动销户。
				</p>
				
			</article>
			<article id="a">
				<h2>全家不限量</h2>
				<img src="../static/images/全家不限量.jpg" width="230" height="230">
				<p>
					升级至e169不限流量套餐，若原ITV是直播版会升级为尊享版，受理当月按天收费（0.7元/天），次月首部ITV免费。
				</p>
				<p>
					套餐所有手机成员全国上网流量月累计达到40GB后，所有手机成员上网速率最高1Mbps，次月恢复正常速率。降速是指降低手机上网速率，并不是关闭4G功能。
				</p>
			</article>
			<article id="a">
				<h2>号码不变流量不限</h2>
				<img src="../static/images/号码.jpg" width="230" height="230">
				<p>
					遵循国际通用流量规则，在体验期内（激活当月+次月+次次月），套餐所有手机上网流量当月累计使用达到5G后，所有手机上网速率最高1Mbps，次月恢复正常速率；在体验期后（第4个月及以后），套餐所有手机上网流量当月累计使用达到10G后，所有手机上网速率最高1Mbps，次月恢复正常速率。
				</p>
				
			</article>
		</div>

	
    </body>
</html>
