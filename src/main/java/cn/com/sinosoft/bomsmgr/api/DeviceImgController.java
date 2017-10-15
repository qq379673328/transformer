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

import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceImg;
import cn.com.sinosoft.bomsmgr.model.biz.DeviceImgDetail;
import cn.com.sinosoft.bomsmgr.model.biz.DeviceImgInfo;
import cn.com.sinosoft.bomsmgr.service.DeviceImgService;
import cn.com.sinosoft.tbf.domain.common.APIResult;

/**
 * 设备图api
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年4月21日
 */
@RestController
@RequestMapping("/api/deviceimg")
public class DeviceImgController {

	@Resource
	DeviceImgService service;

	/**
	 * 列表
	 *
	 * @return
	 */
	@GetMapping("list")
	public APIResult<List<DeviceImgInfo>> getList(@RequestParam Map<String, Object> params) {
		return new APIResult<List<DeviceImgInfo>>(service.getList(params));
	}

	/**
	 * 设备图详情
	 *
	 * @return
	 */
	@GetMapping("getDetailById/{id}")
	public APIResult<DeviceImgDetail> getDetailById(@PathVariable Integer id) {
		return new APIResult<DeviceImgDetail>(service.getDetailById(id));
	}

	/**
	 * 添加
	 *
	 * @param item
	 *            信息
	 * @return
	 */
	@PostMapping("add")
	public APIResult<Object> add(TBizDeviceImg item) {
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
	public APIResult<Object> edit(TBizDeviceImg item) {
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
