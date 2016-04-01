<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  
%>
<!DOCTYPE html>
<!-- saved from url=(0041)http://www.js-css.cn/divcss/login/login5/ -->
<html>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta charset="utf-8">
<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<style type="text/css">
#login {
	width: 450px;
	margin-top: 150px;
	margin-left: auto;
	margin-right: auto;
	padding: 20px 15px;
	border: 1px solid #ccc;
	border-radius: 10px;
	background: #fff;
}

.reg-slogan {
	text-align: center;
	background: #ddd;
	margin-bottom: 10px;
	line-height: 50px;
	border-radius: 10px;
	height: 50px;
}

.reg-slogan h1 {
	margin: auto;
	line-height: 50px;
}
</style>
</head>
<body style="background: #0072C6">
	<div class="wrap">
		<form class="form-horizontal" id="login" name="login"
			ng-controller="loginController" novalidate>
			<div class="reg-slogan">
				<h1>登录</h1>
			</div>
			<div class="form-group">
				<label for="user" class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-10">
					<input type="text" name="user" class="form-control" ng-model="user"
						placeholder="填写注册邮箱账户" required> <span style="color: red"
						ng-show="login.user.$dirty && login.user.$invalid"> <span
						ng-show="login.user.$error.required">用户名是必须的。</span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label for="passwd" class="col-sm-2 control-label">密 码</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" name="passwd"
						ng-model="password" placeholder="输入密码" required> <span
						style="color: red"
						ng-show="login.passwd.$dirty && login.passwd.$invalid"> <span
						ng-show="login.passwd.$error.required">密码是必须的。</span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label> <input type="checkbox"> 记住密码
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" name="submit" class="btn btn-success"
						value="登 录" ng-click="Login()"
						ng-disabled="login.user.$dirty && login.user.$invalid ||login.passwd.$dirty && login.passwd.$invalid">
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="assets/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="assets/angularjs/angular.min.js"></script>
	<script type="text/javascript"
		src="assets/bootstrap/js/bootstrap.min.js"></script>
	<!-- <script type="text/javascript"
		src="assets/login/js/loginController.js"></script> -->
</body>
</html>