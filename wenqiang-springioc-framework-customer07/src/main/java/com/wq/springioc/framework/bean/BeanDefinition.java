package com.wq.springioc.framework.bean;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {
    private String id;

    private String clazz;


    List<ConstructorArg> constructorArgList = new ArrayList<>();

    List<Property> propertiesList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public List<ConstructorArg> getConstructorArgList() {
        return constructorArgList;
    }

    public void setConstructorArgList(List<ConstructorArg> constructorArgList) {
        this.constructorArgList = constructorArgList;
    }

    public List<Property> getPropertiesList() {
        return propertiesList;
    }

    public void setPropertiesList(List<Property> propertiesList) {
        this.propertiesList = propertiesList;
    }
}
