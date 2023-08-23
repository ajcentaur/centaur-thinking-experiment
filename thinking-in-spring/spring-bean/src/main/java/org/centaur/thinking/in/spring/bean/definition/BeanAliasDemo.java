package org.centaur.thinking.in.spring.bean.definition;

import org.centaur.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Centaur
 * @version 1.0
 * @description: SpringBean 别名 Demo
 * @date 2023/8/23 23:32
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        // 配置XML配置文件
        // 启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-definition-context.xml");
        User user = beanFactory.getBean("user", User.class);
        // 通过别名 centaur-user 获取曾用名为user的 Bean
        User centaurUser = beanFactory.getBean("centaur-user", User.class);
        System.out.println("centaur-user 与 user Bean是否相同：" + (user == centaurUser));
    }
}
