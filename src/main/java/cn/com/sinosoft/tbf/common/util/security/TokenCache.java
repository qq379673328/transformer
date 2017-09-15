package cn.com.sinosoft.tbf.common.util.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.bomsmgr.model.common.LoginUserInfo;

/**
 * token 缓存管理
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年7月31日
 */
@Component
public class TokenCache {

	@Autowired
	JCacheCacheManager jCacheCacheManager;

	public static final String CACHE_NAME_TOKEN = "token";

	/**
	 * 根据token获取token中缓存的用户信息
	 *
	 * @param token
	 *            token
	 * @return 用户信息
	 */
	public LoginUserInfo get(String token) {
		if (token == null)
			return null;
		return getTokenCache().get(token, LoginUserInfo.class);
	}

	/**
	 * 放入用户信息
	 *
	 * @param token
	 *            token
	 * @param userInfo
	 *            用户信息
	 */
	public void put(String token, LoginUserInfo userInfo) {
		getTokenCache().put(token, userInfo);
	}

	/**
	 * 移除token
	 *
	 * @param token
	 *            token
	 */
	public void remove(String token) {
		getTokenCache().evict(token);
	}

	/**
	 * 获取token cache
	 *
	 * @return
	 */
	public Cache getTokenCache() {
		return jCacheCacheManager.getCache(CACHE_NAME_TOKEN);
	}

}
