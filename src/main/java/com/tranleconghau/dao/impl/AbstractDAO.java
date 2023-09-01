package com.tranleconghau.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tranleconghau.dao.GenericDAO;
import com.tranleconghau.mapper.RowMapper;
import com.tranleconghau.model.CategoryModel;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/newservlet";
			String username = "root";
			String password = "H@u772001";
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... paramaters) {
		// TODO Auto-generated method stub
		List<T> results = new ArrayList<>();

		// Open connection
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				// set parameters
				setParamaters(statement, paramaters);
				resultSet = statement.executeQuery();

				while (resultSet.next()) {
					results.add(rowMapper.mapRow(resultSet));
				}
				return results;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				try {
					connection.close();
					if (statement != null) {
						statement.close();
					}

					if (resultSet != null) {
						resultSet.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}

	private void setParamaters(PreparedStatement statement, Object... paramaters) {
		try {
			for (int i = 0; i < paramaters.length; i++) {
				Object parameter = paramaters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (long) parameter);
				}
				else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
