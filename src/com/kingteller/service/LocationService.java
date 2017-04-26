package com.kingteller.service;

import java.util.List;

import com.kingteller.annotation.Tran;
import com.kingteller.bean.Location;

public interface LocationService extends Service{
	List<Location> findAllLocation();
	
	@Tran
	boolean uploadLocation(Location location);
}
