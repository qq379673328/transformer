package cn.com.sinosoft.bomsmgr.api;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizDevice;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizPart;
import cn.com.sinosoft.bomsmgr.model.biz.DeviceInfo;
import cn.com.sinosoft.bomsmgr.model.biz.PartInfo;
import cn.com.sinosoft.bomsmgr.service.DeviceService;
import cn.com.sinosoft.bomsmgr.service.PartService;
import cn.com.sinosoft.tbf.domain.common.APIResult;

/**
 * 部件api
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年4月21日
 */
@RestController
@RequestMapping("/api/part")
public class PartController {

	@Resource
	PartService service;

	/**
	 * 列表
	 *
	 * @return
	 */
	@GetMapping("list")
	public APIResult<List<PartInfo>> getList(@RequestParam Map<String, Object> params) {
		return new APIResult<List<PartInfo>>(service.getList(params));
	}

	/**
	 * 添加
	 *
	 * @param item
	 *            信息
	 * @return
	 */
	@PostMapping("add")
	public APIResult<PartInfo> add(TBizPart item) {
		return new APIResult<PartInfo>(service.add(item));
	}

	/**
	 * 编辑
	 *
	 * @param item
	 *            信息
	 * @return
	 */
	@PostMapping("edit")
	public APIResult<PartInfo> edit(TBizPart item) {
		return new APIResult<PartInfo>(service.update(item));
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
