package com.tranleconghau.dao;

import java.util.List;

import com.tranleconghau.model.NewsModel;

public interface INewDAO {
	List<NewsModel> findByCategoryId(long categoryId);
	Long save(NewsModel newModel);
	void update(NewsModel updateNew);
	void delete(long categoryId);
	NewsModel findOne(Long newId);
	List<NewsModel> findAll();
}
