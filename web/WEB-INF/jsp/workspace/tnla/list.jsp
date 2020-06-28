<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ru">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ТНПА</title>
  <style>
    <%@include file="/WEB-INF/css/style.css"%>
  </style>
</head> 

<body>
  <div class="container">
    <header class="header">
		<jsp:include page="/prototypes/logo.html"/>
      <div class="authentication">
		<jsp:include page="/prototypes/authentication_workspace.html"/>
      </div>
    </header>

    <div class="menu">
		<jsp:include page="/prototypes/menu_hrefs_tnla.html"/>
    </div>

    <div class="container-main">
      <div class="left_pannel">
		<jsp:include page="/prototypes/left_pannel_tnla.html"/>
      </div>
      <div class="main main-workspace">
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
				<td><input name="tableTNLA" type="radio" value="tableTNLA"></td>
				<td>${tnla.codTnla}</td>
				<td>${tnla.nameTnla}</td>
				<td><fmt:formatDate value="${tnla.dateStartTnla}" pattern="dd.MM.yyyy"/></td>
				<td><fmt:formatDate value="${tnla.dateEndTnla}" pattern="dd.MM.yyyy"/></td>
			</tr>
			</c:forEach>
		</table>
      </div>
    </div>
  </div>
</body>

</html>