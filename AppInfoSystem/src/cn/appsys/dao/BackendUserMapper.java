package cn.appsys.dao;

import org.apache.ibatis.annotations.Select;

import cn.appsys.pojo.BackendUser;

public interface BackendUserMapper {
	int deleteByPrimaryKey(Long id);

	int insert(BackendUser record);

	int insertSelective(BackendUser record);

	BackendUser selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(BackendUser record);

	int updateByPrimaryKey(BackendUser record);

	@Select("select * from backend_user where usercode=#{usercode}")
	BackendUser selectDevUserByCode(String usercode);
}