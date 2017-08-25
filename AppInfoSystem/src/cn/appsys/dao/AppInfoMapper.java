package cn.appsys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import cn.appsys.pojo.AppInfo;

public interface AppInfoMapper {
	int deleteByPrimaryKey(Long id);

	int insert(AppInfo record);

	int insertSelective(AppInfo record);

	AppInfo selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(AppInfo record);

	int updateByPrimaryKey(AppInfo record);

	@Select("select * from app_info")
	List<AppInfo> getAppList();

	// 获取appinfo列表
	List<AppInfo> getAppInfoList(Map<String, Object> map);

	// 获取appinfo的数据总数
	int getAppInfoCount(Map<String, Object> map);

	// 通过APK名称查找appInfo
	AppInfo getAppInfo(Map<String, Object> map);

	// 删除
	int delAppInfoById(Map<String, Object> map);
}