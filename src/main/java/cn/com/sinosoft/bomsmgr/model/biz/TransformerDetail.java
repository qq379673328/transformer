package cn.com.sinosoft.bomsmgr.model.biz;

import java.util.List;

/**
 * 变电站详情
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月18日
 */
public class TransformerDetail {

	/**
	 * 变电站
	 */
	private TransformerInfo transformer;

	/**
	 * 接线图
	 */
	private List<WiringdiagramInfo> wiringdiagrams;

	public TransformerInfo getTransformer() {
		return transformer;
	}

	public void setTransformer(TransformerInfo transformer) {
		this.transformer = transformer;
	}

	public List<WiringdiagramInfo> getWiringdiagrams() {
		return wiringdiagrams;
	}

	public void setWiringdiagrams(List<WiringdiagramInfo> wiringdiagrams) {
		this.wiringdiagrams = wiringdiagrams;
	}

}
