package com.wq.mybatis.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLSource {

    private String sqlText;

    public SQLSource(String sqlText) {
        this.sqlText = sqlText;
    }

    public SQLBound getSqlBound(){
        //解析SQl
        String regex = "#\\{[\\w]*\\}";
        String sql = sqlText.replaceAll(regex,"?");
        //解析参数名
        List<ParameterMapping> parameterMappingList = new ArrayList();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sqlText);
        while (matcher.find()){
            String e = matcher.group();
            ParameterMapping parameterMapping = new ParameterMapping();
            parameterMapping.setName(e.replace("#","").replace("{","").replace("}",""));
            parameterMappingList.add(parameterMapping);
        }
        return new SQLBound(sql,parameterMappingList);
    }
}
