<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<u:head title="workspace">
	<u:body>
		<u:header>
			<u:headerAuthenticationWorkspace/>
		</u:header>
		<u:menu>
			<u:menuWorkspace/>
		</u:menu>
		<u:containerMainWorkspace>
			<u:leftPannel>
				<u:leftPannelWorkspace/>
			</u:leftPannel>
			<u:main>
				<u:mainWorkspace>
					<ul>
						<c:forEach var="cableCategoryAndTnlas" items="${cableCategoryAndTnlas}">
							<li><input name="idCableCategory" value="${cableCategoryAndTnlas.key.id}">${cableCategoryAndTnlas.key.name}"
								<ul>
									<c:set var="tnlas" items="${cableCategoryAndTnlas.value}"/>
									<c:forEach var="tnlas" items="${tnlas}">
										<li><input type="radio" name="idTnla" value="${tnlas.id}">"${tnlas.code} + ${tnlas.name}"</li>
									</c:forEach>
								</ul>
							</li>
						</c:forEach>
					</ul>						
				</u:mainWorkspace>
			</u:main>
		</u:containerMainWorkspace>
	</u:body>
</u:head>
