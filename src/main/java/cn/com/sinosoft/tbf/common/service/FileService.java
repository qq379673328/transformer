package cn.com.sinosoft.tbf.common.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.com.sinosoft.bomsmgr.dao.ge.TBizFilesMapper;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizFiles;
import cn.com.sinosoft.bomsmgr.service.common.CommonUserService;
import cn.com.sinosoft.tbf.dao.BaseDao;

/**
 * 文件管理服务
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年8月21日
 */
@Service
public class FileService {

	public static final String NAMESPACE_BASE = "cn.com.sinosoft.file.";

	@Resource
	BaseDao baseDao;
	@Resource
	CommonUserService commonUserService;
	@Autowired
	FileConfig fileConfig;

	/**
	 * 保存文件
	 *
	 * @param file
	 *            文件对象
	 * @param attachType
	 *            文件模块
	 * @return 文件id
	 */
	public String saveFile(MultipartFile file, String attachType) {
		if (file == null || attachType == null)
			return null;
		// 原始文件名
		String fileNameSrc = file.getOriginalFilename();
		// 文件大小-kb
		double fileSizeByte = file.getSize() / 1000;

		// 获取文件名后缀-文件类型
		String[] fileNameSplit = file.getOriginalFilename().split("\\.");
		String fileType = "";
		if (fileNameSplit.length > 1) {
			fileType = fileNameSplit[fileNameSplit.length - 1];
		}
		// 文件主键
		String uuid = UUID.randomUUID().toString();
		// 文件名-新-随机生成
		String fileNameNew = uuid + "." + fileType;
		// 文件路径-相对
		String realPathRel = attachType + File.separator + getTodayString();
		// 文件路径-绝对
		String realPathAbs = fileConfig.getSave() + File.separator + realPathRel;

		// 保存文件到硬盘
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPathAbs, fileNameNew));

			TBizFiles bizFile = new TBizFiles();
			bizFile.setId(uuid);
			bizFile.setFilenameSrc(fileNameSrc);
			bizFile.setFilenameNew(fileNameNew);
			bizFile.setCreateUser(commonUserService.getRequestUserId());
			bizFile.setPath(realPathRel + File.separator + fileNameNew);
			bizFile.setFiletype(fileType);
			bizFile.setFilesize(fileSizeByte);
			baseDao.insert(NAMESPACE_BASE + "insert", bizFile);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return uuid;
	}

	/**
	 * 根据文件id获取文件的下载地址
	 *
	 * @param fileId
	 * @return
	 */
	public String getFileDownloadPathById(String fileId) {
		TBizFiles file = getMapper().selectByPrimaryKey(fileId);
		if (file == null)
			return null;
		String fileAbsPath = file.getPath();
		fileAbsPath = fileAbsPath.replaceAll("\\\\", "/");
		return fileConfig.getDowload() + "/" + fileAbsPath;
	}

	private String getTodayString() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	/**
	 * 获取mapper
	 *
	 * @return
	 */
	private TBizFilesMapper getMapper() {
		return baseDao.getMapper(TBizFilesMapper.class);
	}

}
