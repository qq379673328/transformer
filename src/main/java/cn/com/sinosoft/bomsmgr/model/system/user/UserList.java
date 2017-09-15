package cn.com.sinosoft.bomsmgr.model.system.user;

import java.util.Date;

/**
 * 实体类-用户列表
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年6月2日
 */
public class UserList {

	private Integer id;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 创建人
	 */
	private String createUser;

	/**
	 * 更新人
	 */
	private String updateUser;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 用户状态
	 */
	private String state;

	/**
	 * 用户状态描述
	 */
	private String stateDesc;

	/**
	 * 昵称
	 */
	private String name;

	/**
	 * 关联员工id
	 */
	private Integer idStaff;

	/**
	 * 关联员工名
	 */
	private String staffName;

	/**
	 * 备注
	 */
	private String comment;

	/**
	 * 员工职位
	 */
	private String staffDuty;

	/**
	 * 员工职位描述
	 */
	private String staffDutyDesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateDesc() {
		return stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}

	public Integer getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(Integer idStaff) {
		this.idStaff = idStaff;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStaffDuty() {
		return staffDuty;
	}

	public void setStaffDuty(String staffDuty) {
		this.staffDuty = staffDuty;
	}

	public String getStaffDutyDesc() {
		return staffDutyDesc;
	}

	public void setStaffDutyDesc(String staffDutyDesc) {
		this.staffDutyDesc = staffDutyDesc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
