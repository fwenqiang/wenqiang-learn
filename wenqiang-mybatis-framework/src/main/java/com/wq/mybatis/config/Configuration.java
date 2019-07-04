package com.wq.mybatis.config;

import com.wq.mybatis.entity.MappedStatement;
import lombok.Data;

import javax.sql.DataSource;
import java.util.Map;

@Data
public class Configuration {
    private DataSource dataSource;

    private Map<String, MappedStatement> mappedStatementMap;

}
