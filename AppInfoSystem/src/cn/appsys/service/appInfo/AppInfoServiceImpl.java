package cn.appsys.service.appInfo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.AppInfoMapper;
import cn.appsys.pojo.AppInfo;
import cn.appsys.tools.ResultData;

@Service
public class AppInfoServiceImpl implements AppInfoService {
	@Autowired
	private AppInfoMapper appInfoMapper;

	@Override
	public ResultData getAppInfoList(Map<String, Object> map) {
		ResultData rd = new ResultData();
		List<AppInfo> appInfos = appInfoMapper.getAppInfoList(map);
		rd.setData(appInfos);
		return rd;
	}

	@Override
	public ResultData getAppInfoCount(Map<String, Object> map) {
		ResultData rd = new ResultData();
		int count = appInfoMapper.getAppInfoCount(map);
		rd.setData(count);
		return rd;
	}

	@Override
	public ResultData getAppList() {
		ResultData rd = new ResultData();
		List<AppInfo> apps = appInfoMapper.getAppList();
		return rd;
	}

	@Override
	public ResultData addAppList(AppInfo appInfos) {
		ResultData rd = new ResultData();
		int len = appInfoMapper.insertSelective(appInfos);
		if (len > 0) {
			rd.setFlag(0);
			rd.setMsg("添加成功");
		} else {
			rd.setFlag(1);
			rd.setMsg("添加失败");
		}
		return rd;
	}

	@Override
	public ResultData getAppInfo(Integer id, String APKName) {
		ResultData rd = new ResultData();
		AppInfo app = appInfoMapper.getAppInfo(id, APKName);
		rd.setData(app);
		return rd;
	}

}
