package com.tranleconghau.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranleconghau.constant.SystemConstant;
import com.tranleconghau.model.NewsModel;
import com.tranleconghau.services.INewService;

@WebServlet("/admin-new")
public class NewController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private INewService newService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		NewsModel model = new NewsModel();
		model.setListResult(newService.findAll());
		
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher("views/admin/new/list.jsp");
		rd.forward(req, resp);
	}
}
