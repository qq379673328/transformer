package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceImg;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceImgExample.Criteria;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceImgExample.Criterion;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizDeviceImgExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TBizDeviceImgSqlProvider {

    public String countByExample(TBizDeviceImgExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_biz_device_img");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TBizDeviceImgExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_biz_device_img");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TBizDeviceImg record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_biz_device_img");
        
        if (record.getDesc() != null) {
            sql.VALUES("`desc`", "#{desc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            sql.VALUES("create_user", "#{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getImgId() != null) {
            sql.VALUES("img_id", "#{imgId,jdbcType=VARCHAR}");
        }
        
        if (record.getDeviceId() != null) {
            sql.VALUES("device_id", "#{deviceId,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyStatus() != null) {
            sql.VALUES("verify_status", "#{verifyStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyTime() != null) {
            sql.VALUES("verify_time", "#{verifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyUser() != null) {
            sql.VALUES("verify_user", "#{verifyUser,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyContent() != null) {
            sql.VALUES("verify_content", "#{verifyContent,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TBizDeviceImgExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("`desc`");
        sql.SELECT("create_time");
        sql.SELECT("create_user");
        sql.SELECT("img_id");
        sql.SELECT("device_id");
        sql.SELECT("verify_status");
        sql.SELECT("verify_time");
        sql.SELECT("verify_user");
        sql.SELECT("verify_content");
        sql.FROM("t_biz_device_img");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TBizDeviceImg record = (TBizDeviceImg) parameter.get("record");
        TBizDeviceImgExample example = (TBizDeviceImgExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_biz_device_img");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getDesc() != null) {
            sql.SET("`desc` = #{record.desc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            sql.SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getImgId() != null) {
            sql.SET("img_id = #{record.imgId,jdbcType=VARCHAR}");
        }
        
        if (record.getDeviceId() != null) {
            sql.SET("device_id = #{record.deviceId,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyStatus() != null) {
            sql.SET("verify_status = #{record.verifyStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyTime() != null) {
            sql.SET("verify_time = #{record.verifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyUser() != null) {
            sql.SET("verify_user = #{record.verifyUser,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyContent() != null) {
            sql.SET("verify_content = #{record.verifyContent,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_biz_device_img");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("`desc` = #{record.desc,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        sql.SET("img_id = #{record.imgId,jdbcType=VARCHAR}");
        sql.SET("device_id = #{record.deviceId,jdbcType=INTEGER}");
        sql.SET("verify_status = #{record.verifyStatus,jdbcType=VARCHAR}");
        sql.SET("verify_time = #{record.verifyTime,jdbcType=TIMESTAMP}");
        sql.SET("verify_user = #{record.verifyUser,jdbcType=VARCHAR}");
        sql.SET("verify_content = #{record.verifyContent,jdbcType=VARCHAR}");
        
        TBizDeviceImgExample example = (TBizDeviceImgExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TBizDeviceImg record) {
        SQL sql = new SQL();
        sql.UPDATE("t_biz_device_img");
        
        if (record.getDesc() != null) {
            sql.SET("`desc` = #{desc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            sql.SET("create_user = #{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getImgId() != null) {
            sql.SET("img_id = #{imgId,jdbcType=VARCHAR}");
        }
        
        if (record.getDeviceId() != null) {
            sql.SET("device_id = #{deviceId,jdbcType=INTEGER}");
        }
        
        if (record.getVerifyStatus() != null) {
            sql.SET("verify_status = #{verifyStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyTime() != null) {
            sql.SET("verify_time = #{verifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVerifyUser() != null) {
            sql.SET("verify_user = #{verifyUser,jdbcType=VARCHAR}");
        }
        
        if (record.getVerifyContent() != null) {
            sql.SET("verify_content = #{verifyContent,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TBizDeviceImgExample example, boolean includeExamplePhrase) {
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