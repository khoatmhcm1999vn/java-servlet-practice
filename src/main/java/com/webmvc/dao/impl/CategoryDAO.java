package com.webmvc.dao.impl;

import com.webmvc.dao.ICategoryDAO;
import com.webmvc.mapper.CategoryMapper;
import com.webmvc.model.CategoryModel;

import javax.annotation.ManagedBean;
import java.util.List;

@ManagedBean
public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
	
	@Override
	public List<CategoryModel> findAll() {		
		String sql = "Select * from category";
		CategoryMapper categoryMapper = new CategoryMapper();
		List<CategoryModel> categoryList = this.query(sql, categoryMapper);
		return categoryList;
	}
}
