package org.centaur.thinking.in.spring.ioc.overview.repository;

import org.centaur.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @author Centaur
 * @version 1.0
 * @description: 用户信息仓库
 * @date 2023/8/21 1:14
 */
public class UserRepository {
    /**
     * 自定义Bean
     */
    private Collection<User> users;
    /**
     * 内建非Bean对象
     */
    private BeanFactory beanFactory;

    private ObjectFactory<ApplicationContext> objectFactory;

//    private ObjectFactory<User> userObjectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }

    //    public ObjectFactory<User> getUserObjectFactory() {
//        return userObjectFactory;
//    }
//
//    public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
//        this.userObjectFactory = userObjectFactory;
//    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                '}';
    }
}
