package org.itstep.vinokurov.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.vinokurov.Factory;
import org.itstep.vinokurov.logic.LogicException;
import org.itstep.vinokurov.logic.TnlaService;

public class TnlaDeleteServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if(id != null) {
			try {
				try(Factory factory = new Factory()) {
				TnlaService tnlaService = factory.getTnlaService();
				tnlaService.delete(Long.parseLong(id));
				} catch(LogicException e) {
					throw new ServletException(e);
				}
			} catch(NumberFormatException e) {
				resp.sendError(400);
				return;
			}
			resp.sendRedirect(req.getContextPath() + "/workspace/tnla.html");
		}
	}
}
