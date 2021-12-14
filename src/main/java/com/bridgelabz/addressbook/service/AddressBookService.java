package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.builder.AddressBuilder;
import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.entity.AddressBookEntity;
import com.bridgelabz.addressbook.exception.AddressBookCustomException;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressBuilder addressBuilder;

    public List<AddressBookDto> getAll() {
        return addressBookRepository.findAll().stream()
                .map(atmEntity -> modelMapper.map(atmEntity, AddressBookDto.class))
                .collect(Collectors.toList());
    }

    public String addAddressBook(AddressBookDto addressBookDto) {
        AddressBookEntity addressBookEntity = modelMapper.map(addressBookDto, AddressBookEntity.class);
        addressBookRepository.save(addressBookEntity);
        return "AddressBook Added Successfully";
    }

    public AddressBookEntity getAddressBookById(int id) {
        AddressBookEntity addressBookEntity = addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookCustomException(
                        "Invalid AddressBook Id -> " + id));
        return addressBookEntity;
    }

    public String updateAddressBook(int id, AddressBookDto addressBookDto) {
        AddressBookEntity addressBookEntity = getAddressBookById(id);
        addressBookEntity = addressBuilder.buildAddressEntity(addressBookDto, addressBookEntity);
        addressBookRepository.save(addressBookEntity);
        return "AddressBook Updated Successfully";
    }

    public String deleteAddressBook(int id) {
        AddressBookEntity addressBookEntity = getAddressBookById(id);
        addressBookRepository.delete(addressBookEntity);
        return "AddressBook Deleted Successfully";
    }
}
