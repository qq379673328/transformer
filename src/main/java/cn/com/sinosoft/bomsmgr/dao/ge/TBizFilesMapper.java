package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizFiles;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizFilesExample;
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

public interface TBizFilesMapper {
    @SelectProvider(type=TBizFilesSqlProvider.class, method="countByExample")
    int countByExample(TBizFilesExample example);

    @DeleteProvider(type=TBizFilesSqlProvider.class, method="deleteByExample")
    int deleteByExample(TBizFilesExample example);

    @Delete({
        "delete from t_biz_files",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into t_biz_files (filename_src, filename_new, ",
        "create_time, create_user, ",
        "`path`, filetype, ",
        "filesize)",
        "values (#{filenameSrc,jdbcType=VARCHAR}, #{filenameNew,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createUser,jdbcType=VARCHAR}, ",
        "#{path,jdbcType=VARCHAR}, #{filetype,jdbcType=VARCHAR}, ",
        "#{filesize,jdbcType=DOUBLE})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=String.class)
    int insert(TBizFiles record);

    @InsertProvider(type=TBizFilesSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=String.class)
    int insertSelective(TBizFiles record);

    @SelectProvider(type=TBizFilesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="filename_src", property="filenameSrc", jdbcType=JdbcType.VARCHAR),
        @Result(column="filename_new", property="filenameNew", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="filetype", property="filetype", jdbcType=JdbcType.VARCHAR),
        @Result(column="filesize", property="filesize", jdbcType=JdbcType.DOUBLE)
    })
    List<TBizFiles> selectByExample(TBizFilesExample example);

    @Select({
        "select",
        "id, filename_src, filename_new, create_time, create_user, `path`, filetype, ",
        "filesize",
        "from t_biz_files",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="filename_src", property="filenameSrc", jdbcType=JdbcType.VARCHAR),
        @Result(column="filename_new", property="filenameNew", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="filetype", property="filetype", jdbcType=JdbcType.VARCHAR),
        @Result(column="filesize", property="filesize", jdbcType=JdbcType.DOUBLE)
    })
    TBizFiles selectByPrimaryKey(String id);

    @UpdateProvider(type=TBizFilesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TBizFiles record, @Param("example") TBizFilesExample example);

    @UpdateProvider(type=TBizFilesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TBizFiles record, @Param("example") TBizFilesExample example);

    @UpdateProvider(type=TBizFilesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBizFiles record);

    @Update({
        "update t_biz_files",
        "set filename_src = #{filenameSrc,jdbcType=VARCHAR},",
          "filename_new = #{filenameNew,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "`path` = #{path,jdbcType=VARCHAR},",
          "filetype = #{filetype,jdbcType=VARCHAR},",
          "filesize = #{filesize,jdbcType=DOUBLE}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TBizFiles record);
}