package cn.appsys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import cn.appsys.pojo.AppVersion;

public interface AppVersionMapper {
	int deleteByPrimaryKey(Long id);

	int insert(AppVersion record);

	int insertSelective(AppVersion record);

	AppVersion selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(AppVersion record);

	int updateByPrimaryKey(AppVersion record);

	List<AppVersion> getAppVersionList(Map<String, Object> map);

	AppVersion getAppVersionById(Map<String, Object> map);

	@Select("select count(*) from app_version where appId=#{appId}")
	int getVersionCountByAppId(Map<String, Object> map);

	int delVersionByAppId(Map<String, Object> map);
}