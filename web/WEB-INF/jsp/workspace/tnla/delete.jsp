<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:head title="Удалить ТНПА">
	<u:body>
		<u:header>
			<u:headerAuthenticationWorkspace/>
		</u:header>
		<u:menu>
			<h2>Удалить ТНПА?</h2>
		</u:menu>
			<div class="container-main">
			<u:leftPannel/>
			<u:main1>
				<u:mainWorkspace>
					<div>
						<form action="deleteImplement.html" method="post">
							<br>
							<input type="hidden" name="id" value="${tnla.id}">
							<label for="code">Код ТНПА</label>
							<br>
							<input type="text" name="code" value="${tnla.code}" disabled>
							<br>
							<br>
							<label for="name">Наименование ТНПА</label>
							<br>
							<input type="text" name="name" value="${tnla.name}" disabled>
							<br>
							<br>
							<br>
							<button type="submit" class="button button_add">
								<span class="button-text">Да</span>
							</button>
						</form>
								<br>
						<form action="../tnla.html">
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

 