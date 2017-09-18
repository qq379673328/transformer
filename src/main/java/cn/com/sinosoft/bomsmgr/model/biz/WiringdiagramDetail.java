package cn.com.sinosoft.bomsmgr.model.biz;

import java.util.List;

/**
 * 接线图详情
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月18日
 */
public class WiringdiagramDetail {

	/**
	 * 接线图
	 */
	private WiringdiagramInfo Wiringdiagram;

	/**
	 * 设备
	 */
	private List<DeviceInfo> deviceInfos;

	public WiringdiagramInfo getWiringdiagram() {
		return Wiringdiagram;
	}

	public void setWiringdiagram(WiringdiagramInfo wiringdiagram) {
		Wiringdiagram = wiringdiagram;
	}

	public List<DeviceInfo> getDeviceInfos() {
		return deviceInfos;
	}

	public void setDeviceInfos(List<DeviceInfo> deviceInfos) {
		this.deviceInfos = deviceInfos;
	}

}
