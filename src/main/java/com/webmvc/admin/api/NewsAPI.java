package com.webmvc.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webmvc.model.NewsModel;
import com.webmvc.service.INewsService;
import com.webmvc.utils.HttpUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class NewsAPI
 */
@WebServlet("/api-admin-news")
public class NewsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private INewsService newsService;
	   
	/**
     * @see HttpServlet#HttpServlet()
     */
    public NewsAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel requestNews =  HttpUtils.of(request.getReader()).toModel(NewsModel.class);
		NewsModel news = this.newsService.save(requestNews);		
		objectMapper.writeValue(response.getOutputStream(), news);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		NewsModel requestNews =  HttpUtils.of(request.getReader()).toModel(NewsModel.class);
		NewsModel news = this.newsService.edit(requestNews);	
		objectMapper.writeValue(response.getOutputStream(), news);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		NewsModel news = HttpUtils.of(request.getReader()).toModel(NewsModel.class);
		this.newsService.delete(news.getIds());
		objectMapper.writeValue(response.getOutputStream(), "{}");
	}
}
