package com.phoneBook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phoneBook.model.Contact;
import com.phoneBook.service.IContactService;

@Controller
public class ContactInfoController {
	
	private IContactService contactService;

	public ContactInfoController(IContactService contactService) {
		this.contactService = contactService;
	}
	
	@GetMapping(value = {"/","/register"})
	public String showContactInfo(ModelMap map){
		map.addAttribute("contact", new Contact());
		return "contactInfo";
	}
	
	@PostMapping("/register")
	public String registerContact(@ModelAttribute("contact")Contact contact,RedirectAttributes redirectAttributes){
		boolean isSave = contactService.saveContact(contact);
		if(contact.getContactId() == null) {
			if(isSave) {
				redirectAttributes.addFlashAttribute("saveSuccess", isSave);				
			}
		}
		else {
			if(isSave) {				
				redirectAttributes.addFlashAttribute("updateSuccess", isSave);
			}
		}
		redirectAttributes.addFlashAttribute("contact", new Contact());
		return "redirect:/register";
	}
	
	@GetMapping("/viewAllContacts")
	public String viewAllContacts(ModelMap map){
		List<Contact> allContacts = contactService.getAllContacts();
		map.addAttribute("allContacts", allContacts);
		return "viewContacts";
	}
}