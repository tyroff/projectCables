<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="title"  required="true" rtexprvalue="true" type="java.lang.String" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>${title}</title>
		<c:url var="css" value="/css/style.css"/>
		<link rel="stylesheet" href="${css}" type="text/css">
	</head>
		<jsp:doBody/>
</html>