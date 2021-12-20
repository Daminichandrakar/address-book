package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Purpose : To demonstrate different HTTP methods for addressBook application
 *
 * @author : DAMINI CHANDRAKAR
 * @version : 0.0.1-SNAPSHOT
 * @since : 15-12-2021
 */
@RestController
@RequestMapping(value = "/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    /**
     * Purpose : To get list of all addresses from database.
     *
     * @return list of all address.
     */
    @GetMapping(value = "/get-all")
    public ResponseEntity<List<AddressBookDto>> getAll() {
        return new ResponseEntity<>(addressBookService.getAll(), HttpStatus.OK);
    }

    /**
     * Purpose : To add addressBook into database.
     *
     * @param addressBookDto : input data to be added into database to add addressBook.
     * @return String : success message "AddressBook Added Successfully".
     */
    @PostMapping(value = "/add")
    public ResponseEntity<String> add(@Valid @RequestBody AddressBookDto addressBookDto) {
        return new ResponseEntity<>(addressBookService.addAddressBook(addressBookDto),HttpStatus.OK);
    }

    /**
     * Purpose : To update addressBook into database.
     *
     * @param addressBookDto : input data to be updated into database.
     * @return String : success message "AddressBook Updated Successfully".
     */
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> update(@PathVariable(value = "id") int id, @Valid @RequestBody AddressBookDto addressBookDto) {
        return new ResponseEntity<>(addressBookService.updateAddressBook(id, addressBookDto),HttpStatus.OK);
    }

    /**
     * Purpose : To delete addressBook into database.
     *
     * @param id : data will be deleted found by with this given id
     * @return String : success message "AddressBook Deleted Successfully".
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return new ResponseEntity<>(addressBookService.deleteAddressBook(id),HttpStatus.OK);
    }
}
