package com.tranleconghau.dao;

import java.util.List;

import com.tranleconghau.model.NewsModel;

public interface INewDAO {
	List<NewsModel> findByCategoryId(long categoryId);
}
