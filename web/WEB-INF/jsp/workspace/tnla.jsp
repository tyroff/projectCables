<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ru">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>ТНПА</title>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/prototypes/images/icon.png" type="image/x-icon">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/prototypes/css/style.css">
</head> 

<body>
 	<div class="container">
	    <header class="header">
			<a href="../../cables/" class="logo">
				<img src="${pageContext.request.contextPath}/prototypes/images/logoCable.svg" alt="Logotype" class="logo" />
			</a>
	     	<div class="authentication">
				<jsp:include page="/prototypes/authentication_workspace.html"/>
	      	</div>
	    </header>
	
	    <div class="menu">
		    <div class="menu-hrefs">
				<div class="menu-hrefs-home">
					<a href="../workspace.html">
						<img src="${pageContext.request.contextPath}/prototypes/images/home.png" alt="home" />
					</a>
				</div>
				<jsp:include page="/prototypes/menu_hrefs_tnla.html"/>
		    </div>
		</div>
	
	    <form action="tnla/delegate.html" method="post">
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
							<td><input type="radio" name="id" value="${tnla.id}"></td>
							<td>${tnla.code}</td>
							<td>${tnla.name}</td>
							<td><fmt:formatDate value="${tnla.dateStart}" pattern="dd.MM.yyyy"/></td>
							<td><fmt:formatDate value="${tnla.dateEnd}" pattern="dd.MM.yyyy"/></td>
						</tr>
						</c:forEach>
					</table>
		     	</div>
		    </div>
	    </form>
	 </div>
</body>

</html>