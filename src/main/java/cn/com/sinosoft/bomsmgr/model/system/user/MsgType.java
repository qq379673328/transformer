package cn.com.sinosoft.bomsmgr.model.system.user;

/**
 * 用户消息类型
 *
 */
public enum MsgType {

	PAYMENT("01"), // 缴费
	FEEDBACK("02") // 问题反馈
	;

	private String value;

	public String getValue() {
		return value;
	}

	private MsgType(String value) {
		this.value = value;
	}

}
