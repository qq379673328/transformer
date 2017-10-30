package cn.com.sinosoft.bomsmgr.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sinosoft.bomsmgr.dao.ge.TSystemConfigMapper;
import cn.com.sinosoft.bomsmgr.entity.ge.TSystemConfig;
import cn.com.sinosoft.bomsmgr.model.biz.SystemConfigInfo;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.tbf.dao.BaseDao;

/**
 * 系统配置服务
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月14日
 */
@Service
public class SystemConfigService {

	public static final String NAMESPACE_BASE = "cn.com.sinosoft.systemconfig.";

	@Resource
	BaseDao baseDao;
	@Resource
	CommonUserService commonUserService;

	/**
	 * 获取所有
	 *
	 * @return
	 */
	public List<SystemConfigInfo> getList(Map<String, Object> params) {
		return baseDao.queryList(NAMESPACE_BASE + "get-list", params);
	}

	/**
	 * 更新
	 *
	 * @param item
	 *            信息
	 * @return 影响条数
	 */
	@Transactional
	public int update(TSystemConfig item) {
		item.setUpdateTime(new Date());
		item.setUpdateUser(commonUserService.getRequestUserId());
		return getMapper().updateByPrimaryKeySelective(item);
	}

	/**
	 * 获取mapper
	 *
	 * @return
	 */
	private TSystemConfigMapper getMapper() {
		return baseDao.getMapper(TSystemConfigMapper.class);
	}

}
