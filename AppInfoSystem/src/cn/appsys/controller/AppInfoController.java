package cn.appsys.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.appCategory.AppCategoryService;
import cn.appsys.service.appInfo.AppInfoService;
import cn.appsys.service.dataDictionary.DataDictionaryService;
import cn.appsys.tools.Contants;
import cn.appsys.tools.Page;
import cn.appsys.tools.ResultData;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("appInfo")
public class AppInfoController {
	@Autowired
	private AppInfoService appInfoService;
	@Autowired
	private DataDictionaryService dataDictionaryService;
	@Autowired
	private AppCategoryService appCategoryService;

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
		Long devId = ((DevUser) session.getAttribute(Contants.DEV_USER_SESSION))
				.getId();
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
		Integer queryflatformId = null;
		if (_queryflatformId != null && !"".equals(_queryflatformId)) {
			queryflatformId = Integer.valueOf(_queryflatformId);
		}
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("softwareName", querysoftwareName);
		maps.put("status", querystatus);
		maps.put("categorylevel1", querycategoryLevel1);
		maps.put("categorylevel2", querycategoryLevel2);
		maps.put("categorylevel3", querycategoryLevel3);
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
	public List<AppCategory> getAppCategoryList(@RequestParam String pid) {
		System.out.println("传到后台的pid" + pid);
		if (("").equals(pid)) {
			pid = null;
		}
		return this.getCategoryList(pid);
	}

	public List<AppCategory> getCategoryList(String pid) {
		System.out.println(1);
		List<AppCategory> categorieList = new ArrayList<AppCategory>();
		ResultData rd = appCategoryService
				.getAppCategoriesByParentId(pid == null ? null : Integer
						.valueOf(pid));
		categorieList = (List<AppCategory>) rd.getData();

		for (AppCategory categorie : categorieList) {
			System.out.println(categorie.toString());
		}

		// JSONArray array = null;
		//
		// array = JSONArray.parseArray("categorieList", categorieList);// 能过去

		return categorieList;
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

	@RequestMapping(value = "apkexist.json", method = RequestMethod.GET)
	@ResponseBody
	public Object apkNameIsExit(@RequestParam String APKName) {
		// System.out.println(1);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (StringUtils.isNullOrEmpty(APKName)) {
			resultMap.put("APKName", "empty");
		} else {
			AppInfo appInfo = null;
			ResultData rd = appInfoService.getAppInfo(null, APKName);
			appInfo = (AppInfo) rd.getData();
			if (appInfo != null) {
				resultMap.put("APKName", "exist");
			} else {
				resultMap.put("APKName", "noexist");
			}
		}
		return JSONArray.toJSONString(resultMap);
	}

	@RequestMapping(value = "/appinfoaddsave", method = RequestMethod.POST)
	public String addSave(
			AppInfo appInfo,
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "a_logoPicPath", required = false) MultipartFile attach) {
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
				String fileName = appInfo.getApkname() + ".jpg";
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

		appInfo.setCreatedby(((DevUser) session
				.getAttribute(Contants.DEV_USER_SESSION)).getId());
		appInfo.setCreationdate(new Date());
		appInfo.setLogopicpath(logoPicPath);
		appInfo.setLogolocpath(logoLocPath);
		appInfo.setDevid(((DevUser) session
				.getAttribute(Contants.DEV_USER_SESSION)).getId());
		appInfo.setStatus(1L);
		ResultData rd = appInfoService.addAppList(appInfo);
		if (rd.getFlag() == 0) {
			return "redirect:/appInfo/appInfoList";
		} else {
			return "developer/appinfoadd";
		}

	}
	// @RequestMapping(value = "dataDictionaryList.json", method =
	// RequestMethod.GET)
	// @ResponseBody
	// public List<DataDictionary> getDataDictionary(@RequestParam String tcode)
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
