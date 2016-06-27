package com.heroku.demo.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.heroku.demo.entities.Contact;

/**
 * Repository : Account.
 */
public interface ContactRepository extends PagingAndSortingRepository<Contact, Integer> {
	Contact findBySfid(String sfid);
	List<Contact> findByAccountid(String accountid);
}
