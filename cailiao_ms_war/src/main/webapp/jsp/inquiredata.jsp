<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  
%>
<!DOCTYPE html>
<html lang="zh-CN" ng-app="inquireApp">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<meta name="description" content="">
		<meta name="author" content="">
		<!-- 开启高速模式渲染页面 -->
		<meta name="renderer" content="webkit">
		<!-- 项目logo -->
		<!-- <link rel="icon" href="../../favicon.ico"> -->
		<title>我国水泥工业环境状况调查信息共享平台</title>
	 	 <link rel="stylesheet" type="text/css" href="/assets/bootstrap/3.3.5/css/bootstrap.min.css">
	 	 <link rel="stylesheet" type="text/css" href="/assets/bootstrap/3.3.5/css/bootstrap-table.min.css">
	 	 <link rel="stylesheet" type="text/css" href="/assets/bootstrap/3.3.5/css/bootstrap-table.css">
<!-- 	 	 <link href="/assets/home/main.css" rel="stylesheet" media="screen, print"> -->
	 	 <link rel="stylesheet" type="text/css" href="/assets/inquire/css/tab.css">
		  
	 	 <style type="text/css">
	 	 	#content{ width: 80%; margin: 0 auto;}
	 	 	#nav{ height:70px; background-color:#3C6DB3; width: 100%; margin-top: -10px; padding: 0;}
	 	 	ul li{ list-style: none; line-height: 70px; float: left;}
	 	 	.navstyle a{color: #fff; display: inline-block;  font-size: 16px; padding:0 10px; text-decoration: none;width: 100px; text-align: center;}
	 	 	.navstyle a:hover{color: #fff; background: #CCCCFF; text-decoration: none; border-radius: 8px;}
	 	 	.logintest{ margin-top: 20px; margin-right: 30px;}
	 	 	.logintest a:hover{ border-radius: 0; background: none;}
	 	 	.small_input{ width: 80px;}
	 	 </style>
	</head>
	<body ng-controller="inquiredataController">
		<div id="nav" >
			<ul class="navstyle">
			   <li class="active"><a href="/jsp/home.jsp">首页</a></li>
			   <li><a href="/jsp/online.jsp">在线填写</a></li>
			   <li><a href="/jsp/offline.jsp">下载填写</a></li>
			   <li><a href="/jsp/upload.jsp">上传文档</a></li>
			   <li><a href="/jsp/inquiredata.jsp">查询</a></li>
			   <div class="pull-right logintest"><a href="/jsp/login.jsp">登录</a></div>
			</ul>
		</div>
		
		<div id="content">
			<div ng-include="'/jsp/pages/inquire.html'"></div>
		</div>
		<script type="text/javascript" src="/assets/jquery/jquery.min.js"></script>
	  	 <script type="text/javascript" src="/assets/angularjs/angular.min.js"></script>
	    <script type="text/javascript" src="/assets/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="/assets/inquire/js/inquiredataController.js"></script>
	</body>
</html>
