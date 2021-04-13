package com.zetcode.service;

import java.util.List;

import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.service.IService;
import com.zetcode.bean.City;
import com.zetcode.persistence.CityDAO;

public class CityService implements IService<City>{
	
	@Override
	public void save(City model) {
		
		CityDAO cityDAO = new CityDAO();
		cityDAO.save(model);
	}

	public List<City> findAll() {

		CityDAO cityDAO = new CityDAO();
        return cityDAO.findAll();
    }
}
