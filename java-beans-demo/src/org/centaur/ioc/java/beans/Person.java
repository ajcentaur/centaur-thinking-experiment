package org.centaur.ioc.java.beans;

/**
 * @author Centaur
 * @version 1.0
 * @description: TODO
 * @date 2023/8/20 16:31
 */
public class Person {
    //String to String
    private String name;

    //String to Integer
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
