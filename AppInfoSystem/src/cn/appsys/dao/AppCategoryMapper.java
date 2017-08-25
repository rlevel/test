package cn.appsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;

public interface AppCategoryMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(AppCategory record);

	int insertSelective(AppCategory record);

	AppCategory selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(AppCategory record);

	int updateByPrimaryKey(AppCategory record);

	// ͨ��parentId��ѯAPPcategory��Ϣ
	List<AppCategory> getAppCategoriesByParentId(
			@Param("parentId") Integer parentId);
}