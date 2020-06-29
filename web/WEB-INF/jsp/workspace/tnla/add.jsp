<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>добавить ТНПА</title>
</head> 

<body>
	<br>
	<label for="code">Код</label>
	<br>
	<input type="text" id="cod" name="cod">
	<br>
	<br>
	<label for="name">Название</label>
	<br>
	<input type="text" id="name" name="name">
	<br>
	<br>
	<label for="dateStart">Дата начала</label>
	<br>
	<input type="date" id="dateStart" name="dateStart">
	<br>
	<br>
	<label for="dateEnd">Дата конца</label>
	<br>
	<input type="date" id="dateEnd" name="dateEnd">
	<br>
	<br>
	<form action="save.html">
	 	<c:forEach var="cableCategory" items="${cableCategores}">
	 		<input type="checkbox" value="${cableCategory.id}">${cableCategory.name}<Br>
	 	</c:forEach>
	<br>
	<br>
	<button type="submit">Сохранить</button>
	</form>
</body>

</html>
 