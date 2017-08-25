package cn.appsys.controller.backend;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cn.appsys.service.backend.BacUserService;
import cn.appsys.tools.Contants;
import cn.appsys.tools.ResultData;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("bacuser")
@SessionAttributes({ "suser" })
public class BacUserController {
	@Autowired
	private BacUserService bacUserService;

	// 处理登录
	@RequestMapping(value = "login")
	@ResponseBody
	public String isLogin(String usercode, String userpassword,
			Map<String, Object> map, HttpSession session) {
		ResultData rd = new ResultData();
		rd = bacUserService.selectDevUserByCode(usercode, userpassword);
		if (rd.getFlag() == 0) {
			map.put("suser", rd.getData());
		}
		String json = JSON.toJSONString(rd);
		session.setAttribute(Contants.USER_SESSION, rd.getData());
		// System.out.println(json);
		return json;
	}

	// 跳转到首页
	@RequestMapping(value = "devIndex")
	public String jumpIndex() {
		return "backend/main";
	}

	// 处理注销,返回系统登录页
	@RequestMapping("logOut")
	public String logOut(HttpSession session, SessionStatus sessionStatus,
			Map<String, Object> map) {
		System.out.println(1);
		session.invalidate();
		sessionStatus.setComplete();
		map.put("flag", 1);
		return "backendlogin";
	}
}
