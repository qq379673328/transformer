package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizWiringdiagram;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizWiringdiagramExample;
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

public interface TBizWiringdiagramMapper {
    @SelectProvider(type=TBizWiringdiagramSqlProvider.class, method="countByExample")
    int countByExample(TBizWiringdiagramExample example);

    @DeleteProvider(type=TBizWiringdiagramSqlProvider.class, method="deleteByExample")
    int deleteByExample(TBizWiringdiagramExample example);

    @Delete({
        "delete from t_biz_wiringdiagram",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_biz_wiringdiagram (`desc`, create_time, ",
        "create_user, img_id, ",
        "transformer_id)",
        "values (#{desc,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR}, #{imgId,jdbcType=VARCHAR}, ",
        "#{transformerId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TBizWiringdiagram record);

    @InsertProvider(type=TBizWiringdiagramSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TBizWiringdiagram record);

    @SelectProvider(type=TBizWiringdiagramSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_id", property="imgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="transformer_id", property="transformerId", jdbcType=JdbcType.INTEGER)
    })
    List<TBizWiringdiagram> selectByExample(TBizWiringdiagramExample example);

    @Select({
        "select",
        "id, `desc`, create_time, create_user, img_id, transformer_id",
        "from t_biz_wiringdiagram",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_id", property="imgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="transformer_id", property="transformerId", jdbcType=JdbcType.INTEGER)
    })
    TBizWiringdiagram selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TBizWiringdiagramSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TBizWiringdiagram record, @Param("example") TBizWiringdiagramExample example);

    @UpdateProvider(type=TBizWiringdiagramSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TBizWiringdiagram record, @Param("example") TBizWiringdiagramExample example);

    @UpdateProvider(type=TBizWiringdiagramSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBizWiringdiagram record);

    @Update({
        "update t_biz_wiringdiagram",
        "set `desc` = #{desc,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "img_id = #{imgId,jdbcType=VARCHAR},",
          "transformer_id = #{transformerId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBizWiringdiagram record);
}