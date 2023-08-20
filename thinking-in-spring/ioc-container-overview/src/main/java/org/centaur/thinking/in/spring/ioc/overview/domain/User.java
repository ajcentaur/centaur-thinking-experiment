package org.centaur.thinking.in.spring.ioc.overview.domain;

/**
 * @author Centaur
 * @version 1.0
 * @description: 用户
 * @date 2023/8/20 23:30
 */
public class User {
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
