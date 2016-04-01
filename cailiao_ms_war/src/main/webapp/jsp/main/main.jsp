<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<meta charset="utf-8">
<!-- CORE CSS-->
<link href="assets/materialize/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection">
<link href="assets/materialize/css/style.css" type="text/css" rel="stylesheet" media="screen,projection">
<link href="assets/materialize/css/perfect-scrollbar.css" type="text/css" rel="stylesheet" media="screen,projection">
</head>

<body>
	<jsp:include page="header.jsp" />
	<!-- START MAIN -->
	<div id="main">
		<!-- START WRAPPER -->
		<div class="wrapper">
		    <jsp:include page="sidebar.jsp" />
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	
	<!-- jQuery Library -->
    <script type="text/javascript" src="assets/jquery/jquery.min.js"></script>    
    <!--materialize js-->
    <script type="text/javascript" src="assets/materialize/js/materialize.js"></script>
    <!--scrollbar-->
    <script type="text/javascript" src="assets/materialize/js/perfect-scrollbar.min.js"></script>
</body>
</html>