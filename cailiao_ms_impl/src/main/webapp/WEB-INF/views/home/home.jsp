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
    <title>登录</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <!-- CORE CSS-->
    <link rel="stylesheet" href="assets/bootstrap/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="assets/adminlte/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="assets/adminlte/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="assets/adminlte/AdminLTE.min.css">
    <link rel="stylesheet" href="assets/adminlte/_all-skins.min.css">
    <link rel="stylesheet" href="assets/adminlte/style.css">
    
    <link rel="stylesheet" href="assets/datatable/dataTables.bootstrap.min.css">
    
    <link rel="stylesheet" href="assets/datepicker/datepicker3.css">

</head>

<body class="skin-blue fixed" data-spy="scroll" data-target="#scrollspy">

    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="sidebar.jsp"></jsp:include>
    
    <div class="mainContent">
        <div class="content-wrapper">
            <div class="content-header">
                <h1>主面板<small>快捷访问</small></h1>
            </div>
            
            <div class="content body">
                <p class="lead">您可以通过一下的快捷方式快速访问系统.</p>
                <div class="row">
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="info-box bg-blue">
                            <span class="info-box-icon bg-blue"><i class="fa fa-envelope-o"></i></span>
                            <div class="info-box-content">
                                <span class="info-box-text">未读消息</span>
                                <span class="info-box-number">93,139</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="info-box bg-red">
                            <span class="info-box-icon bg-red"><i class="fa fa-bell-o"></i></span>
                            <div class="info-box-content">
                                <span class="info-box-text">未读通知</span>
                                <span class="info-box-number">139</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="info-box bg-green">
                            <span class="info-box-icon bg-green"><i class="fa fa-users"></i></span>
                            <div class="info-box-content">
                                <span class="info-box-text">用户管理</span>
                                <span class="info-box-number"></span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="info-box bg-blue">
                            <span class="info-box-icon bg-blue"><i class="fa fa-search"></i></span>
                            <div class="info-box-content">
                                <span class="info-box-text">数据查询</span>
                                <span class="info-box-number"></span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="info-box bg-green">
                            <span class="info-box-icon bg-green"><i class="fa fa-bar-chart-o"></i></span>
                            <div class="info-box-green">
                                <span class="info-box-text">问卷管理</span>
                                <span class="info-box-number"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- CORE js -->
    <script type="text/javascript" src="assets/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="assets/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/adminlte/app.min.js"></script>
    <script type="text/javascript" src="assets/adminlte/jquery.slimscroll.min.js"></script>
    
    <script type="text/javascript" src="assets/custom/home/sidebar_goto.js"></script>
    
    <script type="text/javascript" src="assets/datatable/jquery.dataTables.js"></script>
    <script type="text/javascript" src="assets/datatable/dataTables.bootstrap.min.js"></script>
    
    <!--<script type="text/javascript" src="/jquery-ui/jquery-ui.min.js"></script>-->
    
    <script type="text/javascript" src="assets/datepicker/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="assets/datepicker/bootstrap-datepicker.zh-CN.js"></script>
    
    <script type="text/javascript" src="assets/custom/util/ajax.js"></script>

</body>
</html>