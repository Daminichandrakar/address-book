package com.bridgelabz.addressbook.dto;

import lombok.Data;

@Data
public class AddressBookDto {
    private String name;
    private String address;
    private String city;
    private String state;
    private String phoneNumber;
    private String zip;
}
