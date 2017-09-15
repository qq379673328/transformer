package cn.com.sinosoft.bomsmgr.model.common;

import java.io.Serializable;
import java.util.List;

import cn.com.sinosoft.bomsmgr.entity.ge.TAuthMenufun;
import cn.com.sinosoft.bomsmgr.entity.ge.TAuthUser;
import cn.com.sinosoft.bomsmgr.model.base.MFTreeVO;

/**
 * 登录用户信息
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年4月21日
 */
public class LoginUserInfo implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 3539475926671377371L;
	/**
	 * 用户id
	 */
	private String id;
	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 密码-返回客户端的话不包含此信息
	 */
	private String passWord;
	/**
	 * 移动端接口使用
	 */
	private String token;
	/**
	 * 用户信息
	 */
	private TAuthUser user;

	/**
	 * 用户权限信息
	 */
	private MFTreeVO mfTreeVo;

	/**
	 * 用户权限信息、带功能点-列表
	 */
	private List<TAuthMenufun> mfListVO;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public TAuthUser getUser() {
		return user;
	}
	public void setUser(TAuthUser user) {
		this.user = user;
	}
	public MFTreeVO getMfTreeVo() {
		return mfTreeVo;
	}
	public void setMfTreeVo(MFTreeVO mfTreeVo) {
		this.mfTreeVo = mfTreeVo;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public List<TAuthMenufun> getMfListVO() {
		return mfListVO;
	}
	public void setMfListVO(List<TAuthMenufun> mfListVO) {
		this.mfListVO = mfListVO;
	}

}
