package cn.appsys.service.backend;

import cn.appsys.tools.ResultData;

public interface BacUserService {
	// ����devcode��ѯ�û�
	public ResultData selectDevUserByCode(String devcode, String devpassword);
}
