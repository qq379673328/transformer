package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TAuthRole;
import cn.com.sinosoft.bomsmgr.entity.ge.TAuthRoleExample;
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

public interface TAuthRoleMapper {
    @SelectProvider(type=TAuthRoleSqlProvider.class, method="countByExample")
    int countByExample(TAuthRoleExample example);

    @DeleteProvider(type=TAuthRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(TAuthRoleExample example);

    @Delete({
        "delete from t_auth_role",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_auth_role (CREATE_USER, CREATE_TIME, ",
        "UPDATE_USER, UPDATE_TIME, ",
        "ROLE_NAME, ROLE_DESC)",
        "values (#{createUser,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateUser,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{roleName,jdbcType=CHAR}, #{roleDesc,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TAuthRole record);

    @InsertProvider(type=TAuthRoleSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TAuthRole record);

    @SelectProvider(type=TAuthRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="CREATE_USER", property="createUser", jdbcType=JdbcType.INTEGER),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_USER", property="updateUser", jdbcType=JdbcType.INTEGER),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ROLE_NAME", property="roleName", jdbcType=JdbcType.CHAR),
        @Result(column="ROLE_DESC", property="roleDesc", jdbcType=JdbcType.CHAR)
    })
    List<TAuthRole> selectByExample(TAuthRoleExample example);

    @Select({
        "select",
        "ID, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, ROLE_NAME, ROLE_DESC",
        "from t_auth_role",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="CREATE_USER", property="createUser", jdbcType=JdbcType.INTEGER),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_USER", property="updateUser", jdbcType=JdbcType.INTEGER),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ROLE_NAME", property="roleName", jdbcType=JdbcType.CHAR),
        @Result(column="ROLE_DESC", property="roleDesc", jdbcType=JdbcType.CHAR)
    })
    TAuthRole selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TAuthRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TAuthRole record, @Param("example") TAuthRoleExample example);

    @UpdateProvider(type=TAuthRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TAuthRole record, @Param("example") TAuthRoleExample example);

    @UpdateProvider(type=TAuthRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TAuthRole record);

    @Update({
        "update t_auth_role",
        "set CREATE_USER = #{createUser,jdbcType=INTEGER},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_USER = #{updateUser,jdbcType=INTEGER},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "ROLE_NAME = #{roleName,jdbcType=CHAR},",
          "ROLE_DESC = #{roleDesc,jdbcType=CHAR}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TAuthRole record);
}