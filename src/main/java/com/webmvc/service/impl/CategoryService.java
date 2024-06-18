package com.webmvc.service.impl;

import com.webmvc.dao.ICategoryDAO;
import com.webmvc.model.CategoryModel;
import com.webmvc.service.ICategoryService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
		
	}
	
}
