package com.zetcode.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zetcode.bean.EPages;
import com.zetcode.service.LoginService;
import com.zetcode.util.GLOBAL;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(
		description = "Login Module", 
		urlPatterns = { 
				"/login"
		})
public class LoginController extends AbstractSecurityController {
	private static final long serialVersionUID = 1L;
	
	protected void securedGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher disp = getServletContext()
				.getRequestDispatcher("/" + EPages.LOGIN_PAGE.getPageName());
			disp.forward(request,response);
			
			
	}

	protected void securedPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		boolean isAuthorized = LoginService.login(userId,password);
		EPages ePages = EPages.START_PAGE;
		
		if(isAuthorized)
		{
			HttpSession session = request.getSession();
			session.setAttribute(GLOBAL.IS_AUTHORIZED,true);
		}
		else
		{
			ePages = EPages.INVALID_LOGIN;
		}

		RequestDispatcher disp = getServletContext()
				.getRequestDispatcher("/" + ePages.getPageName());
			disp.forward(request,response);
		return;
		
	}

}
