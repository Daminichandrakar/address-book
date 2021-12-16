package com.bridgelabz.addressbook.integration;

import com.bridgelabz.addressbook.controller.AddressBookController;
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


}
