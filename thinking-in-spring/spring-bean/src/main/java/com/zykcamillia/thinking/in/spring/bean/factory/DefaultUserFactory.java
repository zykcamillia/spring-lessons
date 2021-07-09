package com.zykcamillia.thinking.in.spring.bean.factory;

import com.zykcamillia.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: zhaoyk
 * @Date: 2021/6/29 15:25
 * @Description:
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

    // 1.基于 @PostConstruct 注解
    @PostConstruct
    public void init(){
        System.out.println("UserFactory 初始化中。。。");
    }

    public void initUserFactory(){
        System.out.println("自定义初始化方法 initUserFactory():UserFactory 初始化中。。。");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet :UserFactory 初始化中。。。");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("@PreDestroy:UserFactory 销毁中。。。");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destroy():UserFactory 销毁中。。。");
    }

    public void doDestroy(){
        System.out.println("自定义销毁方法 doDestroy():UserFactory 销毁中。。。");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("当前 DefaultUserFactory 对象正在被回收。。。");
    }
}








