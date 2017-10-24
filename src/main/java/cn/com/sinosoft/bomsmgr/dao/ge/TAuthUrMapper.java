package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TAuthUr;
import cn.com.sinosoft.bomsmgr.entity.ge.TAuthUrExample;
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

public interface TAuthUrMapper {
    @SelectProvider(type=TAuthUrSqlProvider.class, method="countByExample")
    int countByExample(TAuthUrExample example);

    @DeleteProvider(type=TAuthUrSqlProvider.class, method="deleteByExample")
    int deleteByExample(TAuthUrExample example);

    @Delete({
        "delete from t_auth_ur",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_auth_ur (CREATE_USER, CREATE_TIME, ",
        "USER_ID, ROLE_ID)",
        "values (#{createUser,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{userId,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TAuthUr record);

    @InsertProvider(type=TAuthUrSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TAuthUr record);

    @SelectProvider(type=TAuthUrSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="CREATE_USER", property="createUser", jdbcType=JdbcType.CHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="ROLE_ID", property="roleId", jdbcType=JdbcType.INTEGER)
    })
    List<TAuthUr> selectByExample(TAuthUrExample example);

    @Select({
        "select",
        "ID, CREATE_USER, CREATE_TIME, USER_ID, ROLE_ID",
        "from t_auth_ur",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="CREATE_USER", property="createUser", jdbcType=JdbcType.CHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="ROLE_ID", property="roleId", jdbcType=JdbcType.INTEGER)
    })
    TAuthUr selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TAuthUrSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TAuthUr record, @Param("example") TAuthUrExample example);

    @UpdateProvider(type=TAuthUrSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TAuthUr record, @Param("example") TAuthUrExample example);

    @UpdateProvider(type=TAuthUrSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TAuthUr record);

    @Update({
        "update t_auth_ur",
        "set CREATE_USER = #{createUser,jdbcType=CHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "USER_ID = #{userId,jdbcType=INTEGER},",
          "ROLE_ID = #{roleId,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TAuthUr record);
}