package cn.appsys.service.backend;

import cn.appsys.tools.ResultData;

public interface BacUserService {
	// 根据devcode查询用户
	public ResultData selectDevUserByCode(String devcode, String devpassword);
}
