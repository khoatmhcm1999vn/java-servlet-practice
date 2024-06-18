package com.webmvc.service.impl;

import com.webmvc.dao.INewsDAO;
import com.webmvc.model.NewsModel;
import com.webmvc.paging.Pageable;
import com.webmvc.service.INewsService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

@ManagedBean
public class NewsService implements INewsService{

	@Inject
	private INewsDAO newsDAO;
	
	@Override
	public List<NewsModel> findByCategoryId(long categoryId) {
		return newsDAO.findByCategoryId(categoryId);		
	}

	@Override
	public NewsModel save(NewsModel news) {
		news.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		news.setCreatedBy("");
		Long newsId = newsDAO.save(news);	
		NewsModel outputNews = newsDAO.findOneById(newsId);
		return outputNews;
	}

	@Override
	public NewsModel findOneById(Long id) {
		NewsModel outputNews = newsDAO.findOneById(id);
		return outputNews;
	}

	@Override
	public NewsModel edit(NewsModel news) {
		
		NewsModel oldNews = newsDAO.findOneById(news.getId());
		
		news.setCreatedDate(oldNews.getCreatedDate());
		news.setCreatedBy(oldNews.getCreatedBy());
		Long index = this.newsDAO.edit(news);
		
		return this.newsDAO.findOneById(index); 
	}

	@Override
	public void delete(Long[] ids) {
		for(Long id : ids) {
			this.newsDAO.delete(id);
		}		
	}

	@Override
	public List<NewsModel> findAll() {
		return this.newsDAO.findAll();		
	}

	@Override
	public int getTotalItem() {		
		return this.newsDAO.getTotalItem();
	}

	@Override
	public List<NewsModel> findAll(Pageable pageable) {
		return this.newsDAO.findAll(pageable);		
	}
}
