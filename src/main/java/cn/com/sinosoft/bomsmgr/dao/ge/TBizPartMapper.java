package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizPart;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizPartExample;
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

public interface TBizPartMapper {
    @SelectProvider(type=TBizPartSqlProvider.class, method="countByExample")
    int countByExample(TBizPartExample example);

    @DeleteProvider(type=TBizPartSqlProvider.class, method="deleteByExample")
    int deleteByExample(TBizPartExample example);

    @Delete({
        "delete from t_biz_part",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_biz_part (`name`, `desc`, ",
        "create_time, create_user, ",
        "img_id, x, y, ",
        "width, height, type_id, ",
        "device_img_id)",
        "values (#{name,jdbcType=VARCHAR}, #{desc,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createUser,jdbcType=VARCHAR}, ",
        "#{imgId,jdbcType=VARCHAR}, #{x,jdbcType=INTEGER}, #{y,jdbcType=INTEGER}, ",
        "#{width,jdbcType=INTEGER}, #{height,jdbcType=INTEGER}, #{typeId,jdbcType=INTEGER}, ",
        "#{deviceImgId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TBizPart record);

    @InsertProvider(type=TBizPartSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TBizPart record);

    @SelectProvider(type=TBizPartSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_id", property="imgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="x", property="x", jdbcType=JdbcType.INTEGER),
        @Result(column="y", property="y", jdbcType=JdbcType.INTEGER),
        @Result(column="width", property="width", jdbcType=JdbcType.INTEGER),
        @Result(column="height", property="height", jdbcType=JdbcType.INTEGER),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.INTEGER),
        @Result(column="device_img_id", property="deviceImgId", jdbcType=JdbcType.INTEGER)
    })
    List<TBizPart> selectByExample(TBizPartExample example);

    @Select({
        "select",
        "id, `name`, `desc`, create_time, create_user, img_id, x, y, width, height, type_id, ",
        "device_img_id",
        "from t_biz_part",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_id", property="imgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="x", property="x", jdbcType=JdbcType.INTEGER),
        @Result(column="y", property="y", jdbcType=JdbcType.INTEGER),
        @Result(column="width", property="width", jdbcType=JdbcType.INTEGER),
        @Result(column="height", property="height", jdbcType=JdbcType.INTEGER),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.INTEGER),
        @Result(column="device_img_id", property="deviceImgId", jdbcType=JdbcType.INTEGER)
    })
    TBizPart selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TBizPartSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TBizPart record, @Param("example") TBizPartExample example);

    @UpdateProvider(type=TBizPartSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TBizPart record, @Param("example") TBizPartExample example);

    @UpdateProvider(type=TBizPartSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBizPart record);

    @Update({
        "update t_biz_part",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "`desc` = #{desc,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "img_id = #{imgId,jdbcType=VARCHAR},",
          "x = #{x,jdbcType=INTEGER},",
          "y = #{y,jdbcType=INTEGER},",
          "width = #{width,jdbcType=INTEGER},",
          "height = #{height,jdbcType=INTEGER},",
          "type_id = #{typeId,jdbcType=INTEGER},",
          "device_img_id = #{deviceImgId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBizPart record);
}