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
							<li value="${cableCategoryAndTnlas.key.id}"><b>${cableCategoryAndTnlas.key.name}"</b>
								<ul>
									<c:forEach var="tnlas" items="${cableCategoryAndTnlas.value}">
										<li style="list-style-type: none">
										<table cellspacing=0 border=0 width="100%" cellpadding="5">
											<tr>
												<td style="width: 30px"><input type="radio" name="idTnla" value="${tnlas.id}" name="idCableCategory" value="${cableCategoryAndTnlas.key.id}"></td>
												<td>${tnlas.code}  "${tnlas.name}"</td>
											</tr>
											</table>
										</li>
									</c:forEach>
								</ul>
								<br>
							</li>
						</c:forEach>
					</ul>						
				</u:mainWorkspace>
			</u:main>
		</u:containerMainWorkspace>
	</u:body>
</u:head>


<tr>
			            	<th>id</th>
			            	<th>Код ТНПА</th>
			            	<th>Наименование ТНПА</th>
			            	<th>Дата от</th>
			           		<th>Дата до</th>
			          	</tr>