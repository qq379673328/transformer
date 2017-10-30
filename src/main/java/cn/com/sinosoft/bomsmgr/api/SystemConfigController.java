package cn.com.sinosoft.bomsmgr.api;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosoft.bomsmgr.entity.ge.TSystemConfig;
import cn.com.sinosoft.bomsmgr.model.biz.SystemConfigInfo;
import cn.com.sinosoft.bomsmgr.service.SystemConfigService;
import cn.com.sinosoft.tbf.domain.common.APIResult;

/**
 * 系统配置api
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年4月21日
 */
@RestController
@RequestMapping("/api/system/config")
public class SystemConfigController {

	@Resource
	SystemConfigService service;

	/**
	 * 列表
	 *
	 * @return
	 */
	@GetMapping("list")
	public APIResult<List<SystemConfigInfo>> getList(@RequestParam Map<String, Object> params) {
		return new APIResult<List<SystemConfigInfo>>(service.getList(params));
	}

	/**
	 * 编辑
	 *
	 * @param item
	 *            信息
	 * @return
	 */
	@PostMapping("edit")
	public APIResult<Object> edit(TSystemConfig item) {
		service.update(item);
		return new APIResult<Object>();
	}

}
