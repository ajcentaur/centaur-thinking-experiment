package org.centaur.thinking.in.spring.bean.factory;

import org.centaur.thinking.in.spring.ioc.overview.domain.User;

public interface UserFactory {
    /**
     * 默认实现 jdk8
     * @return
     */
    default User createFactoryUser(){
        User user = new User();
        user.setId(3L);
        user.setName("工厂方法实例化user");
        return user;
    }

}
