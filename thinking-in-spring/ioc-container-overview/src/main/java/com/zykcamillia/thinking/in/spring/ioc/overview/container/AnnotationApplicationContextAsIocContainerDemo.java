package com.zykcamillia.thinking.in.spring.ioc.overview.container;

import com.zykcamillia.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 *
 * 注解能力 {@link ApplicationContext} ioc 容器实例
 *
 * @Author: zhaoyk
 * @Date: 2021/6/8 15:36
 * @Description:
 */
@Configurable
public class AnnotationApplicationContextAsIocContainerDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 AnnotationApplicationContextAsIocContainerDemo 作为配置类
        applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);
        //启动应用上下文
        applicationContext.refresh();

        lookupCollectionByType(applicationContext);

        applicationContext.close();
    }

    @Bean
    public User user(){
        User user = new User();
        user.setId(1l);
        user.setName("camillia");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象" + users);
        }
    }

}
