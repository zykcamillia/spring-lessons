package com.zykcamillia.thinking.in.spring.bean.factory;

import com.zykcamillia.thinking.in.spring.ioc.overview.domain.User;

/**
 * @Author: zhaoyk
 * @Date: 2021/6/29 15:23
 * @Description: User 工厂类
 */
public interface UserFactory {

    default User createUser(){
        return User.createUser();
    }

}
