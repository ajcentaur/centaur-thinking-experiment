package org.centaur.thinking.in.spring.bean.definition;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 * @author luocb
 * @version 1.0
 * @date 2023/8/23 21:43
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        //1. 通过BeanDefinitionBuilder 构建
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
    }

}
