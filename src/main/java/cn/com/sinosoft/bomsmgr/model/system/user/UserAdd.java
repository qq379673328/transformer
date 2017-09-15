package cn.com.sinosoft.bomsmgr.model.system.user;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户新增
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年6月2日
 */
public class UserAdd {

	/**
	 * 用户名
	 */
	@NotBlank(message = "用户名 不能为空")
	@Length(min = 8, max = 20, message = "用户名 长度必须为{min}到{max}")
	private String userName;

	/**
	 * 密码
	 */
	@NotBlank(message = "密码 不能为空")
	@Length(min = 6, max = 20, message = "密码 长度必须为{min}到{max}")
	private String password;

	/**
	 * 姓名-废弃
	 */
	@Length(max = 20, message = "姓名 长度不能大于{max}")
	private String nickname;

	/**
	 * 备注-废弃
	 */
	@Length(max = 500, message = "备注 长度不能大于{max}")
	private String comment;

	/**
	 * 关联员工id
	 */
	private Integer staffId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

}
