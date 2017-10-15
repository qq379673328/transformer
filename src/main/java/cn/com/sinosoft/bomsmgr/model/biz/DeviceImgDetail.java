package cn.com.sinosoft.bomsmgr.model.biz;

import java.util.List;

/**
 * 设备图详情
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月18日
 */
public class DeviceImgDetail {

	/**
	 * 设备图
	 */
	private DeviceImgInfo deviceImg;

	/**
	 * 部件列表
	 */
	private List<PartInfo> partInfos;

	public DeviceImgInfo getDeviceImg() {
		return deviceImg;
	}

	public void setDeviceImg(DeviceImgInfo deviceImg) {
		this.deviceImg = deviceImg;
	}

	public List<PartInfo> getPartInfos() {
		return partInfos;
	}

	public void setPartInfos(List<PartInfo> partInfos) {
		this.partInfos = partInfos;
	}

}
