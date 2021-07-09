package com.zykcamillia.thinking.in.spring.bean.definition;

import com.zykcamillia.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.zykcamillia.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: zhaoyk
 * @Date: 2021/7/1 15:04
 * @Description:
 */
public class SingletonBeanRegistrationDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 创建一个外部 UserFactory 对象
        UserFactory userFactory = new DefaultUserFactory();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        // 注册外部单例对象
        beanFactory.registerSingleton("userFactory", userFactory);
        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 通过依赖查找的方式来获取 UserFactory
        UserFactory userFactoryByKookUp = beanFactory.getBean("userFactory", UserFactory.class);
        System.out.println("userFactory == UserFactoryByLookUp : " + (userFactory == userFactoryByKookUp));

        // 关闭 Spring 应用上下文
        applicationContext.close();
    }

}










