package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBaseDics;
import cn.com.sinosoft.bomsmgr.entity.ge.TBaseDicsExample;
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

public interface TBaseDicsMapper {
    @SelectProvider(type=TBaseDicsSqlProvider.class, method="countByExample")
    int countByExample(TBaseDicsExample example);

    @DeleteProvider(type=TBaseDicsSqlProvider.class, method="deleteByExample")
    int deleteByExample(TBaseDicsExample example);

    @Delete({
        "delete from t_base_dics",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_base_dics (code_type, code_value, ",
        "code_desc, is_use, ",
        "`rank`)",
        "values (#{codeType,jdbcType=VARCHAR}, #{codeValue,jdbcType=VARCHAR}, ",
        "#{codeDesc,jdbcType=VARCHAR}, #{isUse,jdbcType=VARCHAR}, ",
        "#{rank,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TBaseDics record);

    @InsertProvider(type=TBaseDicsSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TBaseDics record);

    @SelectProvider(type=TBaseDicsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code_type", property="codeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="code_value", property="codeValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="code_desc", property="codeDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_use", property="isUse", jdbcType=JdbcType.VARCHAR),
        @Result(column="rank", property="rank", jdbcType=JdbcType.INTEGER)
    })
    List<TBaseDics> selectByExample(TBaseDicsExample example);

    @Select({
        "select",
        "id, code_type, code_value, code_desc, is_use, `rank`",
        "from t_base_dics",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code_type", property="codeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="code_value", property="codeValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="code_desc", property="codeDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_use", property="isUse", jdbcType=JdbcType.VARCHAR),
        @Result(column="rank", property="rank", jdbcType=JdbcType.INTEGER)
    })
    TBaseDics selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TBaseDicsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TBaseDics record, @Param("example") TBaseDicsExample example);

    @UpdateProvider(type=TBaseDicsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TBaseDics record, @Param("example") TBaseDicsExample example);

    @UpdateProvider(type=TBaseDicsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBaseDics record);

    @Update({
        "update t_base_dics",
        "set code_type = #{codeType,jdbcType=VARCHAR},",
          "code_value = #{codeValue,jdbcType=VARCHAR},",
          "code_desc = #{codeDesc,jdbcType=VARCHAR},",
          "is_use = #{isUse,jdbcType=VARCHAR},",
          "`rank` = #{rank,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBaseDics record);
}