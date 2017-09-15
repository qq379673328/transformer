package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizPartsHis;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizPartsHisExample;
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

public interface TBizPartsHisMapper {
    @SelectProvider(type=TBizPartsHisSqlProvider.class, method="countByExample")
    int countByExample(TBizPartsHisExample example);

    @DeleteProvider(type=TBizPartsHisSqlProvider.class, method="deleteByExample")
    int deleteByExample(TBizPartsHisExample example);

    @Delete({
        "delete from t_biz_parts_his",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_biz_parts_his (create_time, create_user, ",
        "img_id, content)",
        "values (#{createTime,jdbcType=TIMESTAMP}, #{createUser,jdbcType=VARCHAR}, ",
        "#{imgId,jdbcType=VARCHAR}, #{content,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TBizPartsHis record);

    @InsertProvider(type=TBizPartsHisSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TBizPartsHis record);

    @SelectProvider(type=TBizPartsHisSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_id", property="imgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TBizPartsHis> selectByExampleWithBLOBs(TBizPartsHisExample example);

    @SelectProvider(type=TBizPartsHisSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_id", property="imgId", jdbcType=JdbcType.VARCHAR)
    })
    List<TBizPartsHis> selectByExample(TBizPartsHisExample example);

    @Select({
        "select",
        "id, create_time, create_user, img_id, content",
        "from t_biz_parts_his",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_id", property="imgId", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    TBizPartsHis selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TBizPartsHisSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TBizPartsHis record, @Param("example") TBizPartsHisExample example);

    @UpdateProvider(type=TBizPartsHisSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") TBizPartsHis record, @Param("example") TBizPartsHisExample example);

    @UpdateProvider(type=TBizPartsHisSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TBizPartsHis record, @Param("example") TBizPartsHisExample example);

    @UpdateProvider(type=TBizPartsHisSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TBizPartsHis record);

    @Update({
        "update t_biz_parts_his",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "img_id = #{imgId,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(TBizPartsHis record);

    @Update({
        "update t_biz_parts_his",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "img_id = #{imgId,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TBizPartsHis record);
}