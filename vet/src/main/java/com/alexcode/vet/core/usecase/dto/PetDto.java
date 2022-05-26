package com.alexcode.vet.core.usecase.dto;


public final class PetDto {
    private final Integer petId;
    private final String name;
    private final Integer age;
    private final String color;
    private final HumanDto human;

    public PetDto(Integer petId, String name, Integer age, String color, HumanDto human) {
        this.petId = petId;
        this.name = name;
        this.age = age;
        this.color = color;
        this.human = human;
    }

    public static PetDto create(Integer petId, String name, Integer age, String color, HumanDto human) {
        return new PetDto(petId, name, age, color, human);
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

    public HumanDto getHuman() {
        return human;
    }
}
