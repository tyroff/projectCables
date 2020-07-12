<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/prototypes/images/icon.png" type="image/x-icon">
	<title>редактор категорию кабелей</title>
</head> 

<body>
<h2>Редактировать категорию кабелей</h2>
	<form action="save.html" method="post">
		<input type="hidden" name="id" value="${cableCategory.id}">
		<br>
		<label for="name">Название</label>
		<br>
		<input type="text" name="name" value="${cableCategory.name}">
		<br>
		<br>
		<button type="submit">Сохранить</button>
	</form>
		<br>
	<form action="../cableCategory.html">
		<button type="submit">Отмена</button>
	</form>
</body>

</html>
 