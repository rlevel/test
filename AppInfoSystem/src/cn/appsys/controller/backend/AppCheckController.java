package cn.appsys.controller.backend;

import java.util.ArrayList;
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
import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.service.appCategory.AppCategoryService;
import cn.appsys.service.appInfo.AppInfoService;
import cn.appsys.service.appVersion.appVersionService;
import cn.appsys.service.dataDictionary.DataDictionaryService;
import cn.appsys.tools.Contants;
import cn.appsys.tools.Page;
import cn.appsys.tools.ResultData;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("check")
public class AppCheckController {
	@Autowired
	private AppInfoService appInfoService;
	@Autowired
	private DataDictionaryService dataDictionaryService;
	@Autowired
	private AppCategoryService appCategoryService;
	@Autowired
	private appVersionService appVersionService;

	// ��ת��appInfoҳ�沢���appInfo
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
		// System.out.println("�������" + querysoftwareName);
		// System.out.println("app" + _querystatus);
		// System.out.println("һ������" + _querycategoryLevel1);
		// System.out.println("��������" + _querycategoryLevel2);
		// System.out.println("��������" + _querycategoryLevel3);
		// System.out.println("ƽ̨" + _queryflatformId);
		// System.out.println("�������" + pageIndex);
		// ��¼����constants�ൽsession
		Long devId = ((BackendUser) session.getAttribute(Contants.USER_SESSION))
				.getId();
		// System.out.println("_querycategoryLevel2" + _querycategoryLevel2);
		// System.out.println("_querycategoryLevel3" + _querycategoryLevel3);
		// System.out.println("_queryflatformId" + _queryflatformId);
		// System.out.println(querysoftwareName);
		System.out.println("-----------------------------");
		List<AppInfo> appInfoList = null;
		List<DataDictionary> statusList = null;
		List<DataDictionary> flatFormList = null;
		// �г�һ�������б�,��������ͨ��ajax�첽��ȡ
		List<AppCategory> categorylevel1List = null;
		List<AppCategory> categorylevel2List = null;
		List<AppCategory> categorylevel3List = null;
		// ҳ������
		int pageSize = Contants.pageSize;
		// System.out.println("ÿҳ��ʾ" + pageSize + "����¼");
		// ��ǰҳ��
		Page pages = new Page();
		Integer currentPageNo = 1;

		if (pageIndex != null && !"".equals(pageIndex)) {
			currentPageNo = Integer.valueOf(pageIndex);

		}
		// System.out.println("��ǰҳ��" + currentPageNo);
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
		maps.put("categoryLevel1", querycategoryLevel1);
		maps.put("categoryLevel2", querycategoryLevel2);
		maps.put("categoryLevel3", querycategoryLevel3);
		maps.put("flatformId", queryflatformId);
		maps.put("devId", devId);
		maps.put("from", pages.getStart());
		maps.put("pageSize", pageSize);
		// System.out.println("��ʼ" + pages.getStart());
		ResultData rd = new ResultData();
		rd = appInfoService.getAppInfoList(maps);

		// System.out.println("rd" + rd);
		// ������(�б�)
		int totalCount = 0;
		totalCount = (Integer) appInfoService.getAppInfoCount(maps).getData();
		// System.out.println(totalCount + "totalCount");
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

		return "backend/appInfoList";
	}

	public List<DataDictionary> getDataDictionaryList(String typecode) {
		ResultData rd = dataDictionaryService.getDataDictionaryList(typecode);
		List<DataDictionary> dataDictionaries = new ArrayList<DataDictionary>();
		dataDictionaries = (List<DataDictionary>) rd.getData();
		return dataDictionaries;
	}

	/**
	 * ����parentID�����Ӧ�ķ��༶���б�
	 * 
	 * @param pid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/categoryLevelList.json", method = RequestMethod.GET)
	public String getAppCategoryList(@RequestParam String pid,
			Map<String, Object> map) {
		// System.out.println("������̨��pid" + pid);
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
		// array = JSONArray.parseArray("categorieList", categorieList);// �ܹ�ȥ
		String json = JSON.toJSONString(rd);
		// System.out.println(json);
		return json;
	}
}
