package com.alexcode.vet.core.usecase.dto;

public final class CreateHuman {
    private final String fullName;
    private final String address;
    private final String phoneNumber;

    public CreateHuman(String fullName, String address, String phoneNumber) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public static CreateHuman create(String fullName, String address, String phoneNumber) {
        return new CreateHuman(fullName, address, phoneNumber);
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
