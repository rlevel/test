<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<%
	String path = request.getContextPath();
	session.setAttribute("path", path);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>首页</title>

<!-- Bootstrap -->
<link href="${path }/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="${path }/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="${path }/vendors/nprogress/nprogress.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="${path }/build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- page content -->
			<div class="col-md-12">
				<div class="col-middle">
					<div class="text-center text-center">
					<br><br><br><br><br>
						<h1 class="error-number"> APP</h1>
						<p>
						<h3>信息管理平台</h3>
							<!-- Full authentication is required to access this resource. <a
								href="#">Report this?</a> -->
						</p>
						<div class="mid_center">
							<p></p>
							<p>
							<!-- Full authentication is required to access this resource. <a
								href="#">Report this?</a> -->
						</p>
							<button class="btn btn-default" type="submit" onclick="window.location='begin/backend'">后台管理系统入口</button>
							<button class="btn btn-default" type="submit" onclick="window.location='begin/developer'">开发者平台入口</button>
						</div>
					</div>
				</div>
			</div>
			<!-- /page content -->
		</div>
	</div>

	<!-- jQuery -->
	<script src="../vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="../vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="../vendors/nprogress/nprogress.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="../build/js/custom.min.js"></script>

</body>
</html>