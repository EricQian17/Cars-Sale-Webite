package com.zetcode.persistence;

import java.util.List;

import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.dao.IUpdate;
import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.City;
import static com.zetcode.util.GLOBAL.DATA_SOURCE;

public class CityDAO implements IQuery<City>, IUpdate<City>{


	@Override
	public List findAll() {

		String sql = " SELECT CITYID, REGIONNAME, INCOME " + 
				" FROM VW_CITYSALES ";

		SQLExecutable<City> executable = rs -> {

			String cityId = rs.getString("CITYID");
			String regionName = rs.getString("REGIONNAME");
			float income = rs.getFloat("INCOME");
			return new City(cityId, regionName,income);

		};

		List<City> cities = SQLUtility.execute(sql, DATA_SOURCE, ESQL.DATASOURCE, executable);

		return cities;
	}

	@Override
	public int save(City model) {
		String sql = " UPDATE CITY SET REGIONNAME= ? WHERE CITYID =? ";
		int code = SQLUtility.update(sql, DATA_SOURCE, ESQL.DATASOURCE, model.getRegionName(), model.getCityId());
		
		
		return code;
	}

}
