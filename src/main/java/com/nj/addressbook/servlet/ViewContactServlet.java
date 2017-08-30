package com.nj.addressbook.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.addressbook.entities.Contact;
import com.nj.addressbook.services.AddressBookService;
import com.nj.addressbook.utils.SpringContext;

/**
 * Servlet implementation class ViewContactServlet
 */
public class ViewContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ViewContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String contactId = request.getParameter("id");
		AddressBookService addressBookService = SpringContext.getBean(AddressBookService.class);
		Contact contactById = addressBookService.getContactById(Integer.valueOf(contactId));
		request.setAttribute("contactDetail", contactById);
		request.getRequestDispatcher("ViewContact.jsp").forward(request, response);
	}

}
