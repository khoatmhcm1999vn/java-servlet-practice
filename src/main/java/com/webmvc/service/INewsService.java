package com.webmvc.service;

import com.webmvc.model.NewsModel;
import com.webmvc.paging.Pageable;

import java.util.List;

public interface INewsService {
	
	List<NewsModel> findAll();
	
	List<NewsModel> findAll(Pageable pageable);
	
	NewsModel findOneById(Long id);
	
	List<NewsModel> findByCategoryId(long categoryId);
	
	NewsModel save(NewsModel news);
	
	NewsModel edit(NewsModel news);
	
	void delete(Long[] ids);
	
	int getTotalItem();

}
