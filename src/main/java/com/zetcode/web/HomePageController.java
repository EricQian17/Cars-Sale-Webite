package com.zetcode.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zetcode.bean.EPages;


@WebServlet(urlPatterns = { 
		"/index.html", 
		"/homepage"})

public class HomePageController extends AbstractSecurityController {
	private static final long serialVersionUID = 1L;

	protected void securedGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher disp = getServletContext().getRequestDispatcher(EPages.START_PAGE.getPageName());
		disp.forward(request, response);
	}

}
