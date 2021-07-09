package com.zykcamillia.thinking.in.spring.ioc.overview.dependency.injection;

import com.zykcamillia.thinking.in.spring.ioc.overview.annotation.Super;
import com.zykcamillia.thinking.in.spring.ioc.overview.domain.User;
import com.zykcamillia.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * 依赖注入实例
 * @Author: zhaoyk
 * @Date: 2021/5/20 15:04
 * @Description:
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {

        //配置 xml 配置文件
        //启动 spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");

        // 来源一：自定义Bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);

        // 来源二：依赖注入(内建依赖)
        System.out.println(userRepository.getBeanFactory());

        ObjectFactory userFactory = userRepository.getObjectFactory();
        System.out.println(userFactory.getObject());

        System.out.println(userFactory.getObject() == beanFactory);

        // 依赖查找 (error)
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        // 来源三：容器内建Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("容器内建bean"+environment);
    }

    private static void whoIsIocContainer(UserRepository userRepository,BeanFactory beanFactory){

        // 为什么这个公式不能成立
        System.out.println(userRepository.getBeanFactory() == beanFactory);
    }

}
