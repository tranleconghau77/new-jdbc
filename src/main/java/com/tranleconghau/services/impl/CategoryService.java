package com.tranleconghau.services.impl;

import java.util.List;

import javax.inject.Inject;

import com.tranleconghau.dao.ICategoryDAO;
import com.tranleconghau.model.CategoryModel;
import com.tranleconghau.services.ICategoryService;

public class CategoryService implements ICategoryService{
	
	@Inject
	private ICategoryDAO categoryDao;
	
	@Override
	public List<CategoryModel> findAll(){
		return categoryDao.findAll();
	}
}
