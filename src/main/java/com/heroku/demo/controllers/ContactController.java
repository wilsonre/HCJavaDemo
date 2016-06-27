package com.heroku.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.heroku.demo.entities.Account;
import com.heroku.demo.entities.Contact;
import com.heroku.demo.services.AccountService;
import com.heroku.demo.services.ContactService;

@Controller
@RequestMapping(value="contacts")
public class ContactController extends BaseController{
	
	private static Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private AccountService accountService;
	
	/*
	 * HTML Pages
	 */
	
	@RequestMapping(value="/account", method=RequestMethod.GET)
	public ModelAndView listPage(@RequestParam(required = true, defaultValue = "") String accountid
								 ) {
		ModelAndView mav = new ModelAndView("contacts/byaccount");
		List<Contact> contact = new ArrayList<Contact>();
		Account account = accountService.findBySfid(accountid);
		
		if (logger.isDebugEnabled())
			logger.debug("ContactController -> Page for listing Contact");
		
		contact.addAll(contactService.findByAccountId(accountid));
		mav.addObject("Account", account);
		mav.addObject("Contacts", contact);
		return mav;
	}

	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView listPage(@RequestParam(required = false, defaultValue = "0") int page, 
								 @RequestParam(required = false, defaultValue = "50") int records
								 ) {
		ModelAndView mav = new ModelAndView("contacts/all");
		List<Contact> Contact = new ArrayList<Contact>();
		
		if (logger.isDebugEnabled())
			logger.debug("ContactController -> Page for listing Contact");
			Contact.addAll(contactService.findAll(page, records).getContent());
		mav.addObject("Contacts", Contact);
		return mav;
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView createPage() {
		ModelAndView mav = new ModelAndView("contacts/new");
		mav.addObject("Contact", new Contact());
		
		if (logger.isDebugEnabled())
			logger.debug("ContactController -> Page for creating Contact");
		
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}.html", method=RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("contacts/edit");
		Contact contact = contactService.get(id);
		
		if (logger.isDebugEnabled())
			logger.debug("ContactController -> Page for editing Contact");

		mav.addObject("Contact", contact);

		return mav;
	}

}
