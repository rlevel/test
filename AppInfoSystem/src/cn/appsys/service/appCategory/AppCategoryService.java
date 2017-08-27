package cn.appsys.service.appCategory;

import cn.appsys.tools.ResultData;

public interface AppCategoryService {
	// 通过parentId获取Appcategory列表
	public ResultData getAppCategoriesByParentId(Integer parentId);

	public ResultData getAppCategoriesByPid(Integer parentId);

	public ResultData getAppCategoriesById(Integer id);
}
