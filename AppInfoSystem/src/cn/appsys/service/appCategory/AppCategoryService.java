package cn.appsys.service.appCategory;

import cn.appsys.tools.ResultData;

public interface AppCategoryService {
	// ͨ��parentId��ȡAppcategory�б�
	public ResultData getAppCategoriesByParentId(Integer parentid);
}
