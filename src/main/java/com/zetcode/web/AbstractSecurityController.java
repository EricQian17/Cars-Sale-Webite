package com.zetcode.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zetcode.bean.EPages;
import com.zetcode.util.GLOBAL;

public abstract class AbstractSecurityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		HttpSession session = request.getSession();
		Object object = session.getAttribute(GLOBAL.IS_AUTHORIZED);
		
		if(object == null || (boolean) object == false)
		{
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/" + EPages.LOGIN_PAGE.getPageName());
			disp.forward(request, response);
			return;
		}
		
		securedGet(request, response);
	}

	protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		securedPost(request,response);
		
	}
		
	
	protected abstract void securedGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	protected void securedPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {}

	

}
