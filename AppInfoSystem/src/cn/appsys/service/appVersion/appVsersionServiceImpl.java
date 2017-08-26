package cn.appsys.service.appVersion;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.AppVersionMapper;
import cn.appsys.pojo.AppVersion;
import cn.appsys.tools.ResultData;

@Service
public class appVsersionServiceImpl implements appVersionService {
	@Autowired
	private AppVersionMapper appVersionMapper;

	@Override
	public ResultData getAppVersionList(Map<String, Object> map) {
		ResultData rd = new ResultData();
		List<AppVersion> ver = appVersionMapper.getAppVersionList(map);
		rd.setData(ver);
		return rd;
	}

	@Override
	public ResultData appsysadd(AppVersion appVersion) {
		ResultData rd = new ResultData();
		int len = appVersionMapper.insertSelective(appVersion);
		if (len > 0) {
			rd.setFlag(0);
			rd.setMsg("新增版本信息成功");
		} else {
			rd.setFlag(1);
			rd.setMsg("新增版本信息失败");
		}
		return rd;
	}

	@Override
	public ResultData getAppVersionById(Map<String, Object> map) {
		ResultData rd = new ResultData();
		AppVersion ver = appVersionMapper.getAppVersionById(map);
		rd.setData(ver);
		return rd;
	}

	@Override
	public boolean deleteApkFile(Integer id) {
		AppVersion appVersion = appVersionMapper.selectByPrimaryKey(id);
		if (appVersion != null) {
			appVersion.setApkFileName(null);
			appVersion.setApkLocPath(null);
			return false;
		}
		return true;
	}

	@Override
	public ResultData updateAppVersion(AppVersion appVersion) {
		ResultData rd = new ResultData();
		int len = appVersionMapper.updateByPrimaryKeySelective(appVersion);
		if (len > 0) {
			rd.setFlag(0);
			rd.setMsg("更新成功");
		} else {
			rd.setFlag(1);
			rd.setMsg("更新失败");
		}
		return rd;
	}
}
