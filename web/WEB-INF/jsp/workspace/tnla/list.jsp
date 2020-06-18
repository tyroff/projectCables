<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="org.itstep.vinokurov.domain.Tnla" %>
<%
@SuppressWarnings("unchecked")
List<Tnla> tnlas = (List<Tnla>)request.getAttribute("tnlas");
%>
 <!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8>
		<title>ТНПА</title>
	</head>
	<body>
		<table border=1>
			<tr>
				<th>id</th>
				<th>Код ТНПА</th>
				<th>Наименование ТНПА</th>
				<th>Дата от</th>
				<th>Дата до</th>
			</tr>
			<% for(Tnla tnla : tnlas) { %>
			<tr>
				<td><%= tnla.getId() %></td>
				<td><%= tnla.getCodTnla() %></td>
				<td><%= tnla.getCodTnla() %></td>
				<td><%= String.format("%1$td.%1$tm.%1$tY", tnla.getDateStartTnla()) %></td>
				<td><%= String.format("%1$td.%1$tm.%1$tY", tnla.getDateEndTnla()) %></td>
			</tr>
			<% } %>
		</table>
	</body>
</html>