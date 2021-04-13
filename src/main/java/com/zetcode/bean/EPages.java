package com.zetcode.bean;

import java.util.Optional;
import java.util.stream.Stream;

public enum EPages {
	
	ALL_CITIES("cities","/WEB-INF/allCities.jsp"),
	ALL_CITIES_PIE_CHART("citychart","/WEB-INF/allCitiesPieChart.jsp"),
	UNKNOWN("unknown","/WEB-INF/unknown.jsp"),
	UPDATE_CITIES("update","/WEB-INF/allCities.jsp"),
	START_PAGE("start","/WEB-INF/_startPage.jsp"),
	LOGIN_PAGE("login","/WEB-INF/login.jsp"), 
	INVALID_LOGIN("invalid","invalid.html"), 
	LOGOUT_PAGE("logout","/WEB-INF/logout.jsp"),
	CAR_LIST("listcars","/WEB-INF/allCars.jsp"), 
	LOAN_LIST("listloans","/WEB-INF/loans.jsp"),
	LOAN_PAYMENT("loans","/WEB-INF/loans.jsp"),
	GROUP_LIST("group","/WEB-INF/groups.jsp"),
	GROUP_AB("AB","/WEB-INF/groups.jsp"),
	GROUP_DC("DC","/WEB-INF/groups.jsp"),
	GROUP_EF("EF","/WEB-INF/groups.jsp"),
	GROUP_GG("GG","/WEB-INF/groups.jsp"),
	GROUP_HK("HK","/WEB-INF/groups.jsp"),
	GROUP_LM("LM","/WEB-INF/groups.jsp"),
	GROUP_NN("NN","/WEB-INF/groups.jsp"),
	GROUP_OP("OP","/WEB-INF/groups.jsp"),
	GROUP_QR("QR","/WEB-INF/groups.jsp"),
	GROUP_ST("ST","/WEB-INF/groups.jsp"),
	GROUP_UV("UV","/WEB-INF/groups.jsp"),
	GROUP_WX("WX","/WEB-INF/groups.jsp"),
	
	;
	

	private String pageCode;
	private String pageName;

	EPages(String pageCode, String pageName) {
		this.pageCode = pageCode;
		this.pageName = pageName;
		
		
	}
	
	public String getPageCode() {
		return pageCode;
	}

	public String getPageName() {
		return pageName;
	}
	
	public static EPages find(String pageCode)
	{
		EPages[] pages = EPages.values();
		Stream<EPages> stream = Stream.of(pages);
		Optional<EPages> page =	stream.filter(e -> e.pageCode.equalsIgnoreCase(pageCode))
						.findFirst();
		
		return page.orElseGet(() -> UNKNOWN);
		
		
		
	}

	@Override
	public String toString() {
		return "EPages [pageCode=" + pageCode + ", pageName=" + pageName + "]";
	}
	

}
