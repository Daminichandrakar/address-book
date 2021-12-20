package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.builder.AddressBuilder;
import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.entity.AddressBook;
import com.bridgelabz.addressbook.exception.AddressBookCustomException;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * Purpose : To invoke test cases for AddressBook service class.
 *
 * @author : DAMINI CHANDRAKAR
 * @version : 0.0.1-SNAPSHOT
 * @since : 15-12-2021
 */
@ExtendWith(MockitoExtension.class)
public class AddressBookServiceTest {

    @InjectMocks
    private AddressBookService addressBookService;
    @Mock
    private AddressBookRepository addressBookRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private AddressBuilder addressBuilder;

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

        List<AddressBook> addressBookEntities = new ArrayList<>();
        AddressBook addressBookEntity = new AddressBook();
        addressBookEntity.setName("Damini");
        addressBookEntity.setAddress("Mahasamund");
        addressBookEntity.setCity("Raipur");
        addressBookEntity.setState("Chhattishgarh");
        addressBookEntity.setPhoneNumber("1234567890");
        addressBookEntity.setZip("123456");
        addressBookEntities.add(addressBookEntity);
        AddressBook addressBookEntity1 = new AddressBook();
        addressBookEntity1.setName("Siva");
        addressBookEntity1.setAddress("Mahasamund");
        addressBookEntity1.setCity("Raipur");
        addressBookEntity1.setState("Chhattishgarh");
        addressBookEntity1.setPhoneNumber("1234567890");
        addressBookEntity1.setZip("123456");
        addressBookEntities.add(addressBookEntity1);

        when(addressBookRepository.findAll()).thenReturn(addressBookEntities);
        when(modelMapper.map(addressBookEntities.get(0), AddressBookDto.class)).thenReturn(addressBookDto);
        when(modelMapper.map(addressBookEntities.get(1), AddressBookDto.class)).thenReturn(addressBookDto2);
        List<AddressBookDto> actualListOfAddressBook = addressBookService.getAll();
        assertEquals(2, actualListOfAddressBook.size());
        assertEquals(addressBookDtoList, actualListOfAddressBook);
    }

    @Test
    void givenAddressBookDto_whenCalledAddAddressBookMethod_shouldReturnSuccessMessage() {

        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Damini");
        addressBookDto.setAddress("Mahasamund");
        addressBookDto.setCity("Raipur");
        addressBookDto.setState("Chhattishgarh");
        addressBookDto.setPhoneNumber("1234567890");
        addressBookDto.setZip("123456");

        AddressBook addressBookEntity = new AddressBook();
        addressBookEntity.setId(1);
        addressBookEntity.setName("Damini");
        addressBookEntity.setAddress("Mahasamund");
        addressBookEntity.setCity("Raipur");
        addressBookEntity.setState("Chhattishgarh");
        addressBookEntity.setPhoneNumber("1234567890");
        addressBookEntity.setZip("123456");
        when(modelMapper.map(addressBookDto, AddressBook.class)).thenReturn(addressBookEntity);
        String actualStringMessage = addressBookService.addAddressBook(addressBookDto);
        assertEquals("AddressBook Added Successfully", actualStringMessage);
        verify(addressBookRepository, times(1)).save(addressBookEntity);
    }

    @Test
    void givenIdAndAddressDto_whenUpdateAddressBookMethodCalled_shouldUpdateAddressBookDetailsAndReturnSuccessMessage() {
        int id = 1;
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Damini");
        addressBookDto.setAddress("Mahasamund");
        addressBookDto.setCity("Raipur");
        addressBookDto.setState("Chhattishgarh");
        addressBookDto.setPhoneNumber("1234567890");
        addressBookDto.setZip("123456");

        AddressBook addressBookEntity = new AddressBook();
        addressBookEntity.setId(1);
        addressBookEntity.setName("Damini");
        addressBookEntity.setAddress("Mahasamund");
        addressBookEntity.setCity("Raipur");
        addressBookEntity.setState("Chhattishgarh");
        addressBookEntity.setPhoneNumber("1234567890");
        addressBookEntity.setZip("123456");

        when(addressBookRepository.findById(id)).thenReturn(Optional.of(addressBookEntity));
        addressBookEntity.setName(addressBookDto.getName());
        addressBookEntity.setPhoneNumber(addressBookDto.getPhoneNumber());

        when(addressBuilder.buildAddressEntity(addressBookDto, addressBookEntity)).
                thenReturn(addressBookEntity);
        String actualSuccessMessage = addressBookService.updateAddressBook(id, addressBookDto);
        verify(addressBookRepository, times(1)).save(addressBookEntity);
        assertEquals("AddressBook Updated Successfully", actualSuccessMessage);
        assertEquals(addressBookDto.getName(), addressBookEntity.getName());
    }

    @Test
    void givenIdAndAddressBookDto_whenUpdateMethodIsCalled_ifIdNotFound_shouldThrowExceptionMessage() {
        int id = 1;
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Damini");
        addressBookDto.setAddress("Mahasamund");
        addressBookDto.setCity("Raipur");
        addressBookDto.setState("Chhattishgarh");
        addressBookDto.setPhoneNumber("1234567890");
        addressBookDto.setZip("123456");

        when(addressBookRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(AddressBookCustomException.class, () -> addressBookService.
                updateAddressBook(id, addressBookDto));
    }

    @Test
    void givenId_whenDeleteAddressBookMethodIsCalledWithAnId_shouldDeleteTheDataOfThatId() {
        int id = 1;
        AddressBook addressBookEntity = new AddressBook();
        addressBookEntity.setId(1);
        addressBookEntity.setName("Damini");
        addressBookEntity.setAddress("Mahasamund");
        addressBookEntity.setCity("Raipur");
        addressBookEntity.setState("Chhattishgarh");
        addressBookEntity.setPhoneNumber("1234567890");
        addressBookEntity.setZip("123456");

        when(addressBookRepository.findById(id)).thenReturn(Optional.of(addressBookEntity));
        String actualMessage = addressBookService.deleteAddressBook(id);
        assertEquals("AddressBook Deleted Successfully", actualMessage);
        verify(addressBookRepository, times(1)).delete(addressBookEntity);
    }

    @Test
    void givenId_whenDeleteEmployeeMethodIsCalled_IfIdNotFound_shouldThrowExceptionMessage() {
        int id = 1;
        AddressBook addressBookEntity = new AddressBook();
        addressBookEntity.setId(1);
        addressBookEntity.setName("Damini");
        addressBookEntity.setAddress("Mahasamund");
        addressBookEntity.setCity("Raipur");
        addressBookEntity.setState("Chhattishgarh");
        addressBookEntity.setPhoneNumber("1234567890");
        addressBookEntity.setZip("123456");
        when(addressBookRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(AddressBookCustomException.class, () -> addressBookService.deleteAddressBook(id));
    }
}
