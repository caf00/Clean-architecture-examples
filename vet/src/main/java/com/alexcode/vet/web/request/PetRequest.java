package com.alexcode.vet.web.request;


import java.io.Serializable;

public class PetRequest implements Serializable {
    private String name;
    private Integer age;
    private String color;
    private Integer humanId;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public Integer getHumanId() {
        return humanId;
    }
}
