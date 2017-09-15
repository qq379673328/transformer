package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizTransformer;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizTransformerExample;
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

public interface TBizTransformerMapper {
    @SelectProvider(type=TBizTransformerSqlProvider.class, method="countByExample")
    int countByExample(TBizTransformerExample example);

    @DeleteProvider(type=TBizTransformerSqlProvider.class, method="deleteByExample")
    int deleteByExample(TBizTransformerExample example);

    @Delete({
        "delete from t_biz_transformer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_biz_transformer (`name`, `type`, ",
        "`desc`, create_user, ",
        "create_time, address)",
        "values (#{name,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, ",
        "#{desc,jdbcType=VARCHAR}, #{createUser,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{address,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TBizTransformer record);

    @InsertProvider(type=TBizTransformerSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TBizTransformer record);

    @SelectProvider(type=TBizTransformerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR)
    })
    List<TBizTransformer> selectByExample(TBizTransformerExample example);

    @Select({
        "select",
        "id, `name`, `type`, `desc`, create_user, create_time, address",
        "from t_biz_transformer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR)
    })
    TBizTransformer selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TBizTransformerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TBizTransformer record, @Param("example") TBizTransformerExample example);

    @UpdateProvider(type=TBizTransformerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TBizTransformer record, @Param("example") TBizTransformerExample example);

    @UpdateProvider(type=TBizTransformerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBizTransformer record);

    @Update({
        "update t_biz_transformer",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "`type` = #{type,jdbcType=VARCHAR},",
          "`desc` = #{desc,jdbcType=VARCHAR},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "address = #{address,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBizTransformer record);
}