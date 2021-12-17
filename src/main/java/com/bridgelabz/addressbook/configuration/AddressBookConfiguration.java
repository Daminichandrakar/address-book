package com.bridgelabz.addressbook.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Purpose : To configure model mapper
 *
 * @author : DAMINI CHANDRAKAR
 * @version : 0.0.1-SNAPSHOT
 * @since : 15-12-2021
 */
@Configuration
public class AddressBookConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
