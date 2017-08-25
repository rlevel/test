package cn.appsys.service.appInfo;

import java.util.Map;

import cn.appsys.pojo.AppInfo;
import cn.appsys.tools.ResultData;

public interface AppInfoService {
	// ���ݾŸ���������ѯapp��Ϣ
	public ResultData getAppInfoList(Map<String, Object> map);

	// ���ݾŸ���������ѯapp����
	public ResultData getAppInfoCount(Map<String, Object> map);

	// test��ѯ�����б�
	public ResultData getAppList();

	// ���info������Ϣ
	public ResultData addAppList(AppInfo appInfos);

	// ͨ��APK���Ʋ���appInfo
	public ResultData getAppInfo(Map<String, Object> map);

	// ͨ��id����appinfo
	public ResultData getAppInfoById(Long id);

	// �������
	public ResultData modify(AppInfo appInfo);

	// ���
	public boolean deleteAppLogo(Long id);

	// ɾ��
	public boolean appsysdeleteAppById(Map<String, Object> map);

	// �ϼ��¼�
	public boolean appsysUpdataSaleStatusByAppId(AppInfo appInfo);

}