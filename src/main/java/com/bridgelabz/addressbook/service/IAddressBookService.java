package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.entity.AddressBookEntity;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookDto> getAll();

    String addAddressBook(AddressBookDto addressBookDto);

    AddressBookEntity getAddressBookById(int id);

    String updateAddressBook(int id, AddressBookDto addressBookDto);

    public String deleteAddressBook(int id);
}
