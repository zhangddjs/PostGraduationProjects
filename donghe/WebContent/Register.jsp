<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>注册 - 创新实验室 - Innovation Laboratory</title>
	<link rel="stylesheet" type="text/css" href="css/register-login.css"/> 
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-2" data-genuitec-path="/web/WebRoot/Register.jsp">
	<div id="box" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-2" data-genuitec-path="/web/WebRoot/Register.jsp"></div>
		<div class="cent-box register-box">
			<div class="cent-box-header">
				<img src="img/23.png"></img>
				<h2 class="sub-title">科学热爱实践 - Innovation Laboratory</h2>
			</div>
			<div class="cont-main clearfix">
				<div class="index-tab">
					<div class="index-slide-nav">
						<a href="Login.jsp">登录</a>
						<a href="Register.jsp" class="active">注册</a>
						<div class="slide-bar slide-bar1"></div>				
					</div>
				</div>
				<div class="login form">
					<div class="group">
						<div class="group-ipt email">
							<input type="email" name="email" id="email" class="ipt" placeholder="用户名" required>
						</div>
						<div class="group-ipt user">
							<input type="text" name="user" id="user" class="ipt" placeholder="输入你的昵称" required>
						</div>
						<div class="group-ipt password">
							<input type="password" name="password" id="password" class="ipt" placeholder="设置登录密码" required>
						</div>
						<div class="group-ipt password1">
							<input type="password" name="password1" id="password1" class="ipt" placeholder="重复输入密码" required>
						</div>
						
					</div>
				</div>
				<div class="button">
					<button type="submit" class="login-btn register-btn" id="button">注册</button>
				</div>
			</div>
		</div>
		<div class="footer">
			<p>创新实验室-Innovation Laboratory</p>
			<p>Designed By 周润宏 & 吉慧慧 & 张冬冬 & 许力 & 董赫</p>
		</div>
		<script src='js/particles.js' type="text/javascript"></script>
		<script src='js/background.js' type="text/javascript"></script>
		<script src='js/jquery.min.js' type="text/javascript"></script>
		<script src='js/layer/layer.js' type="text/javascript"></script>
		<script src='js/index.js' type="text/javascript"></script>
		<script>
			$('.imgcode').hover(function(){
		layer.tips("看不清？点击更换", '.verify', {
        		time: 6000,
        		tips: [2, "#3c3c3c"]
    		})
	},function(){
		layer.closeAll('tips');
	}).click(function(){
		$(this).attr('src','http://zrong.me/home/index/imgcode?id=' + Math.random());
	})

	$(".login-btn").click(function(){
		var email = $("#email").val();
		var password = $("#password").val();
		var verify = $("#verify").val();
		$.ajax({
		url: 'http://www.zrong.me/home/index/userLogin',
		type: 'post',
		jsonp: 'jsonpcallback',
		jsonpCallback: "flightHandler",
		async: false,
		data: {
		'email':email,
		'password':password,
		'verify':verify
		},
		success: function(data){
		info = data.status;
		layer.msg(info);
		}
		})

	})
	$("#remember-me").click(function(){
		var n = document.getElementById("remember-me").checked;
		if(n){
			$(".zt").show();
		}else{
			$(".zt").hide();
		}
	})
</script>
</body>
</html>