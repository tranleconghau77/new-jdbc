package com.tranleconghau.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranleconghau.dao.INewDAO;
import com.tranleconghau.model.NewsModel;
import com.tranleconghau.model.UserModel;
import com.tranleconghau.services.ICategoryService;
import com.tranleconghau.services.INewService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/trang-chu")
public class HomeController extends HttpServlet {
	
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private INewService newService;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String title = "Bài viết 5";
//		String thumbnail = "Thumbnail của bài viết 5";
//		String shortDescription = "Mô tả của bài viết 5";
//		String content = "Nội dung của bài viết 5";
//		Long categoryId = 2L;
//		
//		NewsModel newModel = new NewsModel();
//		newModel.setCategoryId(categoryId);
//		newModel.setTitle(title);
//		newModel.setThumbnail(thumbnail);
//		newModel.setContent(content);
//		newModel.setShortDescription(shortDescription);
//		
//		newService.save(newModel);
//		request.setAttribute("categories", categoryService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("views/web/home.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
