package org.centaur.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @author Centaur
 * @version 1.0
 * @description: TODO
 * @date 2023/8/26 20:08
 */
public class DefaultUserFactory implements UserFactory, InitializingBean {

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct UserFactory正在初始化中。。。。");
    }

    public void initAnnotationBean(){
        System.out.println("AnnotationBean UserFactory正在初始化中。。。。");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet() UserFactory正在初始化中。。。。");
    }
}
