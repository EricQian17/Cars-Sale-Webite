package com.zetcode.web;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zetcode.bean.EPages;
import com.zetcode.bean.Group;
import com.zetcode.service.GroupService;
import com.zetcode.util.GLOBAL;

@WebServlet("/group")
public class GroupController extends AbstractSecurityController {
	private static final long serialVersionUID = 1L;
       
	protected void securedGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pageCode = request.getParameter(GLOBAL.ACTION);
		EPages epage = EPages.find(pageCode);
		List<Object> groupPages = Arrays.asList(EPages.GROUP_AB,EPages.GROUP_DC,EPages.GROUP_EF,
												EPages.GROUP_GG,EPages.GROUP_HK,EPages.GROUP_LM,
												EPages.GROUP_NN,EPages.GROUP_OP,EPages.GROUP_QR,
												EPages.GROUP_ST,EPages.GROUP_UV,EPages.GROUP_WX);
		
		
		if(groupPages.contains(epage)||epage==EPages.GROUP_LIST)
		{
			if(pageCode.equalsIgnoreCase("group"))
			{
				epage=EPages.GROUP_AB;
				pageCode="AB";
			}
			DecimalFormat df = new DecimalFormat("#.00");
				
			GroupService service = new GroupService();
			List<Group> list = service.findBy(pageCode);
			DoubleSummaryStatistics summary = service.getSummary(list, Group::getIncome);
			
			request.setAttribute("groupId", pageCode);
	        request.setAttribute("groupList", list);
	        request.setAttribute("average", df.format(summary.getAverage()));
	        request.setAttribute("total", df.format(summary.getSum()));

		}
        RequestDispatcher disp = getServletContext()
								.getRequestDispatcher("/" + epage.getPageName());
        disp.forward(request,response);

	}

}
