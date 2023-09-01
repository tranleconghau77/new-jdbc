package com.tranleconghau.dao;

import java.util.List;

import com.tranleconghau.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
}
