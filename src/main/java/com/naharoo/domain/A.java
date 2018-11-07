package com.naharoo.domain;

import com.naharoo.annotation.MapperField;

public class A {

    @MapperField(name = "qwe")
    private int age;

    @MapperField(name = "asd")
    private String firstName;

    @MapperField(name = "zxc")
    private String lastName;


    @Override
    public String toString() {
        return "A{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
