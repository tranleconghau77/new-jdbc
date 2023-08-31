package com.tranleconghau.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tranleconghau.dao.INewDAO;
import com.tranleconghau.model.NewsModel;

public class NewDAO implements INewDAO {

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
	public List<NewsModel> findByCategoryId(long categoryId) {
		List<NewsModel> results = new ArrayList<>();
		String sql = "SELECT * FROM news WHERE categoryid = ?";

		// Open connection
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setLong(1, categoryId);
				resultSet = statement.executeQuery();

				while (resultSet.next()) {
					NewsModel news = new NewsModel();
					news.setId(resultSet.getLong("id"));
					news.setTitle(resultSet.getNString("title"));
					news.setThumbnail(resultSet.getString("thumbnail"));
					news.setCategoryid(resultSet.getLong("categoryId"));
					news.setShortdecription(resultSet.getString("shortdescription"));
					results.add(news);
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
