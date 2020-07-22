<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="authentication">
	<form action="workspace.html" class="authentication-form" method="post">
    	<div class="authentication-form-fieldset">
			<fieldset title="Введите логин">
				<legend>логин</legend>
				<input type="login" name="login" required>
			</fieldset>
			<fieldset title="Введите пароль">
				<legend>пароль</legend>
				<input type="password" name="password" required>
			</fieldset>
		</div>
		<div class="authentication-form-href">
			<p><a href="registration.html">Регистрация</a></p>
			<button class="button button-authentication_form">
				<span class="button-text-authentication">Вход</span>
			</button>
		</div>
	</form>
</div>
