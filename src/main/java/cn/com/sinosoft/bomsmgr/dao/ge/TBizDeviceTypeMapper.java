package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceType;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceTypeExample;
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

public interface TBizDeviceTypeMapper {
    @SelectProvider(type=TBizDeviceTypeSqlProvider.class, method="countByExample")
    int countByExample(TBizDeviceTypeExample example);

    @DeleteProvider(type=TBizDeviceTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(TBizDeviceTypeExample example);

    @Delete({
        "delete from t_biz_device_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_biz_device_type (`name`, create_time, ",
        "create_user, `state`)",
        "values (#{name,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR}, #{state,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TBizDeviceType record);

    @InsertProvider(type=TBizDeviceTypeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TBizDeviceType record);

    @SelectProvider(type=TBizDeviceTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR)
    })
    List<TBizDeviceType> selectByExample(TBizDeviceTypeExample example);

    @Select({
        "select",
        "id, `name`, create_time, create_user, `state`",
        "from t_biz_device_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR)
    })
    TBizDeviceType selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TBizDeviceTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TBizDeviceType record, @Param("example") TBizDeviceTypeExample example);

    @UpdateProvider(type=TBizDeviceTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TBizDeviceType record, @Param("example") TBizDeviceTypeExample example);

    @UpdateProvider(type=TBizDeviceTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBizDeviceType record);

    @Update({
        "update t_biz_device_type",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "`state` = #{state,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBizDeviceType record);
}