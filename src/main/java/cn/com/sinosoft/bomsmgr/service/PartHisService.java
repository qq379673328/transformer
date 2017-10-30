package cn.com.sinosoft.bomsmgr.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sinosoft.bomsmgr.dao.BizExtMapper;
import cn.com.sinosoft.bomsmgr.dao.ge.TBizPartHisMapper;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizPartHis;
import cn.com.sinosoft.bomsmgr.model.biz.PartHisInfo;
import cn.com.sinosoft.bomsmgr.model.dic.DicVerifyStatus;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.tbf.dao.BaseDao;
import cn.com.sinosoft.tbf.domain.common.PageParam;
import cn.com.sinosoft.tbf.domain.common.PagingResult;

/**
 * 部件历史记录服务
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月14日
 */
@Service
public class PartHisService {

	public static final String NAMESPACE_BASE = "cn.com.sinosoft.parthis.";

	@Resource
	BaseDao baseDao;
	@Resource
	CommonUserService commonUserService;

	/**
	 * 获取所有
	 *
	 * @return
	 */
	public PagingResult<PartHisInfo> getList(Map<String, Object> params, PageParam pageParam) {
		PagingResult<PartHisInfo> ret = baseDao.pagingSearch(NAMESPACE_BASE + "get-list", params, pageParam);
		return ret;
	}

	/**
	 * 添加
	 *
	 * @param item
	 *            信息
	 * @return 详情
	 */
	@Transactional
	public void add(TBizPartHis item) {
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
	public void update(TBizPartHis item) {
		updateVerifyStatusReady(item.getId());
		getMapper().updateByPrimaryKeySelective(item);
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
		TBizPartHis item = new TBizPartHis();
		item.setId(id);
		item.setVerifyStatus(DicVerifyStatus.READY.getCode());
		item.setVerifyTime(null);
		item.setVerifyUser(null);
		item.setVerifyContent(null);
		getBizExtMapper().verifyPartHis(item);
	}

	/**
	 * 更新审核状态-通过
	 *
	 * @param id
	 *            对象id
	 */
	public void updateVerifyStatusPass(Integer id, String content) {
		TBizPartHis item = new TBizPartHis();
		item.setId(id);
		item.setVerifyStatus(DicVerifyStatus.PASS.getCode());
		item.setVerifyTime(new Date());
		item.setVerifyUser(commonUserService.getRequestUserId());
		item.setVerifyContent(content);
		getBizExtMapper().verifyPartHis(item);
	}

	/**
	 * 更新审核状态-未通过
	 *
	 * @param id
	 *            对象id
	 */
	public void updateVerifyStatusFail(Integer id, String content) {
		TBizPartHis item = new TBizPartHis();
		item.setId(id);
		item.setVerifyStatus(DicVerifyStatus.FAIL.getCode());
		item.setVerifyTime(new Date());
		item.setVerifyUser(commonUserService.getRequestUserId());
		item.setVerifyContent(content);
		getBizExtMapper().verifyPartHis(item);
	}

	/**
	 * 获取mapper
	 *
	 * @return
	 */
	private TBizPartHisMapper getMapper() {
		return baseDao.getMapper(TBizPartHisMapper.class);
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
