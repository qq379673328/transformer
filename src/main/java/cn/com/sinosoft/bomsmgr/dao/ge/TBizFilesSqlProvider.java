package cn.com.sinosoft.bomsmgr.dao.ge;

import cn.com.sinosoft.bomsmgr.entity.ge.TBizFiles;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizFilesExample.Criteria;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizFilesExample.Criterion;
import cn.com.sinosoft.bomsmgr.entity.ge.TBizFilesExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TBizFilesSqlProvider {

    public String countByExample(TBizFilesExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_biz_files");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TBizFilesExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_biz_files");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TBizFiles record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_biz_files");
        
        if (record.getFilenameSrc() != null) {
            sql.VALUES("filename_src", "#{filenameSrc,jdbcType=VARCHAR}");
        }
        
        if (record.getFilenameNew() != null) {
            sql.VALUES("filename_new", "#{filenameNew,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            sql.VALUES("create_user", "#{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            sql.VALUES("`path`", "#{path,jdbcType=VARCHAR}");
        }
        
        if (record.getFiletype() != null) {
            sql.VALUES("filetype", "#{filetype,jdbcType=VARCHAR}");
        }
        
        if (record.getFilesize() != null) {
            sql.VALUES("filesize", "#{filesize,jdbcType=DOUBLE}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TBizFilesExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("filename_src");
        sql.SELECT("filename_new");
        sql.SELECT("create_time");
        sql.SELECT("create_user");
        sql.SELECT("`path`");
        sql.SELECT("filetype");
        sql.SELECT("filesize");
        sql.FROM("t_biz_files");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TBizFiles record = (TBizFiles) parameter.get("record");
        TBizFilesExample example = (TBizFilesExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_biz_files");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getFilenameSrc() != null) {
            sql.SET("filename_src = #{record.filenameSrc,jdbcType=VARCHAR}");
        }
        
        if (record.getFilenameNew() != null) {
            sql.SET("filename_new = #{record.filenameNew,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            sql.SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            sql.SET("`path` = #{record.path,jdbcType=VARCHAR}");
        }
        
        if (record.getFiletype() != null) {
            sql.SET("filetype = #{record.filetype,jdbcType=VARCHAR}");
        }
        
        if (record.getFilesize() != null) {
            sql.SET("filesize = #{record.filesize,jdbcType=DOUBLE}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_biz_files");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("filename_src = #{record.filenameSrc,jdbcType=VARCHAR}");
        sql.SET("filename_new = #{record.filenameNew,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        sql.SET("`path` = #{record.path,jdbcType=VARCHAR}");
        sql.SET("filetype = #{record.filetype,jdbcType=VARCHAR}");
        sql.SET("filesize = #{record.filesize,jdbcType=DOUBLE}");
        
        TBizFilesExample example = (TBizFilesExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TBizFiles record) {
        SQL sql = new SQL();
        sql.UPDATE("t_biz_files");
        
        if (record.getFilenameSrc() != null) {
            sql.SET("filename_src = #{filenameSrc,jdbcType=VARCHAR}");
        }
        
        if (record.getFilenameNew() != null) {
            sql.SET("filename_new = #{filenameNew,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            sql.SET("create_user = #{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            sql.SET("`path` = #{path,jdbcType=VARCHAR}");
        }
        
        if (record.getFiletype() != null) {
            sql.SET("filetype = #{filetype,jdbcType=VARCHAR}");
        }
        
        if (record.getFilesize() != null) {
            sql.SET("filesize = #{filesize,jdbcType=DOUBLE}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TBizFilesExample example, boolean includeExamplePhrase) {
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