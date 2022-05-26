package com.alexcode.vet.core.domain.entity;

public final class Pet {
    private Integer petId;
    private final String name;
    private final Integer age;
    private final String color;
    private final Human human;

    public Pet(Integer petId, String name, Integer age, String color, Human human) {
        this.petId = petId;
        this.name = name;
        this.age = age;
        this.color = color;
        this.human = human;
    }

    public Pet(String name, Integer age, String color, Human human) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.human = human;
    }

    public static Pet createWithId(Integer petId, String name, Integer age, String color, Human human) {
        return new Pet(petId, name, age, color, human);
    }

    public static Pet createWithOutId(String name, Integer age, String color, Human human) {
        return new Pet(name, age, color, human);
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

    public Human getHuman() {
        return human;
    }
}
