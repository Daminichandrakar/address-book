package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.service.AddressBookService;
import com.bridgelabz.addressbook.service.AddressBookServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Purpose : To invoke test cases for AddressBook controller class.
 *
 * @author : DAMINI CHANDRAKAR
 * @version : 0.0.1-SNAPSHOT
 * @since : 15-12-2021
 */
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
        ResponseEntity<List<AddressBookDto>> actualResponse = addressBookController.getAll();
        for (int i = 0; i < actualResponse.getBody().size(); i++) {
            Assertions.assertEquals(addressBookDtoList.get(i).getName(), actualResponse.getBody().get(i).getName());
            Assertions.assertEquals(addressBookDtoList.get(i).getAddress(), actualResponse.getBody().get(i).getAddress());
            Assertions.assertEquals(addressBookDtoList.get(i).getCity(), actualResponse.getBody().get(i).getCity());
            Assertions.assertEquals(addressBookDtoList.get(i).getState(), actualResponse.getBody().get(i).getState());
            Assertions.assertEquals(addressBookDtoList.get(i).getPhoneNumber(), actualResponse.getBody().get(i).getPhoneNumber());
            Assertions.assertEquals(addressBookDtoList.get(i).getZip(), actualResponse.getBody().get(i).getZip());
        }
    }

    @Test
    void givenAddressBookDto_whenCalledAddAddressBookMethod_shouldReturnSuccessMessage() {
        String successString = "AddressBook Added Successfully";
        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>(successString, HttpStatus.OK);
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Damini");
        addressBookDto.setAddress("Mahasamund");
        addressBookDto.setCity("Raipur");
        addressBookDto.setState("Chhattishgarh");
        addressBookDto.setPhoneNumber("1234567890");
        addressBookDto.setZip("123456");
        when(addressBookService.addAddressBook(addressBookDto)).thenReturn(successString);
        ResponseEntity<String> actualResponseString = addressBookController.add(addressBookDto);
        assertEquals(expectedResponseEntity, actualResponseString);
    }

    @Test
    void givenAddressBookDto_whenCalledUpdateAddressBookMethod_shouldReturnSuccessMessage() {
        String successString = "AddressBook Update Successfully";
        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>(successString, HttpStatus.OK);
        int id = 1;
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Damini");
        addressBookDto.setAddress("Mahasamund");
        addressBookDto.setCity("Raipur");
        addressBookDto.setState("Chhattishgarh");
        addressBookDto.setPhoneNumber("1234567890");
        addressBookDto.setZip("123456");
        when(addressBookService.updateAddressBook(id, addressBookDto)).thenReturn(successString);
        ResponseEntity<String> actualResponseString = addressBookController.update(id, addressBookDto);
        assertEquals(expectedResponseEntity, actualResponseString);
    }

    @Test
    void givenId_whenCalledDeleteAddressBookMethod_shouldReturnSuccessMessage() {
        String successString = "AddressBook Delete Successfully";
        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>(successString, HttpStatus.OK);
        int id = 1;
        when(addressBookService.deleteAddressBook(id)).thenReturn(successString);
        ResponseEntity<String> actualResponseString = addressBookController.delete(1);
        assertEquals(expectedResponseEntity, actualResponseString);
    }
}
