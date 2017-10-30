package cn.com.sinosoft.bomsmgr.model.biz;

import cn.com.sinosoft.bomsmgr.entity.ge.TSystemConfig;

/**
 * 系统配置
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月18日
 */
public class SystemConfigInfo extends TSystemConfig {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * 更新人描述
	 */
	private String updateUserDesc;

	public String getUpdateUserDesc() {
		return updateUserDesc;
	}

	public void setUpdateUserDesc(String updateUserDesc) {
		this.updateUserDesc = updateUserDesc;
	}

}
