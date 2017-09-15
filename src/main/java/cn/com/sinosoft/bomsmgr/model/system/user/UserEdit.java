package cn.com.sinosoft.bomsmgr.model.system.user;

import org.hibernate.validator.constraints.Length;

/**
 * 用户编辑
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年6月2日
 */
public class UserEdit {

	private String id;

	/**
	 * 姓名
	 */
	@Length(max = 20, message = "姓名 长度不能大于{max}")
	private String name;

	/**
	 * 备注-废弃
	 */
	@Length(max = 500, message = "备注 长度不能大于{max}")
	private String comment;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
