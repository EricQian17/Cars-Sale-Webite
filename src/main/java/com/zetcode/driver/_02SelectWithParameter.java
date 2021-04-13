package com.zetcode.driver;

import static com.zetcode.util.GLOBAL.DATA_SOURCE;

import java.util.List;

import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.Car;
import com.zetcode.bean.Group;
import com.zetcode.persistence.GroupDAO;
import com.zetcode.service.GroupService;

public class _02SelectWithParameter {

	public static void main(String[] args) 
	{
		String url = "jdbc:derby://localhost:1527/carsDB"
				  + ";user=app;password=password1234";
		
		String sql = " SELECT GROUPID, NAME, CITYID, PURCHASEMONTH, PRICEPAID, VENDORPRICE, INCOME " + 
				" FROM VW_4THQUARTERBYGROUP "+
				" WHERE GROUPID = ? ";

		SQLExecutable<Group> executable = rs -> {

			String groupId = rs.getString("GROUPID");
			String name = rs.getString("NAME");
			String cityId = rs.getString("CITYID");
			String purchaseMonth = rs.getString("PURCHASEMONTH");
			float pricePaid = rs.getFloat("PRICEPAID");
			float vendorPrice = rs.getFloat("VENDORPRICE");
			float income = rs.getFloat("INCOME");
			return new Group(groupId, name, cityId, purchaseMonth, pricePaid, vendorPrice, income);

		};
		List<Group> groups = SQLUtility.execute(sql, url, ESQL.CONNECTION, executable,"DC");
		groups.forEach(System.out::println);
	}

}
