package cn.appsys.service.appVersion;

import java.util.Map;

import cn.appsys.pojo.AppVersion;
import cn.appsys.tools.ResultData;

public interface appVersionService {
	// 新增版本信息
	public ResultData getAppVersionList(Map<String, Object> map);

	public ResultData appsysadd(AppVersion appVersion);

	public ResultData getAppVersionById(Map<String, Object> map);

	public boolean deleteApkFile(Long id);

	public ResultData updateAppVersion(AppVersion appVersion);

}
