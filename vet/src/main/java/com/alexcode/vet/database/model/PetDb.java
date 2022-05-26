package com.alexcode.vet.database.model;

import javax.persistence.*;

@Entity
@Table(name = "pets")
public class PetDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer petId;
    private String name;
    private Integer age;
    private String color;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "human_id")
    private HumanDb human;

    protected PetDb() {
    }

    public PetDb(String name, Integer age, String color, HumanDb human) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.human = human;
    }

    public PetDb(Integer petId, String name, Integer age, String color, HumanDb human) {
        this.petId = petId;
        this.name = name;
        this.age = age;
        this.color = color;
        this.human = human;
    }

    public static PetDb createWithOutId(String name, Integer age, String color, HumanDb human) {
        return new PetDb(name, age, color, human);
    }

    public static PetDb createWithId(Integer petId, String name, Integer age, String color, HumanDb human) {
        return new PetDb(petId , name, age, color, human);
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

    public HumanDb getHuman() {
        return human;
    }
}
