package org.centaur.thinking.in.spring.bean.definition;

import org.centaur.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.util.StringUtils;

/**
 * 1.使用XML配置元信息
 * 2.使用注解配置元信息
 * 3.使用API配置元信息
 * @author Centaur
 * @version 1.0
 * @description: 注解方式 BeanDefinition 示例
 * @date 2023/8/24 0:14
 */
@Import(AnnotationBeanDefinitionDemo.Config.class) //3. 通过@Import来进行导入
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        // 声明注解方式的ApplicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 加载配置类
        applicationContext.register(Config.class);
        // 通过BeanDefinition 注册 API 实现
        // 1. 命名方式API
        registryBeanDefinition(applicationContext, "name-centaur-user");
        // 2. 非命名方式API
        registryBeanDefinition(applicationContext);
        // 启动Spring应用上下文
        applicationContext.refresh();
        System.out.println("所有Config类型的Beans：" + applicationContext.getBeansOfType(Config.class));
        System.out.println("所有User类型的Beans：" + applicationContext.getBeansOfType(User.class));
        applicationContext.close();
    }

    // 2.通过@Component或它的派生注解（@Configuration、@Service、@Repository、@Controller）方式定义
    @Configuration //定义当前类作为Spring Bean 组件
    public static class Config{
        // 1.通过@Bean方式定义
        @Bean(name = {"user","centaur-user"})
        public User user(){
            User user = new User();
            user.setId(2L);
            user.setName("Centaur");
            return user;
        }
    }

    /**
     * 使用 API 方式配置元信息
     * @param registry
     * @param beanName
     */
    public static void registryBeanDefinition(BeanDefinitionRegistry registry, String beanName){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id",22L);
        beanDefinitionBuilder.addPropertyValue("name", "人马怪-name");
        if(StringUtils.hasText(beanName)){
            // 注册BeanDefinition(命名方式)
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        }else{
            // 注册BeanDefinition（非命名方式）
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    public static void registryBeanDefinition(BeanDefinitionRegistry registry){
        registryBeanDefinition(registry, null);
    }
}
