package cn.com.sinosoft.bomsmgr.api.base;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosoft.bomsmgr.entity.ge.TBaseDics;
import cn.com.sinosoft.bomsmgr.model.base.MFTreeVO;
import cn.com.sinosoft.bomsmgr.model.common.LoginUserInfo;
import cn.com.sinosoft.bomsmgr.service.common.CommonBaseService;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.bomsmgr.service.system.user.SystemUserService;
import cn.com.sinosoft.tbf.domain.common.APIResult;
import cn.com.sinosoft.tbf.domain.common.ResultCode;

/**
 * 基础控制器
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年5月2日
 */
@RestController
@RequestMapping("/api/base")
public class BaseController {

	@Resource
	CommonUserService commonUserService;
	@Resource
	SystemUserService systemUserService;
	@Resource
	CommonBaseService commonBaseService;

	/**
	 * 获取我的菜单
	 *
	 * @return
	 */
	@GetMapping("getMyMenus")
	public APIResult<MFTreeVO> getList() {
		LoginUserInfo info = commonUserService.getRequestUser();
		return new APIResult<MFTreeVO>(info == null ? null : info.getMfTreeVo());
	}

	/**
	 * 获取登录用户id
	 *
	 * @return
	 */
	@GetMapping("getUserId")
	public APIResult<String> getUserId() {
		LoginUserInfo info = commonUserService.getRequestUser();
		return new APIResult<String>(info.getUser().getId());
	}

	/**
	 * 验证用户名和密码
	 *
	 * @return
	 */
	@GetMapping("validUserPwd")
	public APIResult<Boolean> validUserPwd(String userName, String userPwd) {
		boolean flag = commonUserService.validUser(userName, userPwd);
		return new APIResult<Boolean>(flag);
	}

	/**
	 * 修改登录用户自己密码
	 *
	 * @param srcPwd
	 *            原始密码
	 * @param newPwd
	 *            新密码
	 * @return
	 */
	@PostMapping("changSelfPwd")
	public APIResult<Boolean> changSelfPwd(@RequestParam(required = true) String srcPwd,
			@RequestParam(required = true) String newPwd) {
		boolean ret = systemUserService.changeSelfPwd(srcPwd, newPwd);
		if (ret == true) {
			return new APIResult<Boolean>(ResultCode.SUCCESS.getCode(), "密码修改成功", ret);
		} else {
			return new APIResult<Boolean>(ResultCode.FAILURE.getCode(), "原始密码错误，修改失败", ret);
		}
	}

	/**
	 * 获取初始化码表-可用
	 *
	 * @return
	 */
	@GetMapping("getInitCodes")
	public APIResult<List<List<TBaseDics>>> getInitCodes(String[] type) {
		return new APIResult<List<List<TBaseDics>>>(commonBaseService.getInitCodes(type));
	}

	/**
	 * 获取某类型码表-可用
	 *
	 * @return
	 */
	@GetMapping("getTypeCodes")
	public APIResult<List<TBaseDics>> getTypeCodes(String type) {
		if ("business.type".equals(type)) {// 不缓存-商家行业分类
			return new APIResult<List<TBaseDics>>(commonBaseService.getTypeCodeNotCache(type));
		} else {// 带缓存
			return new APIResult<List<TBaseDics>>(commonBaseService.getTypeCode(type));
		}
	}

}
