<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/prototypes/images/icon.png" type="image/x-icon">
	<title>редактор ТНПА</title>
</head> 

<body>
<h2>Добавить новый ТНПА</h2>
	<form action="save.html" method="post">
		<br>
		<label for="code">Код</label>
		<br>
		<input type="text" name="code">
		<br>
		<br>
		<label for="name">Название</label>
		<br>
		<input type="text" name="name">
		<br>
		<br>
		<label for="dateStart">Дата начала</label>
		<br>
		<input type="date" name="dateStart">
		<br>
		<br>
		<label for="dateEnd">Дата конца</label>
		<br>
		<input type="date" name="dateEnd">
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
 