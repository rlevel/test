package cn.appsys.service.developer;

import cn.appsys.tools.ResultData;

public interface DevUserService {
	// ����devcode��ѯ�û�
	public ResultData selectDevUserByCode(String devCode, String devpassword);
}
