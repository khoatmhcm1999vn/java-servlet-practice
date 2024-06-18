package com.webmvc.dao;

import com.webmvc.model.NewsModel;
import com.webmvc.paging.Pageable;

import java.util.List;

public interface INewsDAO {
	
	List<NewsModel> findAll();
	
	List<NewsModel> findAll(Pageable pageable);
	
	NewsModel findOneById(Long id);
	
	List<NewsModel> findByCategoryId(long categoryId);
	
	Long save(NewsModel news);
	
	Long edit(NewsModel news);
	
	void delete(Long id);
	
	int getTotalItem();
}
