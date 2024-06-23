package com.webmvc.dao;

import com.webmvc.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO {

	List<CategoryModel> findAll();

}
