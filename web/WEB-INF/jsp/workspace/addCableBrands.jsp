<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:head title="Создание марок">
	<u:body>
		<u:header>
			<u:headerAuthenticationWorkspace/>
		</u:header>
		<u:menu>
			<h2>Создание марок</h2>
		</u:menu>
			<div class="container-main">
			<u:leftPannel/>
			<u:main1>
				<u:mainWorkspace>
					<div>
						<form action="saveCableBrands.html" method="post">
							<input type="hidden" name="idTnla" value="${tnla.id}">
							<label for="code">Код ТНПА</label>
							<br>
							<input type="text" name="code" value="${tnla.code}" disabled>
							<br><br>
							
							<input type="hidden" name="idCableCategory" value="${cableCategory.id}">
							<label for="name">Название категории</label>
							<br>
							<input type="text" name="name" value="${cableCategory.name}" disabled>
							<br><br>
							
							<c:forEach var="typeProduct" items="${typeProducts}">
								<table cellspacing=0 border=0 width="100%" cellpadding="5">
									<tr>
										<td width=30px><input type="radio" name="idTypeProduct" value="${typeProduct.ordinal()}"></td>
										<td>${typeProduct}</td>
									</tr>
								</table>
							</c:forEach><br>
							
							<label for="brand">Марка</label>
							<br>
							<select name="idBrand" required>
								<c:forEach var="brand" items="${brands}">
									<option value="${brand.id}">${brand.name}</option>
								</c:forEach>
							</select><br><br>
							
							<label for="numberOfConductors">Количество жил</label>
							<br>
							<label for="numberOfConductorsFrom">от</label>
							<br>
							<select name="idNumberOfConductorFrom" required>
								<c:forEach var="numberOfConductor" items="${numberOfConductors}">
									<option value="${numberOfConductor.id}">${numberOfConductor.value}</option>
								</c:forEach>
							</select>
							<br>
							<label for="numberOfConductorsBefore">до</label>
							<br>
							<select name="idNumberOfConductorBefore" required>
								<c:forEach var="numberOfConductor" items="${numberOfConductors}">
									<option value="${numberOfConductor.id}">${numberOfConductor.value}</option>
								</c:forEach>
							</select><br><br>
							
							<label for="nominalCrossSections">Сечение жил</label>
							<br>
							<label for="nominalCrossSectionsFrom">от</label>
							<br>
							<select name="idNominalCrossSectionsFrom" required>
								<c:forEach var="nominalCrossSection" items="${nominalCrossSections}">
									<option value="${nominalCrossSection.id}">${nominalCrossSection.value}</option>
								</c:forEach>
							</select>
							<br>
							<label for="nominalCrossSectionsBefore">до</label>
							<br>
							<select name="idNominalCrossSectionsBefore" required>
								<c:forEach var="nominalCrossSection" items="${nominalCrossSections}">
									<option value="${nominalCrossSection.id}">${nominalCrossSection.value}</option>
								</c:forEach>
							</select><br><br>
							
							<label for="typeConductors">Тип жилы</label>
							<br>
							<select name="idTypeConductor" required>
								<c:forEach var="typeConductor" items="${typeConductors}">
									<option value="${typeConductor.id}">${typeConductor.value}</option>
								</c:forEach>
							</select><br><br>
							
							<label for="ratedVoltages">Величина напряжения</label>
							<br>
							<select name="idRatedVoltage" required>
								<c:forEach var="ratedVoltage" items="${ratedVoltages}">
									<option value="${ratedVoltage.id}">${ratedVoltage.value}</option>
								</c:forEach>
							</select><br><br>
							
							<button type="submit" class="button button_add">
								<span class="button-text">Сохранить</span>
							</button>
						</form>
						<br>
						<form action="../workspace.html">
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

 