package com.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


/*
 * Servlet 要在 web.xml 中配置。
 */
public class TestAction extends HttpServlet{

	public TestAction() {
		super();
		System.out.println("-------------TestAction 构造法");
	}

	public void destroy() {	
		super.destroy();
		System.out.println("-------------TestAction destroy");
	}

	public void init() throws ServletException {
		super.init();
		System.out.println("-------------TestAction init");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response); // 合并doGet ,doPost
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-------------TestAction run");
		
		// 全局参 : getServletContext() == application
		String allNum = getServletContext().getInitParameter("allNum");
		System.out.println("----test-------allNum = "+allNum);
		
		// 局部参
		String testNum = this.getInitParameter("testNum");
		System.out.println("----test-------testNum = "+testNum);
		
		// request 乱码处理
		request.setCharacterEncoding("UTF-8");
		// response 乱码处理
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String s = "<h1>Servlet 测试</h1>";
		
		out.print(s);
		
		out.flush();
		out.close();
	}

}
