<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>

<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>

<html lang="en-US">
<head>
    <base href="<%=basePath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="GENES">
    <meta name="author" content="WHUT">
    <!-- <link rel="shortcut icon" href="assets/favicon.ico" type="image/x-icon" /> -->
    <title>GENES</title>
    <!-- Bootstrap core CSS -->
    <link href="assets/bootstrap/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="assets/custom/login/login.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <form class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputUserId" class="sr-only">User Id</label>
        <input type="text" name="id" id="inputUserId" class="form-control first" placeholder="User Id" tabindex="1">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" tabindex="2">
        <label for="inputPassword" class="sr-only">Captcha</label>
        <div class="captcha-wrapper">
            <input type="text" name="captcha" id="captcha" class="form-control last" placeholder="Captcha" tabindex="3">
            <a>
                <img src="checkcode.html" id="checkcodeImg">
            </a>
        </div>
        <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in" id="btnSignIn" tabindex="4" />
        <div class="bg-danger hidden">
            <p class="username-tooltip hidden">请输入用户名</p>
            <p class="password-tooltip hidden">请输入密码</p>
        </div>
    </form>
</div>

<script type="text/javascript" src="assets/jquery/jquery.min.js"></script>

<script type="text/javascript" src="assets/crypto/core-min.js"></script>
<script type="text/javascript" src="assets/crypto/md5-min.js"></script>

<!-- <script type="text/javascript" src="assets/fingerprint/fingerprint.js"></script> -->

<script type="text/javascript" src="assets/custom/login/login_page.js"></script>

</body>
</html>