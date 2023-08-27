package org.centaur.thinking.in.spring.bean.instantiation;

import org.centaur.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author Centaur
 * @version 1.0
 * @description: 特殊方式实例化bean
 * @date 2023/8/27 14:45
 */
public class SpecialBeanInstantiationDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/special-dependency-instantiation-context.xml");
        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("serviceLoaderFactoryBean", ServiceLoader.class);
        displayServiceLoader(serviceLoader);
//        serviceLoaderDemo();

    }

    private static void serviceLoaderDemo(){
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader){
        Iterator<UserFactory> iterator =  serviceLoader.iterator();
        while (iterator.hasNext()){
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createFactoryUser());
        }
    }
}
