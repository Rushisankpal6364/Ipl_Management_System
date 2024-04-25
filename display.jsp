<%@page import="beans1.IplDao"%>
<%@page import="beans1.Player"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<% 
List<Player>list = IplDao.getAllPlayers();
%>


<table class="table">
	<tr>
	    <th>id</th>
	    <th>jerseyno</th>
		<th>name</th>
		<th>age</th>
		<th>team</th>
		<th>highestscore</th>
		<th>type</th>
		<th>Delete Option</th>
		<th>Update Option</th>
	</tr>
	
<%for(Player p:list){ %>
		<tr>
			<td><%=p.getId() %></td>
		    <td><%=p.getJerseyno() %></td>
			<td><%=p.getName() %></td>
			<td><%=p.getAge() %></td>
			<td><%=p.getTeam() %></td>
			<td><%=p.getHighestscore() %></td>
			<td><%=p.getType() %></td>
			<td><a href='Delete?id=<%=p.getId()%>'>Delete</a></td>
		    <td><a href='Update.jsp?id=<%=p.getId()%>'>Update</a></td>
		   
		</tr>
	<%} %>
	
</table>
	
</body>
</html>