package cn.com.sinosoft.bomsmgr.entity.ge;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAuthMenufunExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAuthMenufunExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("UPDATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("UPDATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("UPDATE_USER =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("UPDATE_USER <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("UPDATE_USER >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("UPDATE_USER <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("UPDATE_USER like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("UPDATE_USER not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("UPDATE_USER in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("UPDATE_USER not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("UPDATE_USER between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USER not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andMfIdIsNull() {
            addCriterion("MF_ID is null");
            return (Criteria) this;
        }

        public Criteria andMfIdIsNotNull() {
            addCriterion("MF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMfIdEqualTo(String value) {
            addCriterion("MF_ID =", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdNotEqualTo(String value) {
            addCriterion("MF_ID <>", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdGreaterThan(String value) {
            addCriterion("MF_ID >", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdGreaterThanOrEqualTo(String value) {
            addCriterion("MF_ID >=", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdLessThan(String value) {
            addCriterion("MF_ID <", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdLessThanOrEqualTo(String value) {
            addCriterion("MF_ID <=", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdLike(String value) {
            addCriterion("MF_ID like", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdNotLike(String value) {
            addCriterion("MF_ID not like", value, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdIn(List<String> values) {
            addCriterion("MF_ID in", values, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdNotIn(List<String> values) {
            addCriterion("MF_ID not in", values, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdBetween(String value1, String value2) {
            addCriterion("MF_ID between", value1, value2, "mfId");
            return (Criteria) this;
        }

        public Criteria andMfIdNotBetween(String value1, String value2) {
            addCriterion("MF_ID not between", value1, value2, "mfId");
            return (Criteria) this;
        }

        public Criteria andPmfIdIsNull() {
            addCriterion("PMF_ID is null");
            return (Criteria) this;
        }

        public Criteria andPmfIdIsNotNull() {
            addCriterion("PMF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPmfIdEqualTo(String value) {
            addCriterion("PMF_ID =", value, "pmfId");
            return (Criteria) this;
        }

        public Criteria andPmfIdNotEqualTo(String value) {
            addCriterion("PMF_ID <>", value, "pmfId");
            return (Criteria) this;
        }

        public Criteria andPmfIdGreaterThan(String value) {
            addCriterion("PMF_ID >", value, "pmfId");
            return (Criteria) this;
        }

        public Criteria andPmfIdGreaterThanOrEqualTo(String value) {
            addCriterion("PMF_ID >=", value, "pmfId");
            return (Criteria) this;
        }

        public Criteria andPmfIdLessThan(String value) {
            addCriterion("PMF_ID <", value, "pmfId");
            return (Criteria) this;
        }

        public Criteria andPmfIdLessThanOrEqualTo(String value) {
            addCriterion("PMF_ID <=", value, "pmfId");
            return (Criteria) this;
        }

        public Criteria andPmfIdLike(String value) {
            addCriterion("PMF_ID like", value, "pmfId");
            return (Criteria) this;
        }

        public Criteria andPmfIdNotLike(String value) {
            addCriterion("PMF_ID not like", value, "pmfId");
            return (Criteria) this;
        }

        public Criteria andPmfIdIn(List<String> values) {
            addCriterion("PMF_ID in", values, "pmfId");
            return (Criteria) this;
        }

        public Criteria andPmfIdNotIn(List<String> values) {
            addCriterion("PMF_ID not in", values, "pmfId");
            return (Criteria) this;
        }

        public Criteria andPmfIdBetween(String value1, String value2) {
            addCriterion("PMF_ID between", value1, value2, "pmfId");
            return (Criteria) this;
        }

        public Criteria andPmfIdNotBetween(String value1, String value2) {
            addCriterion("PMF_ID not between", value1, value2, "pmfId");
            return (Criteria) this;
        }

        public Criteria andMfNameIsNull() {
            addCriterion("MF_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMfNameIsNotNull() {
            addCriterion("MF_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMfNameEqualTo(String value) {
            addCriterion("MF_NAME =", value, "mfName");
            return (Criteria) this;
        }

        public Criteria andMfNameNotEqualTo(String value) {
            addCriterion("MF_NAME <>", value, "mfName");
            return (Criteria) this;
        }

        public Criteria andMfNameGreaterThan(String value) {
            addCriterion("MF_NAME >", value, "mfName");
            return (Criteria) this;
        }

        public Criteria andMfNameGreaterThanOrEqualTo(String value) {
            addCriterion("MF_NAME >=", value, "mfName");
            return (Criteria) this;
        }

        public Criteria andMfNameLessThan(String value) {
            addCriterion("MF_NAME <", value, "mfName");
            return (Criteria) this;
        }

        public Criteria andMfNameLessThanOrEqualTo(String value) {
            addCriterion("MF_NAME <=", value, "mfName");
            return (Criteria) this;
        }

        public Criteria andMfNameLike(String value) {
            addCriterion("MF_NAME like", value, "mfName");
            return (Criteria) this;
        }

        public Criteria andMfNameNotLike(String value) {
            addCriterion("MF_NAME not like", value, "mfName");
            return (Criteria) this;
        }

        public Criteria andMfNameIn(List<String> values) {
            addCriterion("MF_NAME in", values, "mfName");
            return (Criteria) this;
        }

        public Criteria andMfNameNotIn(List<String> values) {
            addCriterion("MF_NAME not in", values, "mfName");
            return (Criteria) this;
        }

        public Criteria andMfNameBetween(String value1, String value2) {
            addCriterion("MF_NAME between", value1, value2, "mfName");
            return (Criteria) this;
        }

        public Criteria andMfNameNotBetween(String value1, String value2) {
            addCriterion("MF_NAME not between", value1, value2, "mfName");
            return (Criteria) this;
        }

        public Criteria andMfLinkIsNull() {
            addCriterion("MF_LINK is null");
            return (Criteria) this;
        }

        public Criteria andMfLinkIsNotNull() {
            addCriterion("MF_LINK is not null");
            return (Criteria) this;
        }

        public Criteria andMfLinkEqualTo(String value) {
            addCriterion("MF_LINK =", value, "mfLink");
            return (Criteria) this;
        }

        public Criteria andMfLinkNotEqualTo(String value) {
            addCriterion("MF_LINK <>", value, "mfLink");
            return (Criteria) this;
        }

        public Criteria andMfLinkGreaterThan(String value) {
            addCriterion("MF_LINK >", value, "mfLink");
            return (Criteria) this;
        }

        public Criteria andMfLinkGreaterThanOrEqualTo(String value) {
            addCriterion("MF_LINK >=", value, "mfLink");
            return (Criteria) this;
        }

        public Criteria andMfLinkLessThan(String value) {
            addCriterion("MF_LINK <", value, "mfLink");
            return (Criteria) this;
        }

        public Criteria andMfLinkLessThanOrEqualTo(String value) {
            addCriterion("MF_LINK <=", value, "mfLink");
            return (Criteria) this;
        }

        public Criteria andMfLinkLike(String value) {
            addCriterion("MF_LINK like", value, "mfLink");
            return (Criteria) this;
        }

        public Criteria andMfLinkNotLike(String value) {
            addCriterion("MF_LINK not like", value, "mfLink");
            return (Criteria) this;
        }

        public Criteria andMfLinkIn(List<String> values) {
            addCriterion("MF_LINK in", values, "mfLink");
            return (Criteria) this;
        }

        public Criteria andMfLinkNotIn(List<String> values) {
            addCriterion("MF_LINK not in", values, "mfLink");
            return (Criteria) this;
        }

        public Criteria andMfLinkBetween(String value1, String value2) {
            addCriterion("MF_LINK between", value1, value2, "mfLink");
            return (Criteria) this;
        }

        public Criteria andMfLinkNotBetween(String value1, String value2) {
            addCriterion("MF_LINK not between", value1, value2, "mfLink");
            return (Criteria) this;
        }

        public Criteria andMfTypeIsNull() {
            addCriterion("MF_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMfTypeIsNotNull() {
            addCriterion("MF_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMfTypeEqualTo(String value) {
            addCriterion("MF_TYPE =", value, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeNotEqualTo(String value) {
            addCriterion("MF_TYPE <>", value, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeGreaterThan(String value) {
            addCriterion("MF_TYPE >", value, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MF_TYPE >=", value, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeLessThan(String value) {
            addCriterion("MF_TYPE <", value, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeLessThanOrEqualTo(String value) {
            addCriterion("MF_TYPE <=", value, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeLike(String value) {
            addCriterion("MF_TYPE like", value, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeNotLike(String value) {
            addCriterion("MF_TYPE not like", value, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeIn(List<String> values) {
            addCriterion("MF_TYPE in", values, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeNotIn(List<String> values) {
            addCriterion("MF_TYPE not in", values, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeBetween(String value1, String value2) {
            addCriterion("MF_TYPE between", value1, value2, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfTypeNotBetween(String value1, String value2) {
            addCriterion("MF_TYPE not between", value1, value2, "mfType");
            return (Criteria) this;
        }

        public Criteria andMfDescIsNull() {
            addCriterion("MF_DESC is null");
            return (Criteria) this;
        }

        public Criteria andMfDescIsNotNull() {
            addCriterion("MF_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andMfDescEqualTo(String value) {
            addCriterion("MF_DESC =", value, "mfDesc");
            return (Criteria) this;
        }

        public Criteria andMfDescNotEqualTo(String value) {
            addCriterion("MF_DESC <>", value, "mfDesc");
            return (Criteria) this;
        }

        public Criteria andMfDescGreaterThan(String value) {
            addCriterion("MF_DESC >", value, "mfDesc");
            return (Criteria) this;
        }

        public Criteria andMfDescGreaterThanOrEqualTo(String value) {
            addCriterion("MF_DESC >=", value, "mfDesc");
            return (Criteria) this;
        }

        public Criteria andMfDescLessThan(String value) {
            addCriterion("MF_DESC <", value, "mfDesc");
            return (Criteria) this;
        }

        public Criteria andMfDescLessThanOrEqualTo(String value) {
            addCriterion("MF_DESC <=", value, "mfDesc");
            return (Criteria) this;
        }

        public Criteria andMfDescLike(String value) {
            addCriterion("MF_DESC like", value, "mfDesc");
            return (Criteria) this;
        }

        public Criteria andMfDescNotLike(String value) {
            addCriterion("MF_DESC not like", value, "mfDesc");
            return (Criteria) this;
        }

        public Criteria andMfDescIn(List<String> values) {
            addCriterion("MF_DESC in", values, "mfDesc");
            return (Criteria) this;
        }

        public Criteria andMfDescNotIn(List<String> values) {
            addCriterion("MF_DESC not in", values, "mfDesc");
            return (Criteria) this;
        }

        public Criteria andMfDescBetween(String value1, String value2) {
            addCriterion("MF_DESC between", value1, value2, "mfDesc");
            return (Criteria) this;
        }

        public Criteria andMfDescNotBetween(String value1, String value2) {
            addCriterion("MF_DESC not between", value1, value2, "mfDesc");
            return (Criteria) this;
        }

        public Criteria andMfRankIsNull() {
            addCriterion("MF_RANK is null");
            return (Criteria) this;
        }

        public Criteria andMfRankIsNotNull() {
            addCriterion("MF_RANK is not null");
            return (Criteria) this;
        }

        public Criteria andMfRankEqualTo(String value) {
            addCriterion("MF_RANK =", value, "mfRank");
            return (Criteria) this;
        }

        public Criteria andMfRankNotEqualTo(String value) {
            addCriterion("MF_RANK <>", value, "mfRank");
            return (Criteria) this;
        }

        public Criteria andMfRankGreaterThan(String value) {
            addCriterion("MF_RANK >", value, "mfRank");
            return (Criteria) this;
        }

        public Criteria andMfRankGreaterThanOrEqualTo(String value) {
            addCriterion("MF_RANK >=", value, "mfRank");
            return (Criteria) this;
        }

        public Criteria andMfRankLessThan(String value) {
            addCriterion("MF_RANK <", value, "mfRank");
            return (Criteria) this;
        }

        public Criteria andMfRankLessThanOrEqualTo(String value) {
            addCriterion("MF_RANK <=", value, "mfRank");
            return (Criteria) this;
        }

        public Criteria andMfRankLike(String value) {
            addCriterion("MF_RANK like", value, "mfRank");
            return (Criteria) this;
        }

        public Criteria andMfRankNotLike(String value) {
            addCriterion("MF_RANK not like", value, "mfRank");
            return (Criteria) this;
        }

        public Criteria andMfRankIn(List<String> values) {
            addCriterion("MF_RANK in", values, "mfRank");
            return (Criteria) this;
        }

        public Criteria andMfRankNotIn(List<String> values) {
            addCriterion("MF_RANK not in", values, "mfRank");
            return (Criteria) this;
        }

        public Criteria andMfRankBetween(String value1, String value2) {
            addCriterion("MF_RANK between", value1, value2, "mfRank");
            return (Criteria) this;
        }

        public Criteria andMfRankNotBetween(String value1, String value2) {
            addCriterion("MF_RANK not between", value1, value2, "mfRank");
            return (Criteria) this;
        }

        public Criteria andMfLevelIsNull() {
            addCriterion("MF_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andMfLevelIsNotNull() {
            addCriterion("MF_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andMfLevelEqualTo(String value) {
            addCriterion("MF_LEVEL =", value, "mfLevel");
            return (Criteria) this;
        }

        public Criteria andMfLevelNotEqualTo(String value) {
            addCriterion("MF_LEVEL <>", value, "mfLevel");
            return (Criteria) this;
        }

        public Criteria andMfLevelGreaterThan(String value) {
            addCriterion("MF_LEVEL >", value, "mfLevel");
            return (Criteria) this;
        }

        public Criteria andMfLevelGreaterThanOrEqualTo(String value) {
            addCriterion("MF_LEVEL >=", value, "mfLevel");
            return (Criteria) this;
        }

        public Criteria andMfLevelLessThan(String value) {
            addCriterion("MF_LEVEL <", value, "mfLevel");
            return (Criteria) this;
        }

        public Criteria andMfLevelLessThanOrEqualTo(String value) {
            addCriterion("MF_LEVEL <=", value, "mfLevel");
            return (Criteria) this;
        }

        public Criteria andMfLevelLike(String value) {
            addCriterion("MF_LEVEL like", value, "mfLevel");
            return (Criteria) this;
        }

        public Criteria andMfLevelNotLike(String value) {
            addCriterion("MF_LEVEL not like", value, "mfLevel");
            return (Criteria) this;
        }

        public Criteria andMfLevelIn(List<String> values) {
            addCriterion("MF_LEVEL in", values, "mfLevel");
            return (Criteria) this;
        }

        public Criteria andMfLevelNotIn(List<String> values) {
            addCriterion("MF_LEVEL not in", values, "mfLevel");
            return (Criteria) this;
        }

        public Criteria andMfLevelBetween(String value1, String value2) {
            addCriterion("MF_LEVEL between", value1, value2, "mfLevel");
            return (Criteria) this;
        }

        public Criteria andMfLevelNotBetween(String value1, String value2) {
            addCriterion("MF_LEVEL not between", value1, value2, "mfLevel");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}