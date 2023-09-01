package com.tranleconghau.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tranleconghau.model.NewsModel;

public class NewMapper implements RowMapper<NewsModel> {
	@Override
	public NewsModel mapRow(ResultSet resultSet) {
		NewsModel news = new NewsModel();
		try {
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getNString("title"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setCategoryid(resultSet.getLong("categoryId"));
			news.setShortdecription(resultSet.getString("shortdescription"));
			return news;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
