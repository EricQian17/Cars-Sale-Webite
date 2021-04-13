package com.zetcode.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zetcode.bean.EPages;
import com.zetcode.util.GLOBAL;


@WebServlet(
		description = "Logout Module", 
		urlPatterns = { 
				"/logout"
		})
public class LogoutController extends AbstractSecurityController {
	private static final long serialVersionUID = 1L;
	
	protected void securedGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute(GLOBAL.IS_AUTHORIZED,false);
		
		
		RequestDispatcher disp = getServletContext()
				.getRequestDispatcher("/" + EPages.LOGOUT_PAGE.getPageName());
			disp.forward(request,response);
			
			return;
			
			
	}

}
