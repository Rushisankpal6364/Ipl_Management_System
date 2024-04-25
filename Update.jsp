<%@page import="beans1.IplDao"%>
<%@page import="beans1.Player"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int id = Integer.parseInt(request.getParameter("id"));
Player p = IplDao.getPlayer(id);
%>

<form action="Update" method="POST">
<h1>Welcome to Update page</h1>
        <table>
        <tr>
            <td><label>Jerseyno :</label> </td>
            <td><input type="text" name="jerseyno" value="<%=p.getJerseyno()%>"></td>
        </tr>
        <tr>
            <td>Name :</td>
            <td><input type="text" name="name" value="<%=p.getName()%>"></td>   
        </tr>
        <tr>
            <td>Age :</td>
            <td><input type="text" name="age" value="<%=p.getAge()%>"></td>   
        </tr>
        <tr>
            <td>Team :</td>
            <td><input type="text" name="team" value="<%=p.getTeam()%>"></td>   
        </tr>
        <tr>
            <td>HighestScore :</td>
            <td><input type="text" name="highestscore" value="<%=p.getHighestscore()%>"></td>   
        </tr>
         <tr>
            <td>Type :</td>
            <td><input type="text" name="type" value="<%=p.getType()%>"></td>   
        </tr>
        <tr>
            <td><input type="hidden" name="id" value="<%=p.getId()%>"></td>   
        </tr>
        <tr>
            <td>
                <button type="submit" name="btn" value="insert">Update</button>
            </td>
        </tr>
        
    </table>
    </form>
</body>
</html>