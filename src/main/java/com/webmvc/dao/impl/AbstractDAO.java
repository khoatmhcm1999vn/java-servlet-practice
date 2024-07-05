package com.webmvc.dao.impl;

import com.webmvc.dao.IGenericDAO;
import com.webmvc.mapper.IRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AbstractDAO<T> implements IGenericDAO<T> {
	
	private final ResourceBundle resource = ResourceBundle.getBundle("db");

	@Override
	public Connection getConnection() {
		try {
			Class.forName(resource.getString("driverName"));
			String url = resource.getString("url");
			String user = resource.getString("user");
			String password = resource.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void setParams(PreparedStatement statement, Object... params) {
		int index = 1;
		try {
			for (Object param : params) {
				if (param instanceof Long) {
					statement.setLong(index, (Long) param);
				} else if (param instanceof String) {
					statement.setString(index, (String) param);
				} else if (param instanceof Integer) {
					statement.setInt(index, (Integer) param);
				} else if (param instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) param);
				} else if (param == null) {
					statement.setNull(index, Types.NULL);
				}
				index++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<T> query(String sql, IRowMapper<T> rowMapper, Object... params) {
		List<T> listObjectModel = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(sql);
			// set params
			this.setParams(statement, params);
			// get result
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				T modelObject = rowMapper.mapRow(resultSet);
				listObjectModel.add(modelObject);
			}

			return listObjectModel;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				
				if (statement != null) {
					statement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(String sql, Object... params) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = this.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			this.setParams(statement, params);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
			try {
				if (statement != null) {
					statement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... params) {
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		Long id = null;

		try {
			connection = this.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			this.setParams(statement, params);
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return null;
		} finally {
			try {
				if (resultSet != null) {
					statement.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int count(String sql, Object... params) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			int count = 0;
			connection = this.getConnection();
			statement = connection.prepareStatement(sql);
			// set params
			this.setParams(statement, params);
			// get result
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				count = resultSet.getInt(1);		
			}
			
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				
				if (statement != null) {
					statement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
