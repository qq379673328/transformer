package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizPartHis;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizPartHisExample;
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

public interface TBizPartHisMapper {
    @SelectProvider(type=TBizPartHisSqlProvider.class, method="countByExample")
    int countByExample(TBizPartHisExample example);

    @DeleteProvider(type=TBizPartHisSqlProvider.class, method="deleteByExample")
    int deleteByExample(TBizPartHisExample example);

    @Delete({
        "delete from t_biz_part_his",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_biz_part_his (create_time, create_user, ",
        "img_id, content)",
        "values (#{createTime,jdbcType=TIMESTAMP}, #{createUser,jdbcType=VARCHAR}, ",
        "#{imgId,jdbcType=VARCHAR}, #{content,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TBizPartHis record);

    @InsertProvider(type=TBizPartHisSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TBizPartHis record);

    @SelectProvider(type=TBizPartHisSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_id", property="imgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TBizPartHis> selectByExampleWithBLOBs(TBizPartHisExample example);

    @SelectProvider(type=TBizPartHisSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_id", property="imgId", jdbcType=JdbcType.VARCHAR)
    })
    List<TBizPartHis> selectByExample(TBizPartHisExample example);

    @Select({
        "select",
        "id, create_time, create_user, img_id, content",
        "from t_biz_part_his",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_id", property="imgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    TBizPartHis selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TBizPartHisSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TBizPartHis record, @Param("example") TBizPartHisExample example);

    @UpdateProvider(type=TBizPartHisSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") TBizPartHis record, @Param("example") TBizPartHisExample example);

    @UpdateProvider(type=TBizPartHisSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TBizPartHis record, @Param("example") TBizPartHisExample example);

    @UpdateProvider(type=TBizPartHisSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBizPartHis record);

    @Update({
        "update t_biz_part_his",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "img_id = #{imgId,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(TBizPartHis record);

    @Update({
        "update t_biz_part_his",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "img_id = #{imgId,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBizPartHis record);
}