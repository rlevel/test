package cn.appsys.dao;

import org.apache.ibatis.annotations.Select;

import cn.appsys.pojo.DevUser;

public interface DevUserMapper {
	int deleteByPrimaryKey(Long id);

	int insert(DevUser record);

	int insertSelective(DevUser record);

	DevUser selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(DevUser record);

	int updateByPrimaryKey(DevUser record);

	@Select("select * from dev_user where devcode=#{devcode}")
	DevUser selectDevUserByCode(String devcode);
}