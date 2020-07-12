<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ru">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Workspace</title>
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/prototypes/images/icon.png" type="image/x-icon">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/prototypes/css/style.css">
	</head> 
	
	<body>
	 	<div class="container">
		    <header class="header">
				<div class="logo">
					<img src="${pageContext.request.contextPath}/prototypes/images/logoCable.svg" alt="Logotype" class="logo" />
				</div>
		     	<div class="authentication">
					<jsp:include page="/prototypes/authentication_workspace.html"/>
		      	</div>
		    </header>
		
		    <div class="menu">
			    <div class="menu-hrefs">
		    	<div class="menu-hrefs-home"></div>
					<jsp:include page="/prototypes/menu_hrefs_workspace.html"/>
			    </div>
			</div>
		
		    <div class="container-main">
		     	<div class="left_pannel">
					<jsp:include page="/prototypes/left_pannel_workspace.html"/>
		      	</div>
		      	<div class="main main-workspace">
	
	
	
	
		     	</div>
		    </div>
		 </div>
	</body>

</html>