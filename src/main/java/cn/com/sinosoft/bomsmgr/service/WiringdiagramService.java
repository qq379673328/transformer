package cn.com.sinosoft.bomsmgr.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sinosoft.bomsmgr.dao.BizExtMapper;
import cn.com.sinosoft.bomsmgr.dao.ge.TBizWiringdiagramMapper;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizWiringdiagram;
import cn.com.sinosoft.bomsmgr.model.biz.ItemXyWh;
import cn.com.sinosoft.bomsmgr.model.biz.WiringdiagramDetail;
import cn.com.sinosoft.bomsmgr.model.biz.WiringdiagramInfo;
import cn.com.sinosoft.bomsmgr.model.dic.DicVerifyStatus;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.tbf.dao.BaseDao;

/**
 * 接线图服务
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月14日
 */
@Service
public class WiringdiagramService {

	public static final String NAMESPACE_BASE = "cn.com.sinosoft.wiringdiagram.";

	@Resource
	BaseDao baseDao;
	@Resource
	CommonUserService commonUserService;
	@Resource
	DeviceService deviceService;

	/**
	 * 获取所有
	 *
	 * @return
	 */
	public List<WiringdiagramInfo> getList(Map<String, Object> params) {
		return baseDao.queryList(NAMESPACE_BASE + "get-list", params);
	}

	/**
	 * 根据id获取
	 *
	 * @param id
	 * @return
	 */
	public WiringdiagramInfo getById(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		List<WiringdiagramInfo> items = getList(params);
		return items.size() > 0 ? items.get(0) : null;
	}

	/**
	 * 根据接线图id获取接线图详情
	 *
	 * @param id
	 * @return
	 */
	public WiringdiagramDetail getDetailById(Integer id) {
		WiringdiagramDetail detail = new WiringdiagramDetail();
		detail.setWiringdiagram(getById(id));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("wiringdiagramId", id);
		detail.setDeviceInfos(deviceService.getList(params));
		return detail;
	}

	/**
	 * 添加
	 *
	 * @param item
	 *            信息
	 * @return 详情
	 */
	@Transactional
	public void add(TBizWiringdiagram item) {
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
	public int update(TBizWiringdiagram item) {
		updateVerifyStatusReady(item.getId());
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

		if (items != null && items.size() > 0) {
			updateVerifyStatusReady(deviceService.getById(items.get(0).getId()).getWiringdiagramId());
		}

		return baseDao.delete(NAMESPACE_BASE + "updateXyWh", params);
	}

	/**
	 * 更新审核状态-待审核
	 *
	 * @param id
	 *            对象id
	 */
	public void updateVerifyStatusReady(Integer id) {
		TBizWiringdiagram item = new TBizWiringdiagram();
		item.setId(id);
		item.setVerifyStatus(DicVerifyStatus.READY.getCode());
		item.setVerifyTime(null);
		item.setVerifyUser(null);
		item.setVerifyContent(null);
		getBizExtMapper().verifyWd(item);
	}

	/**
	 * 更新审核状态-通过
	 *
	 * @param id
	 *            对象id
	 */
	public void updateVerifyStatusPass(Integer id, String content) {
		TBizWiringdiagram item = new TBizWiringdiagram();
		item.setId(id);
		item.setVerifyStatus(DicVerifyStatus.PASS.getCode());
		item.setVerifyTime(new Date());
		item.setVerifyUser(commonUserService.getRequestUserId());
		item.setVerifyContent(content);
		getBizExtMapper().verifyWd(item);
	}

	/**
	 * 更新审核状态-未通过
	 *
	 * @param id
	 *            对象id
	 */
	public void updateVerifyStatusFail(Integer id, String content) {
		TBizWiringdiagram item = new TBizWiringdiagram();
		item.setId(id);
		item.setVerifyStatus(DicVerifyStatus.FAIL.getCode());
		item.setVerifyTime(new Date());
		item.setVerifyUser(commonUserService.getRequestUserId());
		item.setVerifyContent(content);
		getBizExtMapper().verifyWd(item);
	}

	/**
	 * 获取mapper
	 *
	 * @return
	 */
	private TBizWiringdiagramMapper getMapper() {
		return baseDao.getMapper(TBizWiringdiagramMapper.class);
	}

	/**
	 * 获取mapper
	 *
	 * @return
	 */
	private BizExtMapper getBizExtMapper() {
		return baseDao.getMapper(BizExtMapper.class);
	}

}
