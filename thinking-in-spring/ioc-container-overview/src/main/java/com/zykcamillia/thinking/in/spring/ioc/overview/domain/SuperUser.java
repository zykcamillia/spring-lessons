package com.zykcamillia.thinking.in.spring.ioc.overview.domain;

import com.zykcamillia.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * @Author: zhaoyk
 * @Date: 2021/5/28 15:59
 * @Description:
 */

@Super
public class SuperUser extends User{

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
