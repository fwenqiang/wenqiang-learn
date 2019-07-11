package com.wq.springioc;

import com.wq.springioc.bean.Course;
import com.wq.springioc.bean.Student;
import com.wq.springioc.framework.factory.BeanFactory;
import com.wq.springioc.framework.factory.DefaultListableBeanFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.TreeSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WenqiangSpringiocTestApplicationTests {

    @Test
    public void contextLoads() {
        String beansXMLPath = "bean.xml";
        BeanFactory beanFactory = new DefaultListableBeanFactory(beansXMLPath);
        Student student = (Student) beanFactory.getBean("student");

        Course course = (Course) beanFactory.getBean("course");

        System.out.println("student:::::::::::::::" + student);
        System.out.println("course:::::::::::::::" + course);

    }
}
