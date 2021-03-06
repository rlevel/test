<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<%
	String path = request.getContextPath();
	session.setAttribute("path", path);
%>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>APP开发者平台</title>

    <!-- Bootstrap -->
    <link href="${path}/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${path}/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${path}/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="${path}/vendors/animate.css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${path}/build/css/custom.min.css" rel="stylesheet">
    
    <script type="text/javascript" src="${path}/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".isLogin").on("click",function(){
			var devCode = $("#devCode").val();
			var password = $("#devpassword").val();
			$.getJSON("../devuser/login",{"devCode":devCode,"devpassword":password},function(data){
				if(data!=null){
					if(data.flag==0){
						window.location.href="../devuser/devIndex";
					}else{
						$("#loginNameSpan").css("color","red").html(data.msg);
					}
				}
			})
		})
	})
</script>
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form action="../devuser/login"  name="actionForm" id="actionForm"  method="post" >
              <h1>APP开发者平台</h1>
              <div>
                <input type="text" id="devCode" name="devCode" class="form-control" placeholder="请输入用户名" required="" /><span id="loginNameSpan"></span>
              </div>
              <div>
                <input type="password" id="devpassword" name="devpassword" class="form-control" placeholder="请输入密码" required="" />
              </div>
              <div>
                <%-- <a class="btn btn-default submit isLogin" href="${path}/user/login">登录</a> --%>
                <input type="button"   value="登录系统" class="input-button isLogin" />
                <input type="reset"  value="重　　填" class="btn btn-default submit" />
                <!-- <a class="reset_pass" href="#">Lost your password?</a> -->
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">New to site?
                  <a href="#signup" class="to_register"> Create Account </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Gentelella Alela!</h1>
                  <p>©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p>
                </div>
              </div>
            </form>
          </section>
        </div>

        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form>
              <h1>Create Account</h1>
              <div>
                <input type="text" class="form-control" placeholder="Username" required="" />
              </div>
              <div>
                <input type="email" class="form-control" placeholder="Email" required="" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="Password" required="" />
              </div>
              <div>
                <a class="btn btn-default submit" href="index.html">Submit</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">Already a member ?
                  <a href="#signin" class="to_register"> Log in </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Gentelella Alela!</h1>
                  <p>©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
    </div>
  </body>
</html>
