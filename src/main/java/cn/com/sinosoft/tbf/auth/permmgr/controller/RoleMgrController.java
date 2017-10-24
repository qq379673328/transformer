package cn.com.sinosoft.tbf.auth.permmgr.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosoft.bomsmgr.entity.ge.TAuthRole;
import cn.com.sinosoft.tbf.auth.permmgr.serivce.RoleMgrService;
import cn.com.sinosoft.tbf.common.util.excel.ExportExcelUtil;
import cn.com.sinosoft.tbf.domain.common.APIResult;
import cn.com.sinosoft.tbf.domain.common.PageParam;
import cn.com.sinosoft.tbf.domain.common.PagingResult;

/**
 * @ClassName: RoleMgrController
 * @Description: 角色管理
 * @author WHN
 * @date 2016年6月12日 上午9:59:23
 */

@RestController
@RequestMapping("auth/rolemgr")
public class RoleMgrController {

	@Resource
	RoleMgrService roleMgrService;
	@Resource
	ExportExcelUtil exportExcelUtil;

	/**
	 * 获取角色管理列表
	 *
	 * @param params
	 * @param page
	 * @return
	 */
	@GetMapping("list")
	public APIResult<PagingResult<List<Map<String, Object>>>> getList(Map<String, String> searchParams,
			PageParam pageParam) {
		PagingResult<List<Map<String, Object>>> result = roleMgrService.getList(searchParams, pageParam);
		return new APIResult<PagingResult<List<Map<String, Object>>>>(result);
	}

	/**
	 * 编辑角色信息
	 *
	 * @param role
	 * @return
	 */
	@PostMapping("edit")
	public APIResult<String> editRole(TAuthRole role) {
		roleMgrService.editRole(role);
		return new APIResult<String>(null, "操作成功", true);
	}

	/**
	 * 删除角色
	 *
	 * @param ids
	 * @return
	 */
	@PostMapping("del")
	public APIResult<String> delRole(Integer ids) {
		roleMgrService.delRole(ids);
		return new APIResult<String>(null, "操作成功", true);
	}

	/**
	 * 为角色分配权限-获取权限树
	 *
	 * @param roleId
	 * @return
	 */
	@GetMapping("getPermsAll")
	public Object getPermsAll(String roleId) {
		return roleMgrService.getPermsAll(roleId);
	}

	/**
	 * 获取用户角色
	 *
	 * @param roleId
	 * @return
	 */
	@PostMapping("getRolesByUserId")
	public List<Map<String, Object>> getRolesByUserId(String userId) {
		return roleMgrService.getRolesByUserId(userId);
	}

	/**
	 * 为角色分配权限
	 *
	 * @param roleId
	 * @return
	 */
	@PostMapping("setPerms")
	public APIResult<String> setPerms(String roleId, String ids) {
		String[] idsSplit = ids == null ? new String[]{} : ids.split("&");
		roleMgrService.setPerms(roleId, idsSplit);
		return new APIResult<String>(null, "操作成功", true);
	}

}
