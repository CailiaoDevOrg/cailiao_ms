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
    <link rel="stylesheet" href="assets/adminlte/AdminLTE.min.css">

    <link rel="stylesheet" href="assets/datatable/dataTables.bootstrap.min.css">
</head>

<body>
	<div class="box box-primary">
		<div class="box-header">
			<h4>问卷填写历史</h4>
		</div>
		<div class="box-body">
			<table id="wjTable" class="table table-hover table-responsive">
                <thead>
                    <tr>
                        <th>问卷编号</th>
                        <th>修改时间</th>
                        <th>问卷状态</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <input type="hidden" value="${wjtId}" id="wjtId">
		</div>
	</div>

    <!-- CORE js -->
    <script type="text/javascript" src="assets/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="assets/bootstrap/bootstrap.min.js"></script>

    <script type="text/javascript" src="assets/datatable/jquery.dataTables.js"></script>
    <script type="text/javascript" src="assets/datatable/dataTables.bootstrap.min.js"></script>

    <script type="text/javascript" src="assets/custom/util/time.js"></script>
    <script type="text/javascript" src="assets/custom/online/wj/history.js"></script>

</body>
</html>