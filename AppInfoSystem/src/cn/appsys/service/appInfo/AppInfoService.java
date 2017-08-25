package cn.appsys.service.appInfo;

import java.util.Map;

import cn.appsys.pojo.AppInfo;
import cn.appsys.tools.ResultData;

public interface AppInfoService {
	// 根据九个参数来查询app信息
	public ResultData getAppInfoList(Map<String, Object> map);

	// 根据九个参数来查询app总数
	public ResultData getAppInfoCount(Map<String, Object> map);

	// test查询所有列表
	public ResultData getAppList();

	// 添加info基础信息
	public ResultData addAppList(AppInfo appInfos);

	// 通过APK名称查找appInfo
	public ResultData getAppInfo(Map<String, Object> map);

	// 通过id查找appinfo
	public ResultData getAppInfoById(Long id);

	// 处理更新
	public ResultData modify(AppInfo appInfo);

	// 清除
	public boolean deleteAppLogo(Long id);

	// 删除
	public boolean appsysdeleteAppById(Map<String, Object> map);

	// 上架下架
	public boolean appsysUpdataSaleStatusByAppId(AppInfo appInfo);

}