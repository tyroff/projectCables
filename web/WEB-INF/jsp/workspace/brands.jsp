<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:head title="Марки кабелей">
	<u:body>
		<u:header>
			<u:headerAuthenticationWorkspace/>
		</u:header>
		<u:menu>
			<u:menuWorkspaceBrands/>
		</u:menu>
		<form action="brands/delegate.html" method="post">
			<div class="container-main">
			<u:leftPannel>
				<u:leftPannelWorkspaceCUD/>
			</u:leftPannel>
			<u:main>
				<u:mainWorkspace>
			        <table cellspacing=0 border=1 width="100%" cellpadding="5">
			          	<tr>
			            	<th>id</th>
			            	<th>Марка кебеля</th>
			          	</tr>
						<c:forEach var="brands" items="${brands}">
							<tr>
								<td><input type="radio" name="id" value="${brands.id}"></td>
								<td>${brands.name}</td>
							</tr>
						</c:forEach>
					</table>
				</u:mainWorkspace>
			</u:main>
			</div>
		</form>
	</u:body>
</u:head>
