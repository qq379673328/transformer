package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TAuthRm;
import cn.com.sinosoft.bomsmgr.entity.ge.TAuthRmExample;
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

public interface TAuthRmMapper {
    @SelectProvider(type=TAuthRmSqlProvider.class, method="countByExample")
    int countByExample(TAuthRmExample example);

    @DeleteProvider(type=TAuthRmSqlProvider.class, method="deleteByExample")
    int deleteByExample(TAuthRmExample example);

    @Delete({
        "delete from t_auth_rm",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_auth_rm (CREATE_USER, CREATE_TIME, ",
        "ROLE_ID, MF_ID)",
        "values (#{createUser,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{roleId,jdbcType=CHAR}, #{mfId,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TAuthRm record);

    @InsertProvider(type=TAuthRmSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TAuthRm record);

    @SelectProvider(type=TAuthRmSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="CREATE_USER", property="createUser", jdbcType=JdbcType.CHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ROLE_ID", property="roleId", jdbcType=JdbcType.CHAR),
        @Result(column="MF_ID", property="mfId", jdbcType=JdbcType.CHAR)
    })
    List<TAuthRm> selectByExample(TAuthRmExample example);

    @Select({
        "select",
        "ID, CREATE_USER, CREATE_TIME, ROLE_ID, MF_ID",
        "from t_auth_rm",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="CREATE_USER", property="createUser", jdbcType=JdbcType.CHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ROLE_ID", property="roleId", jdbcType=JdbcType.CHAR),
        @Result(column="MF_ID", property="mfId", jdbcType=JdbcType.CHAR)
    })
    TAuthRm selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TAuthRmSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TAuthRm record, @Param("example") TAuthRmExample example);

    @UpdateProvider(type=TAuthRmSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TAuthRm record, @Param("example") TAuthRmExample example);

    @UpdateProvider(type=TAuthRmSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TAuthRm record);

    @Update({
        "update t_auth_rm",
        "set CREATE_USER = #{createUser,jdbcType=CHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "ROLE_ID = #{roleId,jdbcType=CHAR},",
          "MF_ID = #{mfId,jdbcType=CHAR}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TAuthRm record);
}