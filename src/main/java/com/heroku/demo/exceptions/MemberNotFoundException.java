package com.heroku.demo.exceptions;

public class MemberNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 262039464718205868L;

	public MemberNotFoundException(Integer id) {
		super("Member not found with id: " + id.toString());
	}

	public MemberNotFoundException(String member) {
		super("Member " + member + " not found!");
	}
}
