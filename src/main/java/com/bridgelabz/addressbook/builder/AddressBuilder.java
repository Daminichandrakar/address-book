package com.bridgelabz.addressbook.builder;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.entity.AddressBook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Purpose : This is builder class which holds all the building related application
 *
 * @author : DAMINI CHANDRAKAR
 * @version : 0.0.1-SNAPSHOT
 * @since : 15-12-2021
 */
@Component
public class AddressBuilder {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Purpose : To convert addressBook dto into addressBook entity.
     *
     * @param addressBookDto    : addressBook dto which is to be converted.
     * @param addressBookEntity : addressBook entity which will be overwritten.
     * @return employeePayroll : converted addressBook entity
     */
    public AddressBook buildAddressEntity(AddressBookDto addressBookDto, AddressBook addressBookEntity) {
        modelMapper.map(addressBookDto, addressBookEntity);
        return addressBookEntity;
    }

}


