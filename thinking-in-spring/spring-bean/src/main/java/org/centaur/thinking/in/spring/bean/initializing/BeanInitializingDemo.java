package org.centaur.thinking.in.spring.bean.initializing;

import org.centaur.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.centaur.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Centaur
 * @version 1.0
 * @description: Spring Bean初始化Demo
 * @date 2023/8/27 22:47
 */
@Configuration
public class BeanInitializingDemo {
    public static void main(String[] args) {
        //1. 使用xml配置文件中的init-method实现
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-initializing-context.xml");
//        System.out.println(applicationContext.getBean("defaultUserFactory", UserFactory.class));
        //2. 使用
        // 声明注解方式的ApplicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializingDemo.class);
        applicationContext.refresh();
        // 2. 使用JAVA API中的@PostConstruct注解
        // 3. 使用@Bean注解中的initMethod
        // 4. 使用InitializingBean#afterPropertiesSet()
        // 5. 使用AbstractBeanDefinition#setInitMethodName(String initMethodName),XML的init-method和@Bean注解中的initMethod是映射到这个方法进行的实现
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        applicationContext.close();
    }

    @Bean(initMethod = "initAnnotationBean")
    public UserFactory userFactory(){
        return new DefaultUserFactory();
    }
}
