package com.alexcode.vet.web.response;

import java.io.Serializable;

public class PetResponse implements Serializable {
    private final Integer petId;
    private final String name;
    private final Integer age;
    private final String color;
    private final HumanResponse human;

    public PetResponse(Integer petId, String name, Integer age, String color, HumanResponse human) {
        this.petId = petId;
        this.name = name;
        this.age = age;
        this.color = color;
        this.human = human;
    }

    public static PetResponse create(Integer petId, String name, Integer age, String color, HumanResponse human) {
        return new PetResponse(petId, name, age, color, human);
    }

    public Integer getPetId() {
        return petId;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public HumanResponse getHuman() {
        return human;
    }
}
