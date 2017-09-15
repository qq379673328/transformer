package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBaseDicsType;
import cn.com.sinosoft.bomsmgr.entity.ge.TBaseDicsTypeExample;
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

public interface TBaseDicsTypeMapper {
    @SelectProvider(type=TBaseDicsTypeSqlProvider.class, method="countByExample")
    int countByExample(TBaseDicsTypeExample example);

    @DeleteProvider(type=TBaseDicsTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(TBaseDicsTypeExample example);

    @Delete({
        "delete from t_base_dics_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_base_dics_type (type_code, type_desc)",
        "values (#{typeCode,jdbcType=VARCHAR}, #{typeDesc,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TBaseDicsType record);

    @InsertProvider(type=TBaseDicsTypeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TBaseDicsType record);

    @SelectProvider(type=TBaseDicsTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type_code", property="typeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_desc", property="typeDesc", jdbcType=JdbcType.VARCHAR)
    })
    List<TBaseDicsType> selectByExample(TBaseDicsTypeExample example);

    @Select({
        "select",
        "id, type_code, type_desc",
        "from t_base_dics_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type_code", property="typeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_desc", property="typeDesc", jdbcType=JdbcType.VARCHAR)
    })
    TBaseDicsType selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TBaseDicsTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TBaseDicsType record, @Param("example") TBaseDicsTypeExample example);

    @UpdateProvider(type=TBaseDicsTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TBaseDicsType record, @Param("example") TBaseDicsTypeExample example);

    @UpdateProvider(type=TBaseDicsTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBaseDicsType record);

    @Update({
        "update t_base_dics_type",
        "set type_code = #{typeCode,jdbcType=VARCHAR},",
          "type_desc = #{typeDesc,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBaseDicsType record);
}