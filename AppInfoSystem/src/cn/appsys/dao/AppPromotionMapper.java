package cn.appsys.dao;

import cn.appsys.pojo.AppPromotion;

public interface AppPromotionMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(AppPromotion record);

	int insertSelective(AppPromotion record);

	AppPromotion selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(AppPromotion record);

	int updateByPrimaryKey(AppPromotion record);
}