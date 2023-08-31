package com.tranleconghau.services.impl;

import java.util.List;

import javax.inject.Inject;

import com.tranleconghau.dao.INewDAO;
import com.tranleconghau.model.NewsModel;
import com.tranleconghau.services.INewService;

public class NewService implements INewService{
	@Inject INewDAO newDao;
	
	@Override
	public List<NewsModel> findByCategoryId(long categoryId){
		return newDao.findByCategoryId(categoryId);
	}
	
}
