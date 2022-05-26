package com.alexcode.vet.core.usecase.dto;

public final class CreatePet {
    private final String name;
    private final Integer age;
    private final String color;
    private final Integer humanId;

    public CreatePet(String name, Integer age, String color, Integer humanId) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.humanId = humanId;
    }

    public static CreatePet create(String name, Integer age, String color, Integer humanId) {
        return new CreatePet(name, age, color, humanId);
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

    public Integer getHumanId() {
        return humanId;
    }
}
