package org.centaur.thinking.in.spring.bean.definition;

import org.centaur.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 * @author luocb
 * @version 1.0
 * @date 2023/8/23 21:43
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        //1. 通过BeanDefinitionBuilder 构建
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 设置属性
        builder.addPropertyValue("id",22);
        builder.addPropertyValue("name", "人马怪");
        // 获取 BeanDefinition 实例
        BeanDefinition definition = builder.getBeanDefinition();

        // 2. 通过AbstractBeanDefinition 以及派生类构建
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置Bean类型
        genericBeanDefinition.setBeanClass(User.class);
        //设置属性
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues
                .add("id", 24)
                .add("name", "人马怪2");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);

    }

}
