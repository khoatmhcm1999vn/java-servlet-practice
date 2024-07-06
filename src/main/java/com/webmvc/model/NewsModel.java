package com.webmvc.model;

import java.util.ArrayList;
import java.util.List;

public class NewsModel extends AbstractModel<NewsModel> {

	private String title;

	private String thumbnail;

	private String shortDescription;

	private String content;

	private Long categoryId;

	private List<CategoryModel> categories = new ArrayList<>();
	
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return this.thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public List<CategoryModel> getCategories() {
		return this.categories;
	}

	public void setCategories(List<CategoryModel> categories) {
		this.categories = categories;
	}

}
