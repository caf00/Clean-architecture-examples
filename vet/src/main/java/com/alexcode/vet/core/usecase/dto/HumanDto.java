package com.alexcode.vet.core.usecase.dto;


public final class HumanDto {
    private final Integer humanId;
    private final String fullName;
    private final String address;
    private final String phoneNumber;

    public HumanDto(Integer humanId, String fullName, String address, String phoneNumber) {
        this.humanId = humanId;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public static HumanDto create(Integer humanId, String fullName, String address, String phoneNumber) {
        return new HumanDto(humanId, fullName, address, phoneNumber);
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
