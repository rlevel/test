package cn.appsys.dao;

import org.apache.ibatis.annotations.Select;

import cn.appsys.pojo.DevUser;

public interface DevUserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(DevUser record);

	int insertSelective(DevUser record);

	DevUser selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(DevUser record);

	int updateByPrimaryKey(DevUser record);

	@Select("select * from dev_user where devCode=#{devCode}")
	DevUser selectDevUserByCode(String devCode);
}