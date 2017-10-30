package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TSystemConfig;
import cn.com.sinosoft.bomsmgr.entity.ge.TSystemConfigExample.Criteria;
import cn.com.sinosoft.bomsmgr.entity.ge.TSystemConfigExample.Criterion;
import cn.com.sinosoft.bomsmgr.entity.ge.TSystemConfigExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TSystemConfigSqlProvider {

    public String countByExample(TSystemConfigExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_system_config");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TSystemConfigExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_system_config");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TSystemConfig record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_system_config");
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            sql.VALUES("update_user", "#{updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleId() != null) {
            sql.VALUES("module_id", "#{moduleId,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleDesc() != null) {
            sql.VALUES("module_desc", "#{moduleDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("`type`", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getKey() != null) {
            sql.VALUES("`key`", "#{key,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(TSystemConfigExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("update_time");
        sql.SELECT("update_user");
        sql.SELECT("module_id");
        sql.SELECT("module_desc");
        sql.SELECT("`type`");
        sql.SELECT("`key`");
        sql.SELECT("content");
        sql.FROM("t_system_config");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(TSystemConfigExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("update_time");
        sql.SELECT("update_user");
        sql.SELECT("module_id");
        sql.SELECT("module_desc");
        sql.SELECT("`type`");
        sql.SELECT("`key`");
        sql.FROM("t_system_config");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TSystemConfig record = (TSystemConfig) parameter.get("record");
        TSystemConfigExample example = (TSystemConfigExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_system_config");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            sql.SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleId() != null) {
            sql.SET("module_id = #{record.moduleId,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleDesc() != null) {
            sql.SET("module_desc = #{record.moduleDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getKey() != null) {
            sql.SET("`key` = #{record.key,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_system_config");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        sql.SET("module_id = #{record.moduleId,jdbcType=VARCHAR}");
        sql.SET("module_desc = #{record.moduleDesc,jdbcType=VARCHAR}");
        sql.SET("`type` = #{record.type,jdbcType=VARCHAR}");
        sql.SET("`key` = #{record.key,jdbcType=VARCHAR}");
        sql.SET("content = #{record.content,jdbcType=LONGVARCHAR}");
        
        TSystemConfigExample example = (TSystemConfigExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_system_config");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        sql.SET("module_id = #{record.moduleId,jdbcType=VARCHAR}");
        sql.SET("module_desc = #{record.moduleDesc,jdbcType=VARCHAR}");
        sql.SET("`type` = #{record.type,jdbcType=VARCHAR}");
        sql.SET("`key` = #{record.key,jdbcType=VARCHAR}");
        
        TSystemConfigExample example = (TSystemConfigExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TSystemConfig record) {
        SQL sql = new SQL();
        sql.UPDATE("t_system_config");
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            sql.SET("update_user = #{updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleId() != null) {
            sql.SET("module_id = #{moduleId,jdbcType=VARCHAR}");
        }
        
        if (record.getModuleDesc() != null) {
            sql.SET("module_desc = #{moduleDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("`type` = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getKey() != null) {
            sql.SET("`key` = #{key,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TSystemConfigExample example, boolean includeExamplePhrase) {
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