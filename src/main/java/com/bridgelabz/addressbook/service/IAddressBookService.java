package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.entity.AddressBookEntity;

import java.util.List;

/**
 * Purpose : Create interface for addressbook application
 *
 * @author : DAMINI CHANDRAKAR
 * @version : 0.0.1-SNAPSHOT
 * @since : 15-12-2021
 */
public interface IAddressBookService {
    List<AddressBookDto> getAll();

    String addAddressBook(AddressBookDto addressBookDto);

    AddressBookEntity getAddressBookById(int id);

    String updateAddressBook(int id, AddressBookDto addressBookDto);

    public String deleteAddressBook(int id);
}
