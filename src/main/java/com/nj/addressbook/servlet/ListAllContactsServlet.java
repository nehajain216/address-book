package com.nj.addressbook.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.addressbook.entities.Contact;
import com.nj.addressbook.services.AddressBookService;
import com.nj.addressbook.utils.SpringContext;

/**
 * Servlet implementation class ListAllContactsServlet
 */
public class ListAllContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListAllContactsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AddressBookService addressBookServices = SpringContext.getBean(AddressBookService.class);
		List<Contact> allContacts = addressBookServices.getAllContacts();
		request.setAttribute("ListOfAllContacts", allContacts);
		request.getRequestDispatcher("ListAllContacts.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
