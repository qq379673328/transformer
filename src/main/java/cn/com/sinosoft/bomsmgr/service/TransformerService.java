package cn.com.sinosoft.bomsmgr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sinosoft.bomsmgr.dao.ge.TBizTransformerMapper;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizTransformer;
import cn.com.sinosoft.bomsmgr.model.biz.TransformerDetail;
import cn.com.sinosoft.bomsmgr.model.biz.TransformerInfo;
import cn.com.sinosoft.bomsmgr.model.dic.DicVerifyStatus;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.tbf.dao.BaseDao;

/**
 * 变压器服务
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月14日
 */
@Service
public class TransformerService {

	public static final String NAMESPACE_BASE = "cn.com.sinosoft.transformer.";

	@Resource
	BaseDao baseDao;
	@Resource
	CommonUserService commonUserService;
	@Resource
	WiringdiagramService wiringdiagramService;

	/**
	 * 获取所有变压器
	 *
	 * @return
	 */
	public List<TransformerInfo> getList(Map<String, Object> params) {
		return baseDao.queryList(NAMESPACE_BASE + "get-list", params);
	}

	/**
	 * 根据id获取
	 *
	 * @param id
	 * @return
	 */
	public TransformerInfo getById(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		List<TransformerInfo> items = getList(params);
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
	public void add(TBizTransformer item) {
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
	public int update(TBizTransformer item) {
		TBizTransformer newItem = new TBizTransformer();
		try {
			PropertyUtils.copyProperties(newItem, item);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return getMapper().updateByPrimaryKeySelective(newItem);
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
	 * 根据变电站id获取变电站详情
	 *
	 * @param id
	 * @param isView
	 * @return
	 */
	public TransformerDetail getDetailById(Integer id, Boolean isView) {
		TransformerDetail detail = new TransformerDetail();
		detail.setTransformer(getById(id));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("transformerId", id);

		if(isView){// 查询-过滤审核通过
			params.put("verifyStatus", DicVerifyStatus.PASS.getCode());
		}

		// 接线图信息
		detail.setWiringdiagrams(wiringdiagramService.getList(params));
		return detail;
	}

	/**
	 * 获取mapper
	 *
	 * @return
	 */
	private TBizTransformerMapper getMapper() {
		return baseDao.getMapper(TBizTransformerMapper.class);
	}

}
