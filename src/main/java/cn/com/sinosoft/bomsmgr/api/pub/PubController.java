package cn.com.sinosoft.bomsmgr.api.pub;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

import cn.com.sinosoft.bomsmgr.entity.ge.TAuthUser;
import cn.com.sinosoft.bomsmgr.model.common.LoginUserInfo;
import cn.com.sinosoft.bomsmgr.service.common.CommonBaseService;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.bomsmgr.service.system.user.SystemUserService;
import cn.com.sinosoft.tbf.common.util.security.JwtHelper;
import cn.com.sinosoft.tbf.common.util.security.TokenCache;
import cn.com.sinosoft.tbf.domain.common.APIResult;
import cn.com.sinosoft.tbf.domain.common.ResultCode;

/**
 * 公开接口
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年5月2日
 */
@RestController
@RequestMapping("/api/pub")
public class PubController {

	@Resource
	CommonUserService commonUserService;
	@Resource
	CommonBaseService commonBaseService;
	@Resource
	SystemUserService systemUserService;
	@Resource
	JwtHelper jwtHelper;
	@Resource
	TokenCache tokenCache;
	@Resource
	HttpServletRequest request;

	/**
	 * 登录
	 *
	 * @return 用户信息以及token信息
	 */
	@GetMapping("login")
	public APIResult<LoginUserInfo> login(String userName, String passWord) {
		if (userName == null || passWord == null) {
			return new APIResult<LoginUserInfo>(ResultCode.FAILURE.getCode(), "用户名和密码不能为空");
		}

		// 验证
		TAuthUser userInfo = commonUserService.geTAuthUser(userName, passWord);
		if (userInfo != null) {
			// 用户被锁定
			if (CommonUserService.USER_STATE_LOCKED.equals(userInfo.getIsUsed())) {
				return new APIResult<LoginUserInfo>(ResultCode.FAILURE.getCode(), "用户已禁用");
			}

			// 置空密码
			userInfo.setPassWord(null);
			LoginUserInfo loginUserInfo = new LoginUserInfo();
			loginUserInfo.setId(userInfo.getId());
			loginUserInfo.setUserName(userInfo.getLoginName());
			loginUserInfo.setUser(userInfo);

			Map<String, Object> tokenInfo = new HashMap<String, Object>();
			tokenInfo.put(CommonUserService.SESSION_NAME_USERINFO, userInfo.getLoginName());
			// 生成token
			String token = jwtHelper.createJWT(tokenInfo);
			loginUserInfo.setToken(token);

			// 菜单功能点
			loginUserInfo.setMfTreeVo(commonBaseService.getUserMF(String.valueOf(userInfo.getId()), "1"));
			// 列表权限-带功能点
			loginUserInfo.setMfListVO(systemUserService.getUserMf(String.valueOf(userInfo.getId()), null));

			// token以及用户信息放入缓存中
			tokenCache.put(token, loginUserInfo);

			return new APIResult<LoginUserInfo>(loginUserInfo);
		} else {
			return new APIResult<LoginUserInfo>(ResultCode.FAILURE.getCode(), "用户名或密码错误");
		}
	}

	/**
	 * 登出
	 */
	@PostMapping("logout")
	public APIResult<String> logout(@RequestParam(required = false) String token) {
		tokenCache.remove(token);
		return new APIResult<String>();
	}

	/**
	 * 验证码
	 *
	 * @param request
	 * @param response
	 * @return 验证码
	 */
	@RequestMapping("kaptcha")
	public void kaptcha(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");

		// 验证码配置
		DefaultKaptcha captchaProducer = new DefaultKaptcha();
		Properties properties = new Properties();
		properties.setProperty("kaptcha.border", "no");// 是否有border
		properties.setProperty("kaptcha.textproducer.font.color", "blue");// 颜色
		properties.setProperty("kaptcha.image.width", "125");// 宽度
		properties.setProperty("kaptcha.image.height", "45");// 高度
		properties.setProperty("kaptcha.textproducer.font.size", "45");// 字体大小
		properties.setProperty("kaptcha.session.key", "code");// session key
		properties.setProperty("kaptcha.textproducer.char.length", "4");// 长度
		properties.setProperty("kaptcha.textproducer.char.string", "0123456789");// 内容：全为数字
		properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");// 字体
		properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");// 无干扰线
		Config config = new Config(properties);
		captchaProducer.setConfig(config);
		String capText = captchaProducer.createText();
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		try {
			BufferedImage bi = captchaProducer.createImage(capText);
			ServletOutputStream out;
			out = response.getOutputStream();
			ImageIO.write(bi, "jpg", out);
			try {
				out.flush();
			} finally {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
