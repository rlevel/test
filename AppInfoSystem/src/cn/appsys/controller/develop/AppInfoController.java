package cn.appsys.controller.develop;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.appCategory.AppCategoryService;
import cn.appsys.service.appInfo.AppInfoService;
import cn.appsys.service.appVersion.appVersionService;
import cn.appsys.service.dataDictionary.DataDictionaryService;
import cn.appsys.tools.Contants;
import cn.appsys.tools.Page;
import cn.appsys.tools.ResultData;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("appInfo")
public class AppInfoController {
	private static final String APKName = null;
	@Autowired
	private AppInfoService appInfoService;
	@Autowired
	private DataDictionaryService dataDictionaryService;
	@Autowired
	private AppCategoryService appCategoryService;
	@Autowired
	private appVersionService appVersionService;

	// 跳转到appInfo页面并查出appInfo
	@RequestMapping(value = "appInfoList", produces = {
			"text/html;charset=UTF-8;", "application/json;" })
	public String jumpAppInfoList(
			Model model,
			HttpSession session,
			Map<String, Object> map,
			@RequestParam(value = "querysoftwareName", required = false) String querysoftwareName,
			@RequestParam(value = "querystatus", required = false) String _querystatus,
			@RequestParam(value = "querycategoryLevel1", required = false) String _querycategoryLevel1,
			@RequestParam(value = "querycategoryLevel2", required = false) String _querycategoryLevel2,
			@RequestParam(value = "querycategoryLevel3", required = false) String _querycategoryLevel3,
			@RequestParam(value = "queryflatformId", required = false) String _queryflatformId,
			@RequestParam(value = "pageIndex", required = false) String pageIndex) {
		// System.out.println("软件名称" + querysoftwareName);
		// System.out.println("app" + _querystatus);
		// System.out.println("一级分类" + _querycategoryLevel1);
		// System.out.println("二级分类" + _querycategoryLevel2);
		// System.out.println("三级分类" + _querycategoryLevel3);
		// System.out.println("平台" + _queryflatformId);
		// System.out.println("点击次数" + pageIndex);
		// 登录保存constants类到session
		Integer devId = ((DevUser) session
				.getAttribute(Contants.DEV_USER_SESSION)).getId();
		// System.out.println(devId);
		// System.out.println("_querycategoryLevel2" + _querycategoryLevel2);
		// System.out.println("_querycategoryLevel3" + _querycategoryLevel3);
		// System.out.println("_queryflatformId" + _queryflatformId);
		// System.out.println(querysoftwareName);
		System.out.println("-----------------------------");
		List<AppInfo> appInfoList = null;
		List<DataDictionary> statusList = null;
		List<DataDictionary> flatFormList = null;
		// 列出一级分类列表,二级三级通过ajax异步获取
		List<AppCategory> categorylevel1List = null;
		List<AppCategory> categorylevel2List = null;
		List<AppCategory> categorylevel3List = null;
		// 页面容量
		int pageSize = Contants.pageSize;
		// System.out.println("每页显示" + pageSize + "条记录");
		// 当前页码
		Page pages = new Page();
		Integer currentPageNo = 1;

		if (pageIndex != null && !"".equals(pageIndex)) {
			currentPageNo = Integer.valueOf(pageIndex);

		}
		// System.out.println("当前页码" + currentPageNo);
		// 每页从第几条开始查询
		int start = 0;
		start = (currentPageNo - 1) * pageSize;
		pages.setStart(start);

		// 类型转换
		Integer querystatus = null;
		if (_querystatus != null && !"".equals(_querystatus)) {
			querystatus = Integer.valueOf(_querystatus);
		}
		Integer querycategoryLevel1 = null;
		if (_querycategoryLevel1 != null && !"".equals(_querycategoryLevel1)) {
			querycategoryLevel1 = Integer.valueOf(_querycategoryLevel1);
		}
		Integer querycategoryLevel2 = null;
		if (_querycategoryLevel2 != null && !"".equals(_querycategoryLevel2)) {
			querycategoryLevel2 = Integer.valueOf(_querycategoryLevel2);
		}
		Integer querycategoryLevel3 = null;
		if (_querycategoryLevel3 != null && !"".equals(_querycategoryLevel3)) {
			querycategoryLevel3 = Integer.valueOf(_querycategoryLevel3);
		}
		Long queryflatformId = null;
		if (_queryflatformId != null && !"".equals(_queryflatformId)) {
			queryflatformId = Long.parseLong(_queryflatformId);
		}
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("softwareName", querysoftwareName);
		maps.put("status", querystatus);
		maps.put("categoryLevel1", querycategoryLevel1);
		maps.put("categoryLevel2", querycategoryLevel2);
		maps.put("categoryLevel3", querycategoryLevel3);
		maps.put("flatformId", queryflatformId);
		maps.put("devId", devId);
		maps.put("from", pages.getStart());
		maps.put("pageSize", pageSize);
		// System.out.println("开始" + pages.getStart());
		ResultData rd = new ResultData();
		rd = appInfoService.getAppInfoList(maps);

		// System.out.println("rd" + rd);
		// 总数量(列表)
		int totalCount = 0;
		totalCount = (Integer) appInfoService.getAppInfoCount(maps).getData();
		// System.out.println(totalCount + "totalCount");
		// 总页码
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);

		int totalPageCount = pages.getTotalPageCount();

		// 首尾页
		if (currentPageNo < 1) {
			currentPageNo = 1;
		} else if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}

		// info列表
		appInfoList = (List<AppInfo>) rd.getData();
		// System.out.println("appInfoList" + appInfoList);
		statusList = this.getDataDictionaryList("APP_STATUS");
		flatFormList = this.getDataDictionaryList("APP_FLATFORM");
		// System.out.println(flatFormList);
		ResultData lev = appCategoryService.getAppCategoriesByParentId(null);
		categorylevel1List = (List<AppCategory>) lev.getData();
		// System.out.println("catego" + categorylevel1List);

		model.addAttribute("appInfoList", appInfoList);
		model.addAttribute("statusList", statusList);
		model.addAttribute("flatFormList", flatFormList);
		model.addAttribute("pages", pages);
		model.addAttribute("querystatus", querystatus);
		model.addAttribute("querysoftwareName", querysoftwareName);
		model.addAttribute("categorylevel1List", categorylevel1List);
		model.addAttribute("categorylevel2List", categorylevel2List);
		model.addAttribute("categorylevel3List", categorylevel3List);
		model.addAttribute("queryflatformId", queryflatformId);

		return "developer/appInfoList";
	}

	public List<DataDictionary> getDataDictionaryList(String typecode) {
		ResultData rd = dataDictionaryService.getDataDictionaryList(typecode);
		List<DataDictionary> dataDictionaries = new ArrayList<DataDictionary>();
		dataDictionaries = (List<DataDictionary>) rd.getData();
		return dataDictionaries;
	}

	/**
	 * 根据parentID查出相应的分类级别列表
	 * 
	 * @param pid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/categoryLevelList.json", method = RequestMethod.GET)
	public String getAppCategoryList(@RequestParam String pid,
			Map<String, Object> map) {
		// System.out.println("传到后台的pid" + pid);
		if (("").equals(pid)) {
			pid = null;
		}
		List<AppCategory> categorylevel2List = new ArrayList<AppCategory>();
		ResultData rd = new ResultData();
		rd = appCategoryService.getAppCategoriesByParentId(pid == null ? null
				: Integer.valueOf(pid));
		if (rd != null) {
			map.put("result", rd);
		}
		// System.out.println(rd);
		return this.getCategoryList(pid);

	}

	public String getCategoryList(String pid) {
		List<AppCategory> categorylevel2List = new ArrayList<AppCategory>();
		ResultData rd = new ResultData();
		rd = appCategoryService.getAppCategoriesByParentId(pid == null ? null
				: Integer.valueOf(pid));
		// JSONArray array = null;
		// array = JSONArray.parseArray("categorieList", categorieList);// 能过去
		String json = JSON.toJSONString(rd);
		// System.out.println(json);
		return json;
	}

	/**
	 * 添加APP基础信息
	 */
	// 跳转到添加页面
	@RequestMapping(value = "addAppInfo", method = RequestMethod.GET)
	public String addAppInfo(@ModelAttribute("appInfo") AppInfo appInfo,
			Map<String, Object> map) {
		// 跳转到添加addAppInfo页面添加基础信息
		AppInfo apps = new AppInfo();
		// 获取所属平台列表
		List<DataDictionary> flatFormList = this
				.getDataDictionaryList("APP_FLATFORM");
		// 三个级别的分类列表,获取一级分类,二三级
		ResultData lev = appCategoryService.getAppCategoriesByParentId(null);
		List<AppCategory> categorylevel1List = (List<AppCategory>) lev
				.getData();
		List<AppCategory> categorylevel2List = null;
		List<AppCategory> categorylevel3List = null;
		map.put("apps", apps);
		map.put("flatFormList", flatFormList);
		map.put("categorylevel1List", categorylevel1List);
		map.put("categorylevel2List", categorylevel2List);
		map.put("categorylevel3List", categorylevel3List);

		return "developer/appinfoadd";
	}

	@RequestMapping("list")
	public String jumplist() {
		// 跳转到appInfo页面
		return "developer/appInfoList";
	}

	@RequestMapping(value = "/apkexist.json", method = RequestMethod.GET)
	@ResponseBody
	public String apkNameIsExit(@RequestParam String APKName,
			Map<String, Object> resultMap) {
		// System.out.println(APKName);
		ResultData rd = new ResultData();
		Map<String, Object> apkn = new HashMap<String, Object>();
		apkn.put("id", null);
		apkn.put("APKName", APKName);
		rd = appInfoService.getAppInfo(apkn);
		// System.out.println(rd);
		String json = JSON.toJSONString(rd);
		return json;
	}

	// 添加
	@RequestMapping(value = "/appinfoaddsave", method = RequestMethod.POST)
	public String addSave(
			AppInfo appInfo,
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "a_logoPicPath", required = false) MultipartFile attach) {
		// System.out.println(1);
		String logoPicPath = null;
		String logoLocPath = null;
		if (!attach.isEmpty()) {
			String path = request.getSession().getServletContext()
					.getRealPath("/statics/images");
			String oldFileName = attach.getOriginalFilename();// 源文件名
			String prefix = FilenameUtils.getExtension(oldFileName);// 原后缀
			int filesize = 500000;
			if (attach.getSize() > filesize) {
				request.setAttribute("fileUploadError",
						Contants.FILEUPPLOAD_ERROR_4);
				return "developer/appinfoadd";
			} else if (prefix.equalsIgnoreCase("jpg")
					|| prefix.equalsIgnoreCase("png")
					|| prefix.equalsIgnoreCase("jepg")
					|| prefix.equalsIgnoreCase("pneg")) {
				String fileName = appInfo.getAPKName() + ".jpg";
				File targerFile = new File(path, fileName);
				if (!targerFile.exists()) {
					targerFile.mkdirs();
				}
				try {
					attach.transferTo(targerFile);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("fileUploadError",
							Contants.FILEUPPLOAD_ERROR_2);
					return "developer/appinfoadd";
				}
				logoPicPath = request.getContextPath() + "/statics/images"
						+ fileName;
				logoLocPath = path + File.separator + fileName;
			} else {
				request.setAttribute("fileUploadError",
						Contants.FILEUPPLOAD_ERROR_3);
				return "developer/appinfoadd";
			}
		}

		appInfo.setCreatedBy(((DevUser) session
				.getAttribute(Contants.DEV_USER_SESSION)).getId());
		appInfo.setCreationDate(new Date());
		appInfo.setLogoPicPath(logoPicPath);
		appInfo.setLogoLocPath(logoLocPath);
		appInfo.setDevId(((DevUser) session
				.getAttribute(Contants.DEV_USER_SESSION)).getId());
		appInfo.setStatus(1);
		ResultData rd = appInfoService.addAppList(appInfo);
		if (rd.getFlag() == 0) {
			return "redirect:/appInfo/appInfoList";
		} else {
			return "developer/appinfoadd";
		}

	}

	// 跳转到更新页面,实现回显
	@RequestMapping(value = "jumpmodify/{id}", method = RequestMethod.GET)
	public String modify(@PathVariable Long id, Model model) {
		// System.out.println("id" + id);
		AppInfo appInfo = null;
		Map<String, Object> infos = new HashMap<String, Object>();
		infos.put("id", id);
		appInfo = (AppInfo) appInfoService.getAppInfo(infos).getData();
		List<DataDictionary> flatFormList = this
				.getDataDictionaryList("APP_FLATFORM");
		// 三个级别的分类列表,获取一级分类,二三级
		ResultData lev = appCategoryService.getAppCategoriesByParentId(null);
		List<AppCategory> categorylevel1List = (List<AppCategory>) lev
				.getData();
		List<AppCategory> categorylevel2List = null;
		List<AppCategory> categorylevel3List = null;

		model.addAttribute(appInfo);
		model.addAttribute("flatFormList", flatFormList);
		model.addAttribute("categorylevel1List", categorylevel1List);
		return "developer/appinfomodify";
	}

	/**
	 * 
	 * @param appInfo
	 * @param session
	 * @param request
	 * @param attach
	 * @return
	 */
	// 处理更新
	@RequestMapping(value = "appinfomodify", method = RequestMethod.POST)
	public String updataappInfo(
			AppInfo appInfo,
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "attach", required = false) MultipartFile attach) {

		// System.out.println(1);
		String logoPicPath = null;
		String logoLocPath = null;
		String APKName = appInfo.getAPKName();
		if (!attach.isEmpty()) {
			String path = request.getSession().getServletContext()
					.getRealPath("/statics/images");
			String oldFileName = attach.getOriginalFilename();// 源文件名
			String prefix = FilenameUtils.getExtension(oldFileName);// 原后缀
			int filesize = 500000;
			if (attach.getSize() > filesize) {
				// request.setAttribute("fileUploadError",
				// Contants.FILEUPPLOAD_ERROR_4);
				return "redirect:/appInfo/jumpmodify/id=" + appInfo.getId()
						+ "&error=error4";
			} else if (prefix.equalsIgnoreCase("jpg")
					|| prefix.equalsIgnoreCase("png")
					|| prefix.equalsIgnoreCase("jepg")
					|| prefix.equalsIgnoreCase("pneg")) {
				String fileName = APKName + ".jpg";
				File targerFile = new File(path, fileName);
				if (!targerFile.exists()) {
					targerFile.mkdirs();
				}
				try {
					attach.transferTo(targerFile);
				} catch (Exception e) {
					e.printStackTrace();
					// request.setAttribute("fileUploadError",
					// Contants.FILEUPPLOAD_ERROR_2);
					return "redirect:/appInfo/jumpmodify/id=" + appInfo.getId()
							+ "&error=error2";
				}
				logoPicPath = request.getContextPath() + "/statics/images"
						+ fileName;
				logoLocPath = path + File.separator + fileName;
			} else {
				// request.setAttribute("fileUploadError",
				// Contants.FILEUPPLOAD_ERROR_3);
				return "redirect:/appInfo/jumpmodify/id=" + appInfo.getId()
						+ "&error=error3";
			}
		}

		appInfo.setModifyBy(((DevUser) session
				.getAttribute(Contants.DEV_USER_SESSION)).getId());
		appInfo.setCreationDate(new Date());
		appInfo.setLogoPicPath(logoPicPath);
		appInfo.setLogoLocPath(logoLocPath);
		// appInfo.setDevId(((DevUser) session
		// .getAttribute(Contants.DEV_USER_SESSION)).getId());
		// appInfo.setStatus(1L);
		ResultData rd = appInfoService.modify(appInfo);
		if (rd.getFlag() == 0) {
			return "redirect:/appInfo/appInfoList";
		} else {
			return "developer/appinfomodify";
		}

	}

	@RequestMapping(value = "del")
	@ResponseBody
	public Object delFile(
			@RequestParam(value = "flag", required = false) String flag,
			@RequestParam(value = "id", required = false) String id) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		Map<String, Object> mid = new HashMap<String, Object>();
		mid.put("id", id);

		String fileLocPath = null;
		if (flag == null || flag.equals("") || id == null || ("").equals(id)) {
			resultMap.put("result", "failed");
		} else if (flag.equals("logo")) {
			AppInfo appinfo = null;
			appinfo = (AppInfo) appInfoService.getAppInfo(mid).getData();
			fileLocPath = appinfo.getLogoLocPath();
			File file = new File(fileLocPath);
			if (file.delete()) {
				if (appInfoService.deleteAppLogo(Integer.parseInt(id))) {
					resultMap.put("result", "success");
				}
			}
		} else if (flag.equals("apk")) {
			AppInfo appinfo = null;
			appinfo = (AppInfo) appInfoService.getAppInfo(mid).getData();
			fileLocPath = appinfo.getLogoLocPath();
			File file = new File(fileLocPath);
			if (file.delete()) {
				if (appVersionService.deleteApkFile(Integer.parseInt(id))) {
					resultMap.put("result", "success");
				}
			}
		}
		return JSONArray.toJSONString(resultMap);

	}

	@RequestMapping(value = "appversionadd", method = RequestMethod.GET)
	public String addVersion(@RequestParam(value = "id") String appId,
			AppVersion appVersion, Model model) {
		// System.out.println("APPID+" + appId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appId", Long.parseLong(appId));
		appVersion.setAppId(Integer.parseInt(appId));
		List<AppVersion> appVersionList = (List<AppVersion>) appVersionService
				.getAppVersionList(map).getData();
		// System.out.println(appVersionList);
		model.addAttribute("appVersionList", appVersionList);
		model.addAttribute(appVersion);
		return "developer/appversionadd";
	}

	/**
	 * 新增版本信息
	 * 
	 * @param appVersion
	 * @param session
	 * @param request
	 * @param attach
	 * @return
	 */
	@RequestMapping(value = "/addversionsave", method = RequestMethod.POST)
	public String addVersionSave(
			AppVersion appVersion,
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "a_downloadLink", required = false) MultipartFile attach) {
		// System.out.println(1);
		String downloadLink = null;
		String apkLocPath = null;
		String apkFileName = null;
		if (!attach.isEmpty()) {
			String path = request.getSession().getServletContext()
					.getRealPath("/statics/images");
			String oldFileName = attach.getOriginalFilename();// 源文件名
			String prefix = FilenameUtils.getExtension(oldFileName);// 原后缀
			int filesize = 500000;
			if (prefix.equalsIgnoreCase("apk")) {
				String apkName = null;
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("verid", appVersion.getAppId());
				apkName = ((AppVersion) appInfoService.getAppInfo(map)
						.getData()).getApkName();
				if (apkName != null || "".equals(apkName)) {
					return "redirect:/appInfo/appversionadd?id="
							+ appVersion.getAppId() + "&error=error1";
				}
				apkFileName = apkName + "-" + appVersion.getVersionNo()
						+ ".apk";
				File targerFile = new File(path, apkFileName);
				if (!targerFile.exists()) {
					targerFile.mkdirs();
				}
				try {
					attach.transferTo(targerFile);
				} catch (Exception e) {
					e.printStackTrace();
					return "redirect:/appInfo/jumpmodify/id="
							+ appVersion.getId() + "&error=error2";
				}
				downloadLink = request.getContextPath() + "/statics/images"
						+ apkFileName;
				apkLocPath = path + File.separator + apkFileName;
			} else {
				return "redirect:/appInfo/jumpmodify/id=" + appVersion.getId()
						+ "&error=error3";
			}
		}
		appVersion.setCreatedBy(((DevUser) session
				.getAttribute(Contants.DEV_USER_SESSION)).getId());
		appVersion.setCreationDate(new Date());
		appVersion.setDownloadLink(downloadLink);
		appVersion.setApkLocPath(apkLocPath);
		appVersion.setApkFileName(apkFileName);
		ResultData rd = appVersionService.appsysadd(appVersion);
		if (rd.getFlag() == 0) {
			return "redirect:/appInfo/appInfoList";
		} else {
			return "developer/appversionadd?id=" + appVersion.getAppId();
		}

	}

	/**
	 * 跳转到更新版本页面
	 * 
	 * @param versionId
	 * @param appId
	 * @param fileUploadError
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/appversionmodify", method = RequestMethod.GET)
	public String modifyAppversion(
			@RequestParam("vid") String versionId,
			@RequestParam("aid") String appId,
			@RequestParam(value = "error", required = false) String fileUploadError,
			Model model) {
		System.out.println("跳转到查看页面");
		AppVersion appVersion = null;
		List<AppVersion> appVersionList = null;

		if (null != fileUploadError && ("error1").equals(fileUploadError)) {
			fileUploadError = Contants.FILEUPPLOAD_ERROR_1;
		} else if (null != fileUploadError
				&& ("error2").equals(fileUploadError)) {
			fileUploadError = Contants.FILEUPPLOAD_ERROR_2;
		} else if (null != fileUploadError
				&& ("error3").equals(fileUploadError)) {
			fileUploadError = Contants.FILEUPPLOAD_ERROR_3;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appId", Long.parseLong(appId));
		map.put("id", Long.parseLong(versionId));
		// appVersion.setappId(Long.parseLong(appId));
		appVersion = (AppVersion) appVersionService.getAppVersionById(map)
				.getData();
		appVersionList = (List<AppVersion>) appVersionService
				.getAppVersionList(map).getData();
		// System.out.println("appVersion" + appVersion);

		model.addAttribute(appVersion);
		model.addAttribute("appVersionList", appVersionList);
		model.addAttribute("fileUploadError", fileUploadError);
		return "developer/appversionmodify";
	}

	/**
	 * 更新版本保存
	 * 
	 * @param appVersion
	 * @param session
	 * @param request
	 * @param attach
	 * @return
	 */
	@RequestMapping(value = "addversionmodifysave", method = RequestMethod.POST)
	public String updataappVersion(
			AppVersion appVersion,
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "attach", required = false) MultipartFile attach) {

		// System.out.println(1);
		String downloadLink = null;
		String apkLocPath = null;
		String apkFileName = null;

		if (!attach.isEmpty()) {
			String path = request.getSession().getServletContext()
					.getRealPath("/statics/images");
			String oldFileName = attach.getOriginalFilename();// 源文件名
			String prefix = FilenameUtils.getExtension(oldFileName);// 原后缀

			if (prefix.equalsIgnoreCase("apk")) {
				String apkName = null;
				// System.out.println(111111111);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("verid", appVersion.getAppId());
				apkName = ((AppVersion) appInfoService.getAppInfo(map)
						.getData()).getApkName();
				if (apkName != null || "".equals(apkName)) {
					return "redirect:/appInfo/appversionadd?id="
							+ appVersion.getAppId() + "&error=error1";
				}
				apkFileName = apkName + "-" + appVersion.getVersionNo()
						+ ".apk";
				File targerFile = new File(path, apkFileName);
				if (!targerFile.exists()) {
					targerFile.mkdirs();
				}
				try {
					attach.transferTo(targerFile);
				} catch (Exception e) {
					e.printStackTrace();
					return "redirect:/appInfo/jumpmodify/id="
							+ appVersion.getId() + "&error=error2";
				}
				downloadLink = request.getContextPath() + "/statics/images"
						+ apkFileName;
				apkLocPath = path + File.separator + apkFileName;
			} else {
				return "redirect:/appInfo/jumpmodify/id=" + appVersion.getId()
						+ "&error=error3";
			}
		}
		appVersion.setModifyBy(((DevUser) session
				.getAttribute(Contants.DEV_USER_SESSION)).getId());
		appVersion.setModifyDate(new Date());
		appVersion.setDownloadLink(downloadLink);
		appVersion.setApkLocPath(apkLocPath);
		appVersion.setApkFileName(apkFileName);
		ResultData rd = appVersionService.updateAppVersion(appVersion);
		if (rd.getFlag() == 0) {
			return "redirect:/appInfo/appInfoList";
		} else {
			return "developer/appversionmodify";
		}

	}

	/**
	 * 查看APP基础信息和所有版本信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "appview", method = RequestMethod.GET)
	public String view(
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "vid") String versionId,
			@RequestParam(value = "aid") String appId,
			@RequestParam(value = "error", required = false) String fileUploadError,
			Model model) {
		System.out.println(id);
		System.out.println(versionId);
		System.out.println(appId);
		System.out.println("跳转到查看页面");
		AppVersion appVersion = null;
		List<AppVersion> appVersionList = null;

		if (null != fileUploadError && ("error1").equals(fileUploadError)) {
			fileUploadError = Contants.FILEUPPLOAD_ERROR_1;
		} else if (null != fileUploadError
				&& ("error2").equals(fileUploadError)) {
			fileUploadError = Contants.FILEUPPLOAD_ERROR_2;
		} else if (null != fileUploadError
				&& ("error3").equals(fileUploadError)) {
			fileUploadError = Contants.FILEUPPLOAD_ERROR_3;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appId", Long.parseLong(appId));
		map.put("id", Long.parseLong(versionId));
		// appVersion.setappId(Long.parseLong(appId));
		appVersion = (AppVersion) appVersionService.getAppVersionById(map)
				.getData();
		appVersionList = (List<AppVersion>) appVersionService
				.getAppVersionList(map).getData();
		// System.out.println("appVersion" + appVersion);

		model.addAttribute(appVersion);
		model.addAttribute("appVersionList", appVersionList);

		System.out.println("appid" + id);
		// System.out.println("id" + id);
		AppInfo appInfo = null;
		Map<String, Object> infos = new HashMap<String, Object>();
		infos.put("id", id);
		appInfo = (AppInfo) appInfoService.getAppInfo(infos).getData();
		List<DataDictionary> flatFormList = this
				.getDataDictionaryList("APP_FLATFORM");
		// 三个级别的分类列表,获取一级分类,二三级
		ResultData lev = appCategoryService.getAppCategoriesByParentId(null);
		List<AppCategory> categorylevel1List = (List<AppCategory>) lev
				.getData();
		List<AppCategory> categorylevel2List = null;
		List<AppCategory> categorylevel3List = null;

		model.addAttribute(appInfo);
		model.addAttribute("flatFormList", flatFormList);
		model.addAttribute("categorylevel1List", categorylevel1List);
		return "developer/appinfoview";
	}

	@RequestMapping(value = "/delapp.json")
	@ResponseBody
	public Object delApp(@RequestParam String id) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		if (StringUtils.isNullOrEmpty(id)) {
			resultMap.put("delResult", "notexist");
		} else {
			if (appInfoService.appsysdeleteAppById(map)) {
				resultMap.put("delResult", "true");
			} else {
				resultMap.put("delResult", "false");
			}
		}
		return JSONArray.toJSONString(resultMap);
	}

	@RequestMapping(value = "sale.json", method = RequestMethod.POST)
	@ResponseBody
	public String sale(@RequestParam(value = "valueId") String appId,
			@RequestParam(value = "status") String status,
			Map<String, Object> map, HttpSession session) {
		System.out.println(appId);
		System.out.println(status);
		DevUser devUser = (DevUser) session
				.getAttribute(Contants.DEV_USER_SESSION);
		ResultData rd = new ResultData();
		AppInfo apps = (AppInfo) appInfoService.getAppInfoById(
				Integer.parseInt(appId)).getData();
		String resultMsg = null;
		if (apps.getStatus() == 4) {
			apps.setStatus(5);
			apps.setModifyBy(devUser.getId());
			rd = appInfoService.modify(apps);
			if (rd.getFlag() == 0) {
				resultMsg = "success";
				return "redirect:/appInfo/appInfoList";
			} else {
				resultMsg = "failed";
			}
		} else if (apps.getStatus() == 5 || apps.getStatus() == 2) {
			apps.setStatus(4);
			apps.setModifyBy(devUser.getId());
			rd = appInfoService.modify(apps);
			if (rd.getFlag() == 0) {
				resultMsg = "success";
				return "redirect:/appInfo/appInfoList";
			} else {
				resultMsg = "failed";
			}
		} else {
			resultMsg = "failed";
		}
		String json = resultMsg;
		return json;
	}
	// @RequestMapping(value = "sale.json", method = RequestMethod.POST)
	// @ResponseBody
	// public Object sale(@RequestParam String appId, HttpSession session) {
	// System.out.println(222222);
	// HashMap<String, Object> resultMap = new HashMap<String, Object>();
	// Long appIdInteger = 0L;
	// System.out.println(appId + "aaaaaaaaaaaaaaaaaaa");
	// appIdInteger = Long.parseLong(appId);
	// resultMap.put("errorCode", "0");
	// if (appIdInteger > 0) {
	// System.out.println(2);
	// DevUser devUser = (DevUser) session
	// .getAttribute(Contants.DEV_USER_SESSION);
	// AppInfo appInfo = new AppInfo();
	// appInfo.setId(appIdInteger);
	// appInfo.setModifyBy(devUser.getId());
	// if (appInfoService.appsysUpdataSaleStatusByAppId(appInfo)) {
	// System.out.println(3);
	// resultMap.put("resultMsg", "success");
	// } else {
	// resultMap.put("resultMsg", "failed");
	// }
	// } else {
	// // errorCode:0正常
	// resultMap.put("resultMsg", "param000001");
	// }
	// return resultMap;
	// }
	// 处理更新
	// @RequestMapping(value = "appinfomodify", method = RequestMethod.PUT)
	// public String updataappInfo(@ModelAttribute("appInfos") AppInfo
	// appInfos,
	// Map<String, Object> map) {
	// System.out.println(appInfos);
	// return "redirect:/appInfo/appInfoList";
	// }

	/*
	 * @ModelAttribute public void testModelAttribute(Integer id, Map<String,
	 * Object> map) { System.out.println(id); if (id != null) { AppInfo apps =
	 * (AppInfo) appInfoService.getAppInfoById( id.longValue()).getData();
	 * map.put("appInfos", apps); } }
	 */
	// @RequestMapping(value = "dataDictionaryList.json", method =
	// RequestMethod.GET)
	// @ResponseBody
	// public List<DataDictionary> getDataDictionary(@RequestParam String
	// tcode)
	// {
	// System.out.println(tcode);
	// return this.getDataDictionaryList(tcode);
	// }

	// @RequestMapping("appInfoList")
	// public String test1(Map<String, Object> map) {
	// ResultData rd = appInfoService.getAppList();
	// map.put("result", rd);
	// return "developer/appInfoList";
	// }

}