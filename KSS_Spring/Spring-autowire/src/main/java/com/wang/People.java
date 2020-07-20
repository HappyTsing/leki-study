package com.wang;

public class People {
    Dog dog2;
    Cat cat;
    private String name;

    public Dog getDog() {
        return dog2;
    }

    public void setDog(Dog Dog2) {
        this.dog2 = Dog2;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
