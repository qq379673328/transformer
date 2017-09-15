package cn.com.sinosoft.tbf.domain.common;

import java.util.List;
import java.util.Map;

/**
 * 表单提交列表数据时的数据绑定
 * @date	2014-11-25
 */
public class ExtListData {

	Map<String, List<Map<String, Object>>> extListData;

	public Map<String, List<Map<String, Object>>> getExtListData() {
		return extListData;
	}

	public void setExtListData(
			Map<String, List<Map<String, Object>>> extListData) {
		this.extListData = extListData;
	}
	
}
