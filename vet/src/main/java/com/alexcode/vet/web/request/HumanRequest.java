package com.alexcode.vet.web.request;

import java.io.Serializable;

public class HumanRequest implements Serializable {
    private String fullName;
    private String address;
    private String phoneNumber;

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
