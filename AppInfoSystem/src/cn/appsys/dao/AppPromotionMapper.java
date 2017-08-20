package cn.appsys.dao;

import cn.appsys.pojo.AppPromotion;

public interface AppPromotionMapper {
	int deleteByPrimaryKey(Long id);

	int insert(AppPromotion record);

	int insertSelective(AppPromotion record);

	AppPromotion selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(AppPromotion record);

	int updateByPrimaryKey(AppPromotion record);
}