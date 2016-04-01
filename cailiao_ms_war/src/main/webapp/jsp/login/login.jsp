<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<meta charset="utf-8">
<!-- CORE CSS-->
<link href="assets/materialize/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection">
<link href="assets/materialize/css/style.css" type="text/css" rel="stylesheet" media="screen,projection">
<link href="assets/materialize/css/perfect-scrollbar.css" type="text/css" rel="stylesheet" media="screen,projection">
<link href="assets/materialize/css/page-center.css" type="text/css" rel="stylesheet" media="screen,projection">
</head>
<body class="cyan loaded">
	<div id="login-page" class="row">
		<div class="col s12 z-depth-4 card-panel">
			<form class="login-form">
				<div class="row">
					<div class="input-field col s12 center">
						<img
							src="assets/materialize/img/login-logo.png"
							alt="" class="circle responsive-img valign profile-image-login">
						<p class="center login-form-text">水泥工业环境状况调查后台管理系统</p>
					</div>
				</div>
				<div class="row margin">
					<div class="input-field col s12">
						<i class="mdi-social-person-outline prefix"></i> <input
							id="username" type="text"> <label for="username"
							class="center-align">Username</label>
					</div>
				</div>
				<div class="row margin">
					<div class="input-field col s12">
						<i class="mdi-action-lock-outline prefix"></i> <input
							id="password" type="password"> <label for="password"
							class="">Password</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12 m12 l12  login-text">
						<input type="checkbox" id="remember-me"> <label
							for="remember-me">Remember me</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<a
							href="main.html"
							class="btn waves-effect waves-light col s12">Login</a>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6 m6 l6">
						<p class="margin medium-small">
							<a
								href="#">Register
								Now!</a>
						</p>
					</div>
					<div class="input-field col s6 m6 l6">
						<p class="margin right-align medium-small">
							<a
								href="#">Forgot
								password ?</a>
						</p>
					</div>
				</div>

			</form>
		</div>
	</div>
	
	<!-- jQuery Library -->
    <script type="text/javascript" src="assets/jquery/jquery.min.js"></script>    
    <!--materialize js-->
    <script type="text/javascript" src="assets/materialize/js/materialize.js"></script>
    <!--scrollbar-->
    <script type="text/javascript" src="assets/materialize/js/perfect-scrollbar.min.js"></script>
</body>
</html>