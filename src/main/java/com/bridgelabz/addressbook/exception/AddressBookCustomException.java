package com.bridgelabz.addressbook.exception;

/**
 * Purpose : To invoke the custom exception
 *
 * @author : DAMINI CHANDRAKAR
 * @version : 0.0.1-SNAPSHOT
 * @since : 15-12-2021
 */

public class AddressBookCustomException extends RuntimeException {
    public AddressBookCustomException(String message) {
        super(message);
    }
}
