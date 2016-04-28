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
    <title>注册</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="assets/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="assets/adminlte/font-awesome.min.css">
    <link rel="stylesheet" href="assets/adminlte/AdminLTE.min.css">
    <link href="assets/custom/login/login.css" rel="stylesheet">
</head>

<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="javascript:void(0);"><b>注册</b></a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">注册新帐号</p>
        <form>
            <div class="form-group">
                <input type="text" class="form-control" id="accountId" placeholder="请输入用户名">
            </div>
            <div class="form-group">
                <select class="form-control" id="factoryId">
                    <option value="-1">课题组用户</option>
                    <option value="1">yyyy水泥厂</option>
                    <option value="2">zzzz水泥厂</option>
                    <option value="3">wwww水泥厂</option>
                </select>
            </div>
            <div class="form-group">
                <input type="email" class="form-control" id="email" placeholder="请输入邮箱">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="password" placeholder="请输入密码">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="repassword" placeholder="请确认密码">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="description" placeholder="请输入描述信息,用于加速管理员审核">
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <a href="login.html" class="text-center">我已有账户</a>
                </div>
                <div class="col-xs-4">
                    <input type="button" class="btn btn-primary btn-block btn-flat" id="register" value="注册">
                </div>
            </div>
        </form>
    </div>
</div>

<script src="assets/jquery/jquery.min.js"></script>
<script src="assets/bootstrap/bootstrap.min.js"></script>

<script type="text/javascript" src="assets/crypto/core-min.js"></script>
<script type="text/javascript" src="assets/crypto/md5-min.js"></script>

<script type="text/javascript" src="assets/custom/login/register.js"></script>

</body>

</html>