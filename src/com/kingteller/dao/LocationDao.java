package com.kingteller.dao;

import java.sql.SQLException;
import java.util.List;

import com.kingteller.bean.Location;

public interface LocationDao extends Dao{
	List<Location> findAllLocation();
	boolean uploadLocation(Location location) throws SQLException;
}
