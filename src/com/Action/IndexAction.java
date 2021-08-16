package com.Action;

import java.io.IOException;
import java.io.PrintWriter;

import com.entity.*;
import com.service.*;
import com.service.impl.*;

import java.util.*;
import java.net.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class IndexAction extends HttpServlet {
	private IUserService us = new UserService(); // ���÷����
	/**
	 * Constructor of the object.
	 */
	public IndexAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//request���봦��
		request.setCharacterEncoding("UTF-8");
		//response���봦��
		response.setCharacterEncoding("UTF-8");//�������
		response.setContentType("text/html;charset=UTF-8");//��ҳ����
		//String method=request.getParameter("method");
		//if("list".equals(method)){ //��¼�߼�
		selectAll(request,response);
		//}
	}
	public void selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<dept> list=us.selectAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
