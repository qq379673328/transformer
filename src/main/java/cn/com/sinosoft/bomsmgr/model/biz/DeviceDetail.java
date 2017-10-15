package cn.com.sinosoft.bomsmgr.model.biz;

import java.util.List;

/**
 * 设备详情
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月18日
 */
public class DeviceDetail {

	/**
	 * 设备
	 */
	private DeviceInfo device;

	/**
	 * 设备图列表
	 */
	private List<DeviceImgInfo> deviceImgs;

	public DeviceInfo getDevice() {
		return device;
	}

	public void setDevice(DeviceInfo device) {
		this.device = device;
	}

	public List<DeviceImgInfo> getDeviceImgs() {
		return deviceImgs;
	}

	public void setDeviceImgs(List<DeviceImgInfo> deviceImgs) {
		this.deviceImgs = deviceImgs;
	}

}
