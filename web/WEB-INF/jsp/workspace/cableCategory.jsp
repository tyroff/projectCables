<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:head title="Категории кабелей">
	<u:body>
		<u:header>
			<u:headerAuthenticationWorkspace/>
		</u:header>
		<u:menu>
			<u:menuWorkspaceCableCategory/>
		</u:menu>
		<form action="cableCategory/delegate.html" method="post">
			<div class="container-main">
			<u:leftPannel>
				<u:leftPannelWorkspaceCUD/>
			</u:leftPannel>
			<u:main1>
				<u:mainWorkspace>
			        <table cellspacing=0 border=1 width="100%" cellpadding="5">
			          	<tr>
			            	<th width=30px>id</th>
			            	<th>Наименование категории кабелей</th>
			          	</tr>
						<c:forEach var="cableCategory" items="${cableCategories}">
							<tr>
								<td><input type="radio" name="id" value="${cableCategory.id}"></td>
								<td>${cableCategory.name}</td>
							</tr>
						</c:forEach>
					</table>
				</u:mainWorkspace>
			</u:main1>
			</div>
		</form>
	</u:body>
</u:head>
