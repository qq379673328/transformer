package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizDevice;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceExample;
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

public interface TBizDeviceMapper {
    @SelectProvider(type=TBizDeviceSqlProvider.class, method="countByExample")
    int countByExample(TBizDeviceExample example);

    @DeleteProvider(type=TBizDeviceSqlProvider.class, method="deleteByExample")
    int deleteByExample(TBizDeviceExample example);

    @Delete({
        "delete from t_biz_device",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_biz_device (`name`, type_id, ",
        "`desc`, wiringdiagram_id, ",
        "img_id, x, y, ",
        "width, height, create_user, ",
        "create_time)",
        "values (#{name,jdbcType=VARCHAR}, #{typeId,jdbcType=INTEGER}, ",
        "#{desc,jdbcType=VARCHAR}, #{wiringdiagramId,jdbcType=INTEGER}, ",
        "#{imgId,jdbcType=VARCHAR}, #{x,jdbcType=INTEGER}, #{y,jdbcType=INTEGER}, ",
        "#{width,jdbcType=INTEGER}, #{height,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TBizDevice record);

    @InsertProvider(type=TBizDeviceSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TBizDevice record);

    @SelectProvider(type=TBizDeviceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.INTEGER),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="wiringdiagram_id", property="wiringdiagramId", jdbcType=JdbcType.INTEGER),
        @Result(column="img_id", property="imgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="x", property="x", jdbcType=JdbcType.INTEGER),
        @Result(column="y", property="y", jdbcType=JdbcType.INTEGER),
        @Result(column="width", property="width", jdbcType=JdbcType.INTEGER),
        @Result(column="height", property="height", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TBizDevice> selectByExample(TBizDeviceExample example);

    @Select({
        "select",
        "id, `name`, type_id, `desc`, wiringdiagram_id, img_id, x, y, width, height, ",
        "create_user, create_time",
        "from t_biz_device",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.INTEGER),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="wiringdiagram_id", property="wiringdiagramId", jdbcType=JdbcType.INTEGER),
        @Result(column="img_id", property="imgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="x", property="x", jdbcType=JdbcType.INTEGER),
        @Result(column="y", property="y", jdbcType=JdbcType.INTEGER),
        @Result(column="width", property="width", jdbcType=JdbcType.INTEGER),
        @Result(column="height", property="height", jdbcType=JdbcType.INTEGER),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    TBizDevice selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TBizDeviceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TBizDevice record, @Param("example") TBizDeviceExample example);

    @UpdateProvider(type=TBizDeviceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TBizDevice record, @Param("example") TBizDeviceExample example);

    @UpdateProvider(type=TBizDeviceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBizDevice record);

    @Update({
        "update t_biz_device",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "type_id = #{typeId,jdbcType=INTEGER},",
          "`desc` = #{desc,jdbcType=VARCHAR},",
          "wiringdiagram_id = #{wiringdiagramId,jdbcType=INTEGER},",
          "img_id = #{imgId,jdbcType=VARCHAR},",
          "x = #{x,jdbcType=INTEGER},",
          "y = #{y,jdbcType=INTEGER},",
          "width = #{width,jdbcType=INTEGER},",
          "height = #{height,jdbcType=INTEGER},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBizDevice record);
}