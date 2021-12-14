package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.builder.AddressBuilder;
import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.entity.AddressBookEntity;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressBookService {

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

        List<AddressBookEntity> addressBookEntities = new ArrayList<>();
        AddressBookEntity addressBookEntity = new AddressBookEntity();
        addressBookEntity.setName("Damini");
        addressBookEntity.setAddress("Mahasamund");
        addressBookEntity.setCity("Raipur");
        addressBookEntity.setState("Chhattishgarh");
        addressBookEntity.setPhoneNumber("1234567890");
        addressBookEntity.setZip("123456");
        addressBookEntities.add(addressBookEntity);
        AddressBookEntity addressBookEntity1 = new AddressBookEntity();
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
        assertEquals(addressBookEntities, actualListOfAddressBook);
    }
}
