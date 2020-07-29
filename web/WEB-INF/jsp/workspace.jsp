<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

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
				</u:mainWorkspace>
			</u:main>
		</u:containerMainWorkspace>
	</u:body>
</u:head>
