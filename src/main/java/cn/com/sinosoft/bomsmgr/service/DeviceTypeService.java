package cn.com.sinosoft.bomsmgr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sinosoft.bomsmgr.dao.ge.TBizDeviceTypeMapper;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceType;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.tbf.dao.BaseDao;

/**
 * 设备类型服务
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月14日
 */
@Service
public class DeviceTypeService {

	public static final String NAMESPACE_BASE = "cn.com.sinosoft.devicetype.";

	@Resource
	BaseDao baseDao;
	@Resource
	CommonUserService commonUserService;

	/**
	 * 获取所有
	 *
	 * @return
	 */
	public List<Map<String, Object>> getList(Map<String, Object> params) {
		return baseDao.queryList(NAMESPACE_BASE + "get-list", params);
	}

	/**
	 * 添加
	 *
	 * @param item
	 *            信息
	 * @return 详情
	 */
	@Transactional
	public void add(TBizDeviceType item) {
		item.setCreateUser(commonUserService.getRequestUserId());
		getMapper().insertSelective(item);
	}

	/**
	 * 更新
	 *
	 * @param item
	 *            信息
	 * @return 影响条数
	 */
	@Transactional
	public int update(TBizDeviceType item) {
		return getMapper().updateByPrimaryKeySelective(item);
	}

	/**
	 * 删除
	 *
	 * @param ids
	 *            id列表（以,隔开）
	 * @return 记录条数
	 */
	@Transactional
	public int del(Integer[] ids) {
		if (ids == null || ids.length == 0)
			return 0;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ids", ids);
		return baseDao.delete(NAMESPACE_BASE + "del", params);
	}

	/**
	 * 启用
	 *
	 * @param ids
	 *            id列表（以,隔开）
	 * @return 记录条数
	 */
	@Transactional
	public int enable(Integer[] ids) {
		return changeState(ids, "01");
	}

	/**
	 * 禁用
	 *
	 * @param ids
	 *            id列表（以,隔开）
	 * @return 记录条数
	 */
	@Transactional
	public int disable(Integer[] ids) {
		return changeState(ids, "02");
	}

	/**
	 * 修改状态
	 */
	@Transactional
	private int changeState(Integer[] ids, String state) {
		if (ids == null || ids.length == 0)
			return 0;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("state", state);
		params.put("ids", ids);
		return baseDao.delete(NAMESPACE_BASE + "change-state", params);
	}

	/**
	 * 获取mapper
	 *
	 * @return
	 */
	private TBizDeviceTypeMapper getMapper() {
		return baseDao.getMapper(TBizDeviceTypeMapper.class);
	}

}
