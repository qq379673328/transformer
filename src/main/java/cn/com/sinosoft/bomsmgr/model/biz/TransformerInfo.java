package cn.com.sinosoft.bomsmgr.model.biz;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizTransformer;

/**
 * 变电站信息
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月18日
 */
public class TransformerInfo extends TBizTransformer{

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	/**
	 * 创建人描述
	 */
	private String createUserDesc;

	public String getCreateUserDesc() {
		return createUserDesc;
	}

	public void setCreateUserDesc(String createUserDesc) {
		this.createUserDesc = createUserDesc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
