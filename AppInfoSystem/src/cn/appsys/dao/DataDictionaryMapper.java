package cn.appsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.appsys.pojo.DataDictionary;

public interface DataDictionaryMapper {
	int deleteByPrimaryKey(Long id);

	int insert(DataDictionary record);

	int insertSelective(DataDictionary record);

	DataDictionary selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(DataDictionary record);

	int updateByPrimaryKey(DataDictionary record);

	@Select("select * from data_dictionary where typecode=#{typecode}")
	List<DataDictionary> getDataDictionaryList(String typecode);
}