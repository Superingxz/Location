package com.kingteller.service;

import java.sql.SQLException;
import java.util.List;

import com.kingteller.bean.Location;
import com.kingteller.dao.LocationDao;
import com.kingteller.factory.BasicFactory;

public class LocationServiceImpl implements LocationService{
	LocationDao locationDao = BasicFactory.getFactory().getDao(LocationDao.class);
	
	@Override
	public List<Location> findAllLocation() {
		return locationDao.findAllLocation();
	}
	
	@Override
	public boolean uploadLocation(Location location) {
		try {
			return locationDao.uploadLocation(location);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
