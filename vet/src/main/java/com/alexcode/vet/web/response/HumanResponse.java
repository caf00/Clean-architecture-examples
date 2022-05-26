package com.alexcode.vet.web.response;

import java.io.Serializable;

public class HumanResponse implements Serializable {
    private final Integer humanId;
    private final String fullName;
    private final String address;
    private final String phoneNumber;

    public HumanResponse(Integer humanId, String fullName, String address, String phoneNumber) {
        this.humanId = humanId;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public static HumanResponse create(Integer humanId, String fullName, String address, String phoneNumber) {
        return new HumanResponse(humanId, fullName, address, phoneNumber);
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
