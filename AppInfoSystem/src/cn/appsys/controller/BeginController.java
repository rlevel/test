package cn.appsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("begin")
public class BeginController {
	@RequestMapping(value = "backend")
	public String getBegin1() {
		// ��ת����̨�����¼ҳ��
		return "backendlogin";
	}

	@RequestMapping(value = "developer")
	public String getBegin2() {
		// ��ת�������ߵ�¼ҳ��
		return "devlogin";
	}

}
