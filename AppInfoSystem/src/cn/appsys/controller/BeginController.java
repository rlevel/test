package cn.appsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("begin")
public class BeginController {
	@RequestMapping(value = "backend")
	public String getBegin1() {
		// 跳转到后台管理登录页面
		return "backendlogin";
	}

	@RequestMapping(value = "developer")
	public String getBegin2() {
		// 跳转到开发者登录页面
		return "devlogin";
	}

}
