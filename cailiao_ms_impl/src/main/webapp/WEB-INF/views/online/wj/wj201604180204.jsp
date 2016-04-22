<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <base href="<%=basePath%>"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>后台管理系统</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- CORE CSS-->
    <link rel="stylesheet" href="assets/bootstrap/bootstrap.min.css">
</head>

<body>
    <h1>hello</h1>
    <!-- CORE js -->
    <script type="text/javascript" src="assets/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="assets/bootstrap/bootstrap.min.js"></script>
</body>
</html>