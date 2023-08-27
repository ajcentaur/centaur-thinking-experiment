package org.centaur.thinking.in.spring.bean.instantiation;

import org.centaur.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Centaur
 * @version 1.0
 * @description: Spring实例化Bean的Demo
 * @date 2023/8/26 19:41
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-instantiation-context.xml");
        //第一种方式：通过静态方法实例化
        User staticMethodUser = beanFactory.getBean("user-by-static-method", User.class);
        //第二种方式：通过工厂方法实例化
        User factoryMethodUser = beanFactory.getBean("user-by-factory-method", User.class);
        System.out.println("通过静态方法实例化User Bean：" + staticMethodUser);
        System.out.println("通过工厂方法实例化User Bean：" + factoryMethodUser);
        System.out.println("staticMethodUser和factoryMethodUser是否相等：" + (staticMethodUser == factoryMethodUser));
        //第三种方式：通过FactoryBean实例化
        User factoryBeanUser = beanFactory.getBean("userFactoryBean", User.class);
        System.out.println("通过FactoryBean实例化User Bean：" + factoryBeanUser);
    }

}
