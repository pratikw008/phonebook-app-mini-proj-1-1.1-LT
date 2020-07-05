package com.phoneBook.service;

import java.util.List;

import com.phoneBook.model.Contact;

public interface IContactService {
	
	public boolean saveContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact getContactById(Integer id);
	
	public boolean deleteContact(Integer id);
}
