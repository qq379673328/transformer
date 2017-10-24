package cn.com.sinosoft.bomsmgr.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sinosoft.bomsmgr.dao.BizExtMapper;
import cn.com.sinosoft.bomsmgr.dao.ge.TBizDeviceImgMapper;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceImg;
import cn.com.sinosoft.bomsmgr.model.biz.DeviceImgDetail;
import cn.com.sinosoft.bomsmgr.model.biz.DeviceImgInfo;
import cn.com.sinosoft.bomsmgr.model.dic.DicVerifyStatus;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.tbf.dao.BaseDao;

/**
 * 设备图服务
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月14日
 */
@Service
public class DeviceImgService {

	public static final String NAMESPACE_BASE = "cn.com.sinosoft.deviceimg.";

	@Resource
	BaseDao baseDao;
	@Resource
	CommonUserService commonUserService;
	@Resource
	PartService partService;

	/**
	 * 获取所有
	 *
	 * @return
	 */
	public List<DeviceImgInfo> getList(Map<String, Object> params) {
		return baseDao.queryList(NAMESPACE_BASE + "get-list", params);
	}

	/**
	 * 根据id获取
	 *
	 * @param id
	 * @return
	 */
	public DeviceImgInfo getById(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		List<DeviceImgInfo> items = getList(params);
		return items.size() > 0 ? items.get(0) : null;
	}

	/**
	 * 根据设备图id获取设备图详情
	 *
	 * @param id
	 * @return
	 */
	public DeviceImgDetail getDetailById(Integer id) {
		DeviceImgDetail detail = new DeviceImgDetail();
		detail.setDeviceImg(getById(id));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deviceId", id);
		detail.setPartInfos(partService.getList(params));
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
	public void add(TBizDeviceImg item) {
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
	public int update(TBizDeviceImg item) {
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
	 * 更新审核状态-待审核
	 *
	 * @param id
	 *            对象id
	 */
	public void updateVerifyStatusReady(Integer id) {
		TBizDeviceImg item = new TBizDeviceImg();
		item.setId(id);
		item.setVerifyStatus(DicVerifyStatus.READY.getCode());
		item.setVerifyTime(null);
		item.setVerifyUser(null);
		item.setVerifyContent(null);
		getBizExtMapper().verifyDeviceImg(item);
	}

	/**
	 * 更新审核状态-通过
	 *
	 * @param id
	 *            对象id
	 */
	public void updateVerifyStatusPass(Integer id, String content) {
		TBizDeviceImg item = new TBizDeviceImg();
		item.setId(id);
		item.setVerifyStatus(DicVerifyStatus.PASS.getCode());
		item.setVerifyTime(new Date());
		item.setVerifyUser(commonUserService.getRequestUserId());
		item.setVerifyContent(content);
		getBizExtMapper().verifyDeviceImg(item);
	}

	/**
	 * 更新审核状态-未通过
	 *
	 * @param id
	 *            对象id
	 */
	public void updateVerifyStatusFail(Integer id, String content) {
		TBizDeviceImg item = new TBizDeviceImg();
		item.setId(id);
		item.setVerifyStatus(DicVerifyStatus.FAIL.getCode());
		item.setVerifyTime(new Date());
		item.setVerifyUser(commonUserService.getRequestUserId());
		item.setVerifyContent(content);
		getBizExtMapper().verifyDeviceImg(item);
	}

	/**
	 * 获取mapper
	 *
	 * @return
	 */
	private TBizDeviceImgMapper getMapper() {
		return baseDao.getMapper(TBizDeviceImgMapper.class);
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
