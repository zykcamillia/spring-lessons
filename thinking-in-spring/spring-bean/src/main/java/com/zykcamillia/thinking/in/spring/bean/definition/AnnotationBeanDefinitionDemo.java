package com.zykcamillia.thinking.in.spring.bean.definition;

import com.zykcamillia.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * @Author: zhaoyk
 * @Date: 2021/6/22 17:56
 * @Description: 注解 BeanDefinition 示例
 */

@Import(AnnotationBeanDefinitionDemo.Config.class) //通过 @Import 来进行导入
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        //创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 1.通过@Bean 方式定义
        // 2.通过@Component方式
        // 3.通过@Import 来进行导入

        // 注册 Configuration Class 配置类
        applicationContext.register(Config.class);

        // 通过 BeanDefinition 注册 API 实现
        // 1.命名 Bean 的注册方式
        registerUserBeanDefinition(applicationContext, "mercyblitz-user");
        // 2.非命名 Bean 的注册方式
        registerUserBeanDefinition(applicationContext);

        // 启动 Spring 应用上下文
        applicationContext.refresh();
        // 按照类型查找依赖
        System.out.println("Config 类型所有的 Beans" + applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型所有的 Beans" + applicationContext.getBeansOfType(User.class));

        // 关闭应用上下文
        applicationContext.close();
    }

    /**
     * 命名 Bean 的注册方式
     * @param registry
     * @param beanName
     * @param beanClass
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName, Class<?> beanClass){
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(beanClass);
        beanDefinitionBuilder.addPropertyValue("id", 1l)
                .addPropertyValue("name", "camillia");
        // 注册 BeanDefinition
        registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry){
        registerUserBeanDefinition(registry, null);
    }

    /**
     * 命名 Bean 的注册方式
     * @param registry
     * @param beanName
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName){
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 1l)
                .addPropertyValue("name", "camillia");

        //判断如果 beanName参数存在时
        if(StringUtils.hasText(beanName)){
            // 注册 BeanDefinition
            registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }
    }

    // 通过@Component 方式
    @Component //定义当前组件类为Spring Bean (组件)
    public static class Config{
        /**
         *  通过 Java 注释的方式，定义一个 Bean
         */
        @Bean(name = {"user", "camillia-user"})
        public User user(){
            User user = new User();
            user.setId(1l);
            user.setName("camillia");
            return user;
        }
    }

    /**
     *  通过 Java 注释的方式，定义一个 Bean
     */
//    @Bean
//    public User user(){
//        User user = new User();
//        user.setId(1l);
//        user.setName("camillia");
//        return user;
//    }

}
