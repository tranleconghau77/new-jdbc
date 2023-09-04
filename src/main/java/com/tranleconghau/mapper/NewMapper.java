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
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			news.setShortDescription(resultSet.getString("shortdescription"));

			news.setCreatedDate(resultSet.getTimestamp("createddate"));
			news.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			
			news.setModifiedBy(resultSet.getString("modifiedby"));
			news.setCreatedBy(resultSet.getString("createdby"));
			
			if (resultSet.getTimestamp("modifieddate") != null) {
				news.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				news.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
