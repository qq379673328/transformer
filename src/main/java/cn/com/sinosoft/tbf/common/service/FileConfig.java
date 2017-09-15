package cn.com.sinosoft.tbf.common.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 文件配置
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2016年8月19日
 */
@ConfigurationProperties(prefix = "filepath")
@Component
public class FileConfig {

	/**
	 * 保存地址
	 */
	private String save;

	/**
	 * 下载地址
	 */
	private String dowload;

	public String getSave() {
		return save;
	}

	public void setSave(String save) {
		this.save = save;
	}

	public String getDowload() {
		return dowload;
	}

	public void setDowload(String dowload) {
		this.dowload = dowload;
	}

}
