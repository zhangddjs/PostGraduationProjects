<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>创新实验室管理系统</title>
	<style type="text/css">
	body{ 
		padding:0;
		font:12px "宋体";}
	.infor{
		width:1060px;
		margin:0px;
		padding:0px;
		margin-bottom:30px; 
		overflow:scroll;
		border-left:3px solid orange;
		border-right:3px solid orange;}
	.inforlist{
		line-height:1200px;
		position:relative; 
		float:left; 
		width:180px; 
		height:600px;
		border-right:2px solid #95C9E1;}
	.inforlist ul{
		margin:10px;
		padding:10px;
		list-style:none; 
		position:absolute; 
		top:10px; 
		right:0px; 
		margin-left:50px; 
		height:200px;
		text-align:center;}
	.inforlist li{
		display:block;
		cursor:pointer;
		width:150px;
		color:#949694;
		font-size:20px;
		margin-bottom:5px;
		height:35px;
		line-height:25px; 
		background-color:#E4F2FD}
	.inforlist li.hover{
		padding:0px;
		background:#fff;
		width:116px;
		border:1px solid #95C9E1; 
		border-right:0;
		color:#739242;
		height:35px;
		line-height:25px;}
	.infordiv{
		margin-top:0px; 
		border-top:none;
		padding:20px; 
		border-left:0; 
		margin-left:130px;}
	.div1{
		float:left;
		width:11%;
		border:5px hidden black; }
	.div2{
		float:right;
		width:88%;}
	.div3{
		width:82%;}
	.font1{
		font-size:30px;
		font-family:幼圆；}
	h1{
		font-size:50px;
		color: #fafafa;
		letter-spacing: 0;
		text-shadow: 0px 1px 0px #999, 0px 2px 0px #888, 0px 3px 0px #777, 0px 4px 0px #666, 0px 5px 0px #555, 0px 6px 0px #444, 0px 7px 0px #333, 0px 8px 7px #001135}
	hr{
		height:10px;
		border:none;
		border-top:10px groove skyblue;}
	</style>
	<script>
	function setTab(name,cursel,n)
	{
 		for(i=1;i<=n;i++)
 		{
  			var menu=document.getElementById(name+i);
  			var mokuai=document.getElementById(name+"_"+i);
  			menu.className=i==cursel?"hover":"";
  			mokuai.style.display=i==cursel?"block":"none";
 		}
	}
	</script>  
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-0" data-genuitec-path="/web/WebRoot/First.jsp">
    <div class="div1" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-0" data-genuitec-path="/web/WebRoot/First.jsp">管理员用户，请<a href="Login.jsp">登录</a></div>
    <div class="div2">新用户，请<a href="Register.jsp">注册</a></div>
    <center>
    	<div class="div3">
    		<h1>欢迎！创新实验室</h1><hr>  		
    	</div>
    	<div class="infor">
			<div class="inforlist">
				<ul>
   				<li id="mo1" onclick="setTab('mo',1,5)" class="hover">实验室模块</li>
   				<li id="mo2" onclick="setTab('mo',2,5)">实验项目模块</li>
   				<li id="mo3" onclick="setTab('mo',3,5)">实验人员模块</li>
   				<li id="mo4" onclick="setTab('mo',4,5)">站长特效四号</li>
   				<li id="mo5" onclick="setTab('mo',5,5)">站长特效五号</li>
				</ul>
			</div>
 			<div class="infordiv">
   				<div id="mo_1"><%@include file="project.jsp"%></div>
   				<div id="mo_2" style="display:none">这里是二号选项卡内容</div>
   				<div id="mo_3" style="display:none"><%@include file="member.jsp"%></div>
  				<div id="mo_4" style="display:none">这里是四号选项卡内容</div>
   				<div id="mo_5" style="display:none">这里是五号选项卡内容</div>
 			</div>
		</div>
    </center>
  </body>
</html>
