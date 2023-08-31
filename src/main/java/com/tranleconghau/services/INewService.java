package com.tranleconghau.services;

import java.util.List;

import com.tranleconghau.model.NewsModel;

public interface INewService {
	List<NewsModel> findByCategoryId(long categoryId);
}
