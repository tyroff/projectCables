<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:head title="workspace">
	<u:body>
		<u:header>
			<u:headerAuthenticationWorkspace/>
		</u:header>
		<u:menu>
			<u:menuWorkspace/>
		</u:menu>
			<form action="workspace/addCableBrands.html" method="post">
				<div class="container-main">
					<u:leftPannel>
						<u:leftPannelWorkspace/>
					</u:leftPannel>
						<u:main1>
						<u:mainWorkspace>
							<ul>
								<c:forEach var="cableCategoryAndTnlas" items="${cableCategoryAndTnlas}">
									<li style="list-style-type: none">
										<table cellspacing=0 border=0 width="100%" cellpadding="5">
										<tr>
											<td style="width: 30px"><input type="radio" name="idCableCategory" value="${cableCategoryAndTnlas.key.id}"></td>
											<td><b>${cableCategoryAndTnlas.key.name}"</b></td>
										</tr>
										</table>
										<ul>
											<c:forEach var="tnlas" items="${cableCategoryAndTnlas.value}">
												<li style="list-style-type: none">
												<table cellspacing=0 border=0 width="100%" cellpadding="5">
													<tr>
														<td style="width: 30px"><input type="radio" name="idTnla" value="${tnlas.id}"></td>
														<td>${tnlas.code}  "${tnlas.name}"</td>
													</tr>
													</table>
													<ul>
														<c:forEach var="brandsCategoryTnla" items="${brandsCategoryTnla.value}">
															<c:if test="${cableCategoryAndTnlas.key.id * 1000000 + tnlas.id == brandsCategoryTnla.key}">
																<li style="list-style-type: none">
																<table cellspacing=0 border=0 width="100%" cellpadding="5">
																	<tr>
																		<td>${brandsCategoryTnla}"</td>
																	</tr>
																	</table>
																</li>
															</c:if>	
														</c:forEach>
													</ul>
												</li>
											</c:forEach>
										</ul>
										<br>
									</li>
								</c:forEach>
							</ul>						
						</u:mainWorkspace>
					</u:main1>
				</div>
			</form>
	</u:body>
</u:head>