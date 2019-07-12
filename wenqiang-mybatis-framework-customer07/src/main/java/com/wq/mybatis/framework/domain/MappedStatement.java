package com.wq.mybatis.framework.domain;

public class MappedStatement {
    private String id;
    private String statementType;

    private Class<?> paramType;
    private Class<?> resultType;
    private SQLSource sqlSource;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Class<?> getParamType() {
        return paramType;
    }

    public void setParamType(Class<?> paramType) {
        this.paramType = paramType;
    }

    public Class<?> getResultType() {
        return resultType;
    }

    public void setResultType(Class<?> resultType) {
        this.resultType = resultType;
    }

    public SQLSource getSqlSource() {
        return sqlSource;
    }

    public void setSqlSource(SQLSource sqlSource) {
        this.sqlSource = sqlSource;
    }

    public String getStatementType() {
        return statementType;
    }

    public void setStatementType(String statementType) {
        this.statementType = statementType;
    }
}
