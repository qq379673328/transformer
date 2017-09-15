package cn.com.sinosoft.bomsmgr.model.system.user;

import java.util.Date;

/**
 * 用户个人消息列表
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年8月25日
 */
public class UserMessageList {

	/**
	 * id
	 */
	private Integer id;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 消息类型
	 */
	private String type;

	/**
	 * 消息类型-描述
	 */
	private String typeDesc;

	/**
	 * 消息状态
	 */
	private String state;

	/**
	 * 消息状态-描述
	 */
	private String stateDesc;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 扩展信息
	 */
	private String ext;

	/**
	 * 消息内容
	 */
	private String content;

	/**
	 * 创建人
	 */
	private String createUser;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
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

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	public String getStateDesc() {
		return stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}

}
