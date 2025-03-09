package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class AddressBookDto {
    private long id;
    private String name;
    private String phoneNo;
    private String address;
    private String state;
    private String zipcode;
    private String city;
    // Constructor to initialize all fields


    public AddressBookDto( long id,String name, String phoneNo,  String address, String city, String state, String zipcode) {
        this.id=id;
        this.name = name;
        this.phoneNo = phoneNo;

        this.address = address;
        this.state = state;
        this.zipcode = zipcode;
        this.city = city;
    }

    // Default constructor (if needed)
        public AddressBookDto(){}

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }



    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public long getId() {
        return id;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
