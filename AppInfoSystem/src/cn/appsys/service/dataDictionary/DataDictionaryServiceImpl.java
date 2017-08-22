package cn.appsys.service.dataDictionary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.appsys.dao.DataDictionaryMapper;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.tools.ResultData;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
	@Autowired
	private DataDictionaryMapper dataDictionaryMapper;

	@Override
	public ResultData getDataDictionaryList(String typecode) {
		ResultData rd = new ResultData();
		List<DataDictionary> dictionarys = dataDictionaryMapper
				.getDataDictionaryList(typecode);
		rd.setData(dictionarys);
		return rd;
	}

}
