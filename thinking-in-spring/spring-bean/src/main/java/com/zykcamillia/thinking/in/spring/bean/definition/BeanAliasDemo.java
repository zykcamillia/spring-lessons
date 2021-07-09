package com.zykcamillia.thinking.in.spring.bean.definition;

import com.zykcamillia.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zhaoyk
 * @Date: 2021/6/22 17:42
 * @Description: Bean 别名演示
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        // 配置 XML 配置上下文
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        // 通过别名 camillia-user 获取曾用名 user 的 bean
        User user = beanFactory.getBean("user", User.class);
        User camilliaUser = beanFactory.getBean("camillia-user", User.class);

        System.out.println("user --> " + user);
        System.out.println("camilliaUser --> " + camilliaUser);
        System.out.println("camilliaUser 与 user是否相等 = " + (user == camilliaUser));
    }

}
