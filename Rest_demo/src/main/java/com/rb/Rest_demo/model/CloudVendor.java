package com.rb.Rest_demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cloud_vendor_api")
public class CloudVendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String name;
    private Long phoneNumber;

    public CloudVendor() {
    }

    public CloudVendor(String name, Long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public CloudVendor(Long id, String name, Long phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
