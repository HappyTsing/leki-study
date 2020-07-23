package com.wang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class People {
    @Autowired
    @Qualifier("dog1")
    Dog dog2;
    @Resource(name = "cat2")
    Cat cat;
    private String name;

    public void setDog(Dog Dog2) {
        this.dog2 = Dog2;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }


    public Cat getCat() {
        return cat;
    }
    public Dog getDog() {
        return dog2;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
