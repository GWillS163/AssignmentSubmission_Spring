package com.mengjq.assignmentsubmission_spring.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssignmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public AssignmentExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andAssiidIsNull() {
            addCriterion("assiId is null");
            return (Criteria) this;
        }

        public Criteria andAssiidIsNotNull() {
            addCriterion("assiId is not null");
            return (Criteria) this;
        }

        public Criteria andAssiidEqualTo(Integer value) {
            addCriterion("assiId =", value, "assiid");
            return (Criteria) this;
        }

        public Criteria andAssiidNotEqualTo(Integer value) {
            addCriterion("assiId <>", value, "assiid");
            return (Criteria) this;
        }

        public Criteria andAssiidGreaterThan(Integer value) {
            addCriterion("assiId >", value, "assiid");
            return (Criteria) this;
        }

        public Criteria andAssiidGreaterThanOrEqualTo(Integer value) {
            addCriterion("assiId >=", value, "assiid");
            return (Criteria) this;
        }

        public Criteria andAssiidLessThan(Integer value) {
            addCriterion("assiId <", value, "assiid");
            return (Criteria) this;
        }

        public Criteria andAssiidLessThanOrEqualTo(Integer value) {
            addCriterion("assiId <=", value, "assiid");
            return (Criteria) this;
        }

        public Criteria andAssiidIn(List<Integer> values) {
            addCriterion("assiId in", values, "assiid");
            return (Criteria) this;
        }

        public Criteria andAssiidNotIn(List<Integer> values) {
            addCriterion("assiId not in", values, "assiid");
            return (Criteria) this;
        }

        public Criteria andAssiidBetween(Integer value1, Integer value2) {
            addCriterion("assiId between", value1, value2, "assiid");
            return (Criteria) this;
        }

        public Criteria andAssiidNotBetween(Integer value1, Integer value2) {
            addCriterion("assiId not between", value1, value2, "assiid");
            return (Criteria) this;
        }

        public Criteria andCurriidIsNull() {
            addCriterion("curriId is null");
            return (Criteria) this;
        }

        public Criteria andCurriidIsNotNull() {
            addCriterion("curriId is not null");
            return (Criteria) this;
        }

        public Criteria andCurriidEqualTo(Integer value) {
            addCriterion("curriId =", value, "curriid");
            return (Criteria) this;
        }

        public Criteria andCurriidNotEqualTo(Integer value) {
            addCriterion("curriId <>", value, "curriid");
            return (Criteria) this;
        }

        public Criteria andCurriidGreaterThan(Integer value) {
            addCriterion("curriId >", value, "curriid");
            return (Criteria) this;
        }

        public Criteria andCurriidGreaterThanOrEqualTo(Integer value) {
            addCriterion("curriId >=", value, "curriid");
            return (Criteria) this;
        }

        public Criteria andCurriidLessThan(Integer value) {
            addCriterion("curriId <", value, "curriid");
            return (Criteria) this;
        }

        public Criteria andCurriidLessThanOrEqualTo(Integer value) {
            addCriterion("curriId <=", value, "curriid");
            return (Criteria) this;
        }

        public Criteria andCurriidIn(List<Integer> values) {
            addCriterion("curriId in", values, "curriid");
            return (Criteria) this;
        }

        public Criteria andCurriidNotIn(List<Integer> values) {
            addCriterion("curriId not in", values, "curriid");
            return (Criteria) this;
        }

        public Criteria andCurriidBetween(Integer value1, Integer value2) {
            addCriterion("curriId between", value1, value2, "curriid");
            return (Criteria) this;
        }

        public Criteria andCurriidNotBetween(Integer value1, Integer value2) {
            addCriterion("curriId not between", value1, value2, "curriid");
            return (Criteria) this;
        }

        public Criteria andDdlIsNull() {
            addCriterion("ddl is null");
            return (Criteria) this;
        }

        public Criteria andDdlIsNotNull() {
            addCriterion("ddl is not null");
            return (Criteria) this;
        }

        public Criteria andDdlEqualTo(Date value) {
            addCriterion("ddl =", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlNotEqualTo(Date value) {
            addCriterion("ddl <>", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlGreaterThan(Date value) {
            addCriterion("ddl >", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlGreaterThanOrEqualTo(Date value) {
            addCriterion("ddl >=", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlLessThan(Date value) {
            addCriterion("ddl <", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlLessThanOrEqualTo(Date value) {
            addCriterion("ddl <=", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlIn(List<Date> values) {
            addCriterion("ddl in", values, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlNotIn(List<Date> values) {
            addCriterion("ddl not in", values, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlBetween(Date value1, Date value2) {
            addCriterion("ddl between", value1, value2, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlNotBetween(Date value1, Date value2) {
            addCriterion("ddl not between", value1, value2, "ddl");
            return (Criteria) this;
        }

        public Criteria andPermitanymousIsNull() {
            addCriterion("permitAnymous is null");
            return (Criteria) this;
        }

        public Criteria andPermitanymousIsNotNull() {
            addCriterion("permitAnymous is not null");
            return (Criteria) this;
        }

        public Criteria andPermitanymousEqualTo(Byte value) {
            addCriterion("permitAnymous =", value, "permitanymous");
            return (Criteria) this;
        }

        public Criteria andPermitanymousNotEqualTo(Byte value) {
            addCriterion("permitAnymous <>", value, "permitanymous");
            return (Criteria) this;
        }

        public Criteria andPermitanymousGreaterThan(Byte value) {
            addCriterion("permitAnymous >", value, "permitanymous");
            return (Criteria) this;
        }

        public Criteria andPermitanymousGreaterThanOrEqualTo(Byte value) {
            addCriterion("permitAnymous >=", value, "permitanymous");
            return (Criteria) this;
        }

        public Criteria andPermitanymousLessThan(Byte value) {
            addCriterion("permitAnymous <", value, "permitanymous");
            return (Criteria) this;
        }

        public Criteria andPermitanymousLessThanOrEqualTo(Byte value) {
            addCriterion("permitAnymous <=", value, "permitanymous");
            return (Criteria) this;
        }

        public Criteria andPermitanymousIn(List<Byte> values) {
            addCriterion("permitAnymous in", values, "permitanymous");
            return (Criteria) this;
        }

        public Criteria andPermitanymousNotIn(List<Byte> values) {
            addCriterion("permitAnymous not in", values, "permitanymous");
            return (Criteria) this;
        }

        public Criteria andPermitanymousBetween(Byte value1, Byte value2) {
            addCriterion("permitAnymous between", value1, value2, "permitanymous");
            return (Criteria) this;
        }

        public Criteria andPermitanymousNotBetween(Byte value1, Byte value2) {
            addCriterion("permitAnymous not between", value1, value2, "permitanymous");
            return (Criteria) this;
        }

        public Criteria andFilenameverifyIsNull() {
            addCriterion("fileNameVerify is null");
            return (Criteria) this;
        }

        public Criteria andFilenameverifyIsNotNull() {
            addCriterion("fileNameVerify is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameverifyEqualTo(Byte value) {
            addCriterion("fileNameVerify =", value, "filenameverify");
            return (Criteria) this;
        }

        public Criteria andFilenameverifyNotEqualTo(Byte value) {
            addCriterion("fileNameVerify <>", value, "filenameverify");
            return (Criteria) this;
        }

        public Criteria andFilenameverifyGreaterThan(Byte value) {
            addCriterion("fileNameVerify >", value, "filenameverify");
            return (Criteria) this;
        }

        public Criteria andFilenameverifyGreaterThanOrEqualTo(Byte value) {
            addCriterion("fileNameVerify >=", value, "filenameverify");
            return (Criteria) this;
        }

        public Criteria andFilenameverifyLessThan(Byte value) {
            addCriterion("fileNameVerify <", value, "filenameverify");
            return (Criteria) this;
        }

        public Criteria andFilenameverifyLessThanOrEqualTo(Byte value) {
            addCriterion("fileNameVerify <=", value, "filenameverify");
            return (Criteria) this;
        }

        public Criteria andFilenameverifyIn(List<Byte> values) {
            addCriterion("fileNameVerify in", values, "filenameverify");
            return (Criteria) this;
        }

        public Criteria andFilenameverifyNotIn(List<Byte> values) {
            addCriterion("fileNameVerify not in", values, "filenameverify");
            return (Criteria) this;
        }

        public Criteria andFilenameverifyBetween(Byte value1, Byte value2) {
            addCriterion("fileNameVerify between", value1, value2, "filenameverify");
            return (Criteria) this;
        }

        public Criteria andFilenameverifyNotBetween(Byte value1, Byte value2) {
            addCriterion("fileNameVerify not between", value1, value2, "filenameverify");
            return (Criteria) this;
        }

        public Criteria andUpdatedtimeIsNull() {
            addCriterion("updatedTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedtimeIsNotNull() {
            addCriterion("updatedTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedtimeEqualTo(Date value) {
            addCriterion("updatedTime =", value, "updatedtime");
            return (Criteria) this;
        }

        public Criteria andUpdatedtimeNotEqualTo(Date value) {
            addCriterion("updatedTime <>", value, "updatedtime");
            return (Criteria) this;
        }

        public Criteria andUpdatedtimeGreaterThan(Date value) {
            addCriterion("updatedTime >", value, "updatedtime");
            return (Criteria) this;
        }

        public Criteria andUpdatedtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatedTime >=", value, "updatedtime");
            return (Criteria) this;
        }

        public Criteria andUpdatedtimeLessThan(Date value) {
            addCriterion("updatedTime <", value, "updatedtime");
            return (Criteria) this;
        }

        public Criteria andUpdatedtimeLessThanOrEqualTo(Date value) {
            addCriterion("updatedTime <=", value, "updatedtime");
            return (Criteria) this;
        }

        public Criteria andUpdatedtimeIn(List<Date> values) {
            addCriterion("updatedTime in", values, "updatedtime");
            return (Criteria) this;
        }

        public Criteria andUpdatedtimeNotIn(List<Date> values) {
            addCriterion("updatedTime not in", values, "updatedtime");
            return (Criteria) this;
        }

        public Criteria andUpdatedtimeBetween(Date value1, Date value2) {
            addCriterion("updatedTime between", value1, value2, "updatedtime");
            return (Criteria) this;
        }

        public Criteria andUpdatedtimeNotBetween(Date value1, Date value2) {
            addCriterion("updatedTime not between", value1, value2, "updatedtime");
            return (Criteria) this;
        }
    }

    /**
     */
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