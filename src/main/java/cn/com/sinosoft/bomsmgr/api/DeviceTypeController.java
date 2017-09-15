package cn.com.sinosoft.bomsmgr.api;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceType;
import cn.com.sinosoft.bomsmgr.service.DeviceTypeService;
import cn.com.sinosoft.tbf.domain.common.APIResult;

/**
 * 设备类型api
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年4月21日
 */
@RestController
@RequestMapping("/api/devicetype")
public class DeviceTypeController {

	@Resource
	DeviceTypeService service;

	/**
	 * 列表
	 *
	 * @return
	 */
	@GetMapping("list")
	public APIResult<List<Map<String, Object>>> getList(Map<String, Object> params) {
		return new APIResult<List<Map<String, Object>>>(service.getList(params));
	}

	/**
	 * 添加
	 *
	 * @param item
	 *            信息
	 * @return
	 */
	@PostMapping("add")
	public APIResult<Object> add(TBizDeviceType item) {
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
	public APIResult<Object> edit(TBizDeviceType item) {
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

	/**
	 * 启用
	 *
	 * @param ids
	 *            id列表（以,隔开）
	 * @return 影响数据条数
	 */
	@PostMapping("enable")
	public APIResult<Object> enable(@RequestParam(required = true) Integer[] ids) {
		return new APIResult<Object>(service.enable(ids), "启用成功", true);
	}

	/**
	 * 禁用
	 *
	 * @param ids
	 *            id列表（以,隔开）
	 * @return 影响数据条数
	 */
	@PostMapping("disable")
	public APIResult<Object> disable(@RequestParam(required = true) Integer[] ids) {
		return new APIResult<Object>(service.disable(ids), "禁用成功", true);
	}

}
