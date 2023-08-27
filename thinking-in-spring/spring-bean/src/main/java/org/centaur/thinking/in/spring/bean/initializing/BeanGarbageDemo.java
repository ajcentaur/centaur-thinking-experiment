package org.centaur.thinking.in.spring.bean.initializing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Centaur
 * @version 1.0
 * @description: Spring Bean 垃圾回收 Demo
 * @date 2023/8/28 0:17
 */
public class BeanGarbageDemo {

    public static void main(String[] args) throws InterruptedException {
        // 创建Spring容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册配置类
        applicationContext.register(BeanInitializingDemo.class);
        // 启动Spring应用上下文
        applicationContext.refresh();
        System.out.println("Spring应用上下文启动...");
        System.out.println("Spring应用上下文准备关闭...");
        // 关闭Spring容器
        applicationContext.close();
        Thread.sleep(5000L);
        System.out.println("准备主动触发gc...");
        System.gc();
        System.out.println("主动触发gc结束...");
        Thread.sleep(5000L);
    }

}
