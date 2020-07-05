package com.phoneBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phoneBook.model.Contact;
import com.phoneBook.service.IContactService;

@Controller
public class ViewContactsController {
	
	private IContactService contactService;

	public ViewContactsController(IContactService contactService) {
		this.contactService = contactService;
	}
	
	@GetMapping("/edit")
	public String editContact(@RequestParam("contactId")Integer id,ModelMap map){
		Contact contact = contactService.getContactById(id);
		map.addAttribute("contact", contact);
		return "contactInfo";
	}
	
	@GetMapping("/delete")
	public String deleteContactById(@RequestParam("contactId")Integer id){
		contactService.deleteContact(id);
		return "redirect:viewAllContacts";
	}
}
