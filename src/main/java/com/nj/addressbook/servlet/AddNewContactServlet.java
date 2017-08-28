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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Contact contact = new Contact();
		contact.setName(request.getParameter("name"));
		contact.setPhoneNumber(request.getParameter("phonenumber"));
		contact.setEmail(request.getParameter("email"));
		contact.setAddress(request.getParameter("address"));
		AddressBookService addressBookService = SpringContext.getBean(AddressBookService.class);
		addressBookService.createContact(contact);
		response.sendRedirect("ListAllContactsServlet");
	}

}
