package com.webmvc.paging;

import com.webmvc.sorting.Sorter;

public interface Pageable {

	Integer getPage();

	Integer getOffset();

	Integer getLimit();

	Sorter getSorter();

}
