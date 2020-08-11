<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:head title="Добавить категорию кабеля">
	<u:body>
		<u:header>
			<u:headerAuthenticationWorkspace/>
		</u:header>
		<u:menu>
			<h2>Добавить новую категорию кабеля</h2>
		</u:menu>
			<div class="container-main">
			<u:leftPannel/>
			<u:main>
				<u:mainWorkspace>
					<div>
						<form action="save.html" method="post">
							<br>
							<label for="name">Наименование категории кабеля</label>
							<br>
							<input type="text" name="name">
							<br>
							<br>
							<button type="submit" class="button button_add">
								<span class="button-text">Сохранить</span>
							</button>
						</form>
							<br>
						<form action="../cableCategory.html">
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
 