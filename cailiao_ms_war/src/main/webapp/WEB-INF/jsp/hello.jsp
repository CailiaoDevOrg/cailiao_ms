<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <title>hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- global css -->
    <link type="text/css" rel="stylesheet" href="assets/materialize/css/materialize.min.css" media="screen,projection" />
    <style type="text/css">
        header, main, footer {
            padding-left: 240px;
        }
        ul.side-nav.fixed li a {
            font-size: 13px;
            line-height: 44px;
            height: 44px;
        }
        .side-nav.fixed a {
		    display: block;
		    padding: 0 15px;
		    color: #444;
        }
        .side-nav .collapsible-header {
            background-color: transparent;
		    border: none;
		    line-height: inherit;
		    height: inherit;
		    margin: 0 1rem;
		}
		.bold>a {
            font-weight: bold;
        }
    </style>
</head>
<body>
	<header>
		<nav class="top-nav">
			<div class="container">
				<div class="nav-wrapper">
					<a class="page-title" style="font-size: 34px">问卷管理</a>
				</div>
			</div>
		</nav>
		<ul id="nav-mobile" class="side-nav fixed collapsible collapsible-accordion" style="width: 240px;">
			<li class="bold">
				<a href="about.html" class="waves-effect waves-teal">About</a>
			</li>
			<li class="bold">
				<a href="getting-started.html" class="waves-effect waves-teal">Getting Started</a>
			</li>
				<li class="bold no-padding">
					<a class="collapsible-header waves-effect waves-teal">CSS</a>
					<div class="collapsible-body" style="">
						<ul>
							<li><a href="color.html">Color</a></li>
							<li><a href="grid.html">Grid</a></li>
							<li><a href="helpers.html">Helpers</a></li>
						</ul>
					</div>
				</li>
				<li class="bold no-padding">
					<a class="collapsible-header waves-effect waves-teal">Components</a>
					<div class="collapsible-body" style="display: block;">
						<ul>
							<li><a href="badges.html">Badges</a></li>
							<li><a href="buttons.html">Buttons</a></li>
							<li><a href="breadcrumbs.html">Breadcrumbs</a></li>
						</ul>
					</div>
				</li>
		</ul>
	</header>

	<main>
		<div class="container">
			<div class="row">
				<p class="caption">
				    Forms are the standard way to receive user
					inputted data. The transitions and smoothness of these elements are
					very important because of the inherent user interaction associated
					with forms.
				</p>
				<h2 class="header" style="color: #ee6e73; font-weight: 300;">Input fields</h2>
				<p style="-webkit-font-smoothing: antialiased;">Text fields allow user input. The border should light up simply and clearly indicating which field the user is currently editing. You must have a <code class=" language-markup">.input-field</code> div wrapping your input and label. This helps our jQuery animate the label. This is only used in our Input and Textarea form elements.</p>
				<form class="col s12">
					<div class="row">
						<div class="input-field col s6">
							<input placeholder="Placeholder" id="first_name" type="text"
								class="validate"> <label for="first_name">First
								Name</label>
						</div>
						<div class="input-field col s6">
							<input id="last_name" type="text" class="validate"> <label
								for="last_name">Last Name</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="password" type="password" class="validate"> <label
								for="password">Password</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="email" type="email" class="validate"> <label
								for="email">Email</label>
						</div>
					</div>
				</form>
			</div>
		</div>
	</main>

	<footer class="page-footer" style="background-color: #9E9E9E">
		<div class="container">
			<div class="row">
				<div class="col l6 s12">
					<h5 class="white-text">我国水泥工业环境状况调查信息平台管理系统</h5>
					<p class="grey-text text-lighten-4">
						本系统为我国水泥工业环境状况调查信息平台的正常运营提供服务与支持，系统在使用中遇到任何错误与不便之处，欢迎给我们留言，祝您使用愉快.
					</p>
				</div>
				<div class="col l4 offset-l2 s12">
					<h5 class="white-text">关于我们</h5>
					<ul>
						<li><a class="grey-text text-lighten-3" href="#!">网站简介</a></li>
						<li><a class="grey-text text-lighten-3" href="#!">联系我们</a></li>
						<li><a class="grey-text text-lighten-3" href="#!">致谢</a></li>
						<li><a class="grey-text text-lighten-3" href="https://github.com/CailiaoDevOrg">Join us</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="footer-copyright">
			<div class="container">
				武汉理工大学版权所有 © 2016 Copyright 
				<a class="grey-text text-lighten-4 right" href="http://www.whut.edu.cn/2015web/index.htm">武汉理工大学</a>
			</div>
		</div>
	</footer>

	<!-- global js file, Import jQuery before materialize.js-->
	<script type="text/javascript" src="assets/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="assets/materialize/js/materialize.min.js"></script>
</body>

</html>


