package com.zykcamillia.thinking.in.spring.bean.definition;

import com.zykcamillia.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link BeanDefinition} 构建实例
 *
 * @Author: zhaoyk
 * @Date: 2021/6/8 17:54
 * @Description:
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        // 1.通过 BeanDefinitionBuilder
        BeanDefinitionBuilder beanDefinitionBuilder =
                BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
//        beanDefinitionBuilder.addPropertyValue("id", 1);
//        beanDefinitionBuilder.addPropertyValue("name", "camillia");
        beanDefinitionBuilder.addPropertyValue("id", 1)
                .addPropertyValue("name", "camillia");
        // 获取BeanDefinition 实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // BeanDefinition并非 Bean 终态，可以自定义修改

        // 2.通过AbstractBeanDefinition 以及滋生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置 Bean 类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue("id", 1);
//        propertyValues.addPropertyValue("name", "camillia");
        propertyValues.add("id",1)
                .add("name","camillia");
        // 通过 set MutablePropertyValues 批量操作属性
        genericBeanDefinition.setPropertyValues(propertyValues);
    }

}
