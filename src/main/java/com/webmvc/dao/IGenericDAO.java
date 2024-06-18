package com.webmvc.dao;

import com.webmvc.mapper.IRowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public interface IGenericDAO<T> {
	
	Connection getConnection();
	
	void setParams(PreparedStatement statement, Object... params);
	
	List<T> query(String sql, IRowMapper<T> rowMapper, Object... params);
	
	void update(String sql, Object... params);
	
	Long insert(String sql, Object... params);
	
	int count(String sql, Object... params);
}
