package cn.appsys.service.appInfo;

import java.util.Map;

import cn.appsys.tools.ResultData;

public interface AppInfoService {
	// ���ݾŸ���������ѯapp��Ϣ
	public ResultData getAppInfoList(Map<String, Object> map);

	// ���ݾŸ���������ѯapp����
	public ResultData getAppInfoCount(Map<String, Object> map);

	// test��ѯ�����б�
	public ResultData getAppList();
}
