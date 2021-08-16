<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'newdept.jsp' starting page</title>
    
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
   	 <h2>新增用户</h2>
    <form action="/mywork8/NewIndexAction" method="post">
    <p>编号：<input type="text" name="deptno" ></p>
    <p>名字：<input type="text" name="dname" ></p>
    <p>地址：<input type="text" name="loc" ></p>
    <input type="submit" value="提交">
    </form>
  </body>
</html>
<script src="/mywork8/js/jquery-1.12.4.js"></script>
<script>
	$(function(){
		  var ckadd = '<%=request.getAttribute("addCode")%>';
		  if(ckadd == 'true'){
			  alert("新增成功。");
			  window.location.href= '/mywork8/index.jsp';//如果插入成功就跳转到list
		  }else if(ckadd == 'false'){
			  alert("新增失败！！！");
		  }
		  
	})
</script>
