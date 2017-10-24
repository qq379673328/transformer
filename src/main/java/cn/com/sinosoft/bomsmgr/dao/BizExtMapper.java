package cn.com.sinosoft.bomsmgr.dao;

import org.apache.ibatis.annotations.Update;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceImg;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizWiringdiagram;

/**
 * 业务扩展mapper
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月15日
 */
public interface BizExtMapper {

	/**
	 * 审核-设备图
	 */
	@Update({
        "update t_biz_device_img",
        "set ",
          "verify_status = #{verifyStatus,jdbcType=VARCHAR},",
          "verify_time = #{verifyTime,jdbcType=TIMESTAMP},",
          "verify_user = #{verifyUser,jdbcType=VARCHAR},",
          "verify_content = #{verifyContent,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
	public int verifyDeviceImg(TBizDeviceImg item);

	/**
	 * 审核-接线图
	 */
	 @Update({
	        "update t_biz_wiringdiagram",
	        "set ",
	          "verify_status = #{verifyStatus,jdbcType=VARCHAR},",
	          "verify_time = #{verifyTime,jdbcType=TIMESTAMP},",
	          "verify_user = #{verifyUser,jdbcType=VARCHAR},",
	          "verify_content = #{verifyContent,jdbcType=VARCHAR}",
	        "where id = #{id,jdbcType=INTEGER}"
	    })
	public int verifyWd(TBizWiringdiagram item);

}
