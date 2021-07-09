package com.zykcamillia.thinking.in.spring.bean.definition;

import com.zykcamillia.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zhaoyk
 * @Date: 2021/6/29 15:14
 * @Description: Bean 实例化实例
 */
public class BeanInstantiationDemo {

    public static void main(String[] args){
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext
                ("classpath:/META-INF/bean-instantiation-context.xml");
        User user = beanFactory.getBean("user-by-static-method", User.class);
        User userByInstanceMethod = beanFactory.getBean("user-by-instance-method", User.class);
        User userByFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(user);
        System.out.println(userByInstanceMethod);
        System.out.println(userByFactoryBean);
        System.out.println(user == userByInstanceMethod);
        System.out.println(user == userByFactoryBean);
        System.out.println(userByFactoryBean == userByInstanceMethod);
    }



}
