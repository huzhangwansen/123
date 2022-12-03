<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.hq.pojo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<%
    Admin admin=(Admin)session.getAttribute("admin");
    String notice=admin.getNotice();
%>
</head>
<body>

<h2>公告为：<%=notice%></h2>
</body>
</html>