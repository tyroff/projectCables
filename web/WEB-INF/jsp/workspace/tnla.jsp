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
			<u:menuWorkspaceTnla/>
		</u:menu>
		<u:containerMainWorkspace>
			<u:leftPannelWorkspaceTnla>
				<u:leftPannelWorkspaceTnla/>
			</u:leftPannelWorkspaceTnla>
			<u:main>
				<u:mainWorkspace>
			        <table cellspacing=0 border=1 width="100%" cellpadding="5">
			          	<tr>
			            	<th>id</th>
			            	<th>Код ТНПА</th>
			            	<th>Наименование ТНПА</th>
			            	<th>Дата от</th>
			           		<th>Дата до</th>
			          	</tr>
						<c:forEach var="tnla" items="${tnlas}">
						<tr>
							<td><input type="radio" name="id" value="${tnla.id}"></td>
							<td>${tnla.code}</td>
							<td>${tnla.name}</td>
							<td><fmt:formatDate value="${tnla.dateStart}" pattern="dd.MM.yyyy"/></td>
							<td><fmt:formatDate value="${tnla.dateEnd}" pattern="dd.MM.yyyy"/></td>
						</tr>
						</c:forEach>
					</table>
				</u:mainWorkspace>
			</u:main>
		</u:containerMainWorkspace>
	</u:body>
</u:head>
