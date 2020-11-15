package ru.antongrutsin.Lesson5.Serializator;

import java.io.Serializable;

public class Model implements Serializable {
    private String name;
    private Integer age;
    private char sex;

    Model(String name, Integer age, char sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Объект с именем: " + this.name+ ", пол: " + this.sex;
    }
}
