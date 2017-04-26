package com.kingteller.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kingteller.bean.Location;
import com.kingteller.util.TransactionManager;

public class LocationDaoImpl implements LocationDao {

	@Override
	public List<Location> findAllLocation() {
		String sql = "select * from tb_location";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Location>(Location.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean uploadLocation(Location location) throws SQLException{
		String sql = "insert into tb_location values (?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(TransactionManager.getSource());
		runner.update(sql,location.getId(),location.getAddress(),location.getName(),location.getLat(),location.getLng(),location.getCity());
		return true;
	}
	
	
}
