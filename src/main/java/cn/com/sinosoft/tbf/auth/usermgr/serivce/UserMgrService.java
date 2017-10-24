package cn.com.sinosoft.tbf.auth.usermgr.serivce;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sinosoft.bomsmgr.dao.ge.TAuthUrMapper;
import cn.com.sinosoft.bomsmgr.dao.ge.TAuthUserMapper;
import cn.com.sinosoft.bomsmgr.entity.ge.TAuthUr;
import cn.com.sinosoft.bomsmgr.entity.ge.TAuthUrExample;
import cn.com.sinosoft.bomsmgr.entity.ge.TAuthUser;
import cn.com.sinosoft.bomsmgr.entity.ge.TAuthUserExample;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.tbf.common.ServiceException;
import cn.com.sinosoft.tbf.common.util.StrUtils;
import cn.com.sinosoft.tbf.common.util.security.MD5Util;
import cn.com.sinosoft.tbf.dao.BaseDao;
import cn.com.sinosoft.tbf.domain.common.PageParam;
import cn.com.sinosoft.tbf.domain.common.PagingResult;

/**
 * @ClassName: UserMgrService
 * @Description: 用户管理
 * @author WHN
 * @date 2016年6月6日 上午11:49:24
 */

@Service
public class UserMgrService {

	public static final String NAMESPACE_BASE = "cn.com.sinosoft.common.user.";

	@Resource
	BaseDao baseDao;
	@Resource
	CommonUserService commonUserService;

	/**
	 * 获取列表
	 *
	 * @param searchParams
	 *            查询参数
	 * @param pageParam
	 *            分页参数
	 * @return 列表
	 */
	public PagingResult<List<TAuthUser>> getList(Map<String, String> searchParams, PageParam pageParam) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("params", searchParams);
		PagingResult<List<TAuthUser>> result = baseDao.pagingSearch(NAMESPACE_BASE + "list", params, pageParam);
		return result;
	}

	/**
	 * 登录名是否存在
	 *
	 * @param loginName
	 * @return
	 */
	private boolean isLoginNameExist(String loginName) {
		TAuthUserExample ex = new TAuthUserExample();
		ex.createCriteria().andLoginNameEqualTo(loginName);
		List<TAuthUser> users = getUserMapper().selectByExample(ex);
		return users.size() > 0 ? true : false;
	}

	/**
	 * 编辑用户信息
	 *
	 * @param role
	 * @return
	 */
	@Transactional
	public void editUser(TAuthUser user) {
		if (StrUtils.isNull(user.getId())) {// 新增
			user.setPassWord(CommonUserService.USER_PWD_DEFAULT);
			if (isLoginNameExist(user.getLoginName())) {
				throw new ServiceException("登录名已存在");
			}
			user.setCreateUser(commonUserService.getRequestUserId());
			user.setCreateTime(new Date());
			user.setPassWord(MD5Util.digestMD5(user.getPassWord()));
			getUserMapper().insert(user);
		} else {// 更新
			user.setUpdateTime(new Date());
			user.setUpdateUser(commonUserService.getRequestUserId());
			getUserMapper().updateByPrimaryKeySelective(user);
		}
	}

	/**
	 * 删除用户
	 *
	 * @param ids
	 * @return
	 */
	@Transactional
	public void delUser(Integer id) {

		// 删除用户
		getUserMapper().deleteByPrimaryKey(id);

		// 删除用户与角色关联
		delUserRolesById(id);
	}

	/**
	 * 删除用户与角色关联信息
	 *
	 * @param userId
	 */
	@Transactional
	public void delUserRolesById(Integer userId) {
		TAuthUrExample ex = new TAuthUrExample();
		ex.createCriteria().andUserIdEqualTo(userId);
		getUrMapper().deleteByExample(ex);
	}

	/**
	 * 禁用用户
	 *
	 * @param id
	 * @return
	 */
	@Transactional
	public void disableUser(Integer id) {
		TAuthUser user = new TAuthUser();
		user.setId(id);
		user.setIsUsed("02");
		getUserMapper().updateByPrimaryKeySelective(user);
	}

	/**
	 * 启用用户
	 *
	 * @param ids
	 * @return
	 */
	@Transactional
	public void enableUser(Integer id) {
		TAuthUser user = new TAuthUser();
		user.setId(id);
		user.setIsUsed("01");
		getUserMapper().updateByPrimaryKeySelective(user);
	}

	/**
	 * 重置用户密码
	 *
	 * @param id
	 * @return 重置之后密码
	 */
	@Transactional
	public String resetPwd(Integer id) {
		String pwdDefault = CommonUserService.USER_PWD_DEFAULT;
		TAuthUser user = new TAuthUser();
		user.setId(id);
		user.setPassWord(MD5Util.digestMD5(pwdDefault));
		getUserMapper().updateByPrimaryKeySelective(user);
		return pwdDefault;
	}

	/**
	 * 批量分配：为用户分配角色
	 *
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	@Transactional
	public void setRole(Integer userId, String roleIds) {
		// 删除用户旧的角色信息
		delUserRolesById(userId);

		// 添加新的角色信息
		for (String item : StrUtils.sepStrToArray(roleIds, "&")) {
			TAuthUr ur = new TAuthUr();
			ur.setCreateUser(commonUserService.getRequestUserId());
			ur.setUserId(userId);
			ur.setRoleId(Integer.valueOf(item));
			getUrMapper().insert(ur);
		}
	}

	/**
	 * 为用户分配角色
	 *
	 * @param userId
	 *            用户id
	 * @param ids
	 *            角色ids
	 */
	@Transactional
	public void setUserRoles(Integer userId, String[] ids) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("ids", ids);
		// 删除用户角色
		delUserRolesById(userId);
		// 重新分配权限
		baseDao.update(NAMESPACE_BASE + "user-role-set", params);

	}

	/**
	 * 获取mapper
	 *
	 * @return mapper
	 */
	private TAuthUserMapper getUserMapper() {
		return baseDao.getMapper(TAuthUserMapper.class);
	}
	private TAuthUrMapper getUrMapper() {
		return baseDao.getMapper(TAuthUrMapper.class);
	}

}
