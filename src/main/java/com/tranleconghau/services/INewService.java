package com.tranleconghau.services;

import java.util.List;

import com.tranleconghau.model.NewsModel;

public interface INewService {
	List<NewsModel> findByCategoryId(long categoryId);
	NewsModel save(NewsModel newModel);
	NewsModel update(NewsModel updateNew);
	void delete(long[] ids);
	List<NewsModel> findAll();
}
