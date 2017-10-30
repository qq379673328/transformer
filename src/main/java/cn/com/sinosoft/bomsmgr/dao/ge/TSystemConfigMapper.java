package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TSystemConfig;
import cn.com.sinosoft.bomsmgr.entity.ge.TSystemConfigExample;
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

public interface TSystemConfigMapper {
    @SelectProvider(type=TSystemConfigSqlProvider.class, method="countByExample")
    int countByExample(TSystemConfigExample example);

    @DeleteProvider(type=TSystemConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSystemConfigExample example);

    @Delete({
        "delete from t_system_config",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_system_config (update_time, update_user, ",
        "module_id, module_desc, ",
        "`type`, `key`, content)",
        "values (#{updateTime,jdbcType=TIMESTAMP}, #{updateUser,jdbcType=VARCHAR}, ",
        "#{moduleId,jdbcType=VARCHAR}, #{moduleDesc,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{key,jdbcType=VARCHAR}, #{content,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TSystemConfig record);

    @InsertProvider(type=TSystemConfigSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TSystemConfig record);

    @SelectProvider(type=TSystemConfigSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_id", property="moduleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_desc", property="moduleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="key", property="key", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TSystemConfig> selectByExampleWithBLOBs(TSystemConfigExample example);

    @SelectProvider(type=TSystemConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_id", property="moduleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_desc", property="moduleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="key", property="key", jdbcType=JdbcType.VARCHAR)
    })
    List<TSystemConfig> selectByExample(TSystemConfigExample example);

    @Select({
        "select",
        "id, update_time, update_user, module_id, module_desc, `type`, `key`, content",
        "from t_system_config",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_id", property="moduleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_desc", property="moduleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="key", property="key", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    TSystemConfig selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TSystemConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSystemConfig record, @Param("example") TSystemConfigExample example);

    @UpdateProvider(type=TSystemConfigSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") TSystemConfig record, @Param("example") TSystemConfigExample example);

    @UpdateProvider(type=TSystemConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSystemConfig record, @Param("example") TSystemConfigExample example);

    @UpdateProvider(type=TSystemConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSystemConfig record);

    @Update({
        "update t_system_config",
        "set update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR},",
          "module_id = #{moduleId,jdbcType=VARCHAR},",
          "module_desc = #{moduleDesc,jdbcType=VARCHAR},",
          "`type` = #{type,jdbcType=VARCHAR},",
          "`key` = #{key,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(TSystemConfig record);

    @Update({
        "update t_system_config",
        "set update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR},",
          "module_id = #{moduleId,jdbcType=VARCHAR},",
          "module_desc = #{moduleDesc,jdbcType=VARCHAR},",
          "`type` = #{type,jdbcType=VARCHAR},",
          "`key` = #{key,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TSystemConfig record);
}