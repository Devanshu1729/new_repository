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
<%ArrayList<GSDdetailbean> ab=(ArrayList<GSDdetailbean>) request.getAttribute("display"); %>

<table border=3>

 <th>GSD_ID</th>
 
 <th>Status</th>
<%Iterator i=ab.iterator();

while(i.hasNext())
{
	GSDdetailbean sb=(GSDdetailbean)i.next();%>
                <tr>
               
                <td><%= sb.getGSD_ID()%></td>
                
                <td><%= sb.getStatus() %></td>
                </tr>
   
<% }%>
<br>
<br><br>
<a href="UserLogin.html">Close</a><br>
<a href="CloseTicket.html">Close other tickets</a>
</body>
</html>