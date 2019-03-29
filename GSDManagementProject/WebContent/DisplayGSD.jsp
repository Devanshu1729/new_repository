<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import = "com.cts.gsd.bean.*" %>
<%@page import="java.util.*" %>
<%ArrayList<GSDdetailbean> ab=(ArrayList<GSDdetailbean>) request.getAttribute("dis"); %>
<table border=3>
<th>USER_ID</th>
 <th>GSD_ID</th>
 <th>Issue_Description</th>
 <th>Status</th>
<%Iterator i=ab.iterator();

while(i.hasNext())
{
	GSDdetailbean sb=(GSDdetailbean)i.next();%>
                <tr>
                <td><%= sb.getUSER_ID()%></td>
                <td><%= sb.getGSD_ID()%></td>
                <td><%= sb.getIssue_Description()%></td>
                <td><%= sb.getStatus() %></td>
                </tr>
   
<% }%>
<span style="position: absolute; bottom: 0pt; right: 0pt;"><a href="AdminUpdate.html">Click here to update ticket status</a></span>
</body>
</html>