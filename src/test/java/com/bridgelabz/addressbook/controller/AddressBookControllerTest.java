package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressBookControllerTest {

    @InjectMocks
    private AddressBookController addressBookController;

    @Mock
    private AddressBookService addressBookService;

    @Test
    void given2AddressBookDto_whenCalledGetAllMethod_shouldReturnListOfAddressBookDto() {
        List<AddressBookDto> addressBookDtoList = new ArrayList<>();
        AddressBookDto addressDto = new AddressBookDto();
        addressDto.setName("Damini");
        addressDto.setAddress("Mahasamund");
        addressDto.setCity("Raipur");
        addressDto.setState("Chhattishgarh");
        addressDto.setPhoneNumber("1234567890");
        addressDto.setZip("123456");
        addressBookDtoList.add(addressDto);
        AddressBookDto addressDto2 = new AddressBookDto();
        addressDto2.setName("Siva");
        addressDto2.setAddress("Mahasamund");
        addressDto2.setCity("Raipur");
        addressDto2.setState("Chhattishgarh");
        addressDto2.setPhoneNumber("1234567890");
        addressDto2.setZip("123456");
        addressBookDtoList.add(addressDto2);

        when(addressBookService.getAll()).thenReturn(addressBookDtoList);
        List<AddressBookDto> actualResponse = addressBookController.getAll();
        for (int i = 0; i < actualResponse.size(); i++) {
            Assertions.assertEquals(addressBookDtoList.get(i).getName(), actualResponse.get(i).getName());
            Assertions.assertEquals(addressBookDtoList.get(i).getAddress(), actualResponse.get(i).getAddress());
            Assertions.assertEquals(addressBookDtoList.get(i).getCity(), actualResponse.get(i).getCity());
            Assertions.assertEquals(addressBookDtoList.get(i).getState(), actualResponse.get(i).getState());
            Assertions.assertEquals(addressBookDtoList.get(i).getPhoneNumber(), actualResponse.get(i).getPhoneNumber());
            Assertions.assertEquals(addressBookDtoList.get(i).getZip(), actualResponse.get(i).getZip());
        }

    }
}
