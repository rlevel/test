package cn.appsys.service.dataDictionary;

import cn.appsys.tools.ResultData;

public interface DataDictionaryService {
	// 通过typecode查询dictionary列表
	public ResultData getDataDictionaryList(String typecode);
}
