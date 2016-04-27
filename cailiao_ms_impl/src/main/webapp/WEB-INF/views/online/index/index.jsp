<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
	<title>我国水泥工业环境状况调查</title>
	<meta name="author" content="智能lab"></meta>
	<meta name="keywords" content="我国水泥工业环境状况调查"></meta>
	<meta name="description" content="我国水泥工业环境状况调查"></meta>
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/bootstrap.min.css">
	<link href="assets/custom/online/index/css/index.css" type="text/css" rel="stylesheet"/>
</head>
<body>
	<a name="gotop"></a>
	<div class="header" style="border: none; background-color: rgb(247, 247, 247); background-image: none;">
		<div class="boxall" style="background-color: rgb(247, 247, 247);">
			<h1 class="logo">
				<a href=""> <img src="assets/custom/online/index/img/logo/logo-whut-lg.png" width="600"
					height="90" />
				</a>
			</h1>
			<div class="tel"></div>
		</div>
		<!--菜单导航-->
		<ul class="nav">
			<div class="topbox">
				<li><a href="#">新闻</a></li>
				<li><a href="#">相关下载</a></li>
				<li><a href="#">项目简介</a></li>
				<li><a href="#">支持</a></li>
				<li><a href="main/home.html">后台管理系统</a></li>
			</div>
		</ul>
		<!--菜单导航结束-->
	</div>
	<!--header End  -->

	<div class="maincontentbox">
		<div class="topbg"></div>
		<!--首页幻灯片new Start-->
		<div class="boxall"	style="background: rgb(61, 61, 61) no-repeat right top">
			<!--主体内容区顶大图呈现开始-->
			<div class="H_banner_imgs" id="ADNAV">
				<a class="active slideimg" href="" target="_blank"
					style="display: block;"> <img src="assets/custom/online/index/img/home/img1.JPG"
					width="620" height="305" />
				</a> <a class="active slideimg" href="" target="_blank"
					style="display: none;"> <img src="assets/custom/online/index/img/home/img2.JPG"
					width="620" height="305" />
				</a> <a class="active slideimg" href="" target="_blank"
					style="display: none;"> <img src="assets/custom/online/index/img/home/img3.JPG"
					width="620" height="305" />
				</a> <a class="active slideimg" href="" target="_blank"
					style="display: none;"> <img src="assets/custom/online/index/img/home/img4.jpg"
					width="620" height="305" />
				</a> <a class="active slideimg" href="" target="_blank"
					style="display: none;"> <img src="assets/custom/online/index/img/home/img5.jpg"
					width="620" height="305" />
				</a>
				<p class="showp">
					<i class="imgindex hover">1</i> 
					<i class="imgindex">2</i> 
					<i class="imgindex">3</i> 
					<i class="imgindex">4</i>
				    <i class="imgindex">5</i>
				</p>
			</div>
			<!--主体内容区顶部大图呈现结束-->
			<!--大图右侧新闻-->
			<div class="newsnn01_wjh">
				<div class="newscenter">
					<!-- <span><a href="" target="_blank">更多</a></span> -->
				</div>
				<div class="newslistbydt">
					<div class="defaultlist"></div>
					<ul class="centerdynomic">
					 	
					</ul>
				</div>
			</div>
		</div>
		<!--插入两个空行begin-->
		<div class="m8"></div>
		<div class="m8"></div>
		<!--插入两个空行end-->

		<div class="row" style="width:960px; margin-left:11px;">
			<!--lmbox开始-->
			<div class="col-md-4">
				<div class="newslist">
					<ul>
						<li style="width:320px;height: 290px; overflow: hidden;">
							<a href=""> <img src="assets/custom/online/index/img/home/e.jpg"
								alt="中国水泥工业环境状况数据库及信息共享平台"width="318px" height="290px" />
						   </a>
						</li>
					</ul>
				</div>
				<div class="kydt">
					<span><a href="" target="_blank">中国水泥工业环境状况数据库及信息共享平台</a></span>
				</div>
			</div>

			<div class="col-md-4">
				<div class="newslist">
					<ul>
						<li style="border: 1px solid #eee;width:320px;height: 290px; overflow: hidden;">
							<img src="assets/custom/online/index/img/home/help.jpg" width="318px"
							height="290px" />
						</li>
					</ul>
				</div>
				<div class="kydt">
					<span><a href="" target="_blank">调查问卷在线平台</a></span>
				</div>
			</div>

			<div class="col-md-4">
				<div class="newslist">
					<ul>
						<li style="width:320px;height: 290px; overflow: hidden;">
							<img src="assets/custom/online/index/img/home/factory.jpg" width="320px"
							height="290px" /></li>
					</ul>
				</div>
				<div class="kydt">
					<span><a href="" target="_blank">项目简介</a></span>
				</div>
			</div>
		</div>


		<!--插入两个空行begin-->
		<div class="m8"></div>
		<div class="m8"></div>
		<!--插入两个空行end-->
		<!--banner-->
		<div class="linkweb">
			<span>友情链接：</span> <a href="http://i.whut.edu.cn/" title="武汉理工大学"
				target="_blank">武汉理工大学</a>
		</div>
		<!--/banner-->
		<!--footer Start-->
	</div>
	<div class="footer">
		<p>
			<img src="assets/custom/online/index/img/logo/logos.png" />
		</p>
		<p>2014-2016 《我国水泥工业环境状况调查》科技基础性工作专题网站</p>
		<p>
			<strong>项目编号：2014FY110900</strong>
		</p>
		<p>
			Copyright <span style="font-family: Arial, Helvetica, sans-serif">©</span><span>WHUT</span>
			All Rights Reserved
		</p>
	</div>
	
	<!--footer End  -->
	<script type="text/javascript" src="assets/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="assets/custom/online/index/js/imgSlide.js"></script>
    <script type="text/javascript" src="assets/custom/util/time.js"></script>
    <script type="text/javascript" src="assets/custom/online/index/js/index.js"></script>
</body>
</html>