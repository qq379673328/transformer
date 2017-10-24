package cn.com.sinosoft.tbf.auth.userinfo.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosoft.bomsmgr.entity.ge.TAuthUser;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.tbf.auth.userinfo.serivce.UserInfoService;
import cn.com.sinosoft.tbf.domain.common.APIResult;

/**
 * @author 郑俊鹏
 * @date 2015年7月20日
 */
@RestController
@RequestMapping("auth/userinfo")
public class UserInfoController {

	@Resource
	UserInfoService userInfoService;
	@Resource
	CommonUserService commonUserService;
	/**
	 * 获取用户个人信息
	 *
	 * @param
	 * @return
	 */
	@GetMapping("getUserInfo")
	public TAuthUser getUserInfo() {
		return userInfoService.getUserInfo();
	}
	/**
	 * 修改个人信息
	 *
	 * @param user
	 * @return
	 */
	@PostMapping("edit")
	public APIResult<String> editUser(TAuthUser user) {
		user.setId(commonUserService.getRequestUserIdInt());
		userInfoService.editUser(user);
		return new APIResult<String>(null, "修改成功", true);
	}
	/**
	 * 修改个人密码
	 *
	 * @param params
	 * @return
	 */
	@PostMapping("alterPwd")
	public APIResult<String> alterPwd(@RequestParam Map<String, String> params) {
		userInfoService.alterPwd(params);
		return new APIResult<String>(null, "修改成功", true);
	}
}
