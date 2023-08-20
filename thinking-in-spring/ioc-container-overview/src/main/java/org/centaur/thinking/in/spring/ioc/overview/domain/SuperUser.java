package org.centaur.thinking.in.spring.ioc.overview.domain;

import org.centaur.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * @author Centaur
 * @version 1.0
 * @description: TODO
 * @date 2023/8/21 0:22
 */
@Super
public class SuperUser extends User{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
