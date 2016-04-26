<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="assets/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="assets/adminlte/font-awesome.min.css">
    <link rel="stylesheet" href="assets/adminlte/AdminLTE.min.css">
    <link href="assets/custom/login/login.css" rel="stylesheet">
  </head>
  <body class="hold-transition login-page">
    <div class="login-box">
      <div class="login-logo">
        <a href="javascript:void(0);"><b>后台管理系统</b></a>
      </div>
      <div class="login-box-body">
        <p class="login-box-msg">请输入您的用户名和密码</p>
        <form class="form-signin">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="用户名" id="inputUserId">
          </div>
          <div class="form-group">
            <input type="password" class="form-control" placeholder="密码" id="inputPassword">
          </div>
          <div class="form-group captcha-wrapper">
              <input type="text" class="form-control" placeholder="验证码" id="captcha">
              <a><img src="checkcode.html" id="checkcodeImg"></a>
          </div>
          <div class="row">
            <div class="col-xs-8"><a href="register.html" class="text-center">注册新账户</a></div>
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat" id="btnSignIn">登录</button>
            </div>
          </div>
          <div class="bg-danger hidden">
              <p class="username-tooltip hidden">请输入用户名</p>
              <p class="password-tooltip hidden">请输入密码</p>
          </div>
        </form>
      </div>
    </div>

    <script src="assets/jquery/jquery.min.js"></script>
    <script src="assets/bootstrap/bootstrap.min.js"></script>

    <script type="text/javascript" src="assets/crypto/core-min.js"></script>
    <script type="text/javascript" src="assets/crypto/md5-min.js"></script>

    <script type="text/javascript" src="assets/custom/login/login_page.js"></script>

  </body>
</html>
