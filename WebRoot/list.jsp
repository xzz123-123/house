<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.*,com.service.*,com.service.impl.*" %><!-- 导包 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Object obj=request.getAttribute("list");
List<dept> list=new ArrayList();
if(obj!=null){
	list=(List<dept>)obj;
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table border="1" align="center" width="80%">
    <thead>
    	<tr>
    	<th>编号</th>
    	<th>姓名</th>
    	<th>地址</th>
    	</tr>
    </thead>
    <tbody>
    <%for(dept d:list){ %>
    	<tr>
    	<td><%=d.getDEPTNO() %></td>
    	<td><%=d.getDNAME() %></td>
    	<td><%=d.getLOC() %></td>
    	</tr>
    	<%} %>
    </tbody>
    </table>
    <h2><a href="/mywork8/newdept.jsp">新增部门</a></h2>
  </body>
</html>
