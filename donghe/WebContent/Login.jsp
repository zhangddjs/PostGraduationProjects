<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>登录 - 创新实验室 - Innovation Laboratory</title>
	<link rel="stylesheet" type="text/css" href="css/register-login.css"/> 
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-1" data-genuitec-path="/web/WebRoot/Login.jsp">
	<div id="box" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-1" data-genuitec-path="/web/WebRoot/Login.jsp"></div>
	<div class="cent-box">
		<div class="cent-box-header">
			<img src="img/23.png"></img>
			<h2 class="sub-title">欢迎使用 - Innovation Laboratory</h2>
		</div>
		<div class="cont-main clearfix">
			<div class="index-tab">
				<div class="index-slide-nav">
					<a href="login.jsp" class="active">登录</a>
					<a href="Register.jsp">注册</a>
					<div class="slide-bar"></div>				
				</div>
			</div>
			<div class="login form">
				<div class="group">
					<div class="group-ipt email">
						<input type="text" name="email" id="email" class="ipt" placeholder="输入您的用户名" required>
					</div>
					<div class="group-ipt password">
						<input type="password" name="password" id="password" class="ipt" placeholder="输入您的登录密码" required>
					</div>
				</div>
			</div>
			<div class="button">
				<button type="submit" class="login-btn register-btn" id="button">登录</button>
			</div>
			<div class="remember clearfix">
				<label class="remember-me"><span class="icon"><span class="zt"></span></span><input type="checkbox" name="remember-me" id="remember-me" class="remember-mecheck" checked>记住我</label>
				<label class="forgot-password"><a href="#">忘记密码？</a></label>
			</div>
		</div>
	</div>
	<div class="footer">
		<p>创新实验室-Innovation Laboratory</p>
		<p>Designed By 周润宏 & 吉慧慧 & 张冬冬 & 许力 & 董赫</p>
	</div>
	<script src="js/particles.js" type="text/javascript"></script>
	<script src="js/background.js" type="text/javascript"></script>
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/layer/layer.js" type="text/javascript"></script>
	<script src="js/index.js" type="text/javascript"></script>
	<script>
	$('.imgcode')
	.hover(
		function(){layer.tips("看不清？点击更换",'.verify',{time: 6000,tips: [2, "#3c3c3c"]})},
		function(){layer.closeAll('tips');}
	)
	.click(
		function(){$(this).attr('src','http://zrong.me/home/index/imgcode?id=' + Math.random());}
	);
	$("#remember-me").click
	(
		function()
		{
			var n = document.getElementById("remember-me").checked;
			if(n)
			{
				$(".zt").show();
			}
			else
			{
				$(".zt").hide();
			}
		}
	);
	</script>
</body>
</html>
