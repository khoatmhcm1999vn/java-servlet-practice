package com.webmvc.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {

	private Long id;

    private Timestamp createDate;

    private Timestamp modifiedDate;

    private String createdBy;

    private String modifiedBy;

    private Long[] ids;

    private List<T> listResult = new ArrayList<>();

    private Integer page;

    private Integer totalPage;

    private Integer maxPageItem;

    private Integer totalItem;

    private String sortName;

    private String sortBy;

	public String getSortName() {
		return this.sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortBy() {
		return this.sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public Integer getPage() {
		return this.page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotalPage() {
		return this.totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getMaxPageItem() {
		return this.maxPageItem;
	}

	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}

	public Integer getTotalItem() {
		return this.totalItem;
	}

	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getCreatedDate() {
		return this.createDate;
	}

	public void setCreatedDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Long[] getIds() {
		return this.ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public List<T> getListResult() {
		return this.listResult;
	}

	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}

}
