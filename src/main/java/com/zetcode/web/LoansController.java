package com.zetcode.web;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zetcode.bean.EPages;
import com.zetcode.bean.Loan;
import com.zetcode.util.GLOBAL;

@WebServlet(urlPatterns = { 
		"/listloans", 
		"/loans"})
public class LoansController extends AbstractSecurityController {
	private static final long serialVersionUID = 1L;

	protected void securedGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pageCode = request.getParameter(GLOBAL.ACTION);
		EPages epage = EPages.find(pageCode);
		String amount="1000000";
		String interest="5";
		String times="25";

		float amt = Float.parseFloat(amount);
		float inter = Float.parseFloat(interest)/100;
		float first=0;
		DecimalFormat df = new DecimalFormat("#.00");
		
		List<Loan> list = new ArrayList<Loan>();
		for(int x = 0;x<Integer.parseInt(times);x++)
		{
			if(x==0)
			{
				first = Loan.calculateLoan(inter, 360, amt);
			}
			
			list.add(new Loan((x+1),amt,Float.parseFloat(df.format(Loan.calculateLoan(inter, 360, amt)))));
			amt=amt+500;
		}
		request.setAttribute("times",times);
		request.setAttribute("value1",amount);
		request.setAttribute("value2",interest);
		request.setAttribute("loanlist", list);
		request.setAttribute("first",first);

		RequestDispatcher disp = getServletContext().getRequestDispatcher("/" + epage.getPageName());
		disp.forward(request, response);

	}
	protected void securedPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String amount = request.getParameter("amount");
		String interest = request.getParameter("interest");
		String times = request.getParameter("times");
		EPages ePages = EPages.LOAN_LIST;
		float amt = Float.parseFloat(amount);
		float inter = Float.parseFloat(interest)/100;
		float first=0;
		DecimalFormat df = new DecimalFormat("#.00");
		
		List<Loan> list = new ArrayList<Loan>();
		for(int x = 0;x<Integer.parseInt(times);x++)
		{
			if(x==0)
			{
				first = Loan.calculateLoan(inter, 360, amt);
			}
			
			list.add(new Loan((x+1),amt,Float.parseFloat(df.format(Loan.calculateLoan(inter, 360, amt)))));
			amt=amt+500;
		}
		request.setAttribute("loanlist", list);
		request.setAttribute("first",first);
		request.setAttribute("times",times);
		request.setAttribute("value1",amount);
		request.setAttribute("value2",interest);
		
		RequestDispatcher disp = getServletContext()
				.getRequestDispatcher("/" + ePages.getPageName());
			disp.forward(request,response);
		return;
	}
		
	
	
	


}
