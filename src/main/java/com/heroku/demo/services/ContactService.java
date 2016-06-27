/**
 * 
 */
package com.heroku.demo.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heroku.demo.entities.Contact;
import com.heroku.demo.exceptions.ContactNotFoundException;
import com.heroku.demo.repositories.ContactRepository;

/**
 * @author rtorres
 *
 */
@Service
@Transactional(rollbackFor=ContactNotFoundException.class)
public class ContactService 
{
	private static Logger logger = LoggerFactory.getLogger(ContactService.class);
	
	@Autowired
	private ContactRepository contactRepository;
	
	/*
	 * READ methods
	 */
	public Page<Contact> findAll(int page, int count) {
		
		if (logger.isDebugEnabled())
			logger.debug("ContactService -> findAll Contacts");
		
		return contactRepository.findAll(new PageRequest(page, count));
	}

	public List<Contact> findByAccountId(String accountId){
		if (logger.isDebugEnabled())
			logger.debug("ContactService -> findByAccountId - " + accountId);
		
		return contactRepository.findByAccountid(accountId);
		
	}
	
	public Iterable<Contact> findAll() {
		
		if (logger.isDebugEnabled())
			logger.debug("ContactService -> findAll Contacts");
		
		return contactRepository.findAll();
	}

	public Contact findBySfid(String contact){
		if (logger.isDebugEnabled())
			logger.debug("Retrieving Contact with sfid:" + contact);
		
		return contactRepository.findBySfid(contact);
		
	}

//	public List<Contact> findByContact(String contact) {
//		if (logger.isDebugEnabled())
//			logger.debug("ContactService -> findByLink:" + contact);
//
//		return contactRepository.findByContact(contact);
//	}
	public Contact get(int id) {
		if (logger.isDebugEnabled())
			logger.debug("Retrieving Contact with id:" + id);
		
		Contact elementToGet = contactRepository.findOne(id);
		
		if (elementToGet == null)
			throw new ContactNotFoundException(id);
		
		return elementToGet;
	}

	/*
	 * 
	 */
	public Contact create(Contact contact) {

		if (logger.isDebugEnabled())
			logger.debug("ContactService -> create:" + contact);
			
		return contactRepository.save(contact);
	}

	public Contact update(Contact contact) {
		
		if (logger.isDebugEnabled())
			logger.debug("ContactService -> create:" + contact);

		Contact elementToUpdate = contactRepository.findOne(contact.getId());
		
		if (elementToUpdate == null)
			throw new ContactNotFoundException(contact.getName());
		
		elementToUpdate.update(contact);
		contactRepository.save(elementToUpdate);
		
		return elementToUpdate;
	}

	public Contact delete(int id) {
		if (logger.isDebugEnabled())
			logger.debug("ContactService -> delete:" + id);

		Contact elementToDelete = get(id);
		
		if (elementToDelete == null)
			throw new ContactNotFoundException(id);
		
		contactRepository.delete(elementToDelete);

		return elementToDelete;
	}

	/*
	 * HELPERS
	 */

}

