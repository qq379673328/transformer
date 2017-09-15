package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBaseDics;
import cn.com.sinosoft.bomsmgr.entity.ge.TBaseDicsExample.Criteria;
import cn.com.sinosoft.bomsmgr.entity.ge.TBaseDicsExample.Criterion;
import cn.com.sinosoft.bomsmgr.entity.ge.TBaseDicsExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TBaseDicsSqlProvider {

    public String countByExample(TBaseDicsExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_base_dics");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TBaseDicsExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_base_dics");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TBaseDics record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_base_dics");
        
        if (record.getCodeType() != null) {
            sql.VALUES("code_type", "#{codeType,jdbcType=VARCHAR}");
        }
        
        if (record.getCodeValue() != null) {
            sql.VALUES("code_value", "#{codeValue,jdbcType=VARCHAR}");
        }
        
        if (record.getCodeDesc() != null) {
            sql.VALUES("code_desc", "#{codeDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getIsUse() != null) {
            sql.VALUES("is_use", "#{isUse,jdbcType=VARCHAR}");
        }
        
        if (record.getRank() != null) {
            sql.VALUES("`rank`", "#{rank,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TBaseDicsExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("code_type");
        sql.SELECT("code_value");
        sql.SELECT("code_desc");
        sql.SELECT("is_use");
        sql.SELECT("`rank`");
        sql.FROM("t_base_dics");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TBaseDics record = (TBaseDics) parameter.get("record");
        TBaseDicsExample example = (TBaseDicsExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_base_dics");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getCodeType() != null) {
            sql.SET("code_type = #{record.codeType,jdbcType=VARCHAR}");
        }
        
        if (record.getCodeValue() != null) {
            sql.SET("code_value = #{record.codeValue,jdbcType=VARCHAR}");
        }
        
        if (record.getCodeDesc() != null) {
            sql.SET("code_desc = #{record.codeDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getIsUse() != null) {
            sql.SET("is_use = #{record.isUse,jdbcType=VARCHAR}");
        }
        
        if (record.getRank() != null) {
            sql.SET("`rank` = #{record.rank,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_base_dics");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("code_type = #{record.codeType,jdbcType=VARCHAR}");
        sql.SET("code_value = #{record.codeValue,jdbcType=VARCHAR}");
        sql.SET("code_desc = #{record.codeDesc,jdbcType=VARCHAR}");
        sql.SET("is_use = #{record.isUse,jdbcType=VARCHAR}");
        sql.SET("`rank` = #{record.rank,jdbcType=INTEGER}");
        
        TBaseDicsExample example = (TBaseDicsExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TBaseDics record) {
        SQL sql = new SQL();
        sql.UPDATE("t_base_dics");
        
        if (record.getCodeType() != null) {
            sql.SET("code_type = #{codeType,jdbcType=VARCHAR}");
        }
        
        if (record.getCodeValue() != null) {
            sql.SET("code_value = #{codeValue,jdbcType=VARCHAR}");
        }
        
        if (record.getCodeDesc() != null) {
            sql.SET("code_desc = #{codeDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getIsUse() != null) {
            sql.SET("is_use = #{isUse,jdbcType=VARCHAR}");
        }
        
        if (record.getRank() != null) {
            sql.SET("`rank` = #{rank,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TBaseDicsExample example, boolean includeExamplePhrase) {
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