package com.zykcamillia.thinking.in.spring.bean.factory;

import com.zykcamillia.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: zhaoyk
 * @Date: 2021/6/29 15:45
 * @Description: {@link User} Bean 的 {@link FactoryBean} 实现
 */
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
