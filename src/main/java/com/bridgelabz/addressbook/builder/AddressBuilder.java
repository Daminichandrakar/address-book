package com.bridgelabz.addressbook.builder;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.entity.AddressBookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressBuilder {
    private ModelMapper modelMapper = new ModelMapper();

    public AddressBookEntity buildAddressEntity(AddressBookDto addressBookDto, AddressBookEntity addressBookEntity) {
        modelMapper.map(addressBookDto, addressBookEntity);
        return addressBookEntity;
    }

}


