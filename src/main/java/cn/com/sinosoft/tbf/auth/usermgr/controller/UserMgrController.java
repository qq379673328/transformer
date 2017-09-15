package cn.com.sinosoft.tbf.auth.usermgr.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosoft.bomsmgr.entity.ge.TAuthUser;
import cn.com.sinosoft.tbf.auth.usermgr.serivce.UserMgrService;
import cn.com.sinosoft.tbf.domain.common.APIResult;
import cn.com.sinosoft.tbf.domain.common.PageParam;
import cn.com.sinosoft.tbf.domain.common.PagingResult;

/**
 * @ClassName: UserMgrController
 * @Description: 用户管理
 * @author WHN
 * @date 2016年6月6日 上午11:50:09
 */
@RestController
@RequestMapping("auth/usermgr")
public class UserMgrController {

	@Resource
	UserMgrService userMgrService;

	/**
	 * 列表
	 *
	 * @param searchParams
	 *            查询参数
	 * @param pageParam
	 *            分页参数
	 * @return
	 */
	@GetMapping("list")
	@ResponseBody
	public APIResult<PagingResult<List<TAuthUser>>> getList(Map<String, String> searchParams,
			PageParam pageParam) {
		PagingResult<List<TAuthUser>> result = userMgrService.getList(searchParams, pageParam);
		return new APIResult<PagingResult<List<TAuthUser>>>(result);
	}

	/**
	 * 编辑用户信息
	 *
	 * @param role
	 * @return
	 */
	@PostMapping("edit")
	public APIResult<String> editUser(TAuthUser user) {
		userMgrService.editUser(user);
		return new APIResult<String>(null, "操作成功", true);
	}

	/**
	 * 删除用户
	 *
	 *
	 * @param ids
	 * @return
	 *
	 */
	@PostMapping("del")
	public APIResult<String> delUser(String id) {
		userMgrService.delUser(id);
		return new APIResult<String>(null, "删除成功", true);
	}

	/**
	 * 禁用用户
	 *
	 * @param ids
	 * @return
	 */
	@PostMapping("disable")
	public APIResult<String> disableUser(String id) {
		userMgrService.disableUser(id);
		return new APIResult<String>(null, "禁用成功", true);
	}

	/**
	 * 启用用户
	 *
	 * @param ids
	 * @return
	 */
	@PostMapping("enable")
	public APIResult<String> enableUser(String id) {
		userMgrService.enableUser(id);
		return new APIResult<String>(null, "启用成功", true);
	}

	/**
	 * 重置用户密码
	 *
	 * @param userId
	 * @return
	 */
	@PostMapping("resetPwd")
	public APIResult<String> resetPwd(String ids) {
		String pwd = userMgrService.resetPwd(ids);
		return new APIResult<String>(null, "密码重置为 " + pwd, true);
	}

	/**
	 * 为用户分配角色
	 *
	 * @param userId
	 * @param ids
	 * @return
	 */
	@PostMapping("setRole")
	public APIResult<String> setRole(String userId, String roleIds) {
		userMgrService.setRole(userId, roleIds);
		return new APIResult<String>(null, "角色分配成功", true);
	}

}
