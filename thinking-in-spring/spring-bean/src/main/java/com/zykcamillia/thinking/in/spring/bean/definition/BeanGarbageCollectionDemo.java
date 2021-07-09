package com.zykcamillia.thinking.in.spring.bean.definition;

import com.zykcamillia.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: zhaoyk
 * @Date: 2021/6/30 15:56
 * @Description:
 */
public class BeanGarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class (配置类)
        applicationContext.register(BeanInitializationDemo.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        // 关闭 Spring 应用上下文
        applicationContext.close();
        Thread.sleep(10000);
        // 强制触发 GC
        System.gc();
        Thread.sleep(10000);
    }
}
