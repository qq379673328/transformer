package cn.com.sinosoft.tbf.config.security;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.com.sinosoft.bomsmgr.entity.ge.TAuthMenufun;
import cn.com.sinosoft.bomsmgr.model.common.LoginUserInfo;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.tbf.common.security.annotation.mobileapi.HasRolesMApi;
import cn.com.sinosoft.tbf.common.util.http.ResponseUtil;
import cn.com.sinosoft.tbf.common.util.security.JwtHelper;
import cn.com.sinosoft.tbf.common.util.security.TokenCache;
import cn.com.sinosoft.tbf.domain.common.APIResult;
import cn.com.sinosoft.tbf.domain.common.ResultCode;
import cn.com.sinosoft.tbf.domain.common.security.Audience;

/**
 * api token 认证拦截器
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2016年9月1日
 */
public class ApiTokenAuthInterceptor extends HandlerInterceptorAdapter {

	private Class<?> clazz;
	private Method method;
	private HttpServletResponse response;
	private HttpServletRequest request;

	@Autowired
	private JwtHelper jwtHelper;
	@Autowired
	private TokenCache tokenCache;
	@Autowired
	Audience audience;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean result = true;
		this.response = response;
		this.request = request;

		// 验证session token
		if (!validSession()) {
			// 验证jwt token
			result = result && validJWTToken();
		}

		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			clazz = handlerMethod.getBeanType();
			method = handlerMethod.getMethod();
			if (clazz != null && method != null) {

				// 处理角色权限过滤
				if (clazz.isAnnotationPresent(HasRolesMApi.class) || method.isAnnotationPresent(HasRolesMApi.class)) {
					result = result && validRolesMApi();
				}

			}

		}
		return result && super.preHandle(request, response, handler);
	}

	/**
	 * 验证session用户
	 *
	 * @return
	 */
	private boolean validSession() {
		LoginUserInfo loginUserInfo = (LoginUserInfo) request.getSession()
				.getAttribute(CommonUserService.SESSION_NAME_USERINFO);
		return loginUserInfo == null ? false : isHasPermission(getRequestUri(), loginUserInfo);
	}

	/**
	 * 获取请求地址
	 *
	 * @return
	 */
	private String getRequestUri() {
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		return uri.replaceFirst(context, "");
	}

	/**
	 * 用户是否含有权限
	 *
	 * @param permission
	 * @param userInfo
	 * @return
	 */
	private boolean isHasPermission(String uri, LoginUserInfo userInfo) {
		// 请求类型
		if ("GET".equals(request.getMethod())) {// get类型全部放过
			return true;
		}

		// 忽略的路径
		List<String> excludeAuthUrls = audience.getExcludeAuthUrls();
		if (excludeAuthUrls != null) {
			for (String url : excludeAuthUrls) {
				if (url.equals(uri)) {
					return true;
				}
			}
		}

		// 拥有权限的路径
		List<TAuthMenufun> mfs = userInfo.getMfListVO();
		if (mfs == null || mfs.size() == 0)
			return false;
		for (TAuthMenufun mf : mfs) {
			String mfUrl = mf.getMfLink();
			if (mfUrl != null && mfUrl.equals(uri)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 验证jwt token
	 *
	 * @return
	 */
	private boolean validJWTToken() {
		String auth = jwtHelper.getJWTToken();
		if (jwtHelper.parseJWT(auth) != null) {
			LoginUserInfo userInfo = tokenCache.get(jwtHelper.getJWTToken());
			// 磁盘存储token已失效或不存在
			if (userInfo == null) {
				createUnLoginResponse();
				return false;
			}
			// 从缓存中取出完全的信息
			return true && isHasPermission(getRequestUri(), userInfo);
		} else {
			createUnAuthResponse();
			return false;
		}
	}

	/**
	 * 处理角色过滤注解<br>
	 * 只要满足任意一个角色即可验证通过
	 *
	 * @return
	 */
	private boolean validRolesMApi() {
		boolean ret = false;
		List<AppRoles> roles = new ArrayList<AppRoles>();
		if (clazz.isAnnotationPresent(HasRolesMApi.class)) {
			AppRoles[] clazzRoles = clazz.getAnnotation(HasRolesMApi.class).value();
			Collections.addAll(roles, clazzRoles);
		} else if (method.isAnnotationPresent(HasRolesMApi.class)) {
			AppRoles[] methodRoles = method.getAnnotation(HasRolesMApi.class).value();
			Collections.addAll(roles, methodRoles);
		}
		for (AppRoles role : roles) {
			if (role == AppRoles.TEST) {
				return true;
			}
		}
		if (ret == false) {
			createUnAuthResponse();
		}
		return ret;
	}

	/**
	 * 创建未授权返回信息
	 */
	private void createUnAuthResponse() {
		ResponseUtil.createApiResultJson(response,
				new APIResult<Object>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getDesc()));
	}

	/**
	 * 创建未登录返回信息
	 */
	private void createUnLoginResponse() {
		ResponseUtil.createApiResultJson(response,
				new APIResult<Object>(ResultCode.UNAUTHENTICATION.getCode(), ResultCode.UNAUTHENTICATION.getDesc()));
	}

}
