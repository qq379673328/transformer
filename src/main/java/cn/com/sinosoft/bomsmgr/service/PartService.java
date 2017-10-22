package cn.com.sinosoft.bomsmgr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sinosoft.bomsmgr.dao.ge.TBizPartMapper;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizPart;
import cn.com.sinosoft.bomsmgr.model.biz.ItemXyWh;
import cn.com.sinosoft.bomsmgr.model.biz.PartInfo;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.tbf.dao.BaseDao;

/**
 * 部件服务
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月14日
 */
@Service
public class PartService {

	public static final String NAMESPACE_BASE = "cn.com.sinosoft.part.";

	@Resource
	BaseDao baseDao;
	@Resource
	CommonUserService commonUserService;

	/**
	 * 获取所有
	 *
	 * @return
	 */
	public List<PartInfo> getList(Map<String, Object> params) {
		return baseDao.queryList(NAMESPACE_BASE + "get-list", params);
	}
	
	/**
	 * 根据id获取
	 *
	 * @param id
	 * @return
	 */
	public PartInfo getById(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		List<PartInfo> items = getList(params);
		return items.size() > 0 ? items.get(0) : null;
	}

	/**
	 * 添加
	 *
	 * @param item
	 *            信息
	 * @return 详情
	 */
	@Transactional
	public PartInfo add(TBizPart item) {
		item.setCreateUser(commonUserService.getRequestUserId());
		getMapper().insertSelective(item);
		
		return getById(item.getId());
	}

	/**
	 * 更新
	 *
	 * @param item
	 *            信息
	 * @return 影响条数
	 */
	@Transactional
	public PartInfo update(TBizPart item) {
		getMapper().updateByPrimaryKeySelective(item);
		return getById(item.getId());
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
	 * 更新位置大小信息
	 *
	 * @param items
	 *            数据列表
	 * @return 记录条数
	 */
	@Transactional
	public int updateXyWh(List<ItemXyWh> items) {
		if (items == null || items.size() == 0)
			return 0;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("items", items);
		return baseDao.delete(NAMESPACE_BASE + "updateXyWh", params);
	}

	/**
	 * 获取mapper
	 *
	 * @return
	 */
	private TBizPartMapper getMapper() {
		return baseDao.getMapper(TBizPartMapper.class);
	}

}
