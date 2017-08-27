package cn.appsys.service.developer;

import cn.appsys.tools.ResultData;

public interface DevUserService {
	// 根据devcode查询用户
	public ResultData selectDevUserByCode(String devCode, String devpassword);
}
