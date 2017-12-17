package cn.com.sinosoft.bomsmgr.web.common;

import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.sinosoft.bomsmgr.dao.BizExtLogMapper;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.tbf.common.util.excel.Table2Excel;
import cn.com.sinosoft.tbf.dao.BaseDao;

/**
 * 公共控制器
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年4月21日
 */
@Controller
public class CommonController {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Resource
	CommonUserService commonUserService;
	@Autowired
	BaseDao baseDao;

	/**
	 * 进入首页
	 *
	 * @return
	 */
	@RequestMapping(value = { "/", "/index", "/index.html" })
	public ModelAndView toIndex() {
		ModelAndView mav = new ModelAndView();
		String today = sdf.format(new Date());
		BizExtLogMapper logMapper = getMapper();
		List<Integer> todayCount = logMapper.getVisitCount(today);
		Integer totalCount = logMapper.getVisitCountTotal();

		mav.addObject("todayCount", todayCount == null || todayCount.size() == 0 ? 0 : todayCount.get(0));
		mav.addObject("totalCount", totalCount == null ? 0 : totalCount);
		
		mav.setViewName("index");

		return mav;
	}
	
	/**
	 * 进入图片查阅页面
	 *
	 * @return
	 */
	@RequestMapping(value = { "/imgview" })
	public ModelAndView toImgview() {
		ModelAndView mav = new ModelAndView();
		String today = sdf.format(new Date());
		BizExtLogMapper logMapper = getMapper();
		List<Integer> todayCount = logMapper.getVisitCount(today);
		Integer totalCount = logMapper.getVisitCountTotal();

		mav.addObject("todayCount", todayCount == null || todayCount.size() == 0 ? 0 : todayCount.get(0));
		mav.addObject("totalCount", totalCount == null ? 0 : totalCount);
		
		mav.setViewName("index");

		return mav;
	}

	/**
	 * 进入登录页面
	 *
	 * @return
	 */
	@RequestMapping("/login")
	public String toLogin() {
		return "login";
	}

	/**
	 * 导出简单excel
	 *
	 *
	 * @param response
	 * @param tableJson
	 * @param title
	 * @author <a href="mailto:nytclizy@gmail.com">李志勇</a>
	 */
	@RequestMapping("exportSimpleTable")
	public void exportExcel(HttpServletResponse response, String tableJson, String title) {
		try {
			if (title == null || title.trim().equals("")) {
				title = "export";
			}
			response.setContentType("application/vnd.ms-excel");
			title = URLEncoder.encode(title, "GB2312");
			title = URLDecoder.decode(title, "ISO8859_1");
			response.setHeader("Content-disposition", "attachment;filename=" + title + ".xls");
			OutputStream ouputStream = response.getOutputStream();
			new Table2Excel().transJson2Excel(tableJson, ouputStream);
			ouputStream.flush();
			ouputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取mapper
	 *
	 * @return
	 */
	private BizExtLogMapper getMapper() {
		return baseDao.getMapper(BizExtLogMapper.class);
	}

}
