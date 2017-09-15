package cn.com.sinosoft.bomsmgr.model.system.user;

import cn.com.sinosoft.bomsmgr.entity.ge.TAuthMenufun;

/**
 * 用户分配使用的权限信息
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年6月8日
 */
public class MfAssign extends TAuthMenufun {

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	/**
	 * 是否拥有
	 */
	private Boolean isHave;

	public Boolean getIsHave() {
		return isHave;
	}

	public void setIsHave(Boolean isHave) {
		this.isHave = isHave;
	}

}
