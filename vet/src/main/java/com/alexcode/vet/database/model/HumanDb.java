package com.alexcode.vet.database.model;

import javax.persistence.*;

@Entity
@Table(name = "humans")
public class HumanDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer humanId;
    @Column(nullable = false)
    private String fullName;
    private String address;
    private String phoneNumber;

    protected HumanDb() {
    }

    public HumanDb(String fullName, String address, String phoneNumber) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public HumanDb(Integer humanId, String fullName, String address, String phoneNumber) {
        this.humanId = humanId;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public static HumanDb createWithOutId(String fullName, String address, String phoneNumber) {
        return new HumanDb(fullName, address, phoneNumber);
    }

    public static HumanDb createWithId(Integer humanId, String fullName, String address, String phoneNumber) {
        return new HumanDb(humanId, fullName, address, phoneNumber);
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
