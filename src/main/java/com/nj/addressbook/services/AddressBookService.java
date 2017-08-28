package com.nj.addressbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nj.addressbook.dao.AddressBookDAO;
import com.nj.addressbook.entities.Contact;

@Component
public class AddressBookService 
{
	private AddressBookDAO addressBookDAO;
	
	@Autowired
	public AddressBookService(AddressBookDAO addressBookDAO) {
		super();
		this.addressBookDAO = addressBookDAO;
	}

	public List<Contact> getAllContacts() {
		return addressBookDAO.getAllContacts();
	}

	public Contact getContactById(int id) {
		return addressBookDAO.getContactById(id);
	}

	public Contact createContact(Contact contact) {
		return addressBookDAO.createContact(contact);
	}
	
}
