<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:head title="ТНПА">
	<u:body>
		<u:header>
			<u:headerAuthenticationWorkspace/>
		</u:header>
		<u:menu>
			<h2>Добавить новый ТНПА</h2>
		</u:menu>
			<div class="container-main">
			<u:leftPannel/>
			<u:main>
				<u:mainWorkspace>
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
					</u:mainWorkspace>
				</u:main>
			</div>
	</u:body>
</u:head>
 