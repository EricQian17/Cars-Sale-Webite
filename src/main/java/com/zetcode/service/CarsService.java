package com.zetcode.service;

import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.dao.IUpdate;
import com.jbbwebsolutions.service.IService;
import com.jbbwebsolutions.service.IStatisticsService;
import com.zetcode.bean.Car;
import com.zetcode.persistence.CarDAO;
import java.util.List;

public class CarsService implements IService<Car>, IStatisticsService<Car>{

    @Override
    public List<Car> findAll() {

        IQuery<Car> carDAO = new CarDAO();
        return carDAO.findAll();
    }

    @Override
    public Car findOne(Car car) {

        IQuery<Car> carDAO = new CarDAO();
        car.setId(car.getId());
        return carDAO.findOne(car);
    }

    @Override
    public void save(Car car) {
        
        IUpdate<Car> carDAO = new CarDAO();
        carDAO.save(car);
    }
    
}