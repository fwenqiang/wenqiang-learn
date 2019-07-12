package com.wq.mybatis.framework.sqlsession;

import com.wq.mybatis.framework.config.Configuration;
import com.wq.mybatis.framework.domain.MappedStatement;
import com.wq.mybatis.framework.domain.ParameterMapping;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class SimpleExecutor  implements  Executor{

    private Configuration configuration;

    public SimpleExecutor(Configuration configuration){
             this.configuration = configuration;
    }



    @Override
    public <T> List<T> query(MappedStatement ms, Object param) throws Exception {
        Connection connection = configuration.getDs().getConnection();
        //获取stattementType
        if("prepared".equals(ms.getStatementType())){
            PreparedStatement ps = connection.prepareStatement(ms.getSqlSource().getSqlBound().getSql());
            //封装参数
            if(ms.getParamType()!=null){
                //基本数据类型
                if(ms.getParamType()==Integer.class){
                    ps.setObject(1,param);
                }else {
                    //如果是POJO类型
                  List<ParameterMapping> parameterMappingList = ms.getSqlSource().getSqlBound().getParameterMappingList();
                  if(parameterMappingList!=null && parameterMappingList.size()>0){
                      Class<?>  paramType = ms.getParamType();
                      for(int i=0;i<parameterMappingList.size();i++){
                          String paramName= parameterMappingList.get(i).getName();
                          Field field =  paramType.getDeclaredField(paramName);
                          field.setAccessible(true);
                          Object fieldValue = field.get(param);
                          ps.setObject(i+1,fieldValue);
                      }
                  }
                }
            }
            //执行statement
            ResultSet result =  ps.executeQuery();
            List<Object> list = new ArrayList<>();
            while (result.next()){
                Object returnObj = ms.getResultType().newInstance();
                ResultSetMetaData resultSetMetaData =  result.getMetaData();
                int columentCount = resultSetMetaData.getColumnCount();
                for(int i=1;i<=columentCount;i++){
                    //列从1开始
                    String columnName= resultSetMetaData.getColumnName(i);
                    Field field =  ms.getResultType().getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(returnObj,result.getObject(i));
                }
                list.add(returnObj);
            }
            return (List<T>) list;
        }else {

        }
        return null;
    }
}
