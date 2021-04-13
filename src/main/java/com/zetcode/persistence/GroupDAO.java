package com.zetcode.persistence;

import static com.zetcode.util.GLOBAL.DATA_SOURCE;

import java.util.List;

import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.dao.IUpdate;
import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.Group;

public class GroupDAO implements IQuery<Group>, IUpdate<Group>{

	@Override
	public int save(Group model) {
		return 0;
	}

	@Override
	public List<Group> findAll() {
		String sql = " SELECT GROUPID, NAME, CITYID, PURCHASEMONTH, PRICEPAID, VENDORPRICE, INCOME " + 
				" FROM VW_4THQUARTERBYGROUP ";

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

		List<Group> groups = SQLUtility.execute(sql, DATA_SOURCE, ESQL.DATASOURCE, executable);

		return groups;
	}
	
	public List<Group> findBy(String group){
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
		List<Group> groups = SQLUtility.execute(sql, DATA_SOURCE, ESQL.DATASOURCE, executable, group);
		return groups;
	}
	


}
