package com.bridgelabz.addressbook.builder;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.entity.AddressBookEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Purpose : To invoke test cases for AddressBook builder class.
 *
 * @author : DAMINI CHANDRAKAR
 * @version : 0.0.1-SNAPSHOT
 * @since : 15-12-2021
 */
@ExtendWith(MockitoExtension.class)
public class AddressBookBuilderTest {

    @InjectMocks
    private AddressBuilder addressBuilder;
    @Mock
    private ModelMapper modelMapper;

    @Test
    void givenaddressBookDto_whenNeedToCovertaddressBookDtoToaddressBookEntity_shouldReturnaddressBookEntity() {
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Damini");
        addressBookDto.setAddress("Mahasamund");
        addressBookDto.setCity("Raipur");
        addressBookDto.setState("Chhattishgarh");
        addressBookDto.setPhoneNumber("1234567890");
        addressBookDto.setZip("123456");
        AddressBookEntity addressBookEntity = new AddressBookEntity();
        addressBookEntity.setName("Damini");
        addressBookEntity.setAddress("Mahasamund");
        addressBookEntity.setCity("Raipur");
        addressBookEntity.setState("Chhattishgarh");
        addressBookEntity.setPhoneNumber("1234567890");
        addressBookEntity.setZip("123456");
        addressBookEntity = addressBuilder.buildAddressEntity(addressBookDto, addressBookEntity);
        assertEquals(addressBookDto.getName(), addressBookEntity.getName());
        assertEquals(addressBookDto.getAddress(), addressBookEntity.getAddress());
        assertEquals(addressBookDto.getCity(), addressBookEntity.getCity());
        assertEquals(addressBookDto.getState(), addressBookEntity.getState());
        assertEquals(addressBookDto.getPhoneNumber(), addressBookEntity.getPhoneNumber());
        assertEquals(addressBookDto.getZip(), addressBookEntity.getZip());
    }
}
