package com.tranleconghau.services.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.tranleconghau.dao.INewDAO;
import com.tranleconghau.model.NewsModel;
import com.tranleconghau.services.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDao;

	@Override
	public List<NewsModel> findByCategoryId(long categoryId) {
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedBy("");
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
	}

	@Override
	public NewsModel update(NewsModel updateNew) {
		NewsModel oldNew = new NewsModel();
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newDao.update(updateNew);

		return newDao.findOne(updateNew.getId());

	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for (long id : ids) {
			// delete comments 
			newDao.delete(id);
		}
	}

	@Override
	public List<NewsModel> findAll() {
		return newDao.findAll();
	}

}
