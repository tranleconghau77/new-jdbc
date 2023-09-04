package com.tranleconghau.dao.impl;

import java.util.List;

import com.tranleconghau.dao.INewDAO;
import com.tranleconghau.mapper.NewMapper;
import com.tranleconghau.model.NewsModel;

public class NewDAO extends AbstractDAO<NewsModel> implements INewDAO {

	@Override
	public List<NewsModel> findByCategoryId(long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news (title, content,");
		sql.append(" thumbnail, shortdescription, categoryid, createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newModel.getTitle(), newModel.getContent(), 
				newModel.getThumbnail(), newModel.getShortDescription(), newModel.getCategoryId(),
				newModel.getCreatedDate(), newModel.getCreatedBy());
	}

	@Override
	public void delete(long categoryId) {
		String sql = "delete from news where id = ? ";
		update(sql, categoryId);
	}

	@Override
	public void update(NewsModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
				updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(), updateNew.getCreatedBy(),
				updateNew.getModifiedDate(), updateNew.getModifiedBy(), updateNew.getId());
	}

	@Override
	public NewsModel findOne(Long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewsModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public List<NewsModel> findAll() {
		String sql = "SELECT * FROM news";
		return query(sql, new NewMapper());
	}
}
