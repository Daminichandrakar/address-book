package com.bridgelabz.addressbook.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class AddressBookDto {

    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}" , message = "Name should be start with capital latter " +
            "& should contain more then 3 character ")
    private String name;
    @Size(max = 150, message = " Address can have only up-to 150 characters ")
    private String address;
    @Size(max = 20, message = "City name can have only up-to 20 characters ")
    private String city;
    @Size(max = 20, message = "State name can have only up-to 20 characters ")
    private String state;
    @NotNull
    @Pattern(regexp = "^[1-9]{2}\\s[1-9][0-9]{9}$", message = "Invalid Phone Number & Phone Number should be XX XXXXXXXX " +
            "format")
    private String phoneNumber;
    @NotNull
    @Pattern(regexp = "^[0-9]{6}$", message = "ZIP Code should have 6 digits.")
    private String zip;
}
