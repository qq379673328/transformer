package cn.com.sinosoft.bomsmgr.api;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizWiringdiagram;
import cn.com.sinosoft.bomsmgr.model.biz.WiringdiagramDetail;
import cn.com.sinosoft.bomsmgr.model.biz.WiringdiagramInfo;
import cn.com.sinosoft.bomsmgr.service.WiringdiagramService;
import cn.com.sinosoft.tbf.domain.common.APIResult;

/**
 * 接线图api
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年4月21日
 */
@RestController
@RequestMapping("/api/wiringdiagram")
public class WiringdiagramController {

	@Resource
	WiringdiagramService service;

	/**
	 * 列表
	 *
	 * @return
	 */
	@GetMapping("list")
	public APIResult<List<WiringdiagramInfo>> getList(@RequestParam Map<String, Object> params) {
		return new APIResult<List<WiringdiagramInfo>>(service.getList(params));
	}

	/**
	 * 接线图详情
	 *
	 * @return
	 */
	@GetMapping("getDetailById/{id}")
	public APIResult<WiringdiagramDetail> getDetailById(@PathVariable Integer id) {
		return new APIResult<WiringdiagramDetail>(service.getDetailById(id));
	}

	/**
	 * 添加
	 *
	 * @param item
	 *            信息
	 * @return
	 */
	@PostMapping("add")
	public APIResult<Object> add(TBizWiringdiagram item) {
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
	public APIResult<Object> edit(TBizWiringdiagram item) {
		service.update(item);
		return new APIResult<Object>();
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
