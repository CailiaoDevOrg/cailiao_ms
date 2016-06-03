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
    <title>调查问卷</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- CORE CSS-->
    <link rel="stylesheet" href="assets/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="assets/adminlte/AdminLTE.min.css">
    <link rel="stylesheet" type="text/css" href="assets/custom/online/wj/wj_write.css">
</head>

<body>
    <div class="row">
        <div class="col-md-12">
            <div class="header_title box">
                <div>
                    <h2 class="online_wj_title">2015年水泥企业信息调研表</h2>
                </div>
            </div>
            <form role="form">
                <div class="box-body">
                    <div class="form-group">
                        <input type="button" class="btn btn-primary btn-sm btn-flat" id="showHistoryList" value="查看填写历史及状态">
                        <input type="button" class="btn btn-primary btn-sm btn-flat" id="submit" value="保存">
                        <input type="button" class="btn btn-danger btn-sm btn-flat" id="commit" value="提交">
                        <span style="color:red;padding-left:10px;">(其中<span class="redtag">*</span> 为必填项)</span>
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
    <script type="text/javascript" src="assets/custom/online/wj/wj_create.js"></script>
</body>
</html>