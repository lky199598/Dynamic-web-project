<%@page import="java.text.SimpleDateFormat,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>session内置对象</h1>
<hr>
session的ID编号:<%=session.getId() %><br><br>
从session中获取用户名:<%=session.getAttribute("username") %><br><br>
session中保存的属性有:
<%
String str[] = session.getValueNames();
for(String s:str)
{
	out.println(s+"&nbsp;&nbsp");
}
%>
<br>

</body>
</html>