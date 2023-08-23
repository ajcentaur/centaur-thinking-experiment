package org.centaur.thinking.in.spring.ioc.overview.container;

import org.centaur.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * ApplicationContext 作为 IoC 容器示例
 * 使用注解的方式加载Bean
 * @author Centaur
 * @version 1.0
 * @date 2023/8/23 0:45
 */
@Configuration
public class AnnotationApplicationContextAsIoCContainerDemo {
    public static void main(String[] args) {
        // 声明注解方式的ApplicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将 AnnotationApplicationContextAsIoCContainerDemo.class 作为配置类加载
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);
        // 启动应用上下文
        applicationContext.refresh();
        lookupByType(applicationContext);
        lookupCollectionByType(applicationContext);
        applicationContext.close();
    }

    @Bean
    public User user(){
        User user = new User();
        user.setId(2L);
        user.setName("Centaur");
        return user;
    }

    public static void lookupByType(ApplicationContext applicationContext){
        User user = applicationContext.getBean(User.class);
        System.out.println("通过类型查找Bean-实时查找：" + user);
    }

    public static void lookupCollectionByType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("通过类型查找Bean集合-实时查找：" + users);
        }
    }
}
