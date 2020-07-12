<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/prototypes/images/icon.png" type="image/x-icon">
	<title> ТНПА</title>
</head> 

<body>
<h2>Удалить категорию кабелей?</h2>
	<form action="deleteImplement.html" method="post">
		<br>
		<input type="hidden" name="id" value="${cableCategory.id}">
		<label for="name">Название</label>
		<br>
		<input type="text" name="name" value="${cableCategory.name}" disabled>
		<br>
		<br>
		<br>
		<button type="submit">Да</button>
	</form>
		<br>
	<form action="../cableCategory.html">
		<button type="submit">Нет</button>
	</form>
</body>

</html>
 