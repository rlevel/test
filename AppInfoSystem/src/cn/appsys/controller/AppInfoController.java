package cn.appsys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

@Controller
@RequestMapping("appInfo")
public class AppInfoController {
	@Autowired
	private AppInfoService appInfoService;
	@Autowired
	private DataDictionaryService dataDictionaryService;
	@Autowired
	private AppCategoryService appCategoryService;

	// ��ת��appInfoҳ�沢���appInfo
	@RequestMapping("appInfoList")
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
		System.out.println(querysoftwareName + _querystatus
				+ _querycategoryLevel1 + _querycategoryLevel2
				+ _querycategoryLevel3 + _queryflatformId + pageIndex);
		// ��¼����constants�ൽsession
		Long devId = ((DevUser) session.getAttribute(Contants.DEV_USER_SESSION))
				.getId();
		List<AppInfo> appInfoList = null;
		List<DataDictionary> statusList = null;
		List<DataDictionary> flatFormList = null;
		// �г�һ�������б�,��������ͨ��ajax�첽��ȡ
		List<AppCategory> categorylevel1List = null;
		List<AppCategory> categorylevel2List = null;
		List<AppCategory> categorylevel3List = null;
		// ҳ������
		int pageSize = Contants.pageSize;
		System.out.println("ÿҳ��ʾ" + pageSize + "����¼");
		// ��ǰҳ��
		Page pages = new Page();
		Integer currentPageNo = 1;

		if (pageIndex != null && !"".equals(pageIndex)) {
			currentPageNo = Integer.valueOf(pageIndex);

		}
		System.out.println("��ǰҳ��" + currentPageNo);
		// ÿҳ�ӵڼ�����ʼ��ѯ
		int start = 0;
		start = (currentPageNo - 1) * pageSize;
		pages.setStart(start);

		// ����ת��
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
		System.out.println("��ʼ" + pages.getStart());
		ResultData rd = new ResultData();
		rd = appInfoService.getAppInfoList(maps);

		// ������(�б�)
		int totalCount = 0;
		totalCount = (Integer) appInfoService.getAppInfoCount(maps).getData();
		// ��ҳ��
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);

		int totalPageCount = pages.getTotalPageCount();

		// ��βҳ
		if (currentPageNo < 1) {
			currentPageNo = 1;
		} else if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}

		// info�б�
		appInfoList = (List<AppInfo>) rd.getData();
		statusList = this.getDataDictionaryList("APP_STATUS");
		flatFormList = this.getDataDictionaryList("APP_FLATFORM");
		ResultData lev = appCategoryService.getAppCategoriesByParentId(null);
		categorylevel1List = (List<AppCategory>) lev.getData();
		System.out.println("catego" + categorylevel1List);

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
		List<DataDictionary> dataDictionaries = (List<DataDictionary>) rd
				.getData();
		return dataDictionaries;
	}

	/**
	 * ����parentID�����Ӧ�ķ��༶���б�
	 * 
	 * @param pid
	 * @return
	 */
	@RequestMapping(value = "/categoryLevelList.json", method = RequestMethod.GET)
	@ResponseBody
	public List<AppCategory> getAppCategoryList(@RequestParam String pid) {
		System.out.println("������̨��pid" + pid);
		if (("").equals(pid))
			pid = null;
		return getCategoryList(pid);
	}

	public List<AppCategory> getCategoryList(String pid) {
		List<AppCategory> categorieList = null;
		ResultData rd = appCategoryService
				.getAppCategoriesByParentId(pid == null ? null : Integer
						.parseInt(pid));
		categorieList = (List<AppCategory>) rd.getData();
		return categorieList;
	}
	// @RequestMapping("appInfoList")
	// public String test1(Map<String, Object> map) {
	// ResultData rd = appInfoService.getAppList();
	// map.put("result", rd);
	// return "developer/appInfoList";
	// }
}
