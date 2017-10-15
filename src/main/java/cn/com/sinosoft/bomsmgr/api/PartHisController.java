package cn.com.sinosoft.bomsmgr.api;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizPartHis;
import cn.com.sinosoft.bomsmgr.model.biz.PartHisInfo;
import cn.com.sinosoft.bomsmgr.service.PartHisService;
import cn.com.sinosoft.tbf.domain.common.APIResult;
import cn.com.sinosoft.tbf.domain.common.PageParam;
import cn.com.sinosoft.tbf.domain.common.PagingResult;

/**
 * 部件历史信息api
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年4月21日
 */
@RestController
@RequestMapping("/api/parthis")
public class PartHisController {

	@Resource
	PartHisService service;

	/**
	 * 列表
	 *
	 * @return
	 */
	@GetMapping("list")
	public APIResult<PagingResult<PartHisInfo>> getList(@RequestParam Map<String, Object> params, PageParam pageParam) {
		return new APIResult<PagingResult<PartHisInfo>>(service.getList(params, pageParam));
	}
	
	/**
	 * 添加
	 *
	 * @param item
	 *            信息
	 * @return
	 */
	@PostMapping("add")
	public APIResult<Object> add(TBizPartHis item) {
		service.add(item);
		return new APIResult<Object>();
	}

	/**
	 * 编辑
	 *
	 * @param item
	 *            信息
	 * @return
	 */
	@PostMapping("edit")
	public APIResult<Object> edit(TBizPartHis item) {
		service.update(item);
		return new APIResult<>();
	}

	/**
	 * 删除
	 *
	 * @param ids
	 *            id列表（以,隔开）
	 * @return 影响数据条数
	 */
	@PostMapping("del")
	public APIResult<Integer> del(@RequestParam(required = true) Integer[] ids) {
		return new APIResult<Integer>(service.del(ids), "删除成功", true);
	}

}
