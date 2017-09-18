package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizDevice;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceExample.Criteria;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceExample.Criterion;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TBizDeviceSqlProvider {

    public String countByExample(TBizDeviceExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_biz_device");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TBizDeviceExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_biz_device");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TBizDevice record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_biz_device");
        
        if (record.getName() != null) {
            sql.VALUES("`name`", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeId() != null) {
            sql.VALUES("type_id", "#{typeId,jdbcType=INTEGER}");
        }
        
        if (record.getDesc() != null) {
            sql.VALUES("`desc`", "#{desc,jdbcType=VARCHAR}");
        }
        
        if (record.getWiringdiagramId() != null) {
            sql.VALUES("wiringdiagram_id", "#{wiringdiagramId,jdbcType=INTEGER}");
        }
        
        if (record.getImgId() != null) {
            sql.VALUES("img_id", "#{imgId,jdbcType=VARCHAR}");
        }
        
        if (record.getX() != null) {
            sql.VALUES("x", "#{x,jdbcType=INTEGER}");
        }
        
        if (record.getY() != null) {
            sql.VALUES("y", "#{y,jdbcType=INTEGER}");
        }
        
        if (record.getWidth() != null) {
            sql.VALUES("width", "#{width,jdbcType=INTEGER}");
        }
        
        if (record.getHeight() != null) {
            sql.VALUES("height", "#{height,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUser() != null) {
            sql.VALUES("create_user", "#{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TBizDeviceExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("`name`");
        sql.SELECT("type_id");
        sql.SELECT("`desc`");
        sql.SELECT("wiringdiagram_id");
        sql.SELECT("img_id");
        sql.SELECT("x");
        sql.SELECT("y");
        sql.SELECT("width");
        sql.SELECT("height");
        sql.SELECT("create_user");
        sql.SELECT("create_time");
        sql.FROM("t_biz_device");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TBizDevice record = (TBizDevice) parameter.get("record");
        TBizDeviceExample example = (TBizDeviceExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_biz_device");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeId() != null) {
            sql.SET("type_id = #{record.typeId,jdbcType=INTEGER}");
        }
        
        if (record.getDesc() != null) {
            sql.SET("`desc` = #{record.desc,jdbcType=VARCHAR}");
        }
        
        if (record.getWiringdiagramId() != null) {
            sql.SET("wiringdiagram_id = #{record.wiringdiagramId,jdbcType=INTEGER}");
        }
        
        if (record.getImgId() != null) {
            sql.SET("img_id = #{record.imgId,jdbcType=VARCHAR}");
        }
        
        if (record.getX() != null) {
            sql.SET("x = #{record.x,jdbcType=INTEGER}");
        }
        
        if (record.getY() != null) {
            sql.SET("y = #{record.y,jdbcType=INTEGER}");
        }
        
        if (record.getWidth() != null) {
            sql.SET("width = #{record.width,jdbcType=INTEGER}");
        }
        
        if (record.getHeight() != null) {
            sql.SET("height = #{record.height,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUser() != null) {
            sql.SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_biz_device");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("`name` = #{record.name,jdbcType=VARCHAR}");
        sql.SET("type_id = #{record.typeId,jdbcType=INTEGER}");
        sql.SET("`desc` = #{record.desc,jdbcType=VARCHAR}");
        sql.SET("wiringdiagram_id = #{record.wiringdiagramId,jdbcType=INTEGER}");
        sql.SET("img_id = #{record.imgId,jdbcType=VARCHAR}");
        sql.SET("x = #{record.x,jdbcType=INTEGER}");
        sql.SET("y = #{record.y,jdbcType=INTEGER}");
        sql.SET("width = #{record.width,jdbcType=INTEGER}");
        sql.SET("height = #{record.height,jdbcType=INTEGER}");
        sql.SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        TBizDeviceExample example = (TBizDeviceExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TBizDevice record) {
        SQL sql = new SQL();
        sql.UPDATE("t_biz_device");
        
        if (record.getName() != null) {
            sql.SET("`name` = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeId() != null) {
            sql.SET("type_id = #{typeId,jdbcType=INTEGER}");
        }
        
        if (record.getDesc() != null) {
            sql.SET("`desc` = #{desc,jdbcType=VARCHAR}");
        }
        
        if (record.getWiringdiagramId() != null) {
            sql.SET("wiringdiagram_id = #{wiringdiagramId,jdbcType=INTEGER}");
        }
        
        if (record.getImgId() != null) {
            sql.SET("img_id = #{imgId,jdbcType=VARCHAR}");
        }
        
        if (record.getX() != null) {
            sql.SET("x = #{x,jdbcType=INTEGER}");
        }
        
        if (record.getY() != null) {
            sql.SET("y = #{y,jdbcType=INTEGER}");
        }
        
        if (record.getWidth() != null) {
            sql.SET("width = #{width,jdbcType=INTEGER}");
        }
        
        if (record.getHeight() != null) {
            sql.SET("height = #{height,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUser() != null) {
            sql.SET("create_user = #{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TBizDeviceExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}