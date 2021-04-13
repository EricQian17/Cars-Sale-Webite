package com.zetcode.web;

import static com.zetcode.bean.EPages.ALL_CITIES;
import static com.zetcode.bean.EPages.ALL_CITIES_PIE_CHART;
import static com.zetcode.bean.EPages.UPDATE_CITIES;
import static com.zetcode.util.GLOBAL.ACTION;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zetcode.bean.City;
import com.zetcode.bean.EPages;
import com.zetcode.bean.PieChart;
import com.zetcode.service.CityService;

@WebServlet("/cities")
public class CityController extends AbstractSecurityController {
	private static final long serialVersionUID = 1L;

	protected void securedPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CityService service = new CityService();
		List<City> cities = new ArrayList<City>();
		
		
		String cityId = request.getParameter("cityId");
		String regionName = request.getParameter("regionName");
		service.save(new City(cityId,regionName));
		cities = service.findAll();

		request.setAttribute("cityId", "none");
		request.setAttribute("cities", cities);


	RequestDispatcher disp = getServletContext()
							.getRequestDispatcher("/" + EPages.ALL_CITIES.getPageName());
	disp.forward(request,response);
	}

	protected void securedGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pageCode = request.getParameter(ACTION);
		EPages epage = EPages.find(pageCode);

		if (epage == ALL_CITIES_PIE_CHART) {
			CityService service = new CityService();
			List<City> cities = service.findAll();

			List<PieChart> list = cities.stream().map(e -> new PieChart(false, e.getIncome(), e.getCityId()))
					.collect(Collectors.toList());

			Gson gson = new Gson();
			String dataPoints = gson.toJson(list);

			request.setAttribute("dataPoints", dataPoints);
			request.setAttribute("title", "Income By City");
		} else if (epage == ALL_CITIES || epage == UPDATE_CITIES) {
			CityService service = new CityService();
			List<City> cities = service.findAll();

			String cityId = "none";
			if (epage == UPDATE_CITIES) {
				cityId = request.getParameter("id");
			}

			request.setAttribute("cityId", cityId);
			request.setAttribute("cities", cities);
		}

		RequestDispatcher disp = getServletContext().getRequestDispatcher("/" + epage.getPageName());
		disp.forward(request, response);
	}

}
