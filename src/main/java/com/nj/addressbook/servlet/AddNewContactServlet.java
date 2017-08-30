package com.nj.addressbook.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.addressbook.entities.Contact;
import com.nj.addressbook.services.AddressBookService;
import com.nj.addressbook.utils.SpringContext;

public class AddNewContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddNewContactServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Contact contact = new Contact();
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		contact.setName(name);
		contact.setPhoneNumber(phoneNumber);
		contact.setEmail(email);
		contact.setAddress(address);

		if (name.isEmpty() || name == null) {
			request.setAttribute("errorMessage", "Name is required. Please update.");
			request.setAttribute("contact", contact);
			request.getRequestDispatcher("AddNewContact.jsp").forward(request, response);
		} else {
			if ((phoneNumber.isEmpty()&& email.isEmpty()&& address.isEmpty())) {
				request.setAttribute("errorMessage", "Either PhoneNumber, Email or Address is required. Please update.");
				request.setAttribute("contact", contact);
				request.getRequestDispatcher("AddNewContact.jsp").forward(request, response);
			} else {
				AddressBookService addressBookService = SpringContext.getBean(AddressBookService.class);
				addressBookService.createContact(contact);
				// addressBookService.createDuplicateContacts(contact);
				response.sendRedirect("ListAllContactsServlet");
			}
		}

	}
}
