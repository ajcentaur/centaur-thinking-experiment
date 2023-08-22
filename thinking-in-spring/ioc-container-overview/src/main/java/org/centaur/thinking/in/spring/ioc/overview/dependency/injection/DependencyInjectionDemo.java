package org.centaur.thinking.in.spring.ioc.overview.dependency.injection;

import org.centaur.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入示例
 * 1.通过Bean名称查找 lookupInRealTime / lookupInLazy
 * 2.通过Bean类型查找 lookupInRealTimeByType
 * @author Centaur
 * @version 1.0
 * @date 2023/8/20 23:12
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // BeanFactory是Spring底层IoC容器
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        //ApplicationContext是具备应用特性的BeanFactory的超集
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        //依赖来源一：自定义的bean
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
//        System.out.println(userRepository);
        //依赖来源二：容器内建的依赖
//        BeanFactory userBeanFactory = userRepository.getBeanFactory();
//        System.out.println(userBeanFactory);
//        System.out.println(userBeanFactory == beanFactory);
//        ObjectFactory objectFactory = userRepository.getObjectFactory();
        // todo: 为什么会一样？
//        System.out.println(objectFactory.getObject() == beanFactory);

//        User user = userRepository.getUserObjectFactory().getObject();
//        System.out.println(user);
        //依赖来源三：容器内建的Bean
//        Environment environment = beanFactory.getBean(Environment.class);
//        System.out.println("容器内置的Bean：" + environment);

        //依赖查找（错误获取）
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        //BeanFactory和ApplicationContext谁才是Spring的容器？
        whoIsSpringContainer(userRepository, beanFactory);
    }

    private static void whoIsSpringContainer(UserRepository userRepository, BeanFactory beanFactory){
        // ConfigurableApplicationContext <- ApplicationContext <- BeanFactory
        // ConfigurableApplicationContext#getBeanFactory()

        System.out.println("UserRepository 中的BeanFactory: " + userRepository.getBeanFactory());
        System.out.println("通过 ClassPathXmlApplicationContext 构造的中的BeanFactory: " + beanFactory);
        System.out.println(userRepository.getBeanFactory() == beanFactory);

    }

}
