package org.centaur.thinking.in.spring.bean.factory;

import org.centaur.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author Centaur
 * @version 1.0
 * @description: TODO
 * @date 2023/8/27 14:39
 */
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        User user = new User();
        user.setId(3L);
        user.setName("FactoryBean实例化user");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
