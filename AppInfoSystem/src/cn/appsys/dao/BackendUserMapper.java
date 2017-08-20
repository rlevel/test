package cn.appsys.dao;

import cn.appsys.pojo.BackendUser;

public interface BackendUserMapper {
	int deleteByPrimaryKey(Long id);

	int insert(BackendUser record);

	int insertSelective(BackendUser record);

	BackendUser selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(BackendUser record);

	int updateByPrimaryKey(BackendUser record);
}