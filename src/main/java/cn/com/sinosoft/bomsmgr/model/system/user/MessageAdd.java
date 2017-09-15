package cn.com.sinosoft.bomsmgr.model.system.user;

import java.util.Date;

/**
 * 用户个人消息
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年8月25日
 */
public class MessageAdd {

	private Integer id;

	/**
	 * 标题-必填
	 */
	private String title;

	/**
	 * 消息类型-可选
	 */
	private String type;

	/**
	 * 用户id-必填
	 */
	private Integer userId;

	/**
	 * 扩展信息-可选
	 */
	private String ext;

	/**
	 * 生效时间-可选
	 */
	private Date effectTime;

	/**
	 * 失效时间-可选
	 */
	private Date invalidTime;

	/**
	 * 消息内容
	 */
	private String content;

	/**
	 * 创建人-发送人
	 */
	private String createUser;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public Date getEffectTime() {
		return effectTime;
	}

	public void setEffectTime(Date effectTime) {
		this.effectTime = effectTime;
	}

	public Date getInvalidTime() {
		return invalidTime;
	}

	public void setInvalidTime(Date invalidTime) {
		this.invalidTime = invalidTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
