package cn.appsys.service.appInfo;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.AppInfoMapper;
import cn.appsys.dao.AppVersionMapper;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.tools.ResultData;

@Service
public class AppInfoServiceImpl implements AppInfoService {
	private static final Exception Exception = null;
	@Autowired
	private AppInfoMapper appInfoMapper;
	@Autowired
	private AppVersionMapper appVersionMapper;

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
	public ResultData getAppInfo(Map<String, Object> map) {
		ResultData rd = new ResultData();
		AppInfo app = appInfoMapper.getAppInfoByAPK(map);
		if (app != null) {
			rd.setFlag(1);
			rd.setData(app);
		} else {
			rd.setFlag(2);
		}
		return rd;
	}

	@Override
	public ResultData getAppInfoById(Integer id) {
		ResultData rd = new ResultData();
		AppInfo apps = appInfoMapper.selectByPrimaryKey(id);
		rd.setData(apps);
		return rd;
	}

	@Override
	public ResultData modify(AppInfo appInfo) {
		ResultData rd = new ResultData();
		int len = appInfoMapper.updateByPrimaryKeySelective(appInfo);
		if (len > 0) {
			rd.setFlag(0);
			rd.setMsg("更新成功");
		} else {
			rd.setFlag(1);
			rd.setMsg("更新失败");
		}
		return rd;
	}

	@Override
	public boolean deleteAppLogo(Integer id) {
		AppInfo appInfo = appInfoMapper.selectByPrimaryKey(id);
		if (appInfo != null) {
			appInfo.setLogoLocPath(null);
			appInfo.setLogoPicPath(null);
			return false;
		}
		return true;
	}

	@Override
	public boolean appsysdeleteAppById(Map<String, Object> map) {
		boolean flag = false;
		int versionCount = appVersionMapper.getVersionCountByAppId(map);
		List<AppVersion> appVersionList = null;
		if (versionCount > 0) {
			// 先删除版本信息
			appVersionList = appVersionMapper.getAppVersionList(map);
			for (AppVersion appVersion : appVersionList) {
				if (appVersion.getApkLocPath() != null
						&& !("").equals(appVersion.getApkLocPath())) {
					File file = new File(appVersion.getApkLocPath());
					if (file.exists()) {
						if (!file.delete()) {
							try {
								throw new Exception();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}

			}
			appVersionMapper.delVersionByAppId(map);

		}
		// 删除APP基础信息
		// 删除上传的图片
		AppInfo appInfo = appInfoMapper.getAppInfoByAPK(map);
		if (appInfo.getLogoLocPath() != null
				&& !("").equals(appInfo.getLogoLocPath())) {
			File file = new File(appInfo.getLogoLocPath());
			if (file.exists()) {
				if (!file.delete()) {
					try {
						throw new Exception();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
		// 删除app_info表中的数据
		if (appInfoMapper.delAppInfoById(map) > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean appsysUpdataSaleStatusByAppId(AppInfo appInfoObj) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", appInfoObj.getId());
		AppInfo appInfo = appInfoMapper.getAppInfoByAPK(map);
		System.out.println(appInfo);
		Integer operator = appInfoObj.getModifyBy();
		if (operator < 0 || appInfoObj.getId() < 0) {
			try {
				throw Exception;
			} catch (java.lang.Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (null == appInfo) {
			return false;
		} else {
			switch (appInfo.getStatus().intValue()) {
			case 2:// 审核通过,可以上架
				onSale(appInfo, operator, 4, 2);
				break;
			case 5:// 已下架,可以上架
				onSale(appInfo, operator, 4, 2);
				break;
			case 4:// 已上架,进行下架
				offSale(appInfo, operator, 5);
				break;
			default:
				return false;
			}
		}
		return false;
	}

	/**
	 * on Sale
	 * 
	 * @param appInfo
	 * @param operator
	 * @param appInfStatus
	 * @param versionStatus
	 */
	private void onSale(AppInfo appInfo, Integer operator,
			Integer appInfStatus, Integer versionStatus) {
		offSale(appInfo, operator, appInfStatus);
		setSaleSwitchToAppVersion(appInfo, operator, versionStatus);
	}

	/**
	 * offSale
	 * 
	 * @param appInfo
	 * @param operator
	 * @param appInfStatus
	 * @return
	 */
	private boolean offSale(AppInfo appInfo, Integer operator,
			Integer appInfStatus) {
		AppInfo _appInfo = new AppInfo();
		_appInfo.setId(appInfo.getId());
		_appInfo.setStatus(appInfStatus);
		_appInfo.setModifyBy(operator);
		_appInfo.setOffSaleDate(new Date(System.currentTimeMillis()));
		appInfoMapper.updateByPrimaryKeySelective(_appInfo);
		return true;
	}

	/**
	 * set sale method to on or off
	 * 
	 * @param appInfo
	 * @param operator
	 * @param saleStatus
	 * @return
	 */
	private boolean setSaleSwitchToAppVersion(AppInfo appInfo,
			Integer operator, Integer saleStatus) {
		AppVersion appVersion = new AppVersion();
		appVersion.setId(appInfo.getVersionId());
		appVersion.setPublishStatus(saleStatus);
		appVersion.setModifyBy(operator);
		appVersion.setModifyDate(new Date(System.currentTimeMillis()));
		appVersionMapper.updateByPrimaryKeySelective(appVersion);
		return false;
	}

	// @Override
	// public ResultData getAppById(Map<String, Object> map) {
	// ResultData rd = new ResultData();
	// AppInfo apps = appInfoMapper.getAppInfoById(map);
	// rd.setData(apps);
	// return rd;
	//
	// }
}
