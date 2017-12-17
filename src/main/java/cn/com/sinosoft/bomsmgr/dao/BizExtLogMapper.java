package cn.com.sinosoft.bomsmgr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.com.sinosoft.bomsmgr.entity.VisitParam;

/**
 * 业务扩展mapper-日志
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年9月15日
 */
public interface BizExtLogMapper {

	/**
	 * 访问量-获取某一天
	 */
	 @Select({
        "select count",
        "from t_log_visit t",
        "where day = #{day,jdbcType=VARCHAR}"
    })
	public List<Integer> getVisitCount(String day);
	 
	 /**
	  * 访问量-总
	  */
	 @Select({
        "select sum(count) from t_log_visit t",
    })
	public Integer getVisitCountTotal();
	 
	/**
	 * 访问量-获取某一天
	 */
	 @Insert({
        "insert into t_log_visit",
        "(day, count)",
        "values (#{day}, #{count})"
    })
	public void insertVisitDay(VisitParam params);
	 
	 /**
	 * 访问量-增加一个某天
	 */
	 @Update({
        "update t_log_visit",
        "set count = count+1 where day = #{day}"
    })
	public void addOneCount(String day);

}
