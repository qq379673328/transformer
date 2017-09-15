package cn.com.sinosoft.tbf.config.security;

import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.google.code.kaptcha.Constants;

import cn.com.sinosoft.bomsmgr.entity.ge.TAuthUser;
import cn.com.sinosoft.bomsmgr.model.common.LoginUserInfo;
import cn.com.sinosoft.bomsmgr.service.common.CommonBaseService;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.bomsmgr.service.system.user.SystemUserService;
import cn.com.sinosoft.tbf.dao.BaseDao;

/**
 * 自定义认证
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2016年8月9日
 */
@Component
public class AuthenticationProviderCustom implements AuthenticationProvider {

	@Resource
	CommonUserService userServcie;
	@Resource
	SystemUserService systemUserService;
	@Resource
	CommonBaseService commonBaseService;
	@Resource
	BaseDao baseDao;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;

	// session名-上次登录信息
	public static final String SESSION_NAME_LASTLOGINNAME = "SESSION_NAME_LASTLOGINNAME";
	public static final String SESSION_NAME_LASTLOGINPWD = "SESSION_NAME_LASTLOGINPWD";

	// cookie名-上次登录信息
	public static final String COOKIE_NAME_LASTLOGINNAME = "COOKIE_NAME_LASTLOGINNAME";

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		HttpSession session = request.getSession();

		// 用户名
		String userName = authentication.getName();
		// 密码
		String passWord = String.valueOf(authentication.getCredentials());
		// 记录session
		session.setAttribute(SESSION_NAME_LASTLOGINNAME, userName);
		session.setAttribute(SESSION_NAME_LASTLOGINPWD, passWord);

		// 验证验证码
		String requestCaptcha = request.getParameter("code");
		String genCaptcha = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (requestCaptcha == null) {
			throw new BadCredentialsException("请输入验证码");
		}
		if (!requestCaptcha.equals(genCaptcha)) {
			throw new BadCredentialsException("验证码错误");
		}

		// 验证
		TAuthUser userInfo = userServcie.geTAuthUser(userName, passWord);
		if (userInfo != null) {
			// 用户被锁定
			if (CommonUserService.USER_STATE_LOCKED.equals(userInfo.getIsUsed())) {
				throw new BadCredentialsException("用户已禁用");
			}

			LoginUserInfo loginUserInfo = new LoginUserInfo();
			loginUserInfo.setId(userInfo.getId().toString());
			loginUserInfo.setUserName(userInfo.getLoginName());
			loginUserInfo.setPassWord(userInfo.getPassWord());
			loginUserInfo.setUser(userInfo);

			request.getSession().setAttribute(CommonUserService.SESSION_NAME_USERINFO, loginUserInfo);

			// 树状菜单权限
			loginUserInfo.setMfTreeVo(commonBaseService.getUserMF(userInfo.getId(), "1"));
			// 列表权限-带功能点
			loginUserInfo.setMfListVO(systemUserService.getUserMf(userInfo.getId(), null));

			// 授权
			Collection<? extends GrantedAuthority> authorities = null;

			// 记录cookie
			Cookie cookie = new Cookie(COOKIE_NAME_LASTLOGINNAME, userName);
			cookie.setMaxAge(2592000);// 30天
			response.addCookie(cookie);

			return new UsernamePasswordAuthenticationToken(userName, passWord, authorities);
		} else {
			session.setAttribute(SESSION_NAME_LASTLOGINPWD, null);
			throw new BadCredentialsException("用户名或密码错误");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
