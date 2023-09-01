package com.tranleconghau.dao;

import java.util.List;

import com.tranleconghau.model.NewsModel;

public interface INewDAO extends GenericDAO<NewsModel> {
	List<NewsModel> findByCategoryId(long categoryId);
}
