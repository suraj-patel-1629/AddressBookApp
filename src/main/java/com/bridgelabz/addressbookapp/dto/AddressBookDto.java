package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class AddressBookDto {
    private String name;
    private String phoneNo;
    private String email;
    private String address;

    // Constructor to initialize all fields
    public AddressBookDto(String name, String phoneNo, String email, String address) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
    }

    // Default constructor (if needed)
    public AddressBookDto() {}

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
