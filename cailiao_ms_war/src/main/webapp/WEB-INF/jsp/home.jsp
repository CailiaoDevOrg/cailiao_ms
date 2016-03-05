<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<!-- 开启高速模式渲染页面 -->
<meta name="renderer" content="webkit">
<!-- 项目logo -->
<!-- <link rel="icon" href="../../favicon.ico"> -->
<title>我国水泥工业环境状况调查信息平台后台管理系统</title>
<!-- Bootstrap core CSS -->
<!-- <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet"> -->
<link href="/assets/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="/assets/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="/assets/global/0.0.1-SNAPSHOT/css/dashboard.css" rel="stylesheet">
</head>

<body>
    <jsp:include page="global/header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
		    <jsp:include page="global/sidebar.jsp"></jsp:include>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			    <jsp:include page="questionnaireTemplate/version3/createNew.jsp"></jsp:include>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- 开发时采用非cdn库 -->
	<!-- <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> -->
	<script type="text/javascript" src="/assets/jquery/2.2.0/jquery.min.js"></script>
	<script type="text/javascript" src="/assets/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
</body>
</html>
