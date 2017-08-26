package cn.appsys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import cn.appsys.pojo.AppInfo;

public interface AppInfoMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(AppInfo record);

	int insertSelective(AppInfo record);

	AppInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(AppInfo record);

	int updateByPrimaryKey(AppInfo record);

	@Select("select * from app_info")
	List<AppInfo> getAppList();

	// ��ȡappinfo�б�
	List<AppInfo> getAppInfoList(Map<String, Object> map);

	// ��ȡappinfo����������
	int getAppInfoCount(Map<String, Object> map);

	// ͨ��APK���Ʋ���appInfo
	AppInfo getAppInfoByAPK(Map<String, Object> map);

	// ɾ��
	int delAppInfoById(Map<String, Object> map);

	// AppInfo getAppInfoById(Map<String, Object> map);
}