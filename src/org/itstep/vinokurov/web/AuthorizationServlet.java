package org.itstep.vinokurov.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.itstep.vinokurov.Factory;
import org.itstep.vinokurov.domain.User;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.UserService;

public class AuthorizationServlet extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String login = req.getParameter("login");
			String password = req.getParameter("password");
			if(login == null || login.isBlank() || password == null) {
				throw new IllegalArgumentException();
			}
			try(Factory factory = new Factory()){
				UserService userService = factory.getUserService();
				User user = userService.authentication(login, password);
				if(user != null) {
					HttpSession session = req.getSession();
					session.setAttribute("authorizedUser", user);
					resp.sendRedirect(req.getContextPath() + "/workspace.html");
				} else {
					resp.sendRedirect(req.getContextPath() + "/index.html");
				}
			} catch(LogicException e) {
				throw new ServletException(e);
			}
		} catch(IllegalArgumentException e) {
			resp.sendError(400);
		}
	}
	

}
