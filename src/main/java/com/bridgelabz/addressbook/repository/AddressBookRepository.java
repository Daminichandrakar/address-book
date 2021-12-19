package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.entity.AddressBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Purpose : To invoke the employee repository for addressBook application
 *
 * @author : DAMINI CHANDRAKAR
 * @version : 0.0.1-SNAPSHOT
 * @since : 15-12-2021
 */
@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookEntity, Integer> {
}
