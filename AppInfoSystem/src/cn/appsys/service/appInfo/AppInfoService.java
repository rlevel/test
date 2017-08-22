package cn.appsys.service.appInfo;

import java.util.Map;

import cn.appsys.tools.ResultData;

public interface AppInfoService {
	// 根据九个参数来查询app信息
	public ResultData getAppInfoList(Map<String, Object> map);

	// 根据九个参数来查询app总数
	public ResultData getAppInfoCount(Map<String, Object> map);

	// test查询所有列表
	public ResultData getAppList();
}
