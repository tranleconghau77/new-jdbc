package com.tranleconghau.dao;

import java.util.List;

import com.tranleconghau.model.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();
}
