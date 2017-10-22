package cn.com.sinosoft.tbf.common.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.com.sinosoft.tbf.common.service.FileService;

/**
 * 文件管理控制器
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年8月21日
 */
@Controller
@RequestMapping("file")
public class FileAction {

	@Resource
	private FileService fileService;

	/**
	 * 上传文件
	 *
	 * @param myfiles
	 * @param attachType
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseBody
	public Object upload(@RequestParam MultipartFile file, @RequestParam String attachType, HttpServletRequest request)
			throws IOException {
		Map<String, Object> mav = new HashMap<String, Object>();
		if (file.isEmpty()) {
			mav.put("message", "请选择文件");
			mav.put("success", false);
			return mav;
		}
		String fileId = fileService.saveFile(file, attachType);
		mav.put("fileId", fileId);
		mav.put("success", true);
		return mav;
	}

	/**
	 * 下载附件
	 *
	 * @param fileId
	 * @return
	 */
	@RequestMapping("download/{fileId}")
	public ModelAndView downloadFile(@PathVariable String fileId) {
		ModelAndView mav = new ModelAndView();
		String downloadPath = fileService.getFileDownloadPathById(fileId);
		if (downloadPath != null) {// 跳转下载页面
			mav.setViewName("redirect:" + downloadPath);
		} else {// 跳转错误提示页面
			mav.setViewName("files/notexist");
		}
		return mav;
	}
	
	/**
	 * 根据文件id获取path
	 *
	 * @param fileId
	 * @return
	 */
	@RequestMapping("getFilePathById")
	@ResponseBody
	public Map<String, Object> getFilePathById(String fileId) {
		Map<String, Object> ret = new HashMap<String, Object>();
		String downloadPath = fileService.getFileDownloadPathById(fileId);
		ret.put("path", downloadPath);
		return ret;
	}

}
