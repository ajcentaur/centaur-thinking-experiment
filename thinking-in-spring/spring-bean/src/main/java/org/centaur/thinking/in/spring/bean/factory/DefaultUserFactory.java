package org.centaur.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Centaur
 * @version 1.0
 * @description: TODO
 * @date 2023/8/26 20:08
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct UserFactory正在初始化中...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet() UserFactory正在初始化中...");
    }

    public void initAnnotationBean(){
        System.out.println("自定义初始化方法 UserFactory正在初始化中...");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("@PreDestroy UserFactory正在销毁中...");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destroyt() UserFactory正在销毁中...");
    }

    public void destroyUserFactory(){
        System.out.println("自定义销毁方法 UserFactory正在销毁中...");
    }
}
