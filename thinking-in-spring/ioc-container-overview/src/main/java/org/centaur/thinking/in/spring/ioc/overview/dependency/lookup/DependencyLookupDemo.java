package org.centaur.thinking.in.spring.ioc.overview.dependency.lookup;

import org.centaur.thinking.in.spring.ioc.overview.annotation.Super;
import org.centaur.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * 1.通过Bean名称查找 lookupInRealTime / lookupInLazy
 * 2.通过Bean类型查找 lookupInRealTimeByType
 * @author Centaur
 * @version 1.0
 * @date 2023/8/20 23:12
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        //实时查找bean
        lookupInRealTime(beanFactory);
        //延迟加载bean
        lookupInLazy(beanFactory);
        //通过名称和类型查找bean
        lookupByNameAndType(beanFactory);
        //通过类型查找bean
        lookupByType(beanFactory);
        //通过类型查找bean集合
        lookupCollectionByType(beanFactory);
        //按注解查找Bean
        lookupCollectionByAnnotation(beanFactory);
    }

    public static void lookupInRealTime(BeanFactory beanFactory){
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找：" + user);
    }

    public static void lookupInLazy(BeanFactory beanFactory){
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();;
        System.out.println("延时查找：" + user);
    }

    public static void lookupByNameAndType(BeanFactory beanFactory){
        User user = beanFactory.getBean("user", User.class);
        System.out.println("通过名称+类型查找Bean-实时查找：" + user);
    }

    public static void lookupByType(BeanFactory beanFactory){
        User user = beanFactory.getBean(User.class);
        System.out.println("通过类型查找Bean-实时查找：" + user);
    }

    public static void lookupCollectionByType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("通过类型查找Bean集合-实时查找：" + users);
        }
    }


    public static void lookupCollectionByAnnotation(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("通过注解 @Super 查找Bean集合-实时查找：" + users);
        }
    }

}
