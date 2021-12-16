package com.bridgelabz.addressbook.integration;

import com.bridgelabz.addressbook.controller.AddressBookController;
import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AddressBookController.class)
public class AddressBookControllerIT {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AddressBookService addressBookService;

    @Test
    void getAllAddressBookTest() throws Exception {
        when(addressBookService.getAll()).thenReturn(new ArrayList<>());
        mockMvc.perform(MockMvcRequestBuilders.get("/addressbook/get-all"))
                .andExpect(status().isOk());
    }

    @Test
    void addAddressBookTest() throws Exception {
        when(addressBookService.addAddressBook(any())).thenReturn("success");
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/addressbook/add")
                        .content("{\"name\": \"Damini\",\"address\": \"Mahasamund\",\"city\": \"Raipur\"," +
                                "\"state\": \"Chhattishgarh\",\"phoneNumber\": \"1234567890\",\"zip\": \"123456\"}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void updateAddressBookTest() throws Exception {
        int id = 1;
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Damini");
        addressBookDto.setAddress("Mahasamund");
        addressBookDto.setCity("Raipur");
        addressBookDto.setState("Chhattishgarh");
        addressBookDto.setPhoneNumber("1234567890");
        addressBookDto.setZip("123456");
        when(addressBookService.updateAddressBook(id,addressBookDto)).thenReturn("success");
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/addressbook/update/1")
                        .content("{\"name\": \"Damini\",\"address\": \"Mahasamund\",\"city\": \"Raipur\"," +
                                "\"state\": \"Chhattishgarh\",\"phoneNumber\": \"1234567890\",\"zip\": \"123456\"}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void deleteAddressBookTest() throws Exception {
        when(addressBookService.deleteAddressBook(1)).thenReturn("success");
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/addressbook/delete/1")
                        .content("{\"name\": \"Damini\",\"address\": \"Mahasamund\",\"city\": \"Raipur\"," +
                                "\"state\": \"Chhattishgarh\",\"phoneNumber\": \"1234567890\",\"zip\": \"123456\"}")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

}
