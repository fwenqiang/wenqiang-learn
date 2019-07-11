package com.wq.springioc.framework.factory;

public interface BeanFactory {

    Object getBean(String beanName);

    Object getBean(Class<?> clazz);
}
