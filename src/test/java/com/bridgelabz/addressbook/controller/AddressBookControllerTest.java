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

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Damini");
        addressBookDto.setAddress("Mahasamund");
        addressBookDto.setCity("Raipur");
        addressBookDto.setState("Chhattishgarh");
        addressBookDto.setPhoneNumber("1234567890");
        addressBookDto.setZip("123456");
        addressBookDtoList.add(addressBookDto);
        AddressBookDto addressBookDto2 = new AddressBookDto();
        addressBookDto2.setName("Siva");
        addressBookDto2.setAddress("Mahasamund");
        addressBookDto2.setCity("Raipur");
        addressBookDto2.setState("Chhattishgarh");
        addressBookDto2.setPhoneNumber("1234567890");
        addressBookDto2.setZip("123456");
        addressBookDtoList.add(addressBookDto2);

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

    @Test
    void givenAddressBookDto_whenCalledAddAddressBookMethod_shouldReturnSuccessMessage() {
        String successString = "AddressBook Added Successfully";
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Damini");
        addressBookDto.setAddress("Mahasamund");
        addressBookDto.setCity("Raipur");
        addressBookDto.setState("Chhattishgarh");
        addressBookDto.setPhoneNumber("1234567890");
        addressBookDto.setZip("123456");
        when(addressBookService.addAddressBook(addressBookDto)).thenReturn(successString);
        String actualResponseString = addressBookController.addEmployee(addressBookDto);
        assertEquals(successString, actualResponseString);
    }

    @Test
    void givenAddressBookDto_whenCalledUpdateAddressBookMethod_shouldReturnSuccessMessage() {
        String successString = "AddressBook Update Successfully";
        int id = 1;
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Damini");
        addressBookDto.setAddress("Mahasamund");
        addressBookDto.setCity("Raipur");
        addressBookDto.setState("Chhattishgarh");
        addressBookDto.setPhoneNumber("1234567890");
        addressBookDto.setZip("123456");
        when(addressBookService.updateAddressBook(id,addressBookDto)).thenReturn(successString);
        String actualResponseString = addressBookController.update(id,addressBookDto);
        assertEquals(successString, actualResponseString);
    }

    @Test
    void givenId_whenCalledDeleteAddressBookMethod_shouldReturnSuccessMessage() {
        String successString = "AddressBook Delete Successfully";
        int id = 1;
        when(addressBookService.deleteAddressBook(id)).thenReturn(successString);
        String actualResponseString = addressBookController.delete(1);
        assertEquals(successString, actualResponseString);
    }
}
