package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceImg;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TBizDeviceImgMapper {
    @SelectProvider(type=TBizDeviceImgSqlProvider.class, method="countByExample")
    int countByExample(TBizDeviceImgExample example);

    @DeleteProvider(type=TBizDeviceImgSqlProvider.class, method="deleteByExample")
    int deleteByExample(TBizDeviceImgExample example);

    @Delete({
        "delete from t_biz_device_img",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_biz_device_img (`desc`, create_time, ",
        "create_user, img_id, ",
        "device_id)",
        "values (#{desc,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR}, #{imgId,jdbcType=VARCHAR}, ",
        "#{deviceId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TBizDeviceImg record);

    @InsertProvider(type=TBizDeviceImgSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TBizDeviceImg record);

    @SelectProvider(type=TBizDeviceImgSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_id", property="imgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_id", property="deviceId", jdbcType=JdbcType.INTEGER)
    })
    List<TBizDeviceImg> selectByExample(TBizDeviceImgExample example);

    @Select({
        "select",
        "id, `desc`, create_time, create_user, img_id, device_id",
        "from t_biz_device_img",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_id", property="imgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_id", property="deviceId", jdbcType=JdbcType.INTEGER)
    })
    TBizDeviceImg selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TBizDeviceImgSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TBizDeviceImg record, @Param("example") TBizDeviceImgExample example);

    @UpdateProvider(type=TBizDeviceImgSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TBizDeviceImg record, @Param("example") TBizDeviceImgExample example);

    @UpdateProvider(type=TBizDeviceImgSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBizDeviceImg record);

    @Update({
        "update t_biz_device_img",
        "set `desc` = #{desc,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "img_id = #{imgId,jdbcType=VARCHAR},",
          "device_id = #{deviceId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBizDeviceImg record);
}