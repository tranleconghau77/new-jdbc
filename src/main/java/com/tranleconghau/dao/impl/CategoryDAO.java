package com.tranleconghau.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tranleconghau.dao.ICategoryDAO;
import com.tranleconghau.model.CategoryModel;

public class CategoryDAO implements ICategoryDAO {

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
	public List<CategoryModel> findAll() {
		List<CategoryModel> results = new ArrayList<>();
		String sql = "SELECT * FROM category";

		// Open connection
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();

				while (resultSet.next()) {
					CategoryModel category = new CategoryModel();
					category.setId(resultSet.getLong("id"));
					category.setCode(resultSet.getString("code"));
					category.setName(resultSet.getString("name"));
					results.add(category);
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

}
