package cn.com.sinosoft.bomsmgr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sinosoft.bomsmgr.dao.ge.TBizDeviceMapper;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizDevice;
import cn.com.sinosoft.bomsmgr.model.biz.DeviceDetail;
import cn.com.sinosoft.bomsmgr.model.biz.DeviceInfo;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.tbf.dao.BaseDao;

/**
 * 设备服务
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月14日
 */
@Service
public class DeviceService {

	public static final String NAMESPACE_BASE = "cn.com.sinosoft.device.";

	@Resource
	BaseDao baseDao;
	@Resource
	CommonUserService commonUserService;
	@Resource
	DeviceImgService deviceImgService;

	/**
	 * 获取所有
	 *
	 * @return
	 */
	public List<DeviceInfo> getList(Map<String, Object> params) {
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
	public DeviceInfo add(TBizDevice item) {
		item.setCreateUser(commonUserService.getRequestUserId());
		getMapper().insertSelective(item);

		return getById(item.getId());
	}

	/**
	 * 根据id获取信息
	 *
	 * @param id
	 * @return
	 */
	public DeviceInfo getById(Integer id){
		if(id == null) return null;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		List<DeviceInfo> infos = getList(params);
		return infos.size() > 0 ? infos.get(0) : null;
	}
	
	/**
	 * 根据设备id获取设备详情
	 *
	 * @param id
	 * @return
	 */
	public DeviceDetail getDetailById(Integer id) {
		DeviceDetail detail = new DeviceDetail();
		detail.setDevice(getById(id));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deviceId", id);
		detail.setDeviceImgs(deviceImgService.getList(params));
		return detail;
	}

	/**
	 * 更新
	 *
	 * @param item
	 *            信息
	 * @return 影响条数
	 */
	@Transactional
	public DeviceInfo update(TBizDevice item) {
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
	 * 获取mapper
	 *
	 * @return
	 */
	private TBizDeviceMapper getMapper() {
		return baseDao.getMapper(TBizDeviceMapper.class);
	}

}
