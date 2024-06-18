package com.webmvc.dao.impl;

import com.webmvc.dao.INewsDAO;
import com.webmvc.mapper.NewsMapper;
import com.webmvc.model.NewsModel;
import com.webmvc.paging.Pageable;

import javax.annotation.ManagedBean;
import java.util.List;

@ManagedBean
public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO{

	@Override
	public List<NewsModel> findByCategoryId(long categoryId) {
		
		String sql = "Select * from news where categoryid = ?";
		NewsMapper newsMapper = new NewsMapper();
		Object[] objects = {categoryId};
		List<NewsModel> newsList = this.query(sql, newsMapper, objects);
		return newsList;
	}

	@Override
	public Long save(NewsModel news) {
		String sql = "insert into news (title, thumbnail, content, shortdescription, categoryid, createddate, createdby) values (?,?,?,?,?,?,?)";
		return this.insert(sql, news.getTitle(), news.getThumbnail(), news.getContent(), news.getShortDescription(),
				news.getCategoryId(), news.getCreatedDate(), news.getCreatedBy());
	}

	@Override
	public NewsModel findOneById(Long id) {
		String sql = "Select * from news where id = ?";
		NewsMapper newsMapper = new NewsMapper();
		List<NewsModel> news = this.query(sql, newsMapper, id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public Long edit(NewsModel news) {
		
		StringBuilder sql = new StringBuilder("update news set title = ?, thumbnail = ?,");
		sql.append(" content = ?, shortdescription = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ? where id = ?");		 
		
		this.update(sql.toString(), news.getTitle(), news.getThumbnail(), 
				news.getContent(), news.getShortDescription(), news.getCategoryId(),
				news.getCreatedDate(), news.getCreatedBy(), news.getId());
		return news.getId();
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		this.update(sql, id);
	}

	@Override
	public List<NewsModel> findAll() {
		String sql = "Select * from news";
		NewsMapper newsMapper = new NewsMapper();
		List<NewsModel> listNews = this.query(sql, newsMapper);
		return listNews;
	}

	@Override
	public int getTotalItem() {
		String sql = "select count(*) from news";
		return this.count(sql);
	}

	@Override
	public List<NewsModel> findAll(Pageable pageable) {
		StringBuilder sql = new StringBuilder("Select * from news");
		
		if(pageable.getSorter().getSortBy() != null || pageable.getSorter().getSortName() != null) {
			sql.append(" order by " + pageable.getSorter().getSortName() + " "+pageable.getSorter().getSortBy());
		}
		if(pageable.getOffset() != null  || pageable.getLimit() != null) {
			sql.append(" limit " + pageable.getOffset() + ", "+pageable.getLimit());
		}
		
		NewsMapper newsMapper = new NewsMapper();
		List<NewsModel> listNews = this.query(sql.toString(), newsMapper);
		return listNews;
	}	
}
