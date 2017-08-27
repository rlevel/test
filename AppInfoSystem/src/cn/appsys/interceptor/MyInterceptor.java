package cn.appsys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;
import cn.appsys.tools.Contants;

public class MyInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		DevUser devuser = ((DevUser) session
				.getAttribute(Contants.DEV_USER_SESSION));
		BackendUser backendUser = ((BackendUser) session
				.getAttribute(Contants.USER_SESSION));
		if (devuser != null || backendUser != null) {
			return true;
		} else {
			response.sendRedirect(request.getContextPath() + "/403.jsp");
			return false;
		}

	}
}
