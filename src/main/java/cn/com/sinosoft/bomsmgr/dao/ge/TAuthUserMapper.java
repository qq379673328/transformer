package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TAuthUser;
import cn.com.sinosoft.bomsmgr.entity.ge.TAuthUserExample;
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

public interface TAuthUserMapper {
    @SelectProvider(type=TAuthUserSqlProvider.class, method="countByExample")
    int countByExample(TAuthUserExample example);

    @DeleteProvider(type=TAuthUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(TAuthUserExample example);

    @Delete({
        "delete from t_auth_user",
        "where ID = #{id,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into t_auth_user (CREATE_USER, CREATE_TIME, ",
        "UPDATE_USER, UPDATE_TIME, ",
        "LOGIN_NAME, `NAME`, PASS_WORD, ",
        "IS_USED, EMAIL, SEX, ",
        "PHONE)",
        "values (#{createUser,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateUser,jdbcType=CHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{loginName,jdbcType=CHAR}, #{name,jdbcType=CHAR}, #{passWord,jdbcType=CHAR}, ",
        "#{isUsed,jdbcType=CHAR}, #{email,jdbcType=CHAR}, #{sex,jdbcType=CHAR}, ",
        "#{phone,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=String.class)
    int insert(TAuthUser record);

    @InsertProvider(type=TAuthUserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=String.class)
    int insertSelective(TAuthUser record);

    @SelectProvider(type=TAuthUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="CREATE_USER", property="createUser", jdbcType=JdbcType.CHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_USER", property="updateUser", jdbcType=JdbcType.CHAR),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LOGIN_NAME", property="loginName", jdbcType=JdbcType.CHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.CHAR),
        @Result(column="PASS_WORD", property="passWord", jdbcType=JdbcType.CHAR),
        @Result(column="IS_USED", property="isUsed", jdbcType=JdbcType.CHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.CHAR),
        @Result(column="SEX", property="sex", jdbcType=JdbcType.CHAR),
        @Result(column="PHONE", property="phone", jdbcType=JdbcType.CHAR)
    })
    List<TAuthUser> selectByExample(TAuthUserExample example);

    @Select({
        "select",
        "ID, CREATE_USER, CREATE_TIME, UPDATE_USER, UPDATE_TIME, LOGIN_NAME, `NAME`, ",
        "PASS_WORD, IS_USED, EMAIL, SEX, PHONE",
        "from t_auth_user",
        "where ID = #{id,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="CREATE_USER", property="createUser", jdbcType=JdbcType.CHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_USER", property="updateUser", jdbcType=JdbcType.CHAR),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LOGIN_NAME", property="loginName", jdbcType=JdbcType.CHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.CHAR),
        @Result(column="PASS_WORD", property="passWord", jdbcType=JdbcType.CHAR),
        @Result(column="IS_USED", property="isUsed", jdbcType=JdbcType.CHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.CHAR),
        @Result(column="SEX", property="sex", jdbcType=JdbcType.CHAR),
        @Result(column="PHONE", property="phone", jdbcType=JdbcType.CHAR)
    })
    TAuthUser selectByPrimaryKey(String id);

    @UpdateProvider(type=TAuthUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TAuthUser record, @Param("example") TAuthUserExample example);

    @UpdateProvider(type=TAuthUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TAuthUser record, @Param("example") TAuthUserExample example);

    @UpdateProvider(type=TAuthUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TAuthUser record);

    @Update({
        "update t_auth_user",
        "set CREATE_USER = #{createUser,jdbcType=CHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_USER = #{updateUser,jdbcType=CHAR},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "LOGIN_NAME = #{loginName,jdbcType=CHAR},",
          "`NAME` = #{name,jdbcType=CHAR},",
          "PASS_WORD = #{passWord,jdbcType=CHAR},",
          "IS_USED = #{isUsed,jdbcType=CHAR},",
          "EMAIL = #{email,jdbcType=CHAR},",
          "SEX = #{sex,jdbcType=CHAR},",
          "PHONE = #{phone,jdbcType=CHAR}",
        "where ID = #{id,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(TAuthUser record);
}