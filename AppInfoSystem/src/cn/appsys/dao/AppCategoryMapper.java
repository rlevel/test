package cn.appsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.appsys.pojo.AppCategory;

public interface AppCategoryMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(AppCategory record);

	int insertSelective(AppCategory record);

	AppCategory selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(AppCategory record);

	int updateByPrimaryKey(AppCategory record);

	// 通过parentId查询APPcategory信息
	List<AppCategory> getAppCategoriesByParentId(
			@Param("parentId") Integer parentId);

	@Select("select * from app_category where id=#{id} ")
	List<AppCategory> getAppCategoriesById(Integer id);
}