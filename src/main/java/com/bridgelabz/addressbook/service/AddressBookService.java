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

/**
 * Purpose : To demonstrate business logic for AddressBook Application
 *
 * @author : DAMINI CHANDRAKAR
 * @version : 0.0.1-SNAPSHOT
 * @since : 15-12-2021
 */
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

    /**
     * Purpose : This method is used to add the addressBook details by using of
     *           addressBookDto.
     *
     * @param addressBookDto : takes the addressBook details as DTO to provide the
     *                    repository for storing in database
     * @return String : Success message for adding data into database.
     */
    public String addAddressBook(AddressBookDto addressBookDto) {
        AddressBookEntity addressBookEntity = modelMapper.map(addressBookDto, AddressBookEntity.class);
        addressBookRepository.save(addressBookEntity);
        return "AddressBook Added Successfully";
    }

    /**
     * Purpose : This method is used to get the addressBook details by respective address id
     *
     * @param id : takes the addressBook id of that particular addressBook entity
     * @return the addressBook entity using the addressBook id
     */
    public AddressBookEntity getAddressBookById(int id) {
        AddressBookEntity addressBookEntity = addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookCustomException(
                        "Invalid AddressBook Id -> " + id));
        return addressBookEntity;
    }

    /**
     * Purpose : This method is used to update the addressBook details by using their
     *           respective addressBook id
     *
     * @param id : takes the addressBook id for updating that particular addressBook.
     * @param addressBookDto : takes the updated addressBook details as DTO
     *                     and update in database
     * @return String : Success message for updating data into database.
     */
    public String updateAddressBook(int id, AddressBookDto addressBookDto) {
        AddressBookEntity addressBookEntity = getAddressBookById(id);
        addressBookEntity = addressBuilder.buildAddressEntity(addressBookDto, addressBookEntity);
        addressBookRepository.save(addressBookEntity);
        return "AddressBook Updated Successfully";
    }

    /**
     * Purpose : This method is used to delete the addressBook details by using the respective addressBook id
     *
     * @param id : takes the addressBook id for deleting that particularly addressBook entity
     * @return String : Success message for deleting data into database.
     */
    public String deleteAddressBook(int id) {
        AddressBookEntity addressBookEntity = getAddressBookById(id);
        addressBookRepository.delete(addressBookEntity);
        return "AddressBook Deleted Successfully";
    }
}
