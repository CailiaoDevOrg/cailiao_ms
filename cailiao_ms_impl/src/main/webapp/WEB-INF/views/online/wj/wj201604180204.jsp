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
</head>

<body>
    <div class="row">
        <div class="col-md-12">
            <div class="box box-default">
                <div class="box-header with-border">
                    <h4 class="box-title">2015年水泥企业信息调研表</h4>－强烈建议填写时提高临时保存的频率，以免因突发状况导致提交失败
                </div>
            </div>
            <form role="form">
                <div class="box-body">
                    <div class="form-group">
                        <input type="button" class="btn btn-primary btn-xs" id="showHistoryList" value="查看填写历史">
                        <input type="button" class="btn btn-primary btn-xs" id="submit" value="保存">
                        <input type="button" class="btn btn-danger btn-xs" id="commit" value="提交">
                    </div>
                    <jsp:include page="baseinfo.jsp"/>
                    <jsp:include page="zyxh.jsp"/>
                    <jsp:include page="nyxh.jsp"/>
                    <jsp:include page="fqpf.jsp"/>
                    <jsp:include page="zysb.jsp"/>
                </div>
                <input type="hidden" id="wjtId" value="${wjtId}">
            </form>
        </div>
    <label></label>
    <!-- CORE js -->
    <script type="text/javascript" src="assets/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="assets/bootstrap/bootstrap.min.js"></script>

    <script type="text/javascript" src="assets/custom/online/wj/wj.js"></script>
</body>
</html>