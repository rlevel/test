package cn.appsys.service.appCategory;

import cn.appsys.tools.ResultData;

public interface AppCategoryService {
	// 通过parentId获取Appcategory列表
	public ResultData getAppCategoriesByParentId(Integer parentid);
}
