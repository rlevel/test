package cn.appsys.dao;

import org.apache.ibatis.annotations.Select;

import cn.appsys.pojo.BackendUser;

public interface BackendUserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(BackendUser record);

	int insertSelective(BackendUser record);

	BackendUser selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(BackendUser record);

	int updateByPrimaryKey(BackendUser record);

	@Select("select * from backend_user where usercode=#{usercode}")
	BackendUser selectBacUserByCode(String usercode);
}