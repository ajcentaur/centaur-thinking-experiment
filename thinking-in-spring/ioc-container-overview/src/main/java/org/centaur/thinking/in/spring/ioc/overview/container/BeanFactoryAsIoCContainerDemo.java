package org.centaur.thinking.in.spring.ioc.overview.container;

import org.centaur.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * 使用BeanFactory 作为 IoC 容器示例
 * 使用Xml的方式加载Bean
 * @author Centaur
 * @version 1.0
 * @date 2023/8/23 0:35
 */
public class BeanFactoryAsIoCContainerDemo {
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 加载配置
        XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int definitionBeanCount = definitionReader.loadBeanDefinitions(location);
        System.out.println("通过 BeanFactory 加载到的Bean数量: " + definitionBeanCount);
        //通过BeanFactory 获取 bean
        lookupCollectionByType(beanFactory);
    }

    public static void lookupCollectionByType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("通过类型查找Bean集合-实时查找：" + users);
        }
    }
}
