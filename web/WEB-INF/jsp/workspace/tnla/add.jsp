<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:head title="Добавить ТНПА">
	<u:body>
		<u:header>
			<u:headerAuthenticationWorkspace/>
		</u:header>
		<u:menu>
			<h2>Добавить новый ТНПА</h2>
		</u:menu>
			<div class="container-main">
			<u:leftPannel/>
			<u:main1>
				<u:mainWorkspace>
					<div>
						<form action="save.html" method="post">
							<br>
							<label for="code">Код ТНПА</label>
							<br>
							<input type="text" name="code"  autofocus>
							<br>
							<br>
							<label for="name">Наименование ТНПА</label>
							<br>
							<input type="text" name="name">
							<br>
							<br>
							<label for="dateStart">Дата начала действия ТНПА</label>
							<br>
							<input type="date" name="dateStart">
							<br>
							<br>
							<label for="dateEnd">Дата конца действия ТНПА</label>
							<br>
							<input type="date" name="dateEnd">
							<br>
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
			</u:main1>
		</div>
	</u:body>
</u:head>
 