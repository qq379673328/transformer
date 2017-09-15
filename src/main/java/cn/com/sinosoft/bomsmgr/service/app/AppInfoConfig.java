package cn.com.sinosoft.bomsmgr.service.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * app相关配置信息
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月5日
 */
@ConfigurationProperties(prefix = "app.info")
@Component
public class AppInfoConfig {

	/**
	 * 下载地址前缀
	 */
	private String downloadPre;

	public String getDownloadPre() {
		return downloadPre;
	}

	public void setDownloadPre(String downloadPre) {
		this.downloadPre = downloadPre;
	}

}
