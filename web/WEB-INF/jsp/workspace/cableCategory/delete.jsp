<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:head title="Удалить категорию кабеля">
	<u:body>
		<u:header>
			<u:headerAuthenticationWorkspace/>
		</u:header>
		<u:menu>
			<h2>Удалить категорию кабеля?</h2>
		</u:menu>
			<div class="container-main">
			<u:leftPannel/>
			<u:main1>
				<u:mainWorkspace>
					<div>
						<form action="deleteImplement.html" method="post">
							<br>
							<input type="hidden" name="id" value="${cableCategory.id}">
							<label for="name">Название</label>
							<br>
							<input type="text" name="name" value="${cableCategory.name}" disabled>
							<br>
							<br>
							<br>
							<button type="submit" class="button button_add">
								<span class="button-text">Да</span>
							</button>
						</form>
							<br>
						<form action="../cableCategory.html">
							<button type="submit" class="button button_del">
								<span class="button-text">Нет</span>
							</button>
						</form>
					</div>
				</u:mainWorkspace>
			</u:main1>
		</div>
	</u:body>
</u:head>
