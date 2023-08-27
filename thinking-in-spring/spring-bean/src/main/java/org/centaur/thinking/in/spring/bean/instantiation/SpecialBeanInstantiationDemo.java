package org.centaur.thinking.in.spring.bean.instantiation;

import org.centaur.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.centaur.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.ApplicationContext;
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
        //第一种方式：使用ServiceLoaderFactoryBean
        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("serviceLoaderFactoryBean", ServiceLoader.class);
        displayServiceLoader(serviceLoader);
//        serviceLoaderDemo();
        //第二种方式：使用ApplicationContext获取AutowireCapableBeanFactory实现
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-dependency-instantiation-context.xml");
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        //使用AutowireCapableBeanFactory#createBean(Class<T> beanClass)创建
        UserFactory userFactory = autowireCapableBeanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createFactoryUser());
        //第三种方式：使用BeanDefinitionRegistry#registerBeanDefinition(String beanName, BeanDefinition beanDefinition) 方法
        //参考AnnotationBeanDefinitionDemo.class中的registryBeanDefinition方法
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
