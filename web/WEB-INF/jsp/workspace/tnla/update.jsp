<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ru">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/prototypes/images/icon.png" type="image/x-icon">
	<title>редактор ТНПА</title>
</head> 

<body>
<h2>Редактировать ТНПА</h2>
	<form action="save.html" method="post">
		<input type="hidden" name="id" value="${tnla.id}">
		<br>
		<label for="code">Код</label>
		<br>
		<input type="text" name="code" value="${tnla.code}">
		<br>
		<br>
		<label for="name">Название</label>
		<br>
		<input type="text" name="name" value="${tnla.name}">
		<br>
		<br>
		<label for="dateStart">Дата начала </label>
		<br>
		<fmt:formatDate var="dateStart" value="${tnla.dateStart}" pattern="yyyy-MM-dd"/>
		<input type="date" name="dateStart" value="${dateStart}">
		<br>
		<br>
		<label for="dateEnd">Дата конца</label>
		<br>
		<fmt:formatDate var="dateEnd" value="${tnla.dateEnd}" pattern="yyyy-MM-dd"/>
		<input type="date" name="dateEnd" value="${dateEnd}"/>
		<br>
		<br>
		<br>
		<button type="submit">Сохранить</button>
	</form>
		<br>
	<form action="../tnla.html">
		<button type="submit">Отмена</button>
	</form>
</body>

</html>
 