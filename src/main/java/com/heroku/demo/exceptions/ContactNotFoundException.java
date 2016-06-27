package com.heroku.demo.exceptions;

public class ContactNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 262039464718205868L;

	public ContactNotFoundException(Integer id) {
		super("Contact not found with id: " + id.toString());
	}

	public ContactNotFoundException(String contact) {
		super("Contact " + contact + " not found!");
	}
}
