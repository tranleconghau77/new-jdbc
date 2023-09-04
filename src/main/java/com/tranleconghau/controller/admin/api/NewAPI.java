package com.tranleconghau.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tranleconghau.model.NewsModel;
import com.tranleconghau.services.INewService;
import com.tranleconghau.utils.HttpUtil;

@WebServlet("/api-admin-new")
public class NewAPI extends HttpServlet {
	
	@Inject 
	private INewService newService;

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(111111);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		// Get Json data from request and convert to Model Object
		NewsModel newModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		newModel = newService.save(newModel);
		
		// Use Object mapper to convert from Model to Object
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), newModel);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json"); 
		
		// Get Json data from request and convert to Model Object
		NewsModel updateNewModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		updateNewModel = newService.update(updateNewModel);
		
		// Use Object mapper to convert from Model to Object
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), updateNewModel);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		// Get Json data from request and convert to Model Object
		NewsModel newModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		newService.delete(newModel.getIds());
		
		// Use Object mapper to convert from Model to Object
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
	
}
