<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:head title="ТНПА&Категории">
	<u:body>
		<u:header>
			<u:headerAuthenticationWorkspace/>
		</u:header>
		<u:menu>
			<h2>Привязка ТНПА к категории/ям</h2>
		</u:menu>
			<div class="container-main">
			<u:leftPannel/>
			<u:main>
				<u:mainWorkspace>
					<div>
						<form action="save.html" method="post">
							<input type="hidden" name="id" value="${tnla.id}">
							<br>
							<label for="code">Код ТНПА</label>
							<br>
							<input type="text" name="code" value="${tnla.code}">
							<br>
							<br>
							<label for="name">Наименование ТНПА</label>
							<br>
							<input type="text" name="name" value="${tnla.name}">
							<br>
							<c:forEach var="cableCategory" items="${cableCategories}">
								<tr>
									<td><input type="checkbox" name="id" value="${cableCategory.id}"></td>
									<td>${cableCategory.name}</td>
								</tr>
							</c:forEach>
							<br>
							<br>
							<button type="submit" class="button button_add">
								<span class="button-text">Сохранить</span>
							</button>
						</form>
								<br>
						<form action="../tnla.html">
							<button type="submit" class="button button_del">
								<span class="button-text">Отмена</span>
							</button>
						</form>
					</div>
				</u:mainWorkspace>
			</u:main>
		</div>
	</u:body>
</u:head>

 