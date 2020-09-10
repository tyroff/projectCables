package org.itstep.vinokurov.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.itstep.vinokurov.domain.User;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.UserService;
import org.itstep.vinokurov.web.action.Action;
import org.itstep.vinokurov.web.action.ActionException;

public class LoginAction implements Action {
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public Result exec(HttpServletRequest req, HttpServletResponse resp) throws LogicException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		if(login == null && password == null) {
			return null;
		}
		try {
			if(login == null || login.isBlank() || password == null) {
				throw new IllegalArgumentException();
			}
			User user = userService.authentication(login, password);
			if(user != null) {
				HttpSession session = req.getSession();
				session.setAttribute("userSession", user);
				return new Result("/workspace");
			} else {
				return new Result("/index").add("message", "Неверный логин или пароль!");
			}
		} catch (IllegalArgumentException e) {
			throw new ActionException(e, 400);
		}
	}
}
