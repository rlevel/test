package cn.appsys.service.dataDictionary;

import cn.appsys.tools.ResultData;

public interface DataDictionaryService {
	// ͨ��typecode��ѯdictionary�б�
	public ResultData getDataDictionaryList(String typecode);
}
