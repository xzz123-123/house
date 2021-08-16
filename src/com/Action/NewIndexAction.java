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

public class NewIndexAction extends HttpServlet {
	private IUserService us = new UserService(); // ���÷����
	/**
	 * Constructor of the object.
	 */
	public NewIndexAction() {
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
		//if("newdept".equals(method)){ //��¼�߼�
		addDepts(request,response);
		//}
	}
	public void addDepts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deptno=request.getParameter("deptno");
		String dname=request.getParameter("dname");
		String loc=request.getParameter("loc");
		dept d=new dept();
//			  d.setDeptno(Integer.parseInt(deptno));
//			  d.setDname(dname);
//			  d.setLoc(loc);
		d.setDEPTNO(Integer.parseInt(deptno));
		d.setDNAME(dname);
		d.setLOC(loc);
		IUserService ds=new UserService();
		int num=ds.insertStu(d);
		if(num>0){
			request.setAttribute("addCode", "true");
		}else{
			request.setAttribute("addCode", "false");
		}
		request.getRequestDispatcher("/newdept.jsp").forward(request, response);
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
