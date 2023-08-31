package com.tranleconghau.services;

import java.util.List;

import com.tranleconghau.dao.ICategoryDAO;
import com.tranleconghau.model.CategoryModel;

public interface ICategoryService {
	
	List<CategoryModel> findAll();
}
