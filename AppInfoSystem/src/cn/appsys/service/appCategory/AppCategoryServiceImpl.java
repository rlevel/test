package cn.appsys.service.appCategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.AppCategoryMapper;
import cn.appsys.pojo.AppCategory;
import cn.appsys.tools.ResultData;

@Service
public class AppCategoryServiceImpl implements AppCategoryService {
	@Autowired
	private AppCategoryMapper appCategoryMapper;

	@Override
	public ResultData getAppCategoriesByParentId(Integer parentid) {
		ResultData rd = new ResultData();
		List<AppCategory> appCategories = appCategoryMapper
				.getAppCategoriesByParentId(parentid);
		rd.setData(appCategories);
		return rd;
	}
}
