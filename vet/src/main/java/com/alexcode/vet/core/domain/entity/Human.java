package com.alexcode.vet.core.domain.entity;

public final class Human {
    private Integer humanId;
    private final String fullName;
    private final String address;
    private final String phoneNumber;

    public Human(Integer humanId, String fullName, String address, String phoneNumber) {
        this.humanId = humanId;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Human(String fullName, String address, String phoneNumber) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public static Human createWithId(Integer humanId, String fullName, String address, String phoneNumber) {
        return new Human(humanId, fullName, address, phoneNumber);
    }

    public static Human createWithOutId(String fullName, String address, String phoneNumber) {
        return new Human(fullName, address, phoneNumber);
    }

    public Integer getHumanId() {
        return humanId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
