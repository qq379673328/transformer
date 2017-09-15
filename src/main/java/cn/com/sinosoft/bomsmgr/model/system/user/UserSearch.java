package cn.com.sinosoft.bomsmgr.model.system.user;

/**
 * 查询条件-用户
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年6月2日
 */
public class UserSearch {

	/**
	 * 创建时间-开始
	 */
	private String createDateBegin;

	/**
	 * 创建时间-结束
	 */
	private String createDateEnd;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 状态-common.userstate
	 */
	private String state;

	/**
	 * 是否员工-common.yesno
	 */
	private String isStaff;

	public String getCreateDateBegin() {
		return createDateBegin;
	}
	public void setCreateDateBegin(String createDateBegin) {
		this.createDateBegin = createDateBegin;
	}
	public String getCreateDateEnd() {
		return createDateEnd;
	}
	public void setCreateDateEnd(String createDateEnd) {
		this.createDateEnd = createDateEnd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIsStaff() {
		return isStaff;
	}
	public void setIsStaff(String isStaff) {
		this.isStaff = isStaff;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
