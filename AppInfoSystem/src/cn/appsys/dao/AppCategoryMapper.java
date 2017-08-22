package cn.appsys.dao;

import java.util.List;

import cn.appsys.pojo.AppCategory;

public interface AppCategoryMapper {
	int deleteByPrimaryKey(Long id);

	int insert(AppCategory record);

	int insertSelective(AppCategory record);

	AppCategory selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(AppCategory record);

	int updateByPrimaryKey(AppCategory record);

	// ͨ��parentId��ѯAPPcategory��Ϣ
	List<AppCategory> getAppCategoriesByParentId(Integer parentid);
}