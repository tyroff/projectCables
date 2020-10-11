package org.itstep.vinokurov.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.itstep.vinokurov.domain.Role;
import org.itstep.vinokurov.domain.User;

public class IndexServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			User user = (User)session.getAttribute("authorizedUser");
			if(user != null) {
				switch(user.getRole()) {
				case ADMIN: resp.sendRedirect(req.getContextPath() + "/workspace.html"); break;
				case TECHNOLOGIST: resp.sendRedirect(req.getContextPath() + "/workspace.html"); break;
				default: throw new EnumConstantNotPresentException(Role.class, user.getRole().toString());
				}
				return;
			}
		}
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
	}
}