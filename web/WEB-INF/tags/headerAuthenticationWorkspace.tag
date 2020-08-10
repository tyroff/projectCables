<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="authentication-form">
	<div class="authentication-form-fieldset">
		<h3>${authorizedUser.login}</h3>
	</div>
	<div class="authentication-form-href">
		<p><a href="${pageContext.request.contextPath}/logout.html">Выход</a></p>
	</div>
</div>
