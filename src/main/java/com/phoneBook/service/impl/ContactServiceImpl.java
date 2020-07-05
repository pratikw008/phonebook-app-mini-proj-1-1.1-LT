package com.phoneBook.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.phoneBook.custom.exception.ContactNotFoundException;
import com.phoneBook.model.Contact;
import com.phoneBook.model.ContactEntity;
import com.phoneBook.repository.ContactRepository;
import com.phoneBook.service.IContactService;

@Service
public class ContactServiceImpl implements IContactService {

	private ContactRepository contactRepo;

	public ContactServiceImpl(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}

	@Override
	public boolean saveContact(Contact contact) {
		ContactEntity contactEnt = Optional.ofNullable(contact)
						.filter(cnt-> !cnt.getContactName().isEmpty() && !cnt.getContactEmail().isEmpty() && cnt.getContactNumber() != null)
						.map(ContactServiceImpl::convertContactToContactEntity)
						.orElseThrow(()-> new ContactNotFoundException("Plz Provide Contact"));
		ContactEntity savedInDb = contactRepo.save(contactEnt);
		return Optional.ofNullable(savedInDb)
					   .map(ContactServiceImpl::convertContactEntityToContact)
					   .isPresent();
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepo.findAll()
						  .stream()
						  .map(ContactServiceImpl::convertContactEntityToContact)
						  .sorted((c1,c2)-> c1.getContactId().compareTo(c2.getContactId()))
						  .collect(Collectors.toList());
	}
	
	@Override
	public Contact getContactById(Integer id) {
		return contactRepo.findById(id)
						  .map(ContactServiceImpl::convertContactEntityToContact)
						  .orElseThrow(()-> new ContactNotFoundException("Contact Not Found"));
	}

	@Override
	public boolean deleteContact(Integer id) {
		if(contactRepo.existsById(id)) {
			contactRepo.deleteById(id);
			return true;
		}
		return false;
	}	
	
	private static ContactEntity convertContactToContactEntity(Contact contact) {
		ContactEntity contactEntity = new ContactEntity();
		BeanUtils.copyProperties(contact, contactEntity);
		return contactEntity;
	}

	private static Contact convertContactEntityToContact(ContactEntity contactEntity) {
		Contact contact = new Contact();
		BeanUtils.copyProperties(contactEntity, contact);
		return contact;
	}
}