package com.webmvc.admin;

import com.webmvc.constant.SystemConstant;
import com.webmvc.model.NewsModel;
import com.webmvc.paging.Pageable;
import com.webmvc.paging.RequestPage;
import com.webmvc.service.ICategoryService;
import com.webmvc.service.INewsService;
import com.webmvc.sorting.Sorter;
import com.webmvc.utils.FormUtils;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class NewsController
 */
@WebServlet("/admin-news")
public class NewsController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService categoryService;
    
	@Inject
	private INewsService newsService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsController() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsModel model = FormUtils.toModel(NewsModel.class, request);
		String action = request.getParameter("action");
		if (action != null && action.equalsIgnoreCase("addToCart")) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/news/edit.jsp");
			rd.forward(request, response);
		}
		else {
			//mapping query param to an object
			Pageable pageable = new RequestPage(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));

			//set total item
			model.setTotalItem(this.newsService.getTotalItem());

			//set total page
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));

			//set listResult
			model.setListResult(this.newsService.findAll(pageable));

			//set attribute
			request.setAttribute(SystemConstant.MODEL, model);
			RequestDispatcher rd = request.getRequestDispatcher("views/admin/news/list.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this.doGet(request, response);
		NewsModel model = this.newsService.findOneById(Long.parseLong(request.getParameter("id")));
		model.setCategories(this.categoryService.findAll());
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/news/edit.jsp");
		rd.forward(request, response);
	}

}
