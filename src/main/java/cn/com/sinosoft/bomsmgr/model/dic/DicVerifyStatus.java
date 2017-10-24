package cn.com.sinosoft.bomsmgr.model.dic;

/**
 * 审核状态
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年10月24日
 */
public enum DicVerifyStatus {

	READY("0", "待审核"), PASS("1", "审核通过"), FAIL("9", "审核未通过");

	private String code;
	private String desc;
	private DicVerifyStatus(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}

}
