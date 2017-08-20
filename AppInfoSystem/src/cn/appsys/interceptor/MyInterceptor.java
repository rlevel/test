package cn.appsys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.appsys.pojo.DevUser;

public class MyInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		DevUser user = (DevUser) session.getAttribute("suser");
		if (user != null) {
			return true;
		} else {
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return false;
		}
	}
}
