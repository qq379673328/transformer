package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizParts;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizPartsExample;
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

public interface TBizPartsMapper {
    @SelectProvider(type=TBizPartsSqlProvider.class, method="countByExample")
    int countByExample(TBizPartsExample example);

    @DeleteProvider(type=TBizPartsSqlProvider.class, method="deleteByExample")
    int deleteByExample(TBizPartsExample example);

    @Delete({
        "delete from t_biz_parts",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_biz_parts (`name`, `desc`, ",
        "create_time, create_user, ",
        "img_id, x, y, ",
        "width, height, type_id)",
        "values (#{name,jdbcType=VARCHAR}, #{desc,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createUser,jdbcType=VARCHAR}, ",
        "#{imgId,jdbcType=VARCHAR}, #{x,jdbcType=INTEGER}, #{y,jdbcType=INTEGER}, ",
        "#{width,jdbcType=INTEGER}, #{height,jdbcType=INTEGER}, #{typeId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TBizParts record);

    @InsertProvider(type=TBizPartsSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TBizParts record);

    @SelectProvider(type=TBizPartsSqlProvider.class, method="selectByExample")
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
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.INTEGER)
    })
    List<TBizParts> selectByExample(TBizPartsExample example);

    @Select({
        "select",
        "id, `name`, `desc`, create_time, create_user, img_id, x, y, width, height, type_id",
        "from t_biz_parts",
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
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.INTEGER)
    })
    TBizParts selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TBizPartsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TBizParts record, @Param("example") TBizPartsExample example);

    @UpdateProvider(type=TBizPartsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TBizParts record, @Param("example") TBizPartsExample example);

    @UpdateProvider(type=TBizPartsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBizParts record);

    @Update({
        "update t_biz_parts",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "`desc` = #{desc,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "img_id = #{imgId,jdbcType=VARCHAR},",
          "x = #{x,jdbcType=INTEGER},",
          "y = #{y,jdbcType=INTEGER},",
          "width = #{width,jdbcType=INTEGER},",
          "height = #{height,jdbcType=INTEGER},",
          "type_id = #{typeId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBizParts record);
}